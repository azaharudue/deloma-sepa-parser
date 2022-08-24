package parser.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Azahar Hossain (c) 2022
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CashAccountSEPA2")
public class CashAccountSEPA2
{
	@XmlElement(name = "Id")
	protected AccountIdentificationSEPA id;

	/**
	 * 
	 */
	public CashAccountSEPA2()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 */
	public CashAccountSEPA2(AccountIdentificationSEPA id)
	{
		this.id = id;
	}

	public AccountIdentificationSEPA getId()
	{
		return id;
	}

	public void setId(AccountIdentificationSEPA id)
	{
		this.id = id;
	}

}
