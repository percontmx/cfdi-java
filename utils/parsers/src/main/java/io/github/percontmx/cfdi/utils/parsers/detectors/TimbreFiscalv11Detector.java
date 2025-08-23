package io.github.percontmx.cfdi.utils.parsers.detectors;

import mx.gob.sat.cfdi.complementos.tfd.v11.ObjectFactory;

import javax.xml.xpath.XPath;

public class TimbreFiscalv11Detector extends AbstractXpathContextDetector<ObjectFactory> {

    private static final String TIMBRE_FISCAL_DIGITAL_XPATH = "/cfdi:Comprobante/cfdi:Complemento/tfd:TimbreFiscalDigital/@Version";
    private static final String TIMBRE_FISCAL_DIGITAL_VERSION = "1.1";

    public TimbreFiscalv11Detector(XPath xpathInstance) {
        super(xpathInstance, ObjectFactory.class);
    }

    @Override
    protected String getXpathSentence() {
        return TIMBRE_FISCAL_DIGITAL_XPATH;
    }

    @Override
    protected String getValue() {
        return TIMBRE_FISCAL_DIGITAL_VERSION;
    }
}
