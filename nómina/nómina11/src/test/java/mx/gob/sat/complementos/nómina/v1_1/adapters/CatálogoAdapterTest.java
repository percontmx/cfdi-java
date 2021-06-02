package mx.gob.sat.complementos.nómina.v1_1.adapters;

import mx.gob.sat.catálogos.nómina.Catálogo;
import org.junit.Test;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

public abstract class CatálogoAdapterTest<ValueType, BoundType extends Catálogo> {

    private final XmlAdapter<ValueType, BoundType> adapter;

    private final Map<BoundType, ValueType> expectedValues;

    protected CatálogoAdapterTest(XmlAdapter<ValueType, BoundType> adapterUnderTest,
                                  Map<BoundType, ValueType> expectedValuesFromTest){
        adapter = adapterUnderTest;
        expectedValues = expectedValuesFromTest;
    }

    @Test
    public void marshalNullValueTest() throws Exception {
        assertNull(adapter.marshal(null));
    }

    @Test
    public void marshalExpectedValuesTest() {
        expectedValues.forEach((k, v) -> {
            try {
                assertEquals(v, adapter.marshal(k));
            } catch (Exception e) {
                fail(e.getMessage());
            }
        });
    }

    @Test
    public void unmarshalExpectedValuesTest(){
        expectedValues.forEach((k, v) -> {
            try {
                assertEquals(k, adapter.unmarshal(v));
            } catch (Exception e) {
                fail(e.getMessage());
            }
        });
    }

    @Test
    public void unmarshalNullValueTest() throws Exception {
        assertNull(adapter.unmarshal(null));
    }
}
