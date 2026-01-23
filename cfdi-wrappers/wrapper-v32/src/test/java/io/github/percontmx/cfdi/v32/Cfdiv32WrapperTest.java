package io.github.percontmx.cfdi.v32;

import io.github.percontmx.cfdi.v32.wrappers.Cfdiv32Wrapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import mx.gob.sat.cfdi.v32.Comprobante;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URL;

class Cfdiv32WrapperTest {

    private final Unmarshaller unmarshaller;

    private final static String JAXB_CONTEXT_PATH = "mx.gob.sat.cfdi.v32:" +
            "mx.gob.sat.cfdi.complementos.tfd.v10:" +
            "mx.gob.sat.cfdi.complementos.nomina.v11:" +
            "mx.gob.sat.cfdi.complementos.nomina.v12";

    Cfdiv32WrapperTest() throws JAXBException {
        this.unmarshaller = JAXBContext.newInstance(JAXB_CONTEXT_PATH).createUnmarshaller();
    }

    @Test
    void comprobantev32SinComplementos() throws JAXBException {
        URL xmlUrl = getClass().getClassLoader().getResource("sample_cfdi_v32.xml");
        Assertions.assertNotNull(xmlUrl);

        Object unmarshalled = unmarshaller.unmarshal(xmlUrl);
        Assertions.assertInstanceOf(Comprobante.class, unmarshalled);

        Cfdiv32Wrapper cfdiWrapper = new Cfdiv32Wrapper((Comprobante) unmarshalled);
        Assertions.assertEquals(Comprobante.VERSION, cfdiWrapper.getVersion());
        Assertions.assertTrue(cfdiWrapper.getComplementos().isEmpty());
        Assertions.assertFalse(cfdiWrapper.hasTimbre());
        Assertions.assertNull(cfdiWrapper.getTimbreUuid());
        Assertions.assertFalse(cfdiWrapper.isNomina());
    }

    @Test
    void comprobantev32Timbrado() throws JAXBException {
        URL xmlUrl = getClass().getClassLoader().getResource("sample_cfdi_v32_timbrado.xml");
        Assertions.assertNotNull(xmlUrl);

        Object unmarshalled = unmarshaller.unmarshal(xmlUrl);
        Assertions.assertInstanceOf(Comprobante.class, unmarshalled);

        Cfdiv32Wrapper cfdiWrapper = new Cfdiv32Wrapper((Comprobante) unmarshalled);
        Assertions.assertFalse(cfdiWrapper.getComplementos().isEmpty());
        Assertions.assertTrue(cfdiWrapper.hasTimbre());
        Assertions.assertNotNull(cfdiWrapper.getTimbreUuid());
        Assertions.assertFalse(cfdiWrapper.isNomina());
    }

    @Test
    void comprobantev32Nominav11() throws JAXBException {
        URL xmlUrl = getClass().getClassLoader().getResource("sample_cfdi_v32_nomina_v11.xml");
        Assertions.assertNotNull(xmlUrl);

        Object unmarshalled = unmarshaller.unmarshal(xmlUrl);
        Assertions.assertInstanceOf(Comprobante.class, unmarshalled);

        Cfdiv32Wrapper cfdiWrapper = new Cfdiv32Wrapper((Comprobante) unmarshalled);
        Assertions.assertFalse(cfdiWrapper.getComplementos().isEmpty());
        Assertions.assertTrue(cfdiWrapper.isNomina());
    }

    @Test
    void comprobantev32Nominav12() throws JAXBException {
        URL xmlUrl = getClass().getClassLoader().getResource("sample_cfdi_v32_nomina_v12.xml");
        Assertions.assertNotNull(xmlUrl);

        Object unmarshalled = unmarshaller.unmarshal(xmlUrl);
        Assertions.assertInstanceOf(Comprobante.class, unmarshalled);

        Cfdiv32Wrapper cfdiWrapper = new Cfdiv32Wrapper((Comprobante) unmarshalled);
        Assertions.assertFalse(cfdiWrapper.getComplementos().isEmpty());
        Assertions.assertTrue(cfdiWrapper.isNomina());
    }
}
