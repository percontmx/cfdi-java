package io.github.percontmx.cfdi.utils.parsers.cfdiv32;

import io.github.percontmx.cfdi.utils.parsers.CfdiUtils;
import jakarta.xml.bind.JAXBException;
import mx.gob.sat.cfdi.complementos.nomina.v11.Nomina;
import mx.gob.sat.cfdi.complementos.tfd.v10.TimbreFiscalDigital;
import mx.gob.sat.cfdi.v32.Complemento;
import mx.gob.sat.cfdi.v32.Comprobante;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CfdiUtilsCfdiv32Test {

    private static DocumentBuilder documentBuilder;

    public DocumentBuilder getDocumentBuilder() throws ParserConfigurationException {
        if (null == documentBuilder) {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);
            documentBuilderFactory.setIgnoringComments(true);
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        }
        return documentBuilder;
    }

    private static final String CFDI_V32_MUESTRA = "cfdi_v32_muestra.xml";
    private static final String CFDI_V32_TIMBRADO_MUESTRA = "cfdi_v32_timbrado_muestra.xml";
    private static final String CFDI_V32_NOMINA_MUESTRA = "cfdi_v32_nomina_muestra.xml";

    private void verificarComplemento(Complemento complemento, Class<?> tipoComplemento){
        Assertions.assertNotNull(complemento);
        List<Object> complementos = complemento.getAny();
        Assertions.assertFalse(complementos.isEmpty());
        Assertions.assertTrue(
                () -> complementos.stream().anyMatch(tipoComplemento::isInstance));
    }

    @Test
    void convertirCfdiv32Test() throws ParserConfigurationException, IOException, SAXException, JAXBException {
        InputStream istream = getClass().getResourceAsStream(CFDI_V32_MUESTRA);
        Document document = getDocumentBuilder().parse(istream);
        Comprobante comprobante = CfdiUtils.extract(document);
        Assertions.assertNotNull(comprobante);
    }

    @Test
    void convertirCfdiv32TimbradoTest() throws ParserConfigurationException, IOException, SAXException, JAXBException {
        InputStream istream = getClass().getResourceAsStream(CFDI_V32_TIMBRADO_MUESTRA);
        Document document = getDocumentBuilder().parse(istream);
        Comprobante comprobante = CfdiUtils.extract(document);
        Assertions.assertNotNull(comprobante);
        verificarComplemento(comprobante.getComplemento(), TimbreFiscalDigital.class);
    }

    @Test
    void convertirCfdiv32NominaTest() throws ParserConfigurationException, IOException, SAXException, JAXBException {
        InputStream istream = getClass().getResourceAsStream(CFDI_V32_NOMINA_MUESTRA);
        Document document = getDocumentBuilder().parse(istream);
        Comprobante comprobante = CfdiUtils.extract(document);
        Assertions.assertNotNull(comprobante);
        verificarComplemento(comprobante.getComplemento(), Nomina.class);
    }
}
