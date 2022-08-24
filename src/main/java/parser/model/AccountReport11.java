/**
 * 
 */
package parser.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import parser.model.abs.AccountReportAbs;

/**
 * @author Azahar Hossain (c) 2022
 *
 */

@XmlType(name = "AccountNotification2")
public class AccountReport11 extends AccountReportAbs
{
	@XmlElement(name = "AddtlStmtInf")
	protected String addtlStmtInf;

	/**
	 * Gets the value of the addtlStmtInf property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAddtlStmtInf()
	{
		return addtlStmtInf;
	}

	/**
	 * Sets the value of the addtlStmtInf property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAddtlStmtInf(String value)
	{
		this.addtlStmtInf = value;
	}
}
