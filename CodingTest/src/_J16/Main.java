package _J16;

import java.util.Scanner;

/**
 * 16. 피보나치 수열 구하기 
 * 
 * 문제 설명: 큰 수 출력하기 
 * 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보
 * 
 * [입력] 
 * 10
 * [출력]
 * 1 1 2 3 5 8 13 21 34 55
 * 출처: 인프런 자바 알고리즘 문제풀이 
 * @author kimtaemin
 */

public class Main {
	
	// 내 풀이 
	public static void solution(int n) {
		int[] intArr = new int[n];
		
		for(int i=0; i<n; i++) {
			if(i<2) intArr[i] = 1;
			else intArr[i] = intArr[i-1] + intArr[i-2];
		}
		
		for(int j=0; j<intArr.length; j++) {
			System.out.print(intArr[j]+" ");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		solution(n);
	}
}
