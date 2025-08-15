package io.github.percontmx.cfdi.utils.parsers;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import mx.gob.sat.cfdi.v32.ObjectFactory;
import org.w3c.dom.Document;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CfdiUtils {

    private static final String JAXB_CONTEXT_PATH = Stream
            .of(ObjectFactory.class,
                    mx.gob.sat.cfdi.complementos.tfd.v10.ObjectFactory.class,
                    mx.gob.sat.cfdi.complementos.nomina.v11.ObjectFactory.class)
            .map(Class::getPackageName)
            .collect(Collectors.joining(":"));

    private CfdiUtils() {
        // Constructor privado para evitar instanciación.
    }

    @SuppressWarnings("unchecked")
    public static <T> T extract(Document document) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(JAXB_CONTEXT_PATH);
        Object unmarshalled = jaxbContext.createUnmarshaller().unmarshal(document);
        return Objects.nonNull(unmarshalled) ? (T) unmarshalled : null;
    }
}
