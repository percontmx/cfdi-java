package io.github.percontmx.cfdi.utils.parsers.detectors;

import mx.gob.sat.cfdi.complementos.nomina.v11.Nomina;
import mx.gob.sat.cfdi.complementos.nomina.v11.ObjectFactory;

import javax.xml.xpath.XPath;

public class Nominav11Detector extends AbstractXpathContextDetector<ObjectFactory> {

    private static final String NOMINA_V11_XPATH = "/cfdi:Comprobante/cfdi:Complemento/nomina:Nomina/@Version";
    private static final String NOMINA_V11_VERSION = Nomina.VERSION;

    public Nominav11Detector(XPath xpathInstance) {
        super(xpathInstance, ObjectFactory.class);
    }

    @Override
    protected String getXpathSentence() {
        return NOMINA_V11_XPATH;
    }

    @Override
    protected String getValue() {
        return NOMINA_V11_VERSION;
    }
}
