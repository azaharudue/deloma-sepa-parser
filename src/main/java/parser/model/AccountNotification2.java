package parser.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import parser.model.abs.AccountReportAbs;

/**
 * @author Azahar Hossain (c) 2022
 *
 */

@XmlType(name = "AccountNotification2")
public class AccountNotification2 extends AccountReportAbs
{

	@XmlElement(name = "AddtlNtfctnInf")
	private String addtlNtfctnInf;

	/**
	 * Gets the value of the addtlNtfctnInf property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAddtlNtfctnInf()
	{
		return addtlNtfctnInf;
	}

	/**
	 * Sets the value of the addtlNtfctnInf property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public AccountNotification2 setAddtlNtfctnInf(String value)
	{
		this.addtlNtfctnInf = value;
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "AccountNotification2 [" + (addtlNtfctnInf != null ? "addtlNtfctnInf=" + addtlNtfctnInf + ", " : "") + (id != null ? "id=" + id + ", " : "")
			+ (elctrncSeqNb != null ? "elctrncSeqNb=" + elctrncSeqNb + ", " : "") + (creDtTm != null ? "creDtTm=" + creDtTm + ", " : "")
			+ (frToDt != null ? "frToDt=" + frToDt + ", " : "") + (cpyDplctInd != null ? "cpyDplctInd=" + cpyDplctInd + ", " : "")
			+ (rptgSrc != null ? "rptgSrc=" + rptgSrc + ", " : "") + (acct != null ? "acct=" + acct + ", " : "")
			+ (rltdAcct != null ? "rltdAcct=" + rltdAcct + ", " : "") + (intrst != null ? "intrst=" + intrst + ", " : "")
			+ (bal != null ? "bal=" + bal + ", " : "") + (txsSummry != null ? "txsSummry=" + txsSummry + ", " : "") + (ntry != null ? "ntry=" + ntry : "")
			+ "]";
	}

}
