package com.example.individualprep;

import com.example.individualprep.service.ArithmeticUtility;
import com.example.individualprep.service.VectorUtility;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IndividualprepApplicationTests {

	@Autowired
	private ArithmeticUtility arithmeticUtility;

	@Autowired
	private VectorUtility vectorUtility;

	@Test
	void contextLoads() {
	}

	// ==================== ArithmeticUtility Tests ====================

	@Test
	void testAdd() {
		assertEquals(5.0, arithmeticUtility.add(2.0, 3.0));
		assertEquals(0.0, arithmeticUtility.add(-2.0, 2.0));
		assertEquals(-5.0, arithmeticUtility.add(-2.0, -3.0));
	}

	@Test
	void testSubtract() {
		assertEquals(1.0, arithmeticUtility.subtract(3.0, 2.0));
		assertEquals(-4.0, arithmeticUtility.subtract(-2.0, 2.0));
		assertEquals(0.0, arithmeticUtility.subtract(5.0, 5.0));
	}

	@Test
	void testMultiply() {
		assertEquals(6.0, arithmeticUtility.multiply(2.0, 3.0));
		assertEquals(-6.0, arithmeticUtility.multiply(-2.0, 3.0));
		assertEquals(0.0, arithmeticUtility.multiply(0.0, 5.0));
	}

	@Test
	void testDivide() {
		assertEquals(2.0, arithmeticUtility.divide(6.0, 3.0));
		assertEquals(-2.0, arithmeticUtility.divide(-6.0, 3.0));
	}

	@Test
	void testExponent() {
		assertEquals(8.0, arithmeticUtility.exponent(2.0, 3));
		assertEquals(1.0, arithmeticUtility.exponent(5.0, 0));
		assertEquals(16.0, arithmeticUtility.exponent(2.0, 4));
	}

	// ==================== VectorUtility Tests ====================

	@Test
	void testVectorAdd() {
		double[] v1 = {1.0, 2.0, 3.0};
		double[] v2 = {4.0, 5.0, 6.0};
		double[] result = vectorUtility.add(v1, v2);
		assertArrayEquals(new double[]{5.0, 7.0, 9.0}, result);
	}

	@Test
	void testVectorAddNullThrowsException() {
		assertThrows(IllegalArgumentException.class, () -> vectorUtility.add(null, new double[]{1.0}));
		assertThrows(IllegalArgumentException.class, () -> vectorUtility.add(new double[]{1.0}, null));
	}

	@Test
	void testVectorAddDifferentSizesThrowsException() {
		double[] v1 = {1.0, 2.0};
		double[] v2 = {1.0, 2.0, 3.0};
		assertThrows(IllegalArgumentException.class, () -> vectorUtility.add(v1, v2));
	}

	@Test
	void testVectorSubtract() {
		double[] v1 = {4.0, 5.0, 6.0};
		double[] v2 = {1.0, 2.0, 3.0};
		double[] result = vectorUtility.subtract(v1, v2);
		assertArrayEquals(new double[]{3.0, 3.0, 3.0}, result);
	}

	@Test
	void testVectorMultiply() {
		double[] v1 = {1.0, 2.0, 3.0};
		double[] result = vectorUtility.multiply(v1, 2);
		assertArrayEquals(new double[]{2.0, 4.0, 6.0}, result);
	}

	@Test
	void testDotProduct() {
		double[] v1 = {1.0, 2.0, 3.0};
		double[] v2 = {4.0, 5.0, 6.0};
		assertEquals(32.0, vectorUtility.dotProduct(v1, v2));
	}

	@Test
	void testDotProductNullThrowsException() {
		assertThrows(IllegalArgumentException.class, () -> vectorUtility.dotProduct(null, new double[]{1.0}));
		assertThrows(IllegalArgumentException.class, () -> vectorUtility.dotProduct(new double[]{1.0}, null));
	}

	@Test
	void testDotProductDifferentSizesThrowsException() {
		double[] v1 = {1.0, 2.0};
		double[] v2 = {1.0, 2.0, 3.0};
		assertThrows(IllegalArgumentException.class, () -> vectorUtility.dotProduct(v1, v2));
	}

	@Test
	void testNorm() {
		double[] v1 = {3.0, 4.0};
		assertEquals(5.0, vectorUtility.norm(v1));
	}

	@Test
	void testNormNullThrowsException() {
		assertThrows(IllegalArgumentException.class, () -> vectorUtility.norm(null));
	}
}
