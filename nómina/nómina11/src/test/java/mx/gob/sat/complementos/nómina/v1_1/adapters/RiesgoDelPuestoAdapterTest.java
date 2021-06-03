package mx.gob.sat.complementos.nómina.v1_1.adapters;

import mx.gob.sat.catálogos.nómina.RiesgoDelPuesto;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RiesgoDelPuestoAdapterTest extends CatálogoAdapterTest<Integer, RiesgoDelPuesto> {

    public RiesgoDelPuestoAdapterTest(){
        super(new RiesgoDelPuestoAdapter(),
                Stream.of(RiesgoDelPuesto.values())
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(
                                a -> a,
                                b -> Integer.valueOf(b.value())
                        ),
                        Collections::unmodifiableMap)));
    }
}
