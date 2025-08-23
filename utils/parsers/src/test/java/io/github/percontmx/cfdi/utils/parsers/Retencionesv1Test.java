package io.github.percontmx.cfdi.utils.parsers;

import jakarta.xml.bind.JAXBException;
import mx.gob.sat.cfdi.retenciones.v1.Retenciones;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Retencionesv1Test extends AbstractCfdiUtilsTest {

    private static final String RETENCIONES_V1_MUESTRA = "retenciones_v1_muestra.xml";

    @Test
    void convertirRetencionesV1Test() throws ParserConfigurationException, IOException, SAXException, JAXBException {
        Document document = leerDocumento(RETENCIONES_V1_MUESTRA);
        Retenciones retenciones = CfdiUtils.extract(document);
        Assertions.assertNotNull(retenciones);
    }
}
