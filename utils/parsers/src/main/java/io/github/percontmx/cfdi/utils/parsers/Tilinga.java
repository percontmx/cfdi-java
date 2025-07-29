package io.github.percontmx.cfdi.utils.parsers;

public enum Tilinga {
    CFDI_32(CfdiV32Parser.class);

    private final Class<? extends TilingaLunga> tilingaLungaClass;

    Tilinga(Class<? extends TilingaLunga> tilingaLungaClass) {
        this.tilingaLungaClass = tilingaLungaClass;
    }

    public Class<? extends TilingaLunga> getTilingaLungaClass() {
        return tilingaLungaClass;
    }
}
