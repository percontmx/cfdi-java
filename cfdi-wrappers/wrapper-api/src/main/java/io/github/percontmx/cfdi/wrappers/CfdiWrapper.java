package io.github.percontmx.cfdi.wrappers;

import io.github.percontmx.cfdi.AbstractCfdi;
import io.github.percontmx.cfdi.Cfdi;

import java.util.List;
import java.util.UUID;

public interface CfdiWrapper<T extends AbstractCfdi> extends Cfdi {
    String getVersion();
    List<Object> getComplementos();
    boolean hasTimbre();
    UUID getTimbreUuid();
    boolean isNomina();
}
