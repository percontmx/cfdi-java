package io.github.percontmx.cfdi.complementos.nomina;

import java.math.BigDecimal;
import java.util.List;

public interface ContenedorDeducciones {
    List<? extends Deduccion> getDeducciones();

    BigDecimal getIsrRetenido();
}
