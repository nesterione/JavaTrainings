package auth;

import org.junit.Assert;
import org.junit.Test;

import com.itclass.services.DbService;


public class FirstTest {

	@Test
	public void test() {
		
		double actual = Math.sqrt(9);
		double expected = 3;
		
		Assert.assertEquals(expected, actual,0.0001);
	}
	
	@Test(expected=Exception.class) 
	public void test1() throws Exception {
		
		DbService d;
		
		throw new Exception();
		
	}
	
}
