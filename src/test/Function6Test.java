/**
 * 
 */
package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.FileInputStream;
//import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Function6;

/**
 * @author Mahavir
 *
 */
class Function6Test {
	
	static Function6 fobject;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		 fobject = new Function6();
	}

	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
	}
	
	@Test
	void testBetaFunction() {
		assertEquals(fobject.betaFucntion(1, 1), 1);
		assertNotEquals(fobject.betaFucntion(1, 1), 2);
		assertEquals(fobject.betaFucntion(100, 1), 0.009999999999999998);
		assertNotNull(fobject.betaFucntion(500, 500));
//		assertEquals(fobject.betaFucntion(1000, 7458), Double.NaN);
	}
	
	
	/**
	 * Test Cases where Beta Function have decimal numbers
	 */
	@Test
	void testBetaFunctionFraction() {
		assertEquals(fobject.betaFucntion(1.5, 1.5), 0.28893183744773054);
		assertEquals(fobject.betaFucntion(15.8, 20.8), 1.1488056591230658E-11);	
	}
	
	
	@Test
	void testBetaFunctionZero() {
		assertThrows(StackOverflowError.class, () -> {fobject.betaFucntion(0, 0);});
		assertThrows(StackOverflowError.class, () -> {fobject.betaFucntion(0, 5);});
		assertThrows(StackOverflowError.class, () -> {fobject.betaFucntion(5, 0);});
	}
	
	@Test
	void testBetaFunctionNegative() {
		assertThrows(StackOverflowError.class, () -> {fobject.betaFucntion(0, -5);});
		assertThrows(StackOverflowError.class, () -> {fobject.betaFucntion(-5, 5);});
		assertThrows(StackOverflowError.class, () -> {fobject.betaFucntion(-5, -5);});
		assertThrows(NumberFormatException.class, () -> {fobject.betaFucntion(-5.3, -5.6);});
	}
	
	@Test
	void testFactorial() {
		assertEquals(120,fobject.factorial(5));
		assertEquals(1,fobject.factorial(0));
		assertEquals(7.257415615308004E306,fobject.factorial(170));
	}
	
	@Test
	void testLn() {
		assertEquals(6.589454748803522,fobject.ln(2345));
		assertEquals(-6.791826429960522,fobject.ln(0));
		assertEquals(6.347984312475613, fobject.ln(1000));
	}
	
	@Test
	void testCheckWholeNumber() {
		assertFalse(fobject.checkWholeNumber(0.12));
		assertFalse(fobject.checkWholeNumber(789.646));
		assertTrue(fobject.checkWholeNumber(12.00));
		assertTrue(fobject.checkWholeNumber(45));
	}
	
	@Test
	void testPower() {
		assertEquals(6.458728823355533E-5, fobject.power(5.6, -5.6));
		assertEquals(5.1711434516260956E14, fobject.power(45, 8.9));
		assertEquals(-5.1711434516260956E14, fobject.power(-45, 8.9));
		assertEquals(-0.003817133454577713, fobject.power(-45, -8.9));
		assertEquals(3.833759992447475E21, fobject.power(144, 10));
		assertEquals(1.0, fobject.power(144, 0));
		assertEquals(1.0, fobject.power(144, 0.0));
		assertEquals(1.0, fobject.power(0.0, 0.0));
	}
	
	@Test
	void testGammaFunction() {
		assertEquals(24.0, fobject.gammaFunction(5));
		assertEquals(60.45055028699955, fobject.gammaFunction(5.6));
		assertEquals(7.257415615308004E306, fobject.gammaFunction(171));
		assertEquals(7.257415615308004E306, fobject.gammaFunction(171.0));
		assertEquals(Double.POSITIVE_INFINITY, fobject.gammaFunction(204));
		assertEquals(Double.POSITIVE_INFINITY, fobject.gammaFunction(546.2));
	}
	
//	@Test
//	void testMainFunction() {
//		try {
//			String userInput = String.format("9%s9%sy%ssdf%s-4%s-4%s-4%s0%s0%s-3%s0%s0%s1%s3%s0",
//		            System.lineSeparator(),
//		            System.lineSeparator());
////			ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
//		    System.setIn(new ByteArrayInputStream(userInput.getBytes()));
//		    
//		    String expected = "4.570592805886924E-6\r\n"
//		    		+ "Error !\r\n"
//		    		+ "Error !\r\n"
//		    		+ "Error !\r\n"
//		    		+ "Error !\r\n"
//		    		+ "Error !\r\n"
//		    		+ "0.3333333333333333";
//		    ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		    PrintStream printStream = new PrintStream(baos);
//		    System.setOut(printStream);
//		    
//		    fobject.main(null);
//		    
//		    String[] lines = baos.toString().split(System.lineSeparator());
//		    String actual = lines[lines.length-1];
//
//		    // checkout output
//		    assertEquals(expected,actual);
//		}catch(Exception e) {
//			
//		}
//	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.gc();
	}

}
