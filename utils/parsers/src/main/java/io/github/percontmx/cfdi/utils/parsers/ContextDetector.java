package io.github.percontmx.cfdi.utils.parsers;

import org.w3c.dom.Document;

public interface ContextDetector {

    boolean apply(Document document);

    String getContextPath();

}
