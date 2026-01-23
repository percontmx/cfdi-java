package io.github.percontmx.cfdi.v32.wrappers;

import io.github.percontmx.cfdi.wrappers.AbstractCfdiWrapper;
import mx.gob.sat.cfdi.complementos.tfd.v10.TimbreFiscalDigital;
import mx.gob.sat.cfdi.v32.Comprobante;
import mx.gob.sat.cfdi.v32.TipoDeComprobante;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public final class Cfdiv32Wrapper extends AbstractCfdiWrapper<Comprobante> {

    public Cfdiv32Wrapper(Comprobante comprobante) {
        super(comprobante);
    }

    @Override
    public String getVersion() {
        return Comprobante.VERSION;
    }

    @Override
    public List<Object> getComplementos() {
        return this.comprobante.isSetComplemento() ? this.comprobante.getComplemento().getAny() : List.of();
    }

    private Optional<TimbreFiscalDigital> getOptionalTimbre() {
        return this.getComplementos().stream()
                .filter(c -> c instanceof TimbreFiscalDigital)
                .map(TimbreFiscalDigital.class::cast)
                .findFirst();
    }

    @Override
    public boolean hasTimbre() {
        return this.getOptionalTimbre().isPresent();
    }

    @Override
    public UUID getTimbreUuid() {
        return this.getOptionalTimbre().map(TimbreFiscalDigital::getUuid).orElse(null);
    }

    @Override
    public boolean isNomina() {
        return TipoDeComprobante.EGRESO == this.comprobante.getTipoDeComprobante() &&
                hasComplementoNomina();
    }

    private boolean hasComplementoNomina() {
        return this.getComplementos().stream()
                .anyMatch(c -> c instanceof mx.gob.sat.cfdi.complementos.nomina.v11.Nomina ||
                               c instanceof mx.gob.sat.cfdi.complementos.nomina.v12.Nomina);
    }
}
