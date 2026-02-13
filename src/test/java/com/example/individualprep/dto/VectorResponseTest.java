package com.example.individualprep.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorResponseTest {

    @Test
    void testConstructorWithVectorArray() {
        double[] result = {1.0, 2.0, 3.0};
        VectorResponse response = new VectorResponse(result);
        
        assertArrayEquals(result, response.result());
        assertNull(response.scalarResult());
    }

    @Test
    void testConstructorWithScalar() {
        VectorResponse response = new VectorResponse(42.5);
        
        assertNull(response.result());
        assertEquals(42.5, response.scalarResult());
    }

    @Test
    void testFullConstructor() {
        double[] result = {1.0, 2.0, 3.0};
        VectorResponse response = new VectorResponse(result, 42.5);
        
        assertArrayEquals(result, response.result());
        assertEquals(42.5, response.scalarResult());
    }

    @Test
    void testEquals() {
        double[] result1 = {1.0, 2.0};
        VectorResponse response1 = new VectorResponse(result1);
        VectorResponse response2 = new VectorResponse(result1);
        VectorResponse response3 = new VectorResponse(42.5);
        
        assertEquals(response1, response2);
        assertNotEquals(response1, response3);
    }

    @Test
    void testHashCode() {
        double[] result = {1.0, 2.0};
        VectorResponse response1 = new VectorResponse(result);
        VectorResponse response2 = new VectorResponse(result);
        
        assertEquals(response1.hashCode(), response2.hashCode());
    }

    @Test
    void testToString() {
        double[] result = {1.0, 2.0};
        VectorResponse response = new VectorResponse(result);
        String toString = response.toString();
        
        assertNotNull(toString);
    }
}
