//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2022.09.06 um 03:11:14 PM CEST 
//


package parser.model.camt52;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse f�r CashBalanceAvailabilityDate1 complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CashBalanceAvailabilityDate1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="NbOfDays" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.02}Max15PlusSignedNumericText"/>
 *           &lt;element name="ActlDt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.02}ISODate"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CashBalanceAvailabilityDate1", propOrder = {
    "nbOfDays",
    "actlDt"
})
public class CashBalanceAvailabilityDate1 {

    @XmlElement(name = "NbOfDays")
    protected String nbOfDays;
    @XmlElement(name = "ActlDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar actlDt;

    /**
     * Ruft den Wert der nbOfDays-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbOfDays() {
        return nbOfDays;
    }

    /**
     * Legt den Wert der nbOfDays-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbOfDays(String value) {
        this.nbOfDays = value;
    }

    /**
     * Ruft den Wert der actlDt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActlDt() {
        return actlDt;
    }

    /**
     * Legt den Wert der actlDt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActlDt(XMLGregorianCalendar value) {
        this.actlDt = value;
    }

}
