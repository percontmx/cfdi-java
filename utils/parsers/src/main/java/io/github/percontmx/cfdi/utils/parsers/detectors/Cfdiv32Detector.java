package io.github.percontmx.cfdi.utils.parsers.detectors;

import mx.gob.sat.cfdi.v32.Comprobante;
import mx.gob.sat.cfdi.v32.ObjectFactory;

import javax.xml.xpath.XPath;

public class Cfdiv32Detector extends AbstractXpathContextDetector<ObjectFactory> {

    private static final String CFDI_V32_XPATH = "/cfdi:Comprobante/@version";
    private static final String CFDI_V32_VERSION = Comprobante.VERSION;

    public Cfdiv32Detector(XPath xpathInstance) {
        super(xpathInstance, ObjectFactory.class);
    }

    @Override
    protected String getXpathSentence() {
        return CFDI_V32_XPATH;
    }

    @Override
    protected String getValue() {
        return CFDI_V32_VERSION;
    }
}
