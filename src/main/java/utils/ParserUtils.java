package utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author Azahar Hossain  (c) 2022
 *
 */
public class ParserUtils {

	public static ZoneId utcZoneID = ZoneId.of("Etc/UTC");

	public static DateTimeFormatter formatterLocal = DateTimeFormatter.ISO_LOCAL_DATE;
	public static DateTimeFormatter formatterINSTANT = DateTimeFormatter.ISO_INSTANT;

	/**
	 * Converts given Date objct to XMLGregorianCalendars
	 * 
	 * @param date
	 * @return
	 */
	@Deprecated
	public static XMLGregorianCalendar dateToXMLGregorianCalendar(Date date, TimeZone timeZone) {

		GregorianCalendar cal = new GregorianCalendar();
		date.setYear(date.getYear()-1900);
		date.setMonth(date.getMonth()-1);
		cal.setTime(date);
		cal.setTimeZone(timeZone!=null?timeZone:TimeZone.getTimeZone(utcZoneID));
		try {
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static XMLGregorianCalendar gregorianCalendarToXmlGregorian(GregorianCalendar cal, TimeZone timeZone) {
		try {
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * @param date
	 * @param timeZone
	 * @return
	 */
	public static XMLGregorianCalendar dateToXmlGregorian(Date date, TimeZone timeZone){
		
		if(date == null)
			return null; 
		//Moment 
		Instant intant = date.toInstant();
		ZonedDateTime  zonedDateTime = intant.atZone(timeZone==null?utcZoneID: timeZone.toZoneId());
		GregorianCalendar cal = GregorianCalendar.from(zonedDateTime);
		//TODO Is it obsolete to set timeZone ?? 
		cal.setTimeZone(timeZone);
		
		return getXMLCalender(cal);
	
	}
	
	/**
	 * From a given Date Object return a XMLGregorianCalendar of Date without timezone and offset in format "YYYY-MM-DD"
	 * 
	 * @param date
	 * @return {@link XMLGregorianCalendar}
	 */
	public static XMLGregorianCalendar dateToXmlGregorianNoOffset(Date date){
		if(date == null)
			return null; 
		GregorianCalendar cal = new GregorianCalendar();	
		cal.setTime(date);
		XMLGregorianCalendar xmlCal = getXMLCalender(cal); 
		xmlCal.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
		return xmlCal; 
		
	}
	
	private static XMLGregorianCalendar getXMLCalender(GregorianCalendar cal){
		try {
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
			return null; 
		}
	}
	
}
