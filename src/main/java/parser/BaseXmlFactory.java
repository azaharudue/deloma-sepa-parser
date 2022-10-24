package parser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.text.ParseException;
import java.util.Arrays;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import com.sun.xml.internal.stream.writers.WriterUtility;

import parser.model.abs.DocumentAbs;

/**
 * @author Azahar Hossain (c) 2022
 *
 */
public class BaseXmlFactory {
	

	/**
	 * Writes from Java objects classes to Xml file & validates against given
	 * xsd schema file.
	 * 
	 * @param file
	 * @param t
	 * @param xsdFile
	 * @param schemaLocation
	 * @return
	 * @throws IOException 
	 */
	public static <T> String createXmlFile(T t, String schemaLocation, Class<?>... classes) throws IOException {

		try {

						
			// Resize the classes array
			Class<?>[] classesParam = Arrays.copyOf(classes, classes.length + 2);
			
			
			// Provided document type
			classesParam[classesParam.length - 1] = t.getClass();
			// Base document always
			classesParam[classesParam.length - 2] = DocumentAbs.class;

			// Create JAXB Context
			JAXBContext jaxbContext = JAXBContext.newInstance(classesParam);
			
			// Create Marshaller
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, schemaLocation);
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			// jaxbMarshaller.setSchema(schema);
			 StringWriter sw = new StringWriter();
			 		       
			// Writes XML file to file-system
			jaxbMarshaller.marshal(t, sw);
			
			//jaxbMarshaller.marshal(t, System.out);
			
			//OutputStream os  = new FileOutputStream(file);
			//XMLOutputFactory outputFactory = XMLOutputFactory.newInstance(); 
			
			//XMLStreamWriter  w = outputFactory.createXMLStreamWriter(os);
			

			// Validate against given schema file

			//SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			//Schema schema = factory.newSchema(xsdFile);
			//jaxbMarshaller.setSchema(schema);
			//schema.newValidator().validate(new StreamSource(file));
			return sw.toString();

		} catch (JAXBException  e)
		// | SAXException | IOException e

		{
			e.printStackTrace();

		}
		return null;

	}

	@SuppressWarnings("unchecked")
	public static <T> T parse(InputStream is, Class<?> doc, Class<?>... classes) throws Exception {
		try {
			// Resize the classes array
			Class<?>[] classesParam = Arrays.copyOf(classes, classes.length + 2);
			// Provided document type
			classesParam[classesParam.length - 1] = doc;
			// Base document always
			classesParam[classesParam.length - 2] = DocumentAbs.class;

			// adds also abstract classes in the jaxbcontext
			JAXBContext jc;

			jc = JAXBContext.newInstance(classesParam);

			final XMLInputFactory xif = XMLInputFactory.newInstance();

			// set namespace-check to false
			xif.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, false);
			final XMLStreamReader xsr = xif.createXMLStreamReader(is);

			Unmarshaller unmarshaller = jc.createUnmarshaller();
			T t = (T) unmarshaller.unmarshal(xsr);

			Marshaller marshaller = jc.createMarshaller();
			// marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			// marshaller.marshal(t, System.out);

			return t;
		} catch (JAXBException | XMLStreamException e) {

			e.printStackTrace();

			throw new ParseException("Parsing failed" + e.getLocalizedMessage(), 0);

		}

	}
}
