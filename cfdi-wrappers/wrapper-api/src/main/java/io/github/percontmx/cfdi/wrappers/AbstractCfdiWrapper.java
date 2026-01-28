package io.github.percontmx.cfdi.wrappers;

import io.github.percontmx.cfdi.AbstractCfdi;

import java.math.BigDecimal;
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

    @Override
    public BigDecimal getTotal() {
        return this.comprobante.getTotal();
    }

    @Override
    public T getComprobante() {
        return comprobante;
    }
}
