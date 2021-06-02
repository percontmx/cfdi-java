package mx.gob.sat.complementos.nómina.v1_1.adapters;

import mx.gob.sat.catálogos.nómina.RiesgoDelPuesto;

public class RiesgoDelPuestoAdapter extends CatálogoAdapter<Integer, RiesgoDelPuesto> {

    public RiesgoDelPuestoAdapter() {
        super(integer -> RiesgoDelPuesto.fromValue(String.valueOf(integer)),
                riesgoDelPuesto -> Integer.parseInt(riesgoDelPuesto.value()));
    }
}
