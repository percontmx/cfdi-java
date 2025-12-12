package io.github.percontmx.cfdi;

public interface CfdiWrapper<T extends AbstractCfdi> extends Cfdi {
    String getVersion();
}
