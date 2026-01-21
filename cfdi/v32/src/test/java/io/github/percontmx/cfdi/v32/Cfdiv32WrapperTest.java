package io.github.percontmx.cfdi.v32;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import mx.gob.sat.cfdi.complementos.tfd.v10.TimbreFiscalDigital;
import mx.gob.sat.cfdi.v32.Comprobante;
import mx.gob.sat.cfdi.v32.ObjectFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URL;

class Cfdiv32WrapperTest {

    private final Unmarshaller unmarshaller;

    Cfdiv32WrapperTest() throws JAXBException {
        this.unmarshaller = JAXBContext.newInstance(ObjectFactory.class,
                mx.gob.sat.cfdi.complementos.tfd.v10.ObjectFactory.class)
                .createUnmarshaller();
    }

    @Test
    void comprobantev32SinComplementos() throws JAXBException {
        URL xmlUrl = getClass().getClassLoader().getResource("sample_cfdi_v32.xml");
        Assertions.assertNotNull(xmlUrl);

        JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class, TimbreFiscalDigital.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Object unmarshalled = unmarshaller.unmarshal(xmlUrl);
        Assertions.assertInstanceOf(Comprobante.class, unmarshalled);

        Cfdiv32Wrapper cfdiWrapper = new Cfdiv32Wrapper((Comprobante) unmarshalled);
        Assertions.assertEquals(Comprobante.VERSION, cfdiWrapper.getVersion());
        Assertions.assertFalse(cfdiWrapper.hasTimbre());
        Assertions.assertNull(cfdiWrapper.getTimbreUuid());
    }

    @Test
    void comprobantev32Timbrado() throws JAXBException {
        URL xmlUrl = getClass().getClassLoader().getResource("sample_cfdi_v32_timbrado.xml");
        Assertions.assertNotNull(xmlUrl);

        JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class, TimbreFiscalDigital.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Object unmarshalled = unmarshaller.unmarshal(xmlUrl);
        Assertions.assertInstanceOf(Comprobante.class, unmarshalled);

        Cfdiv32Wrapper cfdiWrapper = new Cfdiv32Wrapper((Comprobante) unmarshalled);
        Assertions.assertEquals(Comprobante.VERSION, cfdiWrapper.getVersion());
        Assertions.assertTrue(cfdiWrapper.hasTimbre());
        Assertions.assertNotNull(cfdiWrapper.getTimbreUuid());
    }
}
