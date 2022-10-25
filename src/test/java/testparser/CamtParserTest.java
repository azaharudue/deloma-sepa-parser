package testparser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.xml.sax.SAXException;

import junit.framework.Assert;
import parser.BaseXmlFactory;
import parser.CamtParser;
import parser.CamtParser.CAMTTYPE;
import parser.model.AccountIdentification4Choice;
import parser.model.AccountNotification2;
import parser.model.AccountReport11;
import parser.model.ActiveOrHistoricCurrencyAndAmount;
import parser.model.AmountAndCurrencyExchange3;
import parser.model.AmountAndCurrencyExchangeDetails3;
import parser.model.BankToCustomerDebitCreditNotificationV02;
import parser.model.BankTransactionCodeStructure4;
import parser.model.BranchAndFinancialInstitutionIdentification4;
import parser.model.CashAccount16;
import parser.model.CashAccount20;
import parser.model.CreditDebitCode;
import parser.model.TransactionReferences2;
import parser.model.DateAndDateTimeChoice;
import parser.model.Document052;
import parser.model.Document053;
import parser.model.Document054;
import parser.model.EntryDetails1;
import parser.model.EntryStatus2Code;
import parser.model.EntryTransaction2;
import parser.model.FinancialInstitutionIdentification7;
import parser.model.GenericFinancialIdentification1;
import parser.model.GroupHeader42;
import parser.model.Pagination;
import parser.model.PartyIdentification32;
import parser.model.ProprietaryBankTransactionCodeStructure1;
import parser.model.RemittanceInformation5;
import parser.model.ReportEntry2;
import parser.model.TransactionParty2;
import utils.ParserUtils;

/**
 * @author Azahar Hossain (c) 2022
 *
 */
public class CamtParserTest {

	static String FILEPATH = "";
	static String actualMsgId = "";
	static String expectedMsgId = "";

	static TimeZone timeZone = TimeZone.getDefault();

	static List<AccountReport11> accountreports = new ArrayList<AccountReport11>();

	public static void main(String[] args) {
		testParser5X();

	}

