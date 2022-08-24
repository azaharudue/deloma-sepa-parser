package parser.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Azahar Hossain (c) 2022
 */

@XmlType(name = "RestrictedSMNDACode")
@XmlEnum
public enum RestrictedSMNDACode
{
	SMNDA;

	public String value()
	{
		return name();
	}

	public static RestrictedSMNDACode fromValue(String v)
	{
		return valueOf(v);
	}

}
