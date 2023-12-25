import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class XMLMessageUpdater {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilder instance
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document document = builder.parse(new File("lab1.xml"));

            // Get the root element
            Element root = document.getDocumentElement();

            // Get all <message> elements
            NodeList messageList = root.getElementsByTagName("message");

            // Iterate over each <message> element and replace the text content
            for (int i = 0; i < messageList.getLength(); i++) {
                Element messageElement = (Element) messageList.item(i);
                messageElement.setTextContent("mar3i");
            }

            // Print the updated XML content
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            transformer.transform(source, result);
            String updatedXml = writer.toString();
            System.out.println(updatedXml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}