package parser.model;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Azahar Hossain (c) 2022
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatchInformation2", propOrder = { "msgId", "pmtInfId", "nbOfTxs", "ttlAmt", "cdtDbtInd" })
public class BatchInformation2 {

	@XmlElement(name = "MsgId")
	protected String msgId;
	@XmlElement(name = "PmtInfId")
	protected String pmtInfId;
	@XmlElement(name = "NbOfTxs")
	protected String nbOfTxs;
	@XmlElement(name = "TtlAmt")
	protected ActiveOrHistoricCurrencyAndAmount ttlAmt;
	@XmlElement(name = "CdtDbtInd")
	protected CreditDebitCode cdtDbtInd;

	/**
	 * Gets the value of the msgId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMsgId() {
		return msgId;
	}

	/**
	 * Sets the value of the msgId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMsgId(String value) {
		this.msgId = value;
	}

	/**
	 * Gets the value of the pmtInfId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPmtInfId() {
		return pmtInfId;
	}

	/**
	 * Sets the value of the pmtInfId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPmtInfId(String value) {
		this.pmtInfId = value;
	}

	/**
	 * Gets the value of the nbOfTxs property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNbOfTxs() {
		return nbOfTxs;
	}

	/**
	 * Sets the value of the nbOfTxs property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNbOfTxs(String value) {
		this.nbOfTxs = value;
	}

	/**
	 * Gets the value of the ttlAmt property.
	 * 
	 * @return possible object is {@link ActiveOrHistoricCurrencyAndAmount }
	 * 
	 */
	public ActiveOrHistoricCurrencyAndAmount getTtlAmt() {
		return ttlAmt;
	}

	/**
	 * Sets the value of the ttlAmt property.
	 * 
	 * @param value
	 *            allowed object is {@link ActiveOrHistoricCurrencyAndAmount }
	 * 
	 */
	public void setTtlAmt(ActiveOrHistoricCurrencyAndAmount value) {
		this.ttlAmt = value;
	}

	/**
	 * Gets the value of the cdtDbtInd property.
	 * 
	 * @return possible object is {@link CreditDebitCode }
	 * 
	 */
	public CreditDebitCode getCdtDbtInd() {
		return cdtDbtInd;
	}

	/**
	 * Sets the value of the cdtDbtInd property.
	 * 
	 * @param value
	 *            allowed object is {@link CreditDebitCode }
	 * 
	 */
	public void setCdtDbtInd(CreditDebitCode value) {
		this.cdtDbtInd = value;
	}

}
