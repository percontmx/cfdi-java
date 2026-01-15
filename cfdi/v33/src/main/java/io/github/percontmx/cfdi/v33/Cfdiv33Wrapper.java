package io.github.percontmx.cfdi.v33;

import io.github.percontmx.cfdi.AbstractCfdiWrapper;
import mx.gob.sat.cfdi.complementos.tfd.v11.TimbreFiscalDigital;
import mx.gob.sat.cfdi.v33.Complemento;
import mx.gob.sat.cfdi.v33.Comprobante;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<Object> getComplementos() {
        return this.comprobante.getComplemento().stream()
                .map(Complemento::getAny)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private Optional<TimbreFiscalDigital> getOptionalTimbre() {
        return this.getComplementos().stream()
                .filter(obj -> obj instanceof TimbreFiscalDigital)
                .map(obj -> (TimbreFiscalDigital) obj)
                .findFirst();
    }

    public TimbreFiscalDigital getTimbre() {
        return this.getOptionalTimbre().orElse(null);
    }

    public boolean hasTimbre() {
        return this.getOptionalTimbre().isPresent();
    }
}
