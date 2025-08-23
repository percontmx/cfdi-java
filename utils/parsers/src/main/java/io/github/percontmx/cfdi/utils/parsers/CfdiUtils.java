package io.github.percontmx.cfdi.utils.parsers;

import io.github.percontmx.cfdi.utils.parsers.detectors.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import org.w3c.dom.Document;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class CfdiUtils {

    private CfdiUtils() {
        // Constructor privado para evitar instanciación.
    }

    @SuppressWarnings("unchecked")
    public static <T> T extract(Document document) throws JAXBException {
        XPath xpath = XPathFactory.newInstance().newXPath();
        xpath.setNamespaceContext(new CfdiUtilsNamespaceContext());
        String jaxbContextPath = Stream.of(new Cfdiv32Detector(xpath),
                        new Cfdiv33Detector(xpath),
                        new TimbreFiscalv10Detector(xpath),
                        new TimbreFiscalv11Detector(xpath),
                        new Nominav11Detector(xpath),
                        new Nominav12Detector(xpath))
                .filter(detector ->
                        detector.matches(document))
                .map(ContextDetector::getPackage)
                .collect(Collectors.joining(":"));
        JAXBContext jaxbContext = JAXBContext.newInstance(jaxbContextPath);
        Object unmarshalled = jaxbContext.createUnmarshaller().unmarshal(document);
        return Objects.nonNull(unmarshalled) ? (T) unmarshalled : null;
    }
}
