package io.github.percontmx.cfdi.utils.parsers;

import mx.gob.sat.cfdi.v32.Complemento;
import org.junit.jupiter.api.Assertions;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public abstract class AbstractCfdiUtilsTest {

    private static DocumentBuilder documentBuilder;

    protected DocumentBuilder getDocumentBuilder() throws ParserConfigurationException {
        if (null == documentBuilder) {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);
            documentBuilderFactory.setIgnoringComments(true);
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        }
        return documentBuilder;
    }

    protected void verificarComplemento(List<Object> complementos, Class<?> tipoComplemento) {
        Assertions.assertNotNull(complementos);
        Assertions.assertFalse(complementos.isEmpty());
        Assertions.assertTrue(
                () -> complementos.stream().anyMatch(tipoComplemento::isInstance));
    }

    protected Document leerDocumento(String documento) throws ParserConfigurationException, IOException, SAXException {
        InputStream istream = getClass().getResourceAsStream(documento);
        return getDocumentBuilder().parse(istream);
    }
}
