package parser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;
import java.util.stream.Collectors;

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
import parser.model.pain.ObjectFactory;
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

/**
 * @author Azahar Hossain (c) 2022
 *
 */

public class PainParser {

	public enum PainDocumentType {
		PAIN00800302,
	}

	/**
	 * normal direct debit : LOCAL_INSTRUMENT_NORMAL = 'CORE'; urgent direct
	 * debit : LOCAL_INSTRUMENT_URGENT = 'COR1'; business direct debit :
	 * LOCAL_INSTRUMENT_BUSINESS = 'B2B';
	 * 
	 * private static String LOCAL_INSTRUMENT_NORMAL = "CORE"; private
	 * static String LOCAL_INSTRUMENT_URGENT = "COR1"; private static String
	 * LOCAL_INSTRUMENT_BUSINESS = "B2B";
	 */
	public enum SepaLocalInstrumentCode {

		CORE("CORE"), COR1("COR1"), B2B("B2B");
		
		private String value;

		SepaLocalInstrumentCode(String value) {
			this.value = value;
		}

		public String getValue(){
			return this.value;  
		}

	}

	public static PainDocumentType documentType;

	public PainParser() {
	}

	public PainParser(PainDocumentType documentType) {
		PainParser.documentType = documentType;
	}

	/**
	 * Read PAIN.008.003.02.xml and return a documentPain00800302
	 * 
	 * @param <T>
	 * 
	 * @throws Exception
	 */
	public static <T> T parse(InputStream is) throws Exception {
		T t = null;
		switch (documentType) {
		case PAIN00800302:
			t = BaseXmlFactory.parse(is, Document.class);
		}
		return t;
	}

	public static String createDocument(String filePath, PainDocumentType type, Document document) {

		String xsdFilePath = "";
		String schemaLocation = "";

		switch (type) {

		case PAIN00800302:
			xsdFilePath += "src/main/java/schemaFiles/pain.008.003.02.xsd";
			schemaLocation += "urn:iso:std:iso:20022:tech:xsd:pain.008.003.02 pain.008.003.02.xsd";
			return createDocument(filePath, document, xsdFilePath, schemaLocation);

		default:
			throw new UnsupportedOperationException("unknown type");
		}
	}

