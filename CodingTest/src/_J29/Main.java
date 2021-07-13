package _J29;

import java.util.Scanner;

/**
 * 29. 연속된 자연수의 합 
 * 
 * 문제 설명: N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
 * 만약 N=15이면
 * 7+8=15
 * 4+5+6=15
 * 1+2+3+4+5=15
 * 
 * [입력] 
 *  15
 * [출력] 
 *  3
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * @author kimtaemin
 */
public class Main {
	// 방법1: 자연수 값 범위를 받아서 배열에 담는거를 제외하고 이전 문제와 동일 함 
	public static void solution(int n, int m, int[] arr) {
		int answer = 0;
		int tempSum = 0;
		int lt=0;
		
		for(int rt=0; rt<n; rt++) {
			tempSum += arr[rt];
			if(tempSum == m) answer ++;
			while(tempSum>=m) {
				tempSum -= arr[lt++];
				if(tempSum == m) answer ++;
			}
		}
		System.out.println(answer);
	}
	
	// 방법2: 수학적인 방법으로 간단히 푸는 방법, 생각해 내기는 어렵고 이런게 있구나 이해
		public static void solution(int n) {
			int answer=0, cnt=1;				//ex) 15 -1 -2 = 12 % 2 = 0 // cnt = 연속된 수의 갯수 
			n--;								
			while(n > 0) {
				cnt++;
				n = n-cnt;
				if(n % cnt == 0) answer++;		//cnt로 나머지 0으로 떨어지는 경우 연속된 숫자의 합은 N 
				
			}
			System.out.println(answer);
		}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=0, size=0;
		n = sc.nextInt();
		size = n/2+1;
		int[] arr = new int[size];
		
		for(int i=0; i<size; i++) {
			arr[i] = i+1;
		}
		
		solution(size,n,arr);
		solution(n);
	}
	
}
