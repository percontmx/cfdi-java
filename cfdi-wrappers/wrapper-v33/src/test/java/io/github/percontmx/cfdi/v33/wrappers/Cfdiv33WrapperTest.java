package io.github.percontmx.cfdi.v33.wrappers;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import mx.gob.sat.cfdi.v33.Comprobante;
import mx.gob.sat.cfdi.v33.ObjectFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URL;

class Cfdiv33WrapperTest {

    @Test
    void wrapperTest() throws JAXBException {
        URL urlXml = getClass().getClassLoader().getResource("sample_cfdi_v33.xml");
        Assertions.assertNotNull(urlXml);

        JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Object unmarshalled = unmarshaller.unmarshal(urlXml);
        Assertions.assertInstanceOf(mx.gob.sat.cfdi.v33.Comprobante.class, unmarshalled);

        Cfdiv33Wrapper cfdiWrapper = new Cfdiv33Wrapper((Comprobante) unmarshalled);
        Assertions.assertEquals(Comprobante.VERSION, cfdiWrapper.getVersion());
    }

    @Test
    void wrapperTes2t() throws JAXBException {
        URL urlXml = getClass().getClassLoader().getResource("sample_cfdi_v33_nomina11.xml");
        Assertions.assertNotNull(urlXml);

        JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class,
                mx.gob.sat.cfdi.complementos.nomina.v11.ObjectFactory.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Object unmarshalled = unmarshaller.unmarshal(urlXml);
        Assertions.assertInstanceOf(mx.gob.sat.cfdi.v33.Comprobante.class, unmarshalled);

        Cfdiv33Wrapper cfdiWrapper = new Cfdiv33Wrapper((Comprobante) unmarshalled);
        Assertions.assertEquals(Comprobante.VERSION, cfdiWrapper.getVersion());
        Assertions.assertTrue(cfdiWrapper.isNomina());
    }
}
