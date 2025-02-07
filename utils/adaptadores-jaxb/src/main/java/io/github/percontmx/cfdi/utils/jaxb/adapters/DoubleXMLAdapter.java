package io.github.percontmx.cfdi.utils.jaxb.adapters;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class DoubleXMLAdapter
        extends XmlAdapter<String, Double> {

    public Double unmarshal(String value) {
        if (value == null) {
            return null;
        }
        return Double.valueOf(value);
    }

    public String marshal(Double value) {
        if (value == null) {
            return null;
        }
        return value.toString();
    }
}