package io.github.percontmx.cfdi.complementos.nomina;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ComplementoNomina {

    LocalDate getFechaPago();

    List<? extends Deduccion> getDeducciones();

    BigDecimal getIsrRetenido();
}
