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
 * Java class for PartySEPAChoice complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="PartySEPAChoice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgId" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.02}OrganisationIdentificationSEPAChoice"/>
 *         &lt;element name="PrvtId" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.02}PersonIdentificationSEPA1Choice" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartySEPAChoice")
public class PartySEPAChoice
{

	@XmlElement(name = "OrgId")
	protected OrganisationIdentificationSEPAChoice orgId;

	@XmlElement(name = "PrvtId")
	protected PersonIdentificationSEPA1Choice prvtId;

	/**
	 * 
	 */
	public PartySEPAChoice()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param orgId
	 * @param prvtId
	 */
	public PartySEPAChoice(OrganisationIdentificationSEPAChoice orgId, PersonIdentificationSEPA1Choice prvtId)
	{
		this.orgId = orgId;
		this.prvtId = prvtId;
	}

	public OrganisationIdentificationSEPAChoice getOrgId()
	{
		return orgId;
	}

	public PersonIdentificationSEPA1Choice getPrvtId()
	{
		return prvtId;
	}

}
