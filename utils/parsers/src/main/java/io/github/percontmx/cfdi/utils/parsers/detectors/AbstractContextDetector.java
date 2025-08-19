package io.github.percontmx.cfdi.utils.parsers.detectors;

import javax.xml.xpath.XPath;

public abstract class AbstractContextDetector<T> implements ContextDetector {

    private final Class<T> contextClass;

    public AbstractContextDetector(Class<T> contextClass) {
        this.contextClass = contextClass;
    }

    @Override
    public String getPackage() {
        return contextClass.getPackageName();
    }
}
