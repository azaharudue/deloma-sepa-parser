package parser.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Azahar Hossain (c) 2022
 *
 */
@XmlType(name = "ChargeBearerTypeSEPACode")
@XmlEnum
public enum ChargeBearerTypeSEPACode
{
	SLEV;

	public String value()
	{
		return name();
	}

	public static ChargeBearerTypeSEPACode fromValue(String v)
	{
		return valueOf(v);
	}
}
