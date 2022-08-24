/**
 * 
 */
package parser.model.abs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;

import parser.model.AccountInterest2;
import parser.model.CashAccount16;
import parser.model.CashAccount20;
import parser.model.CashBalance3;
import parser.model.CopyDuplicate1Code;
import parser.model.DateTimePeriodDetails;
import parser.model.ReportEntry2;
import parser.model.ReportingSource1Choice;
import parser.model.TotalTransactions2;

/**
 * @author Azahar Hossain (c) 2022
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AccountReportAbs
{
	@XmlElement(name = "Id", required = true)
	protected String id;
	@XmlElement(name = "ElctrncSeqNb")
	protected BigDecimal elctrncSeqNb;
	@XmlElement(name = "LglSeqNb")
	protected BigDecimal lglSeqNb;
	@XmlElement(name = "CreDtTm", required = true)
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar creDtTm;
	@XmlElement(name = "FrToDt")
	protected DateTimePeriodDetails frToDt;
	@XmlElement(name = "CpyDplctInd")
	@XmlSchemaType(name = "string")
	protected CopyDuplicate1Code cpyDplctInd;
	@XmlElement(name = "RptgSrc")
	protected ReportingSource1Choice rptgSrc;
	@XmlElement(name = "Acct", required = true)
	protected CashAccount20 acct;
	@XmlElement(name = "RltdAcct")
	protected CashAccount16 rltdAcct;
	@XmlElement(name = "Intrst")
	protected List<AccountInterest2> intrst;
	@XmlElement(name = "Bal", required = true)
	protected List<CashBalance3> bal;
	@XmlElement(name = "TxsSummry")
	protected TotalTransactions2 txsSummry;
	@XmlElement(name = "Ntry")
	protected List<ReportEntry2> ntry;

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setId(String value)
	{
		this.id = value;
	}

	/**
	 * Gets the value of the elctrncSeqNb property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 *
	 */
	public BigDecimal getElctrncSeqNb()
	{
		return elctrncSeqNb;
	}

	/**
	 * Sets the value of the elctrncSeqNb property.
	 *
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 *
	 */
	public void setElctrncSeqNb(BigDecimal value)
	{
		this.elctrncSeqNb = value;
	}

	/**
	 * Gets the value of the lglSeqNb property.
	 *
	 * @return possible object is {@link BigDecimal }
	 *
	 */
	public BigDecimal getLglSeqNb()
	{
		return lglSeqNb;
	}

	/**
	 * Sets the value of the lglSeqNb property.
	 *
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 *
	 */
	public void setLglSeqNb(BigDecimal value)
	{
		this.lglSeqNb = value;
	}

	/**
	 * Gets the value of the creDtTm property.
	 *
	 * @return possible object is {@link XMLGregorianCalendar }
	 *
	 */
	public XMLGregorianCalendar getCreDtTm()
	{
		return creDtTm;
	}

	/**
	 * Sets the value of the creDtTm property.
	 *
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setCreDtTm(XMLGregorianCalendar value)
	{
		this.creDtTm = value;
	}

	/**
	 * Gets the value of the frToDt property.
	 * 
	 * @return possible object is {@link DateTimePeriodDetails }
	 * 
	 */
	public DateTimePeriodDetails getFrToDt()
	{
		return frToDt;
	}

	/**
	 * Sets the value of the frToDt property.
	 * 
	 * @param value
	 *            allowed object is {@link DateTimePeriodDetails }
	 * 
	 */
	public void setFrToDt(DateTimePeriodDetails value)
	{
		this.frToDt = value;
	}

	/**
	 * Gets the value of the cpyDplctInd property.
	 * 
	 * @return possible object is {@link CopyDuplicate1Code }
	 * 
	 */
	public CopyDuplicate1Code getCpyDplctInd()
	{
		return cpyDplctInd;
	}

	/**
	 * Sets the value of the cpyDplctInd property.
	 * 
	 * @param value
	 *            allowed object is {@link CopyDuplicate1Code }
	 * 
	 */
	public void setCpyDplctInd(CopyDuplicate1Code value)
	{
		this.cpyDplctInd = value;
	}

	/**
	 * Gets the value of the rptgSrc property.
	 * 
	 * @return possible object is {@link ReportingSource1Choice }
	 * 
	 */
	public ReportingSource1Choice getRptgSrc()
	{
		return rptgSrc;
	}

	/**
	 * Sets the value of the rptgSrc property.
	 * 
	 * @param value
	 *            allowed object is {@link ReportingSource1Choice }
	 * 
	 */
	public void setRptgSrc(ReportingSource1Choice value)
	{
		this.rptgSrc = value;
	}

	/**
	 * Gets the value of the acct property.
	 * 
	 * @return possible object is {@link CashAccount20 }
	 * 
	 */
	public CashAccount20 getAcct()
	{
		return acct;
	}

	/**
	 * Sets the value of the acct property.
	 * 
	 * @param value
	 *            allowed object is {@link CashAccount20 }
	 * 
	 */
	public void setAcct(CashAccount20 value)
	{
		this.acct = value;
	}

	/**
	 * Gets the value of the rltdAcct property.
	 * 
	 * @return possible object is {@link CashAccount16 }
	 * 
	 */
	public CashAccount16 getRltdAcct()
	{
		return rltdAcct;
	}

	/**
	 * Sets the value of the rltdAcct property.
	 * 
	 * @param value
	 *            allowed object is {@link CashAccount16 }
	 * 
	 */
	public void setRltdAcct(CashAccount16 value)
	{
		this.rltdAcct = value;
	}

	/**
	 * Gets the value of the intrst property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the intrst property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getIntrst().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link AccountInterest2 }
	 * 
	 * 
	 */
	public List<AccountInterest2> getIntrst()
	{
		if (intrst == null)
		{
			intrst = new ArrayList<AccountInterest2>();
		}
		return this.intrst;
	}

	/**
	 * Gets the value of the bal property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the bal property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getBal().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link CashBalance3 }
	 * 
	 * 
	 */
	public List<CashBalance3> getBal()
	{
		if (bal == null)
		{
			bal = new ArrayList<CashBalance3>();
		}
		return this.bal;
	}

	/**
	 * Gets the value of the txsSummry property.
	 * 
	 * @return possible object is {@link TotalTransactions2 }
	 * 
	 */
	public TotalTransactions2 getTxsSummry()
	{
		return txsSummry;
	}

	/**
	 * Sets the value of the txsSummry property.
	 * 
	 * @param value
	 *            allowed object is {@link TotalTransactions2 }
	 * 
	 */
	public void setTxsSummry(TotalTransactions2 value)
	{
		this.txsSummry = value;
	}

	/**
	 * Gets the value of the ntry property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the ntry property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getNtry().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link ReportEntry2 }
	 * 
	 * 
	 */
	public List<ReportEntry2> getNtry()
	{
		if (ntry == null)
		{
			ntry = new ArrayList<ReportEntry2>();
		}
		return this.ntry;
	}

	public void addNtry(ReportEntry2 ntry)
	{
		this.getNtry().add(ntry);
	}

}
