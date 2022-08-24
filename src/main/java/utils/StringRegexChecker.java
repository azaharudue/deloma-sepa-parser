package utils;

import java.rmi.UnexpectedException;
import java.util.regex.Pattern;

/**
 * @author Azahar Hossain (c) 2022
 *
 */
public class StringRegexChecker
{
	private String bicIdentifier;

	public void check(String value) throws UnexpectedException
	{
		Pattern pattern = Pattern.compile("[A-Z]{3,3}");
		if (!pattern.matcher(value).matches())
			throw new UnexpectedException(value + "doesn't match the required ActiveOrHistoricCurrencyCode format!");
	}
}
