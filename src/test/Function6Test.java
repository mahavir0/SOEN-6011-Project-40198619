/**
 * Test Class for Function6.
 */

package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import main.Function6;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Testing the Beta Function.
 *
 * @author Mahavir Patel
 *
 */
class Function6Test {

  static Function6 fobject;

  /**
   * to Setup the environment Before the Junit Test Begin.
   *
   * @throws java.lang.Exception If any exception occur
   */
  @BeforeAll
  static void setUpBeforeClass() throws Exception {
    fobject = new Function6();
  }
  
  /**
   * To arrage the necessary elements before the each test.
   *
   * @throws java.lang.Exception If any exception occur
   */
  @BeforeEach
  void setUp() throws Exception {
  
  }
  
  /**
   * Test the Beta Function for the x and y in Z+.
   */
  @Test
  void testBetaFunction() {
    assertEquals(fobject.betaFucntion(1, 1), 1);
    assertNotEquals(fobject.betaFucntion(1, 1), 2);
    assertEquals(fobject.betaFucntion(100, 1), 0.009999999999999998);
    assertNotNull(fobject.betaFucntion(500, 500));
  }
  
  /**
   * Test Cases where Beta Function have decimal numbers.
   */
  @Test
  void testBetaFunctionFraction() {
    assertEquals(fobject.betaFucntion(1.5, 1.5), 0.28893183744773054);
    assertEquals(fobject.betaFucntion(15.8, 20.8), 1.1488056591230658E-11);
  }
  
  /**
   * Test the Best function where one or more inputs is zero.
   */
  @Test
  void testBetaFunctionZero() {
    assertThrows(StackOverflowError.class, () -> {
      fobject.betaFucntion(0, 0);
    });
    assertThrows(StackOverflowError.class, () -> {
      fobject.betaFucntion(0, 5);
    });
    assertThrows(StackOverflowError.class, () -> {
      fobject.betaFucntion(5, 0);
    });
  }
  
  /**
   * Test the Best function where one or more inputs is negative.
   */
  @Test
  void testBetaFunctionNegative() {
    assertThrows(StackOverflowError.class, () -> {
      fobject.betaFucntion(0, -5);
    });
    assertThrows(StackOverflowError.class, () -> {
      fobject.betaFucntion(-5, 5);
    });
    assertThrows(StackOverflowError.class, () -> {
      fobject.betaFucntion(-5, -5);
    });
    assertThrows(NumberFormatException.class, () -> {
      fobject.betaFucntion(-5.3, -5.6);
    });
  }
  
  /**
   * Test for the tail recursive factorial function.
   */
  @Test
  void testFactorial() {
    assertEquals(120, fobject.factorial(5));
    assertEquals(1, fobject.factorial(0));
    assertEquals(7.257415615308004E306, fobject.factorial(170));
  }
  
  /**
   * Test for the Log Function.
   */
  @Test
  void testLn() {
    assertEquals(6.589454748803522, fobject.ln(2345));
    assertEquals(-6.791826429960522, fobject.ln(0));
    assertEquals(6.347984312475613, fobject.ln(1000));
  }
  
  /**
   * To check the given number is whole number or not.
   */
  @Test
  void testCheckWholeNumber() {
    assertFalse(fobject.checkWholeNumber(0.12));
    assertFalse(fobject.checkWholeNumber(789.646));
    assertTrue(fobject.checkWholeNumber(12.00));
    assertTrue(fobject.checkWholeNumber(45));
  }
  
  /**
   * Test for the power function.
   */
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
  
  /**
   * Test for the Gamma Function for both Whole Number and Real Number.
   */
  @Test
  void testGammaFunction() {
    assertEquals(24.0, fobject.gammaFunction(5));
    assertEquals(60.45055028699955, fobject.gammaFunction(5.6));
    assertEquals(7.257415615308004E306, fobject.gammaFunction(171));
    assertEquals(7.257415615308004E306, fobject.gammaFunction(171.0));
    assertEquals(Double.POSITIVE_INFINITY, fobject.gammaFunction(204));
    assertEquals(Double.POSITIVE_INFINITY, fobject.gammaFunction(546.2));
  }
}
