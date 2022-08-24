package parser.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Azahar Hossain (c) 2022
 *
 */

@XmlType(name = "IdentificationSchemeNameSEPA")
@XmlEnum
public enum IdentificationSchemeNameSEPA
{
	SEPA;
	public String value()
	{
		return name();
	}

	public static IdentificationSchemeNameSEPA fromValue(String v)
	{
		return valueOf(v);
	}

}