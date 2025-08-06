package io.github.percontmx.cfdi.utils.parsers;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;

import java.util.Optional;

abstract class AbstractCfdiContextDetector extends AbstractContextDetector {

    private final String versionAttribute;

    AbstractCfdiContextDetector(String versionAttribute) {
        this.versionAttribute = versionAttribute;
    }

    String getVersion(Element element){
        Attr attribute = element.getAttributeNode(versionAttribute);
        return Optional.ofNullable(attribute)
                .map(Attr::getValue)
                .orElse(null);
    }
}
