package io.github.percontmx.cfdi.v40;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import mx.gob.sat.cfdi.v40.Comprobante;
import mx.gob.sat.cfdi.v40.ObjectFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URL;

class Cfdiv40WrapperTest {

    @Test
    void wrapperTest() throws JAXBException {
        URL urlXml = getClass().getClassLoader().getResource("sample_cfdi_v40.xml");
        Assertions.assertNotNull(urlXml);

        JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Object unmarshalled = unmarshaller.unmarshal(urlXml);
        Assertions.assertInstanceOf(mx.gob.sat.cfdi.v40.Comprobante.class, unmarshalled);

        Cfdiv40Wrapper cfdiWrapper = new Cfdiv40Wrapper((Comprobante) unmarshalled);
        Assertions.assertEquals(Comprobante.VERSION, cfdiWrapper.getVersion());
    }
}
