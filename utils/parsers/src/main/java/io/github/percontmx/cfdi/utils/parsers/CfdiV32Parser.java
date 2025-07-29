package io.github.percontmx.cfdi.utils.parsers;

public class CfdiV32Parser implements TilingaLunga {

    public String xpath() {
        return "//Comprobante[@version]";
    }

    public String value() {
        return "3.2";
    }

    @Override
    public boolean apply(String xml) {
        return false;
    }
}
