package io.github.percontmx.cfdi.utils.parsers;

import mx.gob.sat.cfdi.v32.ObjectFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Cfdi32ContextDetector extends AbstractCfdiContextDetector {

    Cfdi32ContextDetector(){
        super("version");
    }

    @Override
    public boolean apply(Document document) {
        Element rootElement = document.getDocumentElement();
        String namespace = rootElement.getNamespaceURI();
        String rootTag = rootElement.getTagName();
        String version = getVersion(rootElement);

        return "http://www.sat.gob.mx/cfd/3".equals(namespace) &&
                "Comprobante".equals(rootTag) &&
                "3.2".equals(version);
    }

    @Override
    public String getContextPath() {
        return ObjectFactory.class.getPackageName();
    }
}
