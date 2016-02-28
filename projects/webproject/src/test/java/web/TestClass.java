package web;

import org.junit.Assert;
import org.junit.Test;

public class TestClass {
	
	@Test
	public void testSqr() {
		
		
		M m = new M();
		int actual = m.sqr(5);
		int expected = 25;
		
		Assert.assertEquals(expected, actual);
	}
	
}
