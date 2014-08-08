package jaxb.validation;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Validation {
    public static void main(String[] args) {
        URL schemaFile = null;
        try {
            schemaFile = new URL("http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Source xmlFile = new StreamSource(new File("employee.xml"));
        SchemaFactory schemaFactory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = null;
        try {
            schema = schemaFactory.newSchema(schemaFile);
        } catch (SAXException e) {
            e.printStackTrace();
        }
        Validator validator = schema.newValidator();
        try {
            try {
                validator.validate(xmlFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(xmlFile.getSystemId() + " is valid");
        } catch (SAXException e) {
            System.out.println(xmlFile.getSystemId() + " is NOT valid");
            System.out.println("Reason: " + e.getLocalizedMessage());
        }
    }
}
