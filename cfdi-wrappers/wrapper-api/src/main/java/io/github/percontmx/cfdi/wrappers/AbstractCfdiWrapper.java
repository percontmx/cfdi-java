package io.github.percontmx.cfdi.wrappers;

import io.github.percontmx.cfdi.AbstractCfdi;
import io.github.percontmx.cfdi.complementos.nomina.ComplementoNomina;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

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

    @Override
    public ComplementoNomina getComplementoNomina() {
        return getOptionalComplementoNomina()
                .orElse(null);
    }

    protected Optional<ComplementoNomina> getOptionalComplementoNomina() {
        return this.getComplementos()
                .stream()
                .filter(complemento -> complemento instanceof ComplementoNomina)
                .map(ComplementoNomina.class::cast)
                .findFirst();
    }

    protected boolean hasComplementoNomina() {
        return this.getOptionalComplementoNomina().isPresent();
    }
}
