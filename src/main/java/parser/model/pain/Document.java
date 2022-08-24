package parser.model.pain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import parser.model.abs.DocumentAbs;

@XmlRootElement
@XmlType(name = "Document", propOrder = { "cstmrDrctDbtInitn" })
public class Document extends DocumentAbs {

	@XmlElement(name = "CstmrDrctDbtInitn", required = true)
	protected CustomerDirectDebitInitiationV02 cstmrDrctDbtInitn;

	/**
	 * Gets the value of the cstmrDrctDbtInitn property.
	 * 
	 * @return possible object is {@link CustomerDirectDebitInitiationV02 }
	 * 
	 */
	public CustomerDirectDebitInitiationV02 getCstmrDrctDbtInitn() {
		return cstmrDrctDbtInitn;
	}

	/**
	 * Sets the value of the cstmrDrctDbtInitn property.
	 * 
	 * @param value
	 *            allowed object is {@link CustomerDirectDebitInitiationV02 }
	 * 
	 */
	public void setCstmrDrctDbtInitn(CustomerDirectDebitInitiationV02 value) {
		this.cstmrDrctDbtInitn = value;
	}
}