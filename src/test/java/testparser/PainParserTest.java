package testparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

import parser.PainParser;
import parser.PainParser.PainDocumentType;
import parser.model.pain.AccountIdentificationSEPA;
import parser.model.pain.ActiveOrHistoricCurrencyAndAmountSEPA;
import parser.model.pain.ActiveOrHistoricCurrencyCodeEUR;
import parser.model.pain.BranchAndFinancialInstitutionIdentificationSEPA3;
import parser.model.pain.CashAccountSEPA1;
import parser.model.pain.CashAccountSEPA2;
import parser.model.pain.ChargeBearerTypeSEPACode;
import parser.model.pain.CustomerDirectDebitInitiationV02;
import parser.model.pain.DirectDebitTransactionInformationSDD;
import parser.model.pain.DirectDebitTransactionSDD;
import parser.model.pain.Document;
import parser.model.pain.FinancialInstitutionIdentificationSEPA3;
import parser.model.pain.GroupHeaderSDD;
import parser.model.pain.IdentificationSchemeNameSEPA;
import parser.model.pain.LocalInstrumentSEPA;
import parser.model.pain.MandateRelatedInformationSDD;
import parser.model.pain.PartyIdentificationSEPA1;
import parser.model.pain.PartyIdentificationSEPA2;
import parser.model.pain.PartyIdentificationSEPA3;
import parser.model.pain.PartyIdentificationSEPA5;
import parser.model.pain.PartySEPA2;
import parser.model.pain.PaymentIdentificationSEPA;
import parser.model.pain.PaymentInstructionInformationSDD;
import parser.model.pain.PaymentMethod2Code;
import parser.model.pain.PaymentTypeInformationSDD;
import parser.model.pain.PersonIdentificationSEPA2;
import parser.model.pain.RemittanceInformationSEPA1Choice;
import parser.model.pain.RestrictedPersonIdentificationSEPA;
import parser.model.pain.RestrictedPersonIdentificationSchemeNameSEPA;
import parser.model.pain.SequenceType1Code;
import parser.model.pain.ServiceLevelSEPA;
import utils.ParserUtils;

public class PainParserTest {

	static String filePath = "E:\\Test\\Parser\\xml\\test_2_write_pain.008.003.02.xml";
	static String xsdFilePath = "E:\\Test\\Parser\\xsd\\pain.008.003.02.xsd";
	static String schemaLocation = "urn:iso:std:iso:20022:tech:xsd:pain.008.003.02 pain.008.003.02.xsd";
	public static TimeZone timzone = TimeZone.getDefault();

	public static void main(String[] args) {
		testCreatePain00800302();
	}

