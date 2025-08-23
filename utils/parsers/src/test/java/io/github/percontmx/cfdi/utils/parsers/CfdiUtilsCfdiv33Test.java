package io.github.percontmx.cfdi.utils.parsers;

import jakarta.xml.bind.JAXBException;
import mx.gob.sat.cfdi.complementos.nomina.v12.Nomina;
import mx.gob.sat.cfdi.complementos.tfd.v11.TimbreFiscalDigital;
import mx.gob.sat.cfdi.v33.Complemento;
import mx.gob.sat.cfdi.v33.Comprobante;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CfdiUtilsCfdiv33Test extends AbstractCfdiUtilsTest {

    private static final String CFDI_V33_MUESTRA = "cfdi_v33_muestra.xml";
    private static final String CFDI_V33_NOMINA_MUESTRA = "cfdi_v33_nomina_muestra.xml";
    private static final String CFDI_V33_TIMBRADO_MUESTRA = "cfdi_v33_timbrado_muestra.xml";

    @Test
    public void convertirCfdiv33Test() throws ParserConfigurationException, IOException, SAXException, JAXBException {
        Document document = leerDocumento(CFDI_V33_MUESTRA);
        Comprobante comprobante = CfdiUtils.extract(document);
        Assertions.assertNotNull(comprobante);
    }

    @Test
    public void convertirCfdiv33NominaTest() throws ParserConfigurationException, IOException, SAXException, JAXBException {
        Document document = leerDocumento(CFDI_V33_NOMINA_MUESTRA);
        Comprobante comprobante = CfdiUtils.extract(document);
        Assertions.assertNotNull(comprobante);
        verificarComplementos(comprobante.getComplemento(), Nomina.class);
    }

    @Test
    public void convertirCfdiv33TimbradoTest() throws ParserConfigurationException, IOException, SAXException, JAXBException {
        Document document = leerDocumento(CFDI_V33_TIMBRADO_MUESTRA);
        Comprobante comprobante = CfdiUtils.extract(document);
        Assertions.assertNotNull(comprobante);
        verificarComplementos(comprobante.getComplemento(), TimbreFiscalDigital.class);
    }

    protected void verificarComplementos(List<Complemento> complementos, Class<?> tipoComplemento) {
        List<Object> objetosComplemento = complementos.stream()
                .flatMap(complemento -> complemento.getAny()
                        .stream())
                .collect(Collectors.toList());
        verificarComplemento(objetosComplemento, tipoComplemento);
    }
}