	/**
	 * 
	 */
	private static void testParser5X() {
		try {

			// CAMT052
			FILEPATH = "H:\\Test\\Parser\\camt52\\2020.01.08.xml";

			// CAMT053

			// FILEPATH = "H:\\Test\\Parser\\test-camt53.xml";

			InputStream fis = new FileInputStream(FILEPATH);
			camt52(fis);

			// camt53(file);

			// CAMT054
			//FILEPATH = "H:\\Test\\Parser\\test-camt54.xml";

			// validate xml file against xsd:
			String xsdpath = "H:\\Test\\Parser\\xsd\\camt.054.001.02.xsd";

			// createCamt54(FILEPATH, xsdpath);
			// camt54(fis);

			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * CAMT5X CAMT52 Console output
	 * 
	 * @throws Exception
	 * @throws JAXBException
	 * @throws XMLStreamException
	 */
	@SuppressWarnings("unused")
	private static void camt52(InputStream is) throws Exception, JAXBException, XMLStreamException {
		CamtParser parser = new CamtParser(CAMTTYPE.CAMT52);

		Document052 document052 = (Document052) parser.parse(is);

		// expected
		expectedMsgId = "camt52_20200108173025__ONLINEBA";
		// actual
		actualMsgId = document052.getBkToCstmrAcctRpt().getGrpHdr().getMsgId();
		
		GroupHeader42 header = document052.getBkToCstmrAcctRpt().getGrpHdr(); 
		Date date = document052.getBkToCstmrAcctRpt().getGrpHdr().getCreDtTm().toGregorianCalendar().getTime();

		System.out.println(date);
		
		accountreports = document052.getBkToCstmrAcctRpt().getRpt();

		for (AccountReport11 accountReport11 : accountreports) {
			//accountReport11.getNtry().forEach(o -> System.out.println(o.toString() + "\n"));
		}
		System.out.println(actualMsgId);
	}

	/**
	 * CAMT053 Console output
	 * 
	 * @param file
	 * @throws Exception
	 * @throws JAXBException
	 * @throws XMLStreamException
	 */
	@SuppressWarnings("unused")
	private static void camt53(InputStream is) throws Exception, JAXBException, XMLStreamException {
		CamtParser parser = new CamtParser(CAMTTYPE.CAMT53);

		Document053 document053 = (Document053) parser.parse(is);

		actualMsgId = document053.getBkToCstmrStmt().getGrpHdr().getMsgId();

		System.out.println(actualMsgId);
	}

	private static void camt54(InputStream is) throws Exception, JAXBException, XMLStreamException {
		CamtParser parser = new CamtParser(CAMTTYPE.CAMT54);

		Document054 document054 = (Document054) parser.parse(is);

		System.out.println(document054.toString());
	}

	/**
	 * FIXME: fix for document 54
	 * 
	 * @param filepath
	 * @param xsdFilePath
	 * @return
	 * @throws IOException
	 * @throws SAXException
	 */
	private static String createCamt54(String filepath, String xsdFilePath) throws IOException, SAXException {
		File xmlFile = new File(filepath);

		// Document054 document = populateDocument54();
		File xsdFile = new File(xsdFilePath);

		String schemaLocation = "urn:iso:std:iso:20022:tech:xsd:camt.054.001.02 camt.054.001.02.xsd";

		return null;
		// BaseXmlFactory.createXmlFile( document, schemaLocation);
	}

	/**
	 */

	// private static Document054 populateDocument54()
	// {
	// // 1st:Document Top most in the hierarchy
	// Document054 document = new Document054();
	//
	// // 2nd: BankToCustomerDebitCreditNotificationV02
	//
	// BankToCustomerDebitCreditNotificationV02
	// customerDebitCreditNotificationV02 = new
	// BankToCustomerDebitCreditNotificationV02();
	//
	// /* Add Group Header **/
	// parser.model.GroupHeader42 groupHeader = new
	// parser.model.GroupHeader42();
	// // msgId
	// groupHeader.setMsgId("054D2013-12-31T01:59:36.0N130000007");
	//
	// // creation datetime
	// groupHeader.setCreDtTm(ParserUtils.dateToXMLGregorianCalendar(new
	// Date(2013, 12, 31), timeZone));
	//
	// Pagination pagination = new Pagination();
	// pagination.setPgNb("1");
	// pagination.setLastPgInd(true);
	// groupHeader.setMsgPgntn(pagination);
	// customerDebitCreditNotificationV02.setGrpHdr(groupHeader);
	// // ---- end of Group Header --------
	//
	// /* Add Notifications */
	// AccountNotification2 notification1 = new AccountNotification2();
	// notification1.setId("0352C5420131231015954"); // Id
	// notification1.setElctrncSeqNb(new BigDecimal("130000007")); //
	// ElctrncSeqNb
	//
	// // --- Account --//
	// CashAccount20 acct = new CashAccount20();
	// AccountIdentification4Choice accId = new AccountIdentification4Choice();
	// accId.setIBAN("DE58740618130100033626");
	// acct.setId(accId);
	// acct.setCcy("EUR");
	// // owner
	// PartyIdentification32 owner = new PartyIdentification32();
	// owner.setNm("Testkonto Nummer 2");
	// acct.setOwnr(owner);
	// // Bank details
	// BranchAndFinancialInstitutionIdentification4 finInstitute = new
	// BranchAndFinancialInstitutionIdentification4();
	// FinancialInstitutionIdentification7 finInstituteId = new
	// FinancialInstitutionIdentification7();
	// finInstituteId.setBIC("GENODEF1PFK"); // BIC
	// finInstituteId.setNm("VR-Bank Rottal-Inn eG"); // Bank name
	// GenericFinancialIdentification1 generalId = new
	// GenericFinancialIdentification1();
	// generalId.setId("DE 129267947"); // Bank id
	// generalId.setIssr("UmsStId");
	// finInstituteId.setOthr(generalId);
	// finInstitute.setFinInstnId(finInstituteId);
	// acct.setSvcr(finInstitute);
	// notification1.setAcct(acct);
	// // --- end of account details --//
	//
	// /* Entry(ies) */ // Ntry
	// ReportEntry2 entry = createEntry(accId);
	// notification1.addNtry(entry);
	//
	// // Debit entry
	// customerDebitCreditNotificationV02.addNtfctn(notification1);
	//
	// document.setBkToCstmrDbtCdtNtfctn(customerDebitCreditNotificationV02);
	//
	// return document;
	// }

	/**
	 * @param accId
	 * @return
	 */
	private static ReportEntry2 createEntry(AccountIdentification4Choice accId) {
		ReportEntry2 entry = new ReportEntry2();
		ActiveOrHistoricCurrencyAndAmount currenyAndAmount = new ActiveOrHistoricCurrencyAndAmount(); // Amt
		currenyAndAmount.setCcy("EUR");
		currenyAndAmount.setValue(new BigDecimal(1.10));
		entry.setAmt(currenyAndAmount);

		entry.setCdtDbtInd(CreditDebitCode.DBIT);
		entry.setSts(EntryStatus2Code.BOOK);
		// Booking date
		DateAndDateTimeChoice bookingDate = new DateAndDateTimeChoice();
		bookingDate.setDt(ParserUtils.dateToXMLGregorianCalendar(new Date(2013, 12, 30), timeZone));
		entry.setBookgDt(bookingDate);
		// Value date
		DateAndDateTimeChoice valueDate = new DateAndDateTimeChoice();
		valueDate.setDt(ParserUtils.dateToXMLGregorianCalendar(new Date(2013, 12, 30), timeZone));
		entry.setValDt(valueDate);
		entry.setAcctSvcrRef("2013122812211780000");

		/* EntryDetails: Transactions */
		EntryDetails1 ntryDetails = new EntryDetails1();
		EntryTransaction2 txDetails1 = createTransaction(accId);

		/*--------END OF TRANSACTION DETAILS 1------*/

		// EntryTransaction2 txDetails2 = new EntryTransaction2(); // TxDtls 2
		ntryDetails.getTxDtls().add(txDetails1);

		entry.getNtryDtls().add(ntryDetails);
		return entry;
	}

	/**
	 * @param accId
	 * @return
	 */
	private static EntryTransaction2 createTransaction(AccountIdentification4Choice accId) {
		// Tx 1:
		EntryTransaction2 txDetails1 = new EntryTransaction2(); // TxDtls 1

		// refs
		TransactionReferences2 refs = new TransactionReferences2();
		refs.setMsgId("STZV-Msg28122013-11:29");
		refs.setEndToEndId("STZV-EtE28122013-11:29-1");
		txDetails1.setRefs(refs);

		// AmtDtls
		AmountAndCurrencyExchange3 amtDetails = new AmountAndCurrencyExchange3();
		AmountAndCurrencyExchangeDetails3 txAmt = new AmountAndCurrencyExchangeDetails3();
		ActiveOrHistoricCurrencyAndAmount tx1CurrenyAndAmount = new ActiveOrHistoricCurrencyAndAmount(); // Amt
		tx1CurrenyAndAmount.setCcy("EUR");
		tx1CurrenyAndAmount.setValue(new BigDecimal(0.60));
		txAmt.setAmt(tx1CurrenyAndAmount);
		amtDetails.setTxAmt(txAmt);
		txDetails1.setAmtDtls(amtDetails);
		// BkTxCd
		BankTransactionCodeStructure4 bkTxCdStruct = new BankTransactionCodeStructure4();
		ProprietaryBankTransactionCodeStructure1 propTry = new ProprietaryBankTransactionCodeStructure1();
		propTry.setCd("NMSC+201");
		propTry.setIssr("ZKA");
		bkTxCdStruct.setPrtry(propTry);
		txDetails1.setBkTxCd(bkTxCdStruct);

		// RltdPties
		TransactionParty2 txParties = new TransactionParty2();
		// Dbtr
		PartyIdentification32 dbtrInfo = new PartyIdentification32();
		dbtrInfo.setNm("Testkonto Nummer 2");
		txParties.setDbtr(dbtrInfo); // Dbtr
		CashAccount16 dbtrAcct = new CashAccount16();
		accId.setIBAN("DE14740618130000033626");
		dbtrAcct.setId(accId);
		txParties.setDbtrAcct(dbtrAcct); // DbtrAcct
		dbtrInfo.setNm("keine Information vorhanden"); // UltmtDbtr
		txParties.setUltmtDbtr(dbtrInfo);

		// Cdtr
		PartyIdentification32 cdtrInfo = new PartyIdentification32();
		cdtrInfo.setNm("Testkonto Nummer 1");
		txParties.setDbtr(cdtrInfo); // Dbtr
		CashAccount16 CdtrAcct = new CashAccount16();
		accId.setIBAN("DE58740618130100033626");
		dbtrAcct.setId(accId); // Creditor account IBAN = same as Owner
		txParties.setCdtrAcct(CdtrAcct); // CdtrAcct
		cdtrInfo.setNm("test konto 1"); // UltmtCdtr
		txParties.setUltmtCdtr(cdtrInfo);

		txDetails1.setRltdPties(txParties);
		RemittanceInformation5 rmtInf = new RemittanceInformation5();
		rmtInf.getUstrd().add("Sammler aus Testknto 2 Zweite Ueberweisung TAN:704515");
		txDetails1.setRmtInf(rmtInf);
		return txDetails1;
	}

	/**
	 * Test method for {@link parser.CamtParser#parse(java.io.File)}.
	 * 
	 * @throws IOException
	 */
	@Test
	public void testParse() throws IOException {
		main(null);

		Assert.assertTrue(expectedMsgId.equals(actualMsgId));

	}

}
