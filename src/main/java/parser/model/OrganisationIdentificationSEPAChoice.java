package parser.model;

import javax.xml.bind.annotation.XmlType;

import parser.model.abs.OrganisationIdentificationAbs;

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
 * &lt;complexType name="OrganisationIdentificationSEPAChoice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BICOrBEI" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.003.02}AnyBICIdentifier" minOccurs="0"/>
 *         &lt;element name="Othr" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.003.02}GenericOrganisationIdentification1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 */
@XmlType(name = "OrganisationIdentificationSEPAChoice")
public class OrganisationIdentificationSEPAChoice extends OrganisationIdentificationAbs
{
}
