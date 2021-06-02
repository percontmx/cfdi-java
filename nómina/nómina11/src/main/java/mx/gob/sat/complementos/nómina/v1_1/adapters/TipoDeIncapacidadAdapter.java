package mx.gob.sat.complementos.nómina.v1_1.adapters;

import mx.gob.sat.catálogos.nómina.TipoDeIncapacidad;

public class TipoDeIncapacidadAdapter extends CatálogoAdapter<Integer, TipoDeIncapacidad> {

    public TipoDeIncapacidadAdapter(){
        super(integer -> TipoDeIncapacidad.fromValue(String.format("%02d", integer)),
              tipoDeIncapacidad -> Integer.parseInt(tipoDeIncapacidad.value()));
    }
}
