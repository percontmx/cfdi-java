package io.github.percontmx.cfdi.v40;

import io.github.percontmx.cfdi.AbstractCfdiWrapper;
import mx.gob.sat.cfdi.v40.Comprobante;

import java.math.BigDecimal;

public class Cfdiv40Wrapper extends AbstractCfdiWrapper<Comprobante> {

    protected Cfdiv40Wrapper(Comprobante comprobante) {
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
