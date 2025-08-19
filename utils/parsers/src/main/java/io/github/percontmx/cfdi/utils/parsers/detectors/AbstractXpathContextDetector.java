package io.github.percontmx.cfdi.utils.parsers.detectors;

import io.github.percontmx.cfdi.utils.parsers.CfdiUtilsException;
import org.w3c.dom.Document;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;

public abstract class AbstractXpathContextDetector<T> extends AbstractContextDetector<T> {

    private final XPath xPath;

    public AbstractXpathContextDetector(XPath xpathInstance, Class<T> contextClass) {
        super(contextClass);
        this.xPath = xpathInstance;
    }

    protected abstract String getXpathSentence();

    @Override
    public boolean matches(Document document) {
        String xpathSentence = getXpathSentence();
        String matchingValue = getValue();
        try {
            XPathExpression xpathExpression = this.xPath.compile(xpathSentence);
            String evaluate = xpathExpression.evaluate(document);
            return matchingValue.equals(evaluate);
        } catch (XPathExpressionException e) {
            throw new CfdiUtilsException(e);
        }
    }

    protected abstract String getValue();
}
