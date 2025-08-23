package io.github.percontmx.cfdi.utils.parsers.detectors;

import mx.gob.sat.cfdi.retenciones.v1.ObjectFactory;
import mx.gob.sat.cfdi.retenciones.v1.Retenciones;

import javax.xml.xpath.XPath;

public class Retencionesv1Detector extends AbstractXpathContextDetector<ObjectFactory> {

    private static final String RETENCIONES_XPATH = "/retenciones:Retenciones/@Version";
    private static final String RETENCIONES_VERSION = Retenciones.VERSION;

    public Retencionesv1Detector(XPath xpathInstance) {
        super(xpathInstance, ObjectFactory.class);
    }

    @Override
    protected String getXpathSentence() {
        return RETENCIONES_XPATH;
    }

    @Override
    protected String getValue() {
        return RETENCIONES_VERSION;
    }
}
