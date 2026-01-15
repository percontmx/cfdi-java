package io.github.percontmx.cfdi.v32;

import io.github.percontmx.cfdi.AbstractCfdiWrapper;
import mx.gob.sat.cfdi.v32.Comprobante;

import java.math.BigDecimal;
import java.util.List;

public class Cfdiv32Wrapper extends AbstractCfdiWrapper<Comprobante> {

    public Cfdiv32Wrapper(Comprobante comprobante) {
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
        return this.comprobante.getComplemento();
    }
}
