package io.github.percontmx.cfdi.utils.parsers;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

abstract class AbstractContextDetectorTest {

    private final DocumentBuilder documentBuilder;

    protected AbstractContextDetectorTest() {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        builderFactory.setNamespaceAware(true);
        builderFactory.setIgnoringComments(true);
        try {
            documentBuilder = builderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    protected Document loadDocument(String name) {
        try (InputStream istream = getClass().getResourceAsStream(name)) {
            return this.documentBuilder.parse(istream);
        } catch (IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
