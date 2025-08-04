package io.github.percontmx.cfdi.utils.parsers;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class Cfdi32ContextDetectorTest extends AbstractContextDetectorTest {

    private static final String XML_TO_TEST = "cfdi_v32_muestra.xml";
    private static final ContextDetector contextDetectorToTest = new Cfdi32ContextDetector();

    @Test
    public void getContextPathForValidDocument() throws IOException, SAXException {
        Document xmlDoc = loadDocument(XML_TO_TEST);
        assertTrue(contextDetectorToTest.apply(xmlDoc));
    }

    @Test
    public void getContextPathForInvalidDocument() throws IOException, SAXException {
        Document xmlDoc = loadDocument("invalido_muestra.xml");
        assertFalse(contextDetectorToTest.apply(xmlDoc));
    }
}
