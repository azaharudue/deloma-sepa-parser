package parser.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import parser.model.abs.GroupHeaderAbs;

/**
 * @author Azahar Hossain (c) 2022
 *
 */

/**
 * <p>
 * Java class for GroupHeaderSDD complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="GroupHeaderSDD">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MsgId" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.02}RestrictedIdentificationSEPA1" minOccurs="0"/>
 *         &lt;element name="CreDtTm" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.02}Max35Text" minOccurs="0"/>
 *         &lt;element name="NbOfTxs" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.02}Max15NumericText" minOccurs="0"/>
 *         &lt;element name="CtrlSum" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.02}DecimalNumber" minOccurs="0"/>
 *         &lt;element name="InitgPty" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.02}PartyIdentificationSEPA1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 */
@XmlType(name = "GroupHeaderSDD")
public class GroupHeaderSDD extends GroupHeaderAbs
{

	@XmlElement(name = "NbOfTxs", required = true)
	protected String nbOfTxs;

	@XmlElement(name = "CtrlSum", required = true)
	protected BigDecimal ctrlSum;

	@XmlElement(name = "InitgPty", required = true)
	protected PartyIdentificationSEPA1 initgPty;

	/**
	 * 
	 */
	public GroupHeaderSDD()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nbOfTxs
	 * @param ctrlSum
	 * @param initgPty
	 */
	public GroupHeaderSDD(String msgId, XMLGregorianCalendar creDtTm,   String nbOfTxs, BigDecimal ctrlSum, PartyIdentificationSEPA1 initgPty)
	{	this.msgId = msgId; 
		this.creDtTm = creDtTm;
		this.nbOfTxs = nbOfTxs;
		this.ctrlSum = ctrlSum;
		this.initgPty = initgPty;
	}

	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GroupHeaderSDD [nbOfTxs=").append(nbOfTxs).append(", ctrlSum=").append(ctrlSum)
				.append(", initgPty=").append(initgPty).append(", msgId=").append(msgId).append(", creDtTm=")
				.append(creDtTm).append("]");
		return builder.toString();
	}

	/**
	 * @return the nbOfTxs
	 */
	public String getNbOfTxs()
	{
		return nbOfTxs;
	}

	/**
	 * @return the ctrlSum
	 */
	public BigDecimal getCtrlSum()
	{
		return ctrlSum;
	}

	/**
	 * @return the initgPty
	 */
	public PartyIdentificationSEPA1 getInitgPty()
	{
		return initgPty;
	}

	public void setNbOfTxs(String nbOfTxs)
	{
		this.nbOfTxs = nbOfTxs;
	}

	public void setCtrlSum(BigDecimal ctrlSum)
	{
		this.ctrlSum = ctrlSum;
	}

	public void setInitgPty(PartyIdentificationSEPA1 initgPty)
	{
		this.initgPty = initgPty;
	}

}
