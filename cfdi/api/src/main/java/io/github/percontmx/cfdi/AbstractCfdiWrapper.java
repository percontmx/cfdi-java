package io.github.percontmx.cfdi;

public abstract class AbstractCfdiWrapper<T extends AbstractCfdi> implements CfdiWrapper<T> {

    protected final T comprobante;

    protected AbstractCfdiWrapper(T comprobante) {
        this.comprobante = comprobante;
    }
}
