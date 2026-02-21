package io.github.percontmx.cfdi.complementos.nomina;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public abstract class AbstractComplementoNomina implements ComplementoNomina {

    protected abstract ContenedorDeducciones getContenedorDeducciones();

    @Override
    public List<? extends Deduccion> getDeducciones() {
        return getContenedorDeducciones().getDeducciones();
    }

    public BigDecimal getIsrRetenido(){
        return Optional.ofNullable(this.getContenedorDeducciones())
                .map(ContenedorDeducciones::getIsrRetenido)
                .orElse(BigDecimal.ZERO);
    }

}
