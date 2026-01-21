package io.github.percontmx.cfdi;

import java.util.List;
import java.util.UUID;

public interface CfdiWrapper<T extends AbstractCfdi> extends Cfdi {
    String getVersion();
    List<Object> getComplementos();
    boolean hasTimbre();
    UUID getTimbreUuid();
}
