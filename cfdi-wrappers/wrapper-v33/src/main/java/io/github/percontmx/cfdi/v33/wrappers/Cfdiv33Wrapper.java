package io.github.percontmx.cfdi.v33.wrappers;

import io.github.percontmx.cfdi.wrappers.AbstractCfdiWrapper;
import mx.gob.sat.cfdi.catalogos.TipoDeComprobante;
import mx.gob.sat.cfdi.complementos.tfd.v11.TimbreFiscalDigital;
import mx.gob.sat.cfdi.v33.Comprobante;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
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
        return this.comprobante.isSetComplemento() ?
                this.comprobante.getComplemento().stream()
                        .flatMap(e -> e.getAny().stream())
                        .collect(Collectors.toList()) : List.of();
    }

    private Optional<TimbreFiscalDigital> getOptionalTimbre() {
        return this.getComplementos().stream()
                .filter(obj -> obj instanceof TimbreFiscalDigital)
                .map(obj -> (TimbreFiscalDigital) obj)
                .findFirst();
    }

    public boolean hasTimbre() {
        return this.getOptionalTimbre().isPresent();
    }

    public UUID getTimbreUuid() {
        return this.getOptionalTimbre()
                .map(TimbreFiscalDigital::getUuid)
                .orElse(null);
    }

    @Override
    public boolean isNomina() {
        return TipoDeComprobante.NÓMINA == this.comprobante.getTipoDeComprobante() &&
                this.hasComplementoNomina();
    }

    private boolean hasComplementoNomina() {
        return this.getComplementos().stream()
                .anyMatch(c -> c instanceof mx.gob.sat.cfdi.complementos.nomina.v11.Nomina ||
                        c instanceof mx.gob.sat.cfdi.complementos.nomina.v12.Nomina);
    }
}
