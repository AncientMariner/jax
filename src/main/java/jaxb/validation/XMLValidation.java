package jaxb.validation;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XMLValidation {

    public static void main(String[] args) {
        System.out.println("employeeRequest.xml validates against employee.xsd? " + validateXMLSchema("employee.xsd", "employeeRequest.xml"));
        System.out.println("employeeResponse.xml validates against employee.xsd? " + validateXMLSchema("employee.xsd", "employeeResponse.xml"));
        System.out.println("employee.xml validates against employee.xsd? " + validateXMLSchema("employee.xsd", "employee.xml"));
    }

    public static boolean validateXMLSchema(String xsdPath, String xmlPath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File schema1 = new File(xsdPath);
            Schema schema = factory.newSchema(schema1);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | SAXException e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
        return true;
    }
}
