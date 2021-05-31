package mx.gob.sat.complementos.nómina.v1_1.adapters;

import mx.gob.sat.catálogos.nómina.TipoDeIncapacidad;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class TipoDeIncapacidadAdapterTest
        extends CatálogoAdapterTest<Integer, TipoDeIncapacidad> {

    public TipoDeIncapacidadAdapterTest() {
        super(new TipoDeIncapacidadAdapter(),
                Arrays.stream(TipoDeIncapacidad.values()).collect(
                        Collectors.collectingAndThen(
                                Collectors.toMap(
                                        k -> k,
                                        k -> Integer.valueOf(k.value())),
                                Collections::unmodifiableMap)));
    }
}
