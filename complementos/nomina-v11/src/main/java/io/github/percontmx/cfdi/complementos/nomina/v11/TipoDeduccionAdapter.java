package io.github.percontmx.cfdi.complementos.nomina.v11;


import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import mx.gob.sat.cfdi.catalogos.nomina.TipoDeduccion;

public class TipoDeduccionAdapter extends XmlAdapter<Integer, TipoDeduccion> {

    @Override
    public TipoDeduccion unmarshal(Integer integer) {
        if (null == integer) {
            return null;
        }
        String value = String.format("%03d", integer);
        return TipoDeduccion.fromValue(value);
    }

    @Override
    public Integer marshal(TipoDeduccion tipoDeduccion) {
        if (tipoDeduccion == null) {
            return null;
        }
        return Integer.parseInt(tipoDeduccion.value());
    }
}
