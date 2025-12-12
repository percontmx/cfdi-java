package io.github.percontmx.cfdi.v33;

import io.github.percontmx.cfdi.AbstractCfdiWrapper;
import mx.gob.sat.cfdi.v33.Comprobante;

import java.math.BigDecimal;

public class Cfdiv33Wrapper extends AbstractCfdiWrapper<Comprobante> {

    public Cfdiv33Wrapper(Comprobante comprobante) {
        super(comprobante);
    }

    @Override
    public String getVersion() {
        return Comprobante.VERSION;
    }

    @Override
    public BigDecimal getTotal() {
        return this.comprobante.getTotal();
    }
}
