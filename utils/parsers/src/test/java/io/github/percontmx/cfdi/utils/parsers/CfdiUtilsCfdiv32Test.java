package io.github.percontmx.cfdi.utils.parsers;

import jakarta.xml.bind.JAXBException;
import mx.gob.sat.cfdi.complementos.nomina.v11.Nomina;
import mx.gob.sat.cfdi.complementos.tfd.v10.TimbreFiscalDigital;
import mx.gob.sat.cfdi.v32.Comprobante;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class
CfdiUtilsCfdiv32Test extends AbstractCfdiUtilsTest {

    private static final String CFDI_V32_MUESTRA = "cfdi_v32_muestra.xml";
    private static final String CFDI_V32_TIMBRADO_MUESTRA = "cfdi_v32_timbrado_muestra.xml";
    private static final String CFDI_V32_NOMINA_MUESTRA = "cfdi_v32_nomina_muestra.xml";

    @Test
    void convertirCfdiv32Test() throws ParserConfigurationException, IOException, SAXException, JAXBException {
        Document document = leerDocumento(CFDI_V32_MUESTRA);
        Comprobante comprobante = CfdiUtils.extract(document);
        Assertions.assertNotNull(comprobante);
    }

    @Test
    void convertirCfdiv32TimbradoTest() throws ParserConfigurationException, IOException, SAXException, JAXBException {
        Document document = leerDocumento(CFDI_V32_TIMBRADO_MUESTRA);
        Comprobante comprobante = CfdiUtils.extract(document);
        Assertions.assertNotNull(comprobante);
        verificarComplemento(comprobante.getComplemento(), TimbreFiscalDigital.class);
    }

    @Test
    void convertirCfdiv32NominaTest() throws ParserConfigurationException, IOException, SAXException, JAXBException {
        Document document = leerDocumento(CFDI_V32_NOMINA_MUESTRA);
        Comprobante comprobante = CfdiUtils.extract(document);
        Assertions.assertNotNull(comprobante);
        verificarComplemento(comprobante.getComplemento(), Nomina.class);
    }
}
