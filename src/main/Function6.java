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

	/**
	 * 
	 */
	public Function6() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		double x,y;
		Scanner sc = new Scanner(System.in);
		System.out.println("Beta Function Calculator B(X, Y)");
		System.out.println("Enter X (X>0)(Only int numbers) : ");
		x = sc.nextDouble();
		System.out.println("Enter Y (Y>0)(Only int numbers) : ");
		y = sc.nextDouble();
		System.out.println("B(X, Y) : "+betaFucntion(x, y));
		sc.close();
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	static double betaFucntion(double x, double y) {
		return gammaFunction(x) * gammaFunction(y) / gammaFunction(x+y);
	}
	
	/**
	 * 
	 * @param n
	 * @return
	 */
	static double gammaFunction(double n) {
		return factorial(n-1);
	}
	/**
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
	 * 
	 * @param n
	 * @return
	 */
	static double factorial(double n) {
		return factorialTailRecursive(n, 1);
	}
	

}
