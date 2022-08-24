package parser.model;

/**
 * @author Azahar Hossain (c) 2022
 *
 */
public enum SequenceType1Code
{
	FRST,
	RCUR,
	FNAL,
	OOFF;

	public String value()
	{
		return name();
	}

	public static SequenceType1Code fromValue(String v)
	{
		return valueOf(v);
	}
}
