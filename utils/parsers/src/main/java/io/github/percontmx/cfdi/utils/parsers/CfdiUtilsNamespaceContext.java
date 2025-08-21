package io.github.percontmx.cfdi.utils.parsers;

import javax.xml.namespace.NamespaceContext;
import java.util.Iterator;
import java.util.Map;

class CfdiUtilsNamespaceContext implements NamespaceContext {

    private static final Map<String, String> NAMESPACES_MAPS = Map.ofEntries(
            Map.entry("cfdi", "http://www.sat.gob.mx/cfd/3"),
            Map.entry("tfd", "http://www.sat.gob.mx/TimbreFiscalDigital"),
            Map.entry("nomina", "http://www.sat.gob.mx/nomina"),
            Map.entry("nomina12", "http://www.sat.gob.mx/nomina12")
    );

    @Override
    public String getNamespaceURI(String prefix) {
        return NAMESPACES_MAPS.getOrDefault(prefix, "");
    }

    @Override
    public String getPrefix(String namespaceURI) {
        return "";
    }

    @Override
    public Iterator<String> getPrefixes(String namespaceURI) {
        return null;
    }
}
