package com.example.individualprep.controller;

import com.example.individualprep.dto.VectorRequest;
import com.example.individualprep.dto.VectorResponse;
import com.example.individualprep.service.VectorUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class VectorControllerTest {

    private VectorController controller;
    private VectorUtility vectorUtility;

    @BeforeEach
    void setUp() {
        vectorUtility = mock(VectorUtility.class);
        controller = new VectorController(vectorUtility);
    }

    @Test
    void testAdd() {
        when(vectorUtility.add(any(double[].class), any(double[].class)))
                .thenReturn(new double[]{4.0, 6.0});

        VectorRequest request = new VectorRequest(new double[]{1.0, 2.0}, new double[]{3.0, 4.0}, null);
        ResponseEntity<VectorResponse> response = controller.add(request);
        
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertArrayEquals(new double[]{4.0, 6.0}, response.getBody().result());
    }

    @Test
    void testSubtract() {
        when(vectorUtility.subtract(any(double[].class), any(double[].class)))
                .thenReturn(new double[]{-2.0, -2.0});

        VectorRequest request = new VectorRequest(new double[]{1.0, 2.0}, new double[]{3.0, 4.0}, null);
        ResponseEntity<VectorResponse> response = controller.subtract(request);
        
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertArrayEquals(new double[]{-2.0, -2.0}, response.getBody().result());
    }

    @Test
    void testMultiply() {
        when(vectorUtility.multiply(any(double[].class), anyInt()))
                .thenReturn(new double[]{2.0, 4.0});

        VectorRequest request = new VectorRequest(new double[]{1.0, 2.0}, null, 2);
        ResponseEntity<VectorResponse> response = controller.multiply(request);
        
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertArrayEquals(new double[]{2.0, 4.0}, response.getBody().result());
    }

    @Test
    void testMultiplyWithNullScalar() {
        VectorRequest request = new VectorRequest(new double[]{1.0, 2.0}, null, null);
        ResponseEntity<VectorResponse> response = controller.multiply(request);
        
        assertEquals(400, response.getStatusCode().value());
    }

    @Test
    void testDotProduct() {
        when(vectorUtility.dotProduct(any(double[].class), any(double[].class)))
                .thenReturn(11.0);

        VectorRequest request = new VectorRequest(new double[]{1.0, 2.0}, new double[]{3.0, 4.0}, null);
        ResponseEntity<VectorResponse> response = controller.dotProduct(request);
        
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals(11.0, response.getBody().scalarResult());
    }

    @Test
    void testNorm() {
        when(vectorUtility.norm(any(double[].class)))
                .thenReturn(5.0);

        VectorRequest request = new VectorRequest(new double[]{3.0, 4.0}, null, null);
        ResponseEntity<VectorResponse> response = controller.norm(request);
        
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals(5.0, response.getBody().scalarResult());
    }
}
