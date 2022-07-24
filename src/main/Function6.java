/**
 * 
 */
package main;

import java.util.Scanner;

/**
 * @author Mahavir
 *
 */
public class Function6 {

	public final double PI = 3.141592653589793;
	public final double e = 2.718281828459045;
	
	/**
	 * driver function to take inputs from the user and returns the beta value.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		Scanner sc = new Scanner(System.in);
		String f="";
		while(true) {
			double x,y;
			System.out.println("Beta Function Calculator B(X, Y)");
			System.out.println("Enter X (X>0) : ");
			x = sc.nextDouble();
			System.out.println("Enter Y (Y>0) : ");
			y = sc.nextDouble();
			if(x==0 || y==0) {
				System.out.println("Error !");
				continue;
			}
			System.out.println("B(X, Y) : "+betaFucntion(x, y));
			System.out.println("Press 'Y' to continue\nPress 0 to exit .............");
			f = sc.next();
			if(f.equals("0"))
				break;
		}
		sc.close();
	}
	
	/**
	 * Returns the beta value for the x and y
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	static double betaFucntion(double x, double y) {
		return gammaFunction(x) * gammaFunction(y) / gammaFunction(x+y);
	}
	
	/**
	 * Return the gamma values for the Real positive numbers(R+);
	 * 
	 * @param n
	 * @return
	 */
	static double decimalGammaFunction(double n) {
		n = n - 1;
		// Works needs to be done!
		return n;
	}
	
	
	/**
	 * Return the gamma value for the integers only
	 * 
	 * @param n
	 * @return
	 */
	static double gammaFunction(double n) {
		if(checkWholeNumber(n))
			return factorial(n-1);
		return decimalGammaFunction(n);
	}
	/**
	 * tail recursive function for factorial
	 * 
	 * @param n
	 * @param a
	 * @return
	 */
	static double factorialTailRecursive(double n,double a) {
		if(n==0)
			return a;
		return factorialTailRecursive(n-1,n*a);
	}
	
	/**
	 * Return the factorial of number using the tail recursion
	 * 
	 * @param n
	 * @return
	 */
	static double factorial(double n) {
		return factorialTailRecursive(n, 1);
	}
	
	/**
	 * This function returns true is the given number is Whole numbers(Z+) otherwise returns false
	 * 
	 * @param n
	 * @return
	 */
	static boolean checkWholeNumber(double n) {
		if(n%1==0)
			return true;
		return false;
	}

	
	
}
