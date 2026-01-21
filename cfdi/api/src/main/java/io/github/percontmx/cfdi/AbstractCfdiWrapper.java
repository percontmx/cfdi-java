package io.github.percontmx.cfdi;

import mx.gob.sat.cfdi.complementos.nomina.v11.Nomina;

import java.time.LocalDateTime;
import java.util.function.Predicate;

public abstract class AbstractCfdiWrapper<T extends AbstractCfdi> implements CfdiWrapper<T> {

    private static final Predicate<Object> HAS_NOMINA_V11_PREDICATE = o -> o instanceof Nomina;
    private static final Predicate<Object> HAS_NOMINA_V12_PREDICATE = o -> o instanceof mx.gob.sat.cfdi.complementos.nomina.v12.Nomina;
    private static final Predicate<Object> HAS_NOMINA_PREDICATE = HAS_NOMINA_V11_PREDICATE.or(HAS_NOMINA_V12_PREDICATE);

    protected final T comprobante;

    protected AbstractCfdiWrapper(T comprobante) {
        this.comprobante = comprobante;
    }

    @Override
    public LocalDateTime getFechaEmision() {
        return this.comprobante.getFechaEmision();
    }

    protected boolean hasComplementoNomina() {
        return this.getComplementos().stream()
                .anyMatch(HAS_NOMINA_PREDICATE);
    }
}
