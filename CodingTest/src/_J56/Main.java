package _J56;

import java.util.Scanner;

/**
 * 56. Factorial  
 * 
 * [입력] 
 * 5

 * [출력] 
 * 120 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	public static int Factorial(int num) {
		int sum = 0;
		if(num == 1) return 1;
		else return num*Factorial(num-1);
		 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print(Factorial(n));
		
	}
}
