package com.example.individualprep.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticResponseTest {

    @Test
    void testConstructorAndAccessor() {
        ArithmeticResponse response = new ArithmeticResponse(42.5);
        
        assertEquals(42.5, response.result());
    }

    @Test
    void testEquals() {
        ArithmeticResponse response1 = new ArithmeticResponse(42.5);
        ArithmeticResponse response2 = new ArithmeticResponse(42.5);
        ArithmeticResponse response3 = new ArithmeticResponse(43.0);
        
        assertEquals(response1, response2);
        assertNotEquals(response1, response3);
    }

    @Test
    void testHashCode() {
        ArithmeticResponse response1 = new ArithmeticResponse(42.5);
        ArithmeticResponse response2 = new ArithmeticResponse(42.5);
        
        assertEquals(response1.hashCode(), response2.hashCode());
    }

    @Test
    void testToString() {
        ArithmeticResponse response = new ArithmeticResponse(42.5);
        String toString = response.toString();
        
        assertTrue(toString.contains("42.5"));
    }
}
