package io.github.percontmx.cfdi.utils.jaxb.adapters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleXMLAdapterTest {

    private final DoubleXMLAdapter testAdapter = new DoubleXMLAdapter();

    @Test
    public void testMarshallingFromDoubleInstance() {
        Double randomDouble = 123.456;
        String expectedString = randomDouble.toString();
        assertEquals(expectedString, testAdapter.marshal(randomDouble));
    }

    @Test
    public void testMarshallingNullDoubleInstance() {
        assertNull(testAdapter.marshal(null));
    }

    @Test
    public void testUnmarshallingValidDoubleString() {
        Double randomDouble = 123.456;
        assertEquals(randomDouble, testAdapter.unmarshal(randomDouble.toString()));
    }

    @Test
    public void testUnmarshallingInvalidDoubleString() {
        assertThrows(IllegalArgumentException.class, () ->
                testAdapter.unmarshal("testStringSample"));
    }

    @Test
    public void testUnmarshallingDoubleStringWithUpperCase() {
        Double randomDouble = 123.456;
        assertEquals(randomDouble, testAdapter.unmarshal(
                randomDouble.toString().toUpperCase()));
    }

    @Test
    public void testUnmarshallingNullDoubleString() {
        assertNull(testAdapter.unmarshal(null));
    }
}
