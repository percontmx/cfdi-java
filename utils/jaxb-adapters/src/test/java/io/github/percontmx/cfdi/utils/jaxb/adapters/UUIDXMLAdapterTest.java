package io.github.percontmx.cfdi.utils.jaxb.adapters;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UUIDXMLAdapterTest {

    private final UUIDXMLAdapter testAdapter = new UUIDXMLAdapter();

    @Test
    public void testMarshallingFromUUIDInstance() {
        UUID randomUUID = UUID.randomUUID();
        String expectedString = randomUUID.toString();
        assertEquals(expectedString, testAdapter.marshal(randomUUID));
    }

    @Test
    public void testMarshallingNullUUIDInstance() {
        assertNull(testAdapter.marshal(null));
    }

    @Test
    public void testUnmarshallingValidUUIDString() {
        UUID randomUUID = UUID.randomUUID();
        assertEquals(randomUUID, testAdapter.unmarshal(randomUUID.toString()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnmarshallingInvalidUUIDString() {
        testAdapter.unmarshal("testStringSample");
    }

    @Test
    public void testUnmarshallingUUIDStringWithUpperCase() {
        UUID randomUUID = UUID.randomUUID();
        assertEquals(randomUUID, testAdapter.unmarshal(
                randomUUID.toString().toUpperCase()));
    }

    @Test
    public void testUnmarshallingNullUUIDString() {
        assertNull(testAdapter.unmarshal(null));
    }
}
