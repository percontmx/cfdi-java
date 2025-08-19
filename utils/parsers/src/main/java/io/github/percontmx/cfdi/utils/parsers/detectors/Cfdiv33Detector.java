package io.github.percontmx.cfdi.utils.parsers.detectors;

import mx.gob.sat.cfdi.v33.Comprobante;
import mx.gob.sat.cfdi.v33.ObjectFactory;

import javax.xml.xpath.XPath;

public class Cfdiv33Detector extends AbstractXpathContextDetector<ObjectFactory> {

    private static final String CFDI_V33_XPATH = "/cfdi:Comprobante/@Version";
    private static final String CFDI_V33_VERSION = Comprobante.version;

    public Cfdiv33Detector(XPath xpathInstance) {
        super(xpathInstance, ObjectFactory.class);
    }

    @Override
    protected String getXpathSentence() {
        return CFDI_V33_XPATH;
    }

    @Override
    protected String getValue() {
        return CFDI_V33_VERSION;
    }
    /*@Override
    public boolean matches(Document document) {
        return false;
    }

    @Override
    public String getPackage() {
        return ObjectFactory.class.getPackageName();
    }*/
}
