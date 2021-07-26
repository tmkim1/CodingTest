package _J57;

import java.util.Scanner;

/**
 * 57. 피보나치 수열 (메모이제이션)  
 * 
 * 
 * [입력] 
 * 10

 * [출력] 
 * 1 1 2 3 5 8 13 21 34 55
 * 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	public static int[] fibo;
	
	public static int solution(int n) {
		//이전 2개를 더한 값 
		if(fibo[n] > 0) return fibo[n]; //factorial을 구하는 재귀 특성상 이미 구한 값을 계속 구하게 돼 있음. 따라서 배열에 저장 된 값을 이용하여 중복 계산을 방지하여 효율을 높인다. 
		if(n <= 2) return fibo[n] = 1; 
		else {
			return fibo[n] = solution(n-1) + solution(n-2); 
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		fibo = new int[n+1];
		solution(n);
		
		for(int fiboNum : fibo) {
			System.out.print(fiboNum + " ");
		}
	}
}
