package parser.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import parser.model.abs.PartyIdentificationSEPAAbs;

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
 * &lt;complexType name="PartyIdentificationSEPA1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Nm" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.003.02}Max70Text" minOccurs="0"/>
 *         &lt;element name="Id" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.003.02}PartySEPAChoice" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartyIdentificationSEPA1")
public class PartyIdentificationSEPA1 extends PartyIdentificationSEPAAbs
{

	@XmlElement(name = "Id", required = true)
	protected PartySEPAChoice id;

	public PartyIdentificationSEPA1()
	{
		// TODO Auto-generated constructor stub
	}

	public PartyIdentificationSEPA1(PartySEPAChoice id)
	{
		this.id = id;
	}

	public PartyIdentificationSEPA1(String nm)
	{
		super.setNm(nm);

	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("PartyIdentificationSEPA1 [id=").append(id).append(", nm=").append(nm).append("]");
		return builder.toString();
	}

	public PartySEPAChoice getId()
	{
		return id;
	}

	public void setId(PartySEPAChoice id)
	{
		this.id = id;
	}

}
