package io.github.percontmx.cfdi.v40;

import io.github.percontmx.cfdi.AbstractCfdiWrapper;
import mx.gob.sat.cfdi.catalogos.TipoDeComprobante;
import mx.gob.sat.cfdi.complementos.tfd.v11.TimbreFiscalDigital;
import mx.gob.sat.cfdi.v40.Comprobante;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        return this.comprobante.isSetComplemento() ?
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

    @Override
    public boolean isNomina() {
        return this.comprobante.getTipoDeComprobante() == TipoDeComprobante.NÓMINA
                && hasComplementoNomina();
    }
}
