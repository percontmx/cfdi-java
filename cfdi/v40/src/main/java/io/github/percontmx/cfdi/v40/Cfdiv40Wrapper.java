package io.github.percontmx.cfdi.v40;

import io.github.percontmx.cfdi.AbstractCfdiWrapper;
import mx.gob.sat.cfdi.v40.Comprobante;

import java.math.BigDecimal;
import java.util.List;

public class Cfdiv40Wrapper extends AbstractCfdiWrapper<Comprobante> {


    public Cfdiv40Wrapper(Comprobante comprobante) {
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

    @Override
    public List<Object> getComplementos() {
        return this.comprobante.getComplementos();
    }
}
