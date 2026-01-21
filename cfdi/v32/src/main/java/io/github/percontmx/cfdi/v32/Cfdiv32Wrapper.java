package io.github.percontmx.cfdi.v32;

import io.github.percontmx.cfdi.AbstractCfdiWrapper;
import mx.gob.sat.cfdi.complementos.tfd.v10.TimbreFiscalDigital;
import mx.gob.sat.cfdi.v32.Comprobante;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        return this.comprobante.getComplemento() != null ?
        this.comprobante.getComplemento().getAny() : List.of();
    }

    private Optional<TimbreFiscalDigital> getOptionalTimbre() {
        return this.getComplementos().stream()
                .filter(obj -> obj instanceof TimbreFiscalDigital)
                .map(obj -> (TimbreFiscalDigital) obj)
                .findFirst();
    }

    @Override
    public boolean hasTimbre() {
        return this.getOptionalTimbre().isPresent();
    }

    @Override
    public UUID getTimbreUuid() {
        return this.getOptionalTimbre()
                .map(TimbreFiscalDigital::getUuid)
                .orElse(null);
    }
}
