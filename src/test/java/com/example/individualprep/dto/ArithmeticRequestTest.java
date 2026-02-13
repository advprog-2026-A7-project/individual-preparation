package com.example.individualprep.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticRequestTest {

    @Test
    void testConstructorAndAccessors() {
        ArithmeticRequest request = new ArithmeticRequest(10.0, 5.0, 2);
        
        assertEquals(10.0, request.operand1());
        assertEquals(5.0, request.operand2());
        assertEquals(2, request.exponent());
    }

    @Test
    void testConstructorWithNullExponent() {
        ArithmeticRequest request = new ArithmeticRequest(10.0, 5.0, null);
        
        assertEquals(10.0, request.operand1());
        assertEquals(5.0, request.operand2());
        assertNull(request.exponent());
    }

    @Test
    void testEquals() {
        ArithmeticRequest request1 = new ArithmeticRequest(10.0, 5.0, 2);
        ArithmeticRequest request2 = new ArithmeticRequest(10.0, 5.0, 2);
        ArithmeticRequest request3 = new ArithmeticRequest(10.0, 5.0, 3);
        
        assertEquals(request1, request2);
        assertNotEquals(request1, request3);
    }

    @Test
    void testHashCode() {
        ArithmeticRequest request1 = new ArithmeticRequest(10.0, 5.0, 2);
        ArithmeticRequest request2 = new ArithmeticRequest(10.0, 5.0, 2);
        
        assertEquals(request1.hashCode(), request2.hashCode());
    }

    @Test
    void testToString() {
        ArithmeticRequest request = new ArithmeticRequest(10.0, 5.0, 2);
        String toString = request.toString();
        
        assertTrue(toString.contains("10.0"));
        assertTrue(toString.contains("5.0"));
        assertTrue(toString.contains("2"));
    }
}
