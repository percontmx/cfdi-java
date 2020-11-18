package io.github.percontmx.cfdi.utils.jaxb.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.UUID;

public class UUIDXMLAdapter extends XmlAdapter<String, UUID> {

    @Override
    public UUID unmarshal(String string) {
        return null != string ? UUID.fromString(string) : null;
    }

    @Override
    public String marshal(UUID uuid) {
        return null != uuid ? uuid.toString() : null;
    }
}
