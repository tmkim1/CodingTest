package _J54;

import java.util.Scanner;

/**
 * 54. 재귀함수(스택프레임)  
 * 자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지 출력하는 프로그램을 작성하시오. 
 * 
 * [입력] 
 * 6

 * [출력] 
 * 1 2 3 4 5 6 
 * 
 * [설명]
 * 재귀 함수: 자기 자신을 호출하는 함수 
 * StackFrame: 함수의 호출 정보를 저장하는 자료 구조, 
 *             Parameters, Local variables, Return address로 구성 // 함수가 최초로 끝날때 waiting 상태였던 function들이 차례대로 수행 됨.  
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	public static void solution(int n) {
		
		if(n == 0) return; 			
		else {
			solution(n-1);				// 자기 자신을 호출, StackFrame에 순서대로 쌓임  
			System.out.print(n + " ");   
		}
	}
	
	
	//유클리드 호제법 (최대공약수 구하기 - 재귀) 
	public static int gcd(int a, int b) {
		if(a % b == 0) return b;
		else return gcd(b, a % b);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		solution(n);
		System.out.println("");
		System.out.println("gcd 192, 162: " + gcd(192, 162));
	}
}
