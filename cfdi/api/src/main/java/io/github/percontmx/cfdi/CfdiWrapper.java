package io.github.percontmx.cfdi;

import java.util.List;

public interface CfdiWrapper<T extends AbstractCfdi> extends Cfdi {
    String getVersion();
    List<Object> getComplementos();
}
