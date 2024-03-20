package org.prannoy.core.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.prannoy.core.models.Calculator;

public class TestCalculator {

	@Test
	public void testAdd() {
		Calculator cal = new Calculator();
		int result = cal.add(5, 10);
		//assertEquals(15, result);
		assertEquals(12, result, "This test has passed");
	}
	
	@Test
	public void testSub() {
		Calculator cal = new Calculator();
		int result = cal.sub(5, 10);
		//assertEquals(-4, result);
		assertTrue(result == -3);
	}
	
	@Test
	public void testMul() {
		Calculator cal = new Calculator();
		int result = cal.mul(5, 10);
		assertEquals(50, result);
	}
	
	@Test
	public void testDiv() {
		Calculator cal = new Calculator();
		int result = cal.div(5, 10);
		assertEquals(0, result);
	}

}
