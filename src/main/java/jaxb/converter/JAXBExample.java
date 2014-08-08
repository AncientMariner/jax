package jaxb.converter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBExample {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setId(100);
        customer.setName("name");
        customer.setAge(29);
        final String FILE_PATH = "/home/xander/IdeaProjects/jax/file.xml";

        try {
            File file = new File(FILE_PATH);
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(customer, file);
            jaxbMarshaller.marshal(customer, System.out);

            File fileToGet = new File(FILE_PATH);
            JAXBContext jaxbContext1 = JAXBContext.newInstance(Customer.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext1.createUnmarshaller();
            Customer customer1 = (Customer) jaxbUnmarshaller.unmarshal(fileToGet);
            System.out.println("\n" + customer1.getName() + " " + customer1.getId() + " " + customer1.getAge());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
