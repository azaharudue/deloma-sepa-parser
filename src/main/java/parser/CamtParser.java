package parser;

import java.io.InputStream;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

import parser.model.AccountReport11;
import parser.model.BankToCustomerAccountReportV02;
import parser.model.Document052;
import parser.model.Document053;
import parser.model.Document054;

/**
 * Main CamtParser class parses xml file to given Class type f.e
 * {@link Document052} for Camt052
 */
public class CamtParser
{
	public enum CAMTTYPE
	{
		CAMT52,
		CAMT53,
		CAMT54;

	}

	protected CAMTTYPE camtType;

	public CamtParser()
	{

	}

	/**
	 * @param camtType
	 */
	public CamtParser(CAMTTYPE camtType)
	{
		this.camtType = camtType;
	}

	/**
	 * Parses a
	 * <ul>
	 * <li>camt052.001.02.xml</li> or
	 * <li>camt053.001.02.xml</li> or
	 * <li>camt054.001.02.xml</li>
	 * </ul>
	 * file and returns a {@link Document052} object
	 * 
	 * @param is
	 * @return
	 * @throws Exception
	 * @throws JAXBException
	 * @throws XMLStreamException
	 */
	public Object parse(InputStream is) throws Exception
	{
		switch (camtType)
		{
			case CAMT52:
				return BaseXmlFactory.parse(is, Document052.class, AccountReport11.class, BankToCustomerAccountReportV02.class);
			case CAMT53:
				return BaseXmlFactory.parse(is, Document053.class);
			case CAMT54:
				return BaseXmlFactory.parse(is, Document054.class);
			default:
				throw new UnsupportedOperationException("unknown camt type: " + camtType);
		}
	}

}
