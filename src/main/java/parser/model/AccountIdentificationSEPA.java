package parser.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Azahar Hossain (c) 2022
 *
 */

/**
 * <p>
 * Java class for AccountIdentificationSEPA complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="AccountIdentificationSEPA">
 *   &lt;complexContent>
 *       &lt;sequence>
 *           &lt;element name="IBAN" type="{urn:iso:std:iso:20022:tech:xsd:camt.008.003.02}IBAN2007Identifier"/>
 *       &lt;/sequence>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountIdentificationSEPA")
public class AccountIdentificationSEPA
{
	@XmlElement(name = "IBAN")
	protected String iban;

	/**
	 * 
	 */
	public AccountIdentificationSEPA()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param iban
	 */
	public AccountIdentificationSEPA(String iban)
	{
		this.iban = iban;
	}

	/**
	 * Gets the value of the iban property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIban()
	{
		return iban;
	}

	public AccountIdentificationSEPA setIban(String iban)
	{
		this.iban = iban;
		return this;
	}
}