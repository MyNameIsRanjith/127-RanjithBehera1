package junitmockitowhenthenreturn;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class CalcTest {
	
	static Calculator mockCalcObject;
	static int a,b;
	@BeforeClass
	public static void init() {
		mockCalcObject = mock(Calculator.class);
		when(mockCalcObject.add(a,b)).thenReturn(7);
		//when(mockCalcObject.sub(a,b)).thenReturn(2);
	}
	
	@Test
	public void addTest() {
		//a=5;
		//b=2;
		System.out.println("a="+a);
		System.out.println("b="+b);
		assertSame(mockCalcObject.add(a, b),7);
		//assertEquals(mockCalcObject.add(a, b),5);
		
	}

	//@Test
	//public void subTest() {
		//a=3;
		//b=2;
		//System.out.println("a="+a);
		//System.out.println("b="+b);
		//assertSame(mockCalcObject.add(a, b),1);
		//assertEquals(mockCalcObject.add(a, b),5);
	//}
	}