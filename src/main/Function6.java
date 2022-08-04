/**
 * Beta Function B(x,y) Calculator.
 */

package main;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Beta Function Class.
 *
 * @author Mahavir Patel
 *
 */
public class Function6 {

  private static final double PI = 3.141592653589793;
  private static final double e = 2.718281828459045;

  /**
  * driver function to take inputs from the user and returns the beta value.
  *
  * @param args paramters provided by command lines.
  */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      
      String f;
      double x;
      double y;
      System.out.println("Beta Function Calculator B(X, Y)");
      try {
        System.out.println("Enter X (X>0) : ");
        x = sc.nextDouble();
        System.out.println("Enter Y (Y>0) : ");
        y = sc.nextDouble();
        if (x <= 0 || y <= 0) {
          System.out.println("Error ! Please Enter the Positive Numbers Only !!");
          continue;
        }
        Function6 betafucntionobejct = new Function6();
        System.out.println("B(X, Y) : " + betafucntionobejct.betaFucntion(x, y));
        System.out.println("Press 'Y' to continue\nPress 0 to exit .............");
        f = sc.next();
        if (f.equals("0")) {
          break;
        }
      } catch (InputMismatchException e) {
        sc.next();
        System.out.println("Error ! Please Enter the valid Inputs !!");
      } catch (Exception e) {
        System.out.println(e.getClass());  
        System.out.println("Fatal Error!");  
      }
    }
    sc.close();
  }

  /**
   * Returns the beta value for the x and y.
   *
   * @param x first paramter of beta function.
   * @param y second paramter of beta function.
   * @return B(x,y)
   */
  public double betaFucntion(double x, double y) {
    return gammaFunction(x) * gammaFunction(y) / gammaFunction(x + y);
  }

  /**
   * Return the gamma value for the Real positive numbers(R+) using the stirling approximation.
   *
   * @param n number to calulate the gamma function 
   * @return gamma value for the decimal numbers using the stirling's approximation
   */
  public double decimalGammaFunction(double n) {
    n = n - 1;
    double firstpart = 2 * PI * n;
    double secondpart = n / e;
    double result = power(firstpart, 0.5) * power(secondpart, n);
    return result;
  }

  /**
   * Return the gamma value for the integers only by using Factorial Method.
   *
   * @param n number
   * @return gamma value for the number, gamma of n = (n-1)!
   */
  public double gammaFunction(double n) {
    if (checkWholeNumber(n)) {
      return factorial(n - 1);
    } 
    return decimalGammaFunction(n);
  }

  /**
   * Return the power of a to n.
   *
   * @param a base
   * @param n exponent
   * @return pow(a,n)
   */
  public double power(double a, double n) {
    String numberstring = Double.toString(n);
    String[] numberArray = numberstring.split("\\.");
    if (Integer.parseInt(numberArray[1]) > 0) {
      return fractionPower(a, n);
    }
    if (n < 0.0) {
      a = 1.0 / a;
      n = n * -1;
      return power(a, n);
    } else if (n == 0.0) {
      return 1.0;
    } else if (n % 2 == 0.0) {
      a = a * a;
      n = n / 2;
      return power(a, n);
    } else {
      n = (n - 1) / 2;
      return a * power(a * a, n);
    }
  }

  /**
   * Calculate the power function for the decimal number.
   *
   * @param a base
   * @param n exponent
   * @return pow(a,n)
   */
  public double fractionPower(double a, double n) {
    double answer = 0;
    double logvalue;
    if (n == 0) {
      return 1;
    }
    if (a < 0) {
      logvalue = ln(a * (-1));
    } else {
      logvalue = ln(a);
    }
    if (a == 0 && n > 0) {
      return answer;
    }
    for (int i = 0; i <= 125; i++) {
      double numerator = power(n * logvalue, i);
      double denominator = factorial(i);
      answer = answer + (numerator / denominator);
    }
    if (a < 0 && n % 2 != 0) {
      return answer * (-1);
    } else {
      return answer;
    }
  }

  /**
   * Return the log.
   *
   * @param n number
   * @return log n
   */
  public double ln(double n) {
    double answer = 0;
    final double base = (n - 1) / (n + 1);
    for (int i = 1; i <= 125; i++) {
      double exponent = 2 * i - 1;
      answer += (1 / exponent) * (power(base, exponent));
    }
    return 2 * answer;
  }

  /**
   * tail recursive function for factorial.
   *
   * @param n number
   * @param a initially 1 number is used as argument
   * @return n!
   */
  public double factorialTailRecursive(double n, double a) {
    if (n == 0) {
      return a;
    }
    return factorialTailRecursive(n - 1, n * a);
  }
  
  /**
   * Return the factorial of number using the tail recursion.
   *
   * @param n number
   * @return n!
   */
  public double factorial(double n) {
    return factorialTailRecursive(n, 1);
  }
  
  /**
   * This function returns true is the given number is Whole numbers(Z+) otherwise returns false.
   *
   * @param n number to be checked
   * @return true if the given number is whole number else false
   */
  public boolean checkWholeNumber(double n) {
    if (n % 1 == 0) {
      return true;
    }
    return false;
  }
}
