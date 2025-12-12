package io.github.percontmx.cfdi.v32;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import mx.gob.sat.cfdi.v32.Comprobante;
import mx.gob.sat.cfdi.v32.ObjectFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URL;

class Cfdiv32WrapperTest {

    @Test
    void wrapperTest() throws JAXBException {
        URL xmlUrl = getClass().getClassLoader().getResource("sample_cfdi_v32.xml");
        Assertions.assertNotNull(xmlUrl);

        JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Object unmarshalled = unmarshaller.unmarshal(xmlUrl);
        Assertions.assertInstanceOf(Comprobante.class, unmarshalled);

        Cfdiv32Wrapper cfdiWrapper = new Cfdiv32Wrapper((Comprobante) unmarshalled);
        Assertions.assertEquals(Comprobante.VERSION, cfdiWrapper.getVersion());
    }
}
