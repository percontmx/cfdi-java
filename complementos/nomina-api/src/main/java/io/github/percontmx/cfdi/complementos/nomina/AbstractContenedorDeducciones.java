package io.github.percontmx.cfdi.complementos.nomina;

import mx.gob.sat.cfdi.catalogos.nomina.TipoDeduccion;

import java.math.BigDecimal;

public abstract class AbstractContenedorDeducciones implements ContenedorDeducciones {

    @Override
    public BigDecimal getIsrRetenido() {
        return this.getDeducciones().stream().filter(
                        d -> TipoDeduccion.TD_002 == d.getTipoDeduccion())
                .map(Deduccion::getImporte)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
