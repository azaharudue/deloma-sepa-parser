package parser.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author azahar Hossain (c) 2022
 *
 */
/**
 * <p>
 * Java class for CashAccountSEPA1 complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="CashAccountSEPA1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="AccountIdentificationSEPA"/>
 *         &lt;element  name="Ccy" type="ActiveOrHistoricCurrencyCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CashAccountSEPA1")
public class CashAccountSEPA1
{

	@XmlElement(name = "Id", required = true)
	protected AccountIdentificationSEPA id;

	@XmlElement(name = "Ccy")
	protected String ccy;

	public CashAccountSEPA1()
	{
	}

	public CashAccountSEPA1(AccountIdentificationSEPA id, String ccy)
	{
		this.id = id;
		this.ccy = ccy;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("CashAccountSEPA1 [id=").append(id.getIban()).append(", ccy=").append(ccy).append("]");
		return builder.toString();
	}

}
