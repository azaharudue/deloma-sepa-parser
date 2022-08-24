package parser.model.abs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Azahar Hossain (c) 2022
 *
 */

/**
 * <p>
 * Java class for PartyIdentificationSEPA1 complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="PartyIdentificationSEPA(1,2,4,5)">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Nm" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.003.02}Max70Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PartyIdentificationSEPAAbs
{

	@XmlElement(name = "Nm", required = true)
	protected String nm;

	public String getNm()
	{
		return nm;
	}

	public PartyIdentificationSEPAAbs setNm(String nm)
	{
		this.nm = nm;
		return this;
	}

}