	public static String createDocument(String filePath, Document document, String xsdFilePath, String schemaLocation) {
		Objects.requireNonNull(filePath, "filePath must not be null!");
		Objects.requireNonNull(xsdFilePath, "xsdFilePath must not be null!");
		Objects.requireNonNull(schemaLocation, "schemaLocation must not be null!");

		File file = new File(filePath);
		File xsdFile = new File(xsdFilePath);
		try {
			return BaseXmlFactory.createXmlFile(document, schemaLocation, ObjectFactory.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public PainDocumentType getDocumentType() {
		return documentType;
	}

	/**
	 * creates a single transaction for the given parameter informations
	 * 
	 * @param endToEndId
	 * @param amount
	 * @param dbtrName
	 * @param dbtrIban
	 * @param dbtrBic
	 * @param mandateId
	 * @param dtOfSgntr
	 * @param ultDbtrName
	 * @param ustrdRemInf
	 * @return DirectDebitTransactionInformationSDD object
	 */
	public static DirectDebitTransactionInformationSDD createTransaction(String endToEndId, BigDecimal amount,
			String dbtrName, String dbtrIban, String dbtrBic, String mandateId, Date dtOfSgntr, String ultDbtrName,
			String ustrdRemInf) {
		final DirectDebitTransactionInformationSDD transaction = new DirectDebitTransactionInformationSDD();

		// pmtId: EndtoEnd
		final PaymentIdentificationSEPA pmtId = new PaymentIdentificationSEPA();
		pmtId.setEndToEndId(endToEndId);
		transaction.setPmtId(pmtId);

		// Amount
		final ActiveOrHistoricCurrencyAndAmountSEPA amountSEPA = new ActiveOrHistoricCurrencyAndAmountSEPA();
		amountSEPA.setValue(amount);
		amountSEPA.setCcy(ActiveOrHistoricCurrencyCodeEUR.EUR);
		transaction.setInstdAmt(amountSEPA);

		// Debitor name
		final PartyIdentificationSEPA2 dbtr = new PartyIdentificationSEPA2();
		dbtr.setNm(dbtrName);
		transaction.setDbtr(dbtr);

		// Retrieve Bank Account by ShopBusiness id;

		// IBAN
		final CashAccountSEPA2 dbtrAcct = new CashAccountSEPA2();
		final AccountIdentificationSEPA dbtrAccId = new AccountIdentificationSEPA();
		dbtrAccId.setIBAN(dbtrIban);
		dbtrAcct.setId(dbtrAccId);
		transaction.setDbtrAcct(dbtrAcct);

		// BIC
		final BranchAndFinancialInstitutionIdentificationSEPA3 dbtrBicInf = new BranchAndFinancialInstitutionIdentificationSEPA3();

		final FinancialInstitutionIdentificationSEPA3 dbtrBankInfo = new FinancialInstitutionIdentificationSEPA3();

		dbtrBankInfo.setBIC(dbtrBic);

		dbtrBicInf.setFinInstnId(dbtrBankInfo);
		transaction.setDbtrAgt(dbtrBicInf);

		final DirectDebitTransactionSDD ddtxValue = new DirectDebitTransactionSDD();
		final MandateRelatedInformationSDD mandateInfo = new MandateRelatedInformationSDD();

		// Mandate Id
		mandateInfo.setMndtId(mandateId);

		// date of signature
		// bankAccount.getDebitMandateDate()
		mandateInfo.setDtOfSgntr(ParserUtils.dateToXmlGregorianNoOffset(dtOfSgntr));

		mandateInfo.setAmdmntInd(false);
		ddtxValue.setMndtRltdInf(mandateInfo);
		transaction.setDrctDbtTx(new DirectDebitTransactionSDD(mandateInfo, null));
		// Debitor other name
		final PartyIdentificationSEPA1 ultDbtrNm = new PartyIdentificationSEPA1();

		ultDbtrNm.setNm(ultDbtrName);

		transaction.setUltmtDbtr(ultDbtrNm);
		final RemittanceInformationSEPA1Choice rmtInf = new RemittanceInformationSEPA1Choice();
		// Verbindungszweck = RechnungsNr.
		rmtInf.setUstrd(ustrdRemInf);
		transaction.setRmtInf(rmtInf);
		return transaction;
	}

	/**
	 * creates a {@link Document} for the given param values
	 * 
	 * @param msgId
	 * @param creationDateTime
	 * @param initiatorName
	 * @param paymentInfoId
	 * @param creditorName
	 * @param creditorIban
	 * @param creditorBIC
	 * @param totalAmount
	 * @param colDate
	 * @param isFirstSeq
	 * 
	 *            <pre>
	 *  if <code>true</code> then {@link PaymentTypeInformationSDD#getSeqTp()} is set to {@link parser.model.SequenceType1Code#FRST} </br>
	 * 	else SequenceType1Code.RCUR
	 *            </pre>
	 * 
	 * @param b2b
	 *            :
	 * 
	 *            <pre>
	 *  if <code>true</code> then {@link LocalInstrumentSEPA#getCd()} is set to {@link #LOCAL_INSTRUMENT_BUSINESS} </br>
	 * 	else LOCAL_INSTRUMENT_NORMAL
	 *            </pre>
	 * 
	 * @param glauebigerId
	 * @param transactions
	 * @return
	 */
	public static Document createDocumentRaw(final String msgId, final Date creationDateTime,
			final String initiatorName, final String paymentInfoId, final String creditorName,
			final String creditorIban, final String creditorBIC, final Date colDate, final boolean isFirstSeq,
			final SepaLocalInstrumentCode sepaLocalInstrumentCode, final String glauebigerId,
			final List<DirectDebitTransactionInformationSDD> transactions) {

		Objects.requireNonNull(transactions, "transactions must not  be null");

		final Document document = new Document();
		final CustomerDirectDebitInitiationV02 ddIntiation = new CustomerDirectDebitInitiationV02();

		/*---------Group header: document info  --------*/
		final GroupHeaderSDD grpHdr = new GroupHeaderSDD();
		grpHdr.setMsgId(msgId);
		// invoice list size
		grpHdr.setNbOfTxs(String.valueOf(transactions.size()));

		grpHdr.setCreDtTm(
				ParserUtils.dateToXmlGregorian(creationDateTime, TimeZone.getTimeZone(ParserUtils.utcZoneID)));
		final PartyIdentificationSEPA1 identificationSEPA1 = new PartyIdentificationSEPA1();
		identificationSEPA1.setNm(initiatorName);
		grpHdr.setInitgPty(identificationSEPA1);
		ddIntiation.setGrpHdr(grpHdr);

		/*---------Payment Info--------*/
		final PaymentInstructionInformationSDD paymentInfo = new PaymentInstructionInformationSDD();

		// -- Creditor info
		// tenantid ? = Referenz zur eindeutigen Identifizierung des Sammlers
		paymentInfo.setPmtInfId(paymentInfoId);
		// constant DD
		paymentInfo.setPmtMtd(PaymentMethod2Code.DD);

		// Numer of transactions
		paymentInfo.setNbOfTxs(String.valueOf(transactions.size()));

		// BigDecimnal.add?
		BigDecimal totalAmount = BigDecimal
				.valueOf(transactions.stream()
						.collect(Collectors.summingDouble(i -> i.getInstdAmt().getValue().doubleValue())))
				.setScale(2, RoundingMode.CEILING);
		// Total Amount
		paymentInfo.setCtrlSum(totalAmount);

		final PaymentTypeInformationSDD paymentTypeInfo = new PaymentTypeInformationSDD();

		// --- SEPA ---
		final ServiceLevelSEPA serviceLevel = new ServiceLevelSEPA();
		serviceLevel.setCd("SEPA");
		paymentTypeInfo.setSvcLvl(serviceLevel);

		final LocalInstrumentSEPA localInstrumentSEPA = new LocalInstrumentSEPA();
		localInstrumentSEPA.setCd(sepaLocalInstrumentCode.value);
		paymentTypeInfo.setLclInstrm(localInstrumentSEPA);
		paymentTypeInfo.setSeqTp(isFirstSeq ? SequenceType1Code.FRST : SequenceType1Code.RCUR);
		paymentInfo.setPmtTpInf(paymentTypeInfo);
		ddIntiation.getPmtInf().add(paymentInfo);

		/*
		 * final Date colDate = new Date(2022 - 1900, Calendar.SEPTEMBER, 5);
		 */
		// collection date
		paymentInfo.setReqdColltnDt(ParserUtils.dateToXmlGregorianNoOffset(colDate));
		// -- Creditor Bank account info

		// Creditor info
		final PartyIdentificationSEPA5 creditor = new PartyIdentificationSEPA5();
		creditor.setNm(creditorName);
		paymentInfo.setCdtr(creditor);

		/*
		 * Creditor Bank Info
		 */
		// IBAN or Bank id
		final CashAccountSEPA1 creditorBankinfoIBAN = new CashAccountSEPA1();
		final AccountIdentificationSEPA id = new AccountIdentificationSEPA();
		id.setIBAN(creditorIban);
		creditorBankinfoIBAN.setId(id);
		paymentInfo.setCdtrAcct(creditorBankinfoIBAN);

		// BIC or Bank branch
		final BranchAndFinancialInstitutionIdentificationSEPA3 crdtrBankAndBranch = new BranchAndFinancialInstitutionIdentificationSEPA3();
		final FinancialInstitutionIdentificationSEPA3 crdtrBankId = new FinancialInstitutionIdentificationSEPA3();
		crdtrBankId.setBIC(creditorBIC);
		crdtrBankAndBranch.setFinInstnId(crdtrBankId);
		paymentInfo.setCdtrAgt(crdtrBankAndBranch);

		// Constant charge bearer: SLEV
		paymentInfo.setChrgBr(ChargeBearerTypeSEPACode.SLEV);

		// Gläubiger Id
		final PartyIdentificationSEPA3 cdtrSchmeId = new PartyIdentificationSEPA3();
		final PartySEPA2 schemeId = new PartySEPA2();
		final PersonIdentificationSEPA2 prvtId = new PersonIdentificationSEPA2();
		final RestrictedPersonIdentificationSEPA personIdentificationSEPA = new RestrictedPersonIdentificationSEPA();
		personIdentificationSEPA.setId(glauebigerId);

		final RestrictedPersonIdentificationSchemeNameSEPA schemNm = new RestrictedPersonIdentificationSchemeNameSEPA();
		schemNm.setPrtry(IdentificationSchemeNameSEPA.SEPA);
		personIdentificationSEPA.setSchmeNm(schemNm);
		prvtId.setOthr(personIdentificationSEPA);
		schemeId.setPrvtId(prvtId);
		cdtrSchmeId.setId(schemeId);
		paymentInfo.setCdtrSchmeId(cdtrSchmeId);

		paymentInfo.getDrctDbtTxInf().addAll(transactions);
		document.setCstmrDrctDbtInitn(ddIntiation);
		return document;

	}

}
