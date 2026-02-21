package io.github.percontmx.cfdi.wrappers;

import io.github.percontmx.cfdi.AbstractCfdi;
import io.github.percontmx.cfdi.Cfdi;
import io.github.percontmx.cfdi.complementos.nomina.ComplementoNomina;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CfdiWrapper<T extends AbstractCfdi> extends Cfdi {
    T getComprobante();
    String getVersion();
    List<Object> getComplementos();
    boolean hasTimbre();
    UUID getTimbreUuid();
    boolean isNomina();
    ComplementoNomina getComplementoNomina();
}



