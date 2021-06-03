package io.github.percontmx.cfdi.utils.jaxb.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DoubleXMLAdapter
        extends XmlAdapter<String, Double> {

    public Double unmarshal(String value) {
        return new Double(value);
    }

    public String marshal(Double value) {
        if (value == null) {
            return null;
        }
        return value.toString();
    }
}