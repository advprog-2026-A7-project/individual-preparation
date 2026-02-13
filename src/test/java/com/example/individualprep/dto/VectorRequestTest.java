package com.example.individualprep.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorRequestTest {

    @Test
    void testConstructorAndAccessors() {
        double[] vector1 = {1.0, 2.0, 3.0};
        double[] vector2 = {4.0, 5.0, 6.0};
        VectorRequest request = new VectorRequest(vector1, vector2, 2);
        
        assertArrayEquals(vector1, request.vector1());
        assertArrayEquals(vector2, request.vector2());
        assertEquals(2, request.scalar());
    }

    @Test
    void testConstructorWithNullScalar() {
        double[] vector1 = {1.0, 2.0, 3.0};
        double[] vector2 = {4.0, 5.0, 6.0};
        VectorRequest request = new VectorRequest(vector1, vector2, null);
        
        assertArrayEquals(vector1, request.vector1());
        assertArrayEquals(vector2, request.vector2());
        assertNull(request.scalar());
    }

    @Test
    void testEquals() {
        double[] vector1 = {1.0, 2.0};
        double[] vector2 = {3.0, 4.0};
        VectorRequest request1 = new VectorRequest(vector1, vector2, 2);
        VectorRequest request2 = new VectorRequest(vector1, vector2, 2);
        VectorRequest request3 = new VectorRequest(vector1, vector2, 3);
        
        assertEquals(request1, request2);
        assertNotEquals(request1, request3);
    }

    @Test
    void testHashCode() {
        double[] vector1 = {1.0, 2.0};
        double[] vector2 = {3.0, 4.0};
        VectorRequest request1 = new VectorRequest(vector1, vector2, 2);
        VectorRequest request2 = new VectorRequest(vector1, vector2, 2);
        
        assertEquals(request1.hashCode(), request2.hashCode());
    }

    @Test
    void testToString() {
        double[] vector1 = {1.0, 2.0};
        double[] vector2 = {3.0, 4.0};
        VectorRequest request = new VectorRequest(vector1, vector2, 2);
        String toString = request.toString();
        
        assertNotNull(toString);
        assertTrue(toString.contains("VectorRequest") || toString.contains("vector"));
    }
}
