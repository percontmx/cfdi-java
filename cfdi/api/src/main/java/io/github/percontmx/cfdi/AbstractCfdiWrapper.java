package io.github.percontmx.cfdi;

import java.time.LocalDateTime;

public abstract class AbstractCfdiWrapper<T extends AbstractCfdi> implements CfdiWrapper<T> {

    protected final T comprobante;

    protected AbstractCfdiWrapper(T comprobante) {
        this.comprobante = comprobante;
    }

    @Override
    public LocalDateTime getFechaEmision() {
        return this.comprobante.getFechaEmision();
    }
}
