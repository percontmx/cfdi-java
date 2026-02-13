package io.github.percontmx.cfdi.complementos.nomina;

import java.util.List;

public abstract class AbstractComplementoNomina implements ComplementoNomina {

    protected abstract ContenedorDeducciones getContenedorDeducciones();

    @Override
    public List<? extends Deduccion> getDeducciones() {
        return getContenedorDeducciones().getDeducciones();
    }
}
