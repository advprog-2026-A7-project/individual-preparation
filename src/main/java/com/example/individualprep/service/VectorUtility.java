package com.example.individualprep.service;

import org.springframework.stereotype.Service;

@Service
public class VectorUtility {
    
    public double[] add(double[] v1, double[] v2) {
        if (v1 == null || v2 == null) {
            throw new IllegalArgumentException("Vectors must not be null");
        }

        if (v1.length != v2.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }

        double[] result = new double[v1.length];

        for(int i = 0; i < v1.length; i++) {
            result[i] = v1[i] + v2[i];
        }

        return result;
    }

    public double[] subtract(double[] v1, double[] v2) {
        if (v1 == null || v2 == null) {
            throw new IllegalArgumentException("Vectors must not be null");
        }

        if (v1.length != v2.length) {
            throw new IllegalArgumentException("Vector sizes must be the same");
        }

        double[] result = new double[v1.length];

        for (int i = 0; i < v1.length; i++) {
            result[i] = v1[i] - v2[i];
        }

        return result;
    }

    public double[] multiply(double[] v1, int x) {
        double[] result = new double[v1.length];
        for (int i = 0; i < v1.length; i++) {
            result[i] = v1[i] * x;
        }
        return result;
    }
    
    public double dotProduct(double[] v1, double[] v2) {
        if (v1 == null || v2 == null) {
            throw new IllegalArgumentException("Vectors must not be null");
        }
        if (v1.length != v2.length) {
            throw new IllegalArgumentException("Vectors must have the same length (v1=" + v1.length + ", v2=" + v2.length + ")");
        }
        double sum = 0.0;
        for (int i = 0; i < v1.length; i++) {
            sum += v1[i] * v2[i];
        }
        return sum;
    }
    
    public double norm(double[] v1) {
        if (v1 == null) {
            throw new IllegalArgumentException("Vector must not be null");
        }

        double sumOfSquares = 0.0;
        for (int i = 0; i < v1.length; i++) {
            sumOfSquares += v1[i] * v1[i];
        }

        return Math.sqrt(sumOfSquares);
    }
}