package io.github.percontmx.cfdi.utils.parsers.detectors;

import org.w3c.dom.Document;

public interface ContextDetector {

    boolean matches(Document document);

    String getPackage();

}
