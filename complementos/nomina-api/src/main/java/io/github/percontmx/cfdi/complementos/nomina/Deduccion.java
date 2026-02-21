package io.github.percontmx.cfdi.complementos.nomina;

import mx.gob.sat.cfdi.catalogos.nomina.TipoDeduccion;
import java.math.BigDecimal;

public interface Deduccion {

    TipoDeduccion getTipoDeduccion();

    BigDecimal getImporte();
}


