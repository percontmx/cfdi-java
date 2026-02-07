package io.github.percontmx.cfdi.complementos.nomina.v11;

import mx.gob.sat.cfdi.catalogos.nomina.TipoDeduccion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


class TipoDeduccionAdapterTest {

    private final TipoDeduccionAdapter adapter = new TipoDeduccionAdapter();

    @Test
    void marshallValidTipoDeduccion() {
        TipoDeduccion randomTipo = Arrays.stream(TipoDeduccion.values())
                .findAny()
                .orElseThrow();
        Integer value = adapter.marshal(randomTipo);
        Assertions.assertNotNull(value);
        Integer expectedValue = Integer.parseInt(randomTipo.value());
        Assertions.assertEquals(expectedValue, value);
    }

    @Test
    void marshallNullTipoDeduccion() {
        Assertions.assertNull(adapter.marshal(null));
    }

    @Test
    void unmarshallInvalidTipoDeduccion() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> adapter.unmarshal(-1));
    }

    @Test
    void unmarshallValidTipoDeduccion() {
        int randomTipoDeduccion = 1 + (int) (Math.random() * TipoDeduccion.values().length);
        TipoDeduccion tipoDeduccion = adapter.unmarshal(randomTipoDeduccion);
        Assertions.assertNotNull(tipoDeduccion);
        Assertions.assertEquals(String.format("%03d", randomTipoDeduccion), tipoDeduccion.value());
    }

    @Test
    void unmarshallNullTipoDeduccion() {
        Assertions.assertNull(adapter.unmarshal(null));
    }
}
