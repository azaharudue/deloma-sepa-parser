//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB)
// Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source
// schema.
// Generated on: 2015.04.08 at 10:37:47 AM CEST
//

package parser.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import parser.model.abs.DocumentAbs;

/**
 * <p>
 * Java class for Document complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="Document">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BkToCstmrDbtCdtNtfctn" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.02}BkToCstmrDbtCdtNtfctn"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */

@XmlRootElement(name = "Document")
@XmlType(name = "Document", propOrder =
{
	"bkToCstmrDbtCdtNtfctn"
})
public class Document054 extends DocumentAbs
{

	@XmlElement(name = "BkToCstmrDbtCdtNtfctn", required = true)
	protected BankToCustomerDebitCreditNotificationV02 bkToCstmrDbtCdtNtfctn;

	/**
	 * Gets the value of the bkToCstmrDbtCdtNtfctn property.
	 * 
	 * @return possible object is
	 *         {@link BankToCustomerDebitCreditNotificationV02 }
	 * 
	 */
	public BankToCustomerDebitCreditNotificationV02 getBkToCstmrDbtCdtNtfctn()
	{
		return bkToCstmrDbtCdtNtfctn;
	}

	/**
	 * Sets the value of the bkToCstmrDbtCdtNtfctn property.
	 * 
	 * @param value
	 *            allowed object is {@link BkToCstmrDbtCdtNtfctn }
	 * 
	 */
	public void setBkToCstmrDbtCdtNtfctn(BankToCustomerDebitCreditNotificationV02 value)
	{
		this.bkToCstmrDbtCdtNtfctn = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Document054 [bkToCstmrDbtCdtNtfctn=" + bkToCstmrDbtCdtNtfctn + "]";
	}

}
