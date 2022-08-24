package parser.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Azahar Hossain (c) 2022
 *
 */

@XmlType(name = "DocumentType3CodeSEPA")
@XmlEnum
public enum DocumentType3CodeSEPA
{

	SCOR;
	public String value()
	{
		return name();
	}

	public static DocumentType3CodeSEPA fromValue(String v)
	{
		return valueOf(v);
	}

}
