package io.github.percontmx.cfdi;

public interface CfdiWrapper<T extends AbstractCfdi> extends Cfdi {
    T getComprobanteOriginal();

    String getVersion();
}
