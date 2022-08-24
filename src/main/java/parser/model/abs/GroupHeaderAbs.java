
package parser.model.abs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for GroupHeaderAbs complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="GroupHeaderAbs">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MsgId" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.02}Max35Text"/>
 *         &lt;element name="CreDtTm" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.02}ISODateTime"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class GroupHeaderAbs
{

	@XmlElement(name = "MsgId", required = true)
	protected String msgId;
	@XmlElement(name = "CreDtTm", required = true)
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar creDtTm;

	/**
	 * Gets the value of the msgId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMsgId()
	{
		return msgId;
	}

	/**
	 * Sets the value of the msgId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMsgId(String value)
	{
		this.msgId = value;
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
}
