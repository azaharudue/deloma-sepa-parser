package parser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import parser.model.pain.Document;
import parser.model.pain.ObjectFactory;

/**
 * @author Azahar Hossain (c) 2022
 *
 */
public class PainParser {

	public enum PainDocumentType {
		PAIN00800302,
	}

	static PainDocumentType documentType;

	public PainParser() {
	}

	public PainParser(PainDocumentType documentType) {
		PainParser.documentType = documentType;
	}

	/**
	 * Read PAIN.008.003.02.xml and return a documentPain00800302
	 * 
	 * @param <T>
	 * 
	 * @throws Exception
	 */
	public static <T> T parse(InputStream is) throws Exception {
		T t = null;
		switch (documentType) {
		case PAIN00800302:
			t = BaseXmlFactory.parse(is, Document.class);
		}
		return t;
	}

	public static boolean createDocument(String filePath, PainDocumentType type, Document document) {

		String xsdFilePath = "";
		String schemaLocation = "";

		switch (type) {

		case PAIN00800302:
			xsdFilePath += "src/main/java/schemaFiles/pain.008.003.02.xsd";
			System.out.println(xsdFilePath);
			schemaLocation += "urn:iso:std:iso:20022:tech:xsd:pain.008.003.02 pain.008.003.02.xsd";
			return createDocument(filePath, document, xsdFilePath, schemaLocation);

		default:
			throw new UnsupportedOperationException("unknown type");
		}
	}

	public static boolean createDocument(String filePath, Document document, String xsdFilePath,
			String schemaLocation) {
		Objects.requireNonNull(filePath, "filePath must not be null!");
		Objects.requireNonNull(xsdFilePath, "xsdFilePath must not be null!");
		Objects.requireNonNull(schemaLocation, "schemaLocation must not be null!");

		File file = new File(filePath);
		File xsdFile = new File(xsdFilePath);
		try {
			return BaseXmlFactory.createXmlFile(file, document, xsdFile, schemaLocation, ObjectFactory.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public PainDocumentType getDocumentType() {
		return documentType;
	}

}
