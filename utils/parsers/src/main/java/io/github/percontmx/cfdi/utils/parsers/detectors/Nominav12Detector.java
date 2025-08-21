package io.github.percontmx.cfdi.utils.parsers.detectors;

import mx.gob.sat.cfdi.complementos.nomina.v12.Nomina;
import mx.gob.sat.cfdi.complementos.nomina.v12.ObjectFactory;

import javax.xml.xpath.XPath;

public class Nominav12Detector extends AbstractXpathContextDetector<ObjectFactory> {

    private static final String NOMINA_V12_XPATH = "/cfdi:Comprobante/cfdi:Complemento/nomina12:Nomina/@Version";
    private static final String NOMINA_V12_VERSION = Nomina.VERSION;

    public Nominav12Detector(XPath xpathInstance) {
        super(xpathInstance, ObjectFactory.class);
    }

    @Override
    protected String getXpathSentence() {
        return NOMINA_V12_XPATH;
    }

    @Override
    protected String getValue() {
        return NOMINA_V12_VERSION;
    }
}
