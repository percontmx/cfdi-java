package io.github.percontmx.cfdi.utils.parsers.detectors;

import mx.gob.sat.cfdi.complementos.tfd.v10.ObjectFactory;
import mx.gob.sat.cfdi.complementos.tfd.v10.TimbreFiscalDigital;

import javax.xml.xpath.XPath;

public class TimbreFiscalv10Detector extends AbstractXpathContextDetector<ObjectFactory> {

    private static final String TFD_V10_XPATH = "/cfdi:Comprobante/cfdi:Complemento/tfd:TimbreFiscalDigital/@version";
    private static final String VALUE = TimbreFiscalDigital.VERSION;

    public TimbreFiscalv10Detector(XPath xpathInstance) {
        super(xpathInstance, ObjectFactory.class);
    }

    @Override
    protected String getXpathSentence() {
        return TFD_V10_XPATH;
    }

    @Override
    protected String getValue() {
        return VALUE;
    }
}