	public static void testCreatePain00800302() {

		Document document = populateDocumentDataPain00800302();

		try {
			FileOutputStream os = new FileOutputStream(new File(filePath));
			String xml = PainParser.createDocument(filePath, PainDocumentType.PAIN00800302, document);
			os.write(xml.getBytes());
			os.close();
			System.out.println(xml);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	

	}

	private static Document populateDocumentDataPain00800302() {

		Document document = new Document();

		CustomerDirectDebitInitiationV02 directDebitInitiationV02 = new CustomerDirectDebitInitiationV02();

		/* Group Header */
		GroupHeaderSDD groupHeaderSDD = new GroupHeaderSDD();
		groupHeaderSDD.setMsgId("Msg-ID");
		// CredtTm
		groupHeaderSDD.setCreDtTm(ParserUtils.dateToXMLGregorianCalendar(new Date(2010, 12, 21, 9, 30, 47), timzone));
		groupHeaderSDD.setCtrlSum(null);
		PartyIdentificationSEPA1 partyIdentificationSEPA1 = new PartyIdentificationSEPA1();
		partyIdentificationSEPA1.setNm("Initiator Name");
		groupHeaderSDD.setInitgPty(partyIdentificationSEPA1);
		directDebitInitiationV02.setGrpHdr(groupHeaderSDD);

		/* PaymentInf */
		PaymentInstructionInformationSDD pmtInf = new PaymentInstructionInformationSDD();

		pmtInf.setPmtInfId("Payment-ID");
		pmtInf.setPmtMtd(PaymentMethod2Code.DD);
		pmtInf.setNbOfTxs("2");
		BigDecimal cntrlSum = new BigDecimal(6655.86);
		cntrlSum = cntrlSum.setScale(2, RoundingMode.CEILING);
		pmtInf.setCtrlSum(cntrlSum);

		PaymentTypeInformationSDD paymentTypeInformationSDD = new PaymentTypeInformationSDD();
		ServiceLevelSEPA serviceLevelSEPA = new ServiceLevelSEPA();
		serviceLevelSEPA.setCd("SEPA");
		paymentTypeInformationSDD.setSvcLvl(serviceLevelSEPA);
		LocalInstrumentSEPA instrumentSEPA = new LocalInstrumentSEPA();

		/**
		 * normal direct debit : LOCAL_INSTRUMENT_CORE_DIRECT_DEBIT = 'CORE';
		 * urgent direct debit : LOCAL_INSTRUMENT_CORE_DIRECT_DEBIT_D_1 =
		 * 'COR1'; business direct debit : LOCAL_INSTRUMENT_BUSINESS_2_BUSINESS
		 * = 'B2B';
		 */

		instrumentSEPA.setCd("CORE");

		paymentTypeInformationSDD.setLclInstrm(instrumentSEPA);
		paymentTypeInformationSDD.setSeqTp(SequenceType1Code.FRST);

		pmtInf.setReqdColltnDt(ParserUtils.dateToXMLGregorianCalendar(new Date(2010 - 1900, 12 - 1, 03), timzone));

		// Creditor info
		PartyIdentificationSEPA5 creditor = new PartyIdentificationSEPA5();
		creditor.setNm("Creditor Name");
		pmtInf.setCdtr(creditor);

		/*
		 * Creditor Bank Info
		 */
		// IBAN or Bank id
		CashAccountSEPA1 creditorBankinfoIBAN = new CashAccountSEPA1();
		AccountIdentificationSEPA id = new AccountIdentificationSEPA();
		id.setIBAN("DE87200500001234567890");
		creditorBankinfoIBAN.setId(id);
		pmtInf.setCdtrAcct(creditorBankinfoIBAN);

		// BIC or Bank branch
		BranchAndFinancialInstitutionIdentificationSEPA3 crdtrBankAndBranch = new BranchAndFinancialInstitutionIdentificationSEPA3();
		FinancialInstitutionIdentificationSEPA3 crdtrBankId = new FinancialInstitutionIdentificationSEPA3();
		crdtrBankId.setBIC("BANKDEFFXXX");
		crdtrBankAndBranch.setFinInstnId(crdtrBankId);
		pmtInf.setCdtrAgt(crdtrBankAndBranch);

		// Constant charge bearer: SLEV
		pmtInf.setChrgBr(ChargeBearerTypeSEPACode.SLEV);

		// Gläubiger Id
		PartyIdentificationSEPA3 cdtrSchmeId = new PartyIdentificationSEPA3();
		PartySEPA2 schemeId = new PartySEPA2();
		PersonIdentificationSEPA2 prvtId = new PersonIdentificationSEPA2();
		RestrictedPersonIdentificationSEPA personIdentificationSEPA = new RestrictedPersonIdentificationSEPA();
		personIdentificationSEPA.setId("DE00ZZZ00099999999");

		RestrictedPersonIdentificationSchemeNameSEPA schemNm = new RestrictedPersonIdentificationSchemeNameSEPA();
		schemNm.setPrtry(IdentificationSchemeNameSEPA.SEPA);
		personIdentificationSEPA.setSchmeNm(schemNm);
		
		prvtId.setOthr(personIdentificationSEPA);
		schemeId.setPrvtId(prvtId);
		cdtrSchmeId.setId(schemeId);
		pmtInf.setCdtrSchmeId(cdtrSchmeId);

		// set transactions:

		DirectDebitTransactionInformationSDD transaction1 = createTransaction();

		pmtInf.getDrctDbtTxInf().add(transaction1);

		pmtInf.setPmtTpInf(paymentTypeInformationSDD);
		directDebitInitiationV02.getPmtInf().add(pmtInf);

		document.setCstmrDrctDbtInitn(directDebitInitiationV02);

		return document;
	}

	private static DirectDebitTransactionInformationSDD createTransaction() {
		DirectDebitTransactionInformationSDD transaction1 = new DirectDebitTransactionInformationSDD();

		// pmtId: EndtoEnd
		PaymentIdentificationSEPA pmtId = new PaymentIdentificationSEPA();
		pmtId.setEndToEndId("OriginatorID1235");
		transaction1.setPmtId(pmtId);

		// Amount
		ActiveOrHistoricCurrencyAndAmountSEPA amountSEPA = new ActiveOrHistoricCurrencyAndAmountSEPA();
		amountSEPA.setValue(new BigDecimal(112.72).setScale(2, RoundingMode.CEILING));
		amountSEPA.setCcy(ActiveOrHistoricCurrencyCodeEUR.EUR);
		transaction1.setInstdAmt(amountSEPA);

		// Debitor name
		PartyIdentificationSEPA2 dbtr = new PartyIdentificationSEPA2();
		dbtr.setNm("Debtor name");
		transaction1.setDbtr(dbtr);

		// IBAN
		CashAccountSEPA2 dbtrAcct = new CashAccountSEPA2();
		AccountIdentificationSEPA dbtrAccId = new AccountIdentificationSEPA();
		dbtrAccId.setIBAN("DE16200500001234567555");
		dbtrAcct.setId(dbtrAccId);
		transaction1.setDbtrAcct(dbtrAcct);

		// BIC
		BranchAndFinancialInstitutionIdentificationSEPA3 dbtrBicInf = new BranchAndFinancialInstitutionIdentificationSEPA3();

		FinancialInstitutionIdentificationSEPA3 dbtrBankInfo = new FinancialInstitutionIdentificationSEPA3();

		dbtrBankInfo.setBIC("SPUEDE2UXXX");

		dbtrBicInf.setFinInstnId(dbtrBankInfo);
		transaction1.setDbtrAgt(dbtrBicInf);

		DirectDebitTransactionSDD ddtxValue = new DirectDebitTransactionSDD();
		MandateRelatedInformationSDD mandateInfo = new MandateRelatedInformationSDD();

		// Mandate Id
		mandateInfo.setMndtId("Mandate-Id");

		// date of signature
		mandateInfo.setDtOfSgntr(ParserUtils.dateToXMLGregorianCalendar(Date.from(Instant.now()), timzone));

		mandateInfo.setAmdmntInd(false);
		ddtxValue.setMndtRltdInf(mandateInfo);
		transaction1.setDrctDbtTx(new DirectDebitTransactionSDD(mandateInfo, null));
		// Debitor other name
		PartyIdentificationSEPA1 ultDbtrNm = new PartyIdentificationSEPA1();

		ultDbtrNm.setNm("Ultimate Debtor Name");

		transaction1.setUltmtDbtr(ultDbtrNm);
		RemittanceInformationSEPA1Choice rmtInf = new RemittanceInformationSEPA1Choice();
		rmtInf.setUstrd("Unstructured Remittance Information"); // Verbindungszweck
		transaction1.setRmtInf(rmtInf);
		return transaction1;
	}

	

}
