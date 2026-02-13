package com.example.individualprep.controller;

import com.example.individualprep.dto.ArithmeticRequest;
import com.example.individualprep.dto.ArithmeticResponse;
import com.example.individualprep.service.ArithmeticUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ArithmeticControllerTest {

    private ArithmeticController controller;
    private ArithmeticUtility arithmeticUtility;

    @BeforeEach
    void setUp() {
        arithmeticUtility = mock(ArithmeticUtility.class);
        controller = new ArithmeticController(arithmeticUtility);
    }

    @Test
    void testAdd() {
        when(arithmeticUtility.add(anyDouble(), anyDouble())).thenReturn(15.0);
        
        ArithmeticRequest request = new ArithmeticRequest(10.0, 5.0, null);
        ResponseEntity<ArithmeticResponse> response = controller.add(request);
        
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals(15.0, response.getBody().result());
    }

    @Test
    void testSubtract() {
        when(arithmeticUtility.subtract(anyDouble(), anyDouble())).thenReturn(5.0);
        
        ArithmeticRequest request = new ArithmeticRequest(10.0, 5.0, null);
        ResponseEntity<ArithmeticResponse> response = controller.subtract(request);
        
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals(5.0, response.getBody().result());
    }

    @Test
    void testMultiply() {
        when(arithmeticUtility.multiply(anyDouble(), anyDouble())).thenReturn(50.0);
        
        ArithmeticRequest request = new ArithmeticRequest(10.0, 5.0, null);
        ResponseEntity<ArithmeticResponse> response = controller.multiply(request);
        
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals(50.0, response.getBody().result());
    }

    @Test
    void testDivide() {
        when(arithmeticUtility.divide(anyDouble(), anyDouble())).thenReturn(2.0);
        
        ArithmeticRequest request = new ArithmeticRequest(10.0, 5.0, null);
        ResponseEntity<ArithmeticResponse> response = controller.divide(request);
        
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals(2.0, response.getBody().result());
    }

    @Test
    void testExponent() {
        when(arithmeticUtility.exponent(anyDouble(), anyInt())).thenReturn(100.0);
        
        ArithmeticRequest request = new ArithmeticRequest(10.0, 0.0, 2);
        ResponseEntity<ArithmeticResponse> response = controller.exponent(request);
        
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals(100.0, response.getBody().result());
    }

    @Test
    void testExponentWithNullExponent() {
        ArithmeticRequest request = new ArithmeticRequest(10.0, 5.0, null);
        ResponseEntity<ArithmeticResponse> response = controller.exponent(request);
        
        assertEquals(400, response.getStatusCode().value());
    }
}
