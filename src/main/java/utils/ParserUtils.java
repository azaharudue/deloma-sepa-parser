package utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author Azahar Hossain Hossain (c) 2022
 *
 */
public class ParserUtils {
	
	public static ZoneId utcZoneID = ZoneId.of("Etc/UTC");

	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");

	/**
	 * Converts given Date objct to XMLGregorianCalendars
	 * 
	 * @param date
	 * @return
	 */
	public static XMLGregorianCalendar dateToXMLGregorianCalendar(Date date, TimeZone timeZone) {
		
		date = Date.from(date.toInstant().atZone(utcZoneID).toInstant());
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTimeZone(timeZone);
		cal.setTime(date);
		try {
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
			return null;
		}

	}
}
