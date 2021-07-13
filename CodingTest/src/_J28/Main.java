package _J28;

import java.util.Scanner;

/**
 * 28. 연속 부분수열
 * 
 * 문제 설명: N개의 수로 이루어진 수열이 주어집니다.
 * 이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
 * 만약 N=8, M=6이고 수열이 다음과 같다면
 * 1 2 1 3 1 1 1 2
 * 합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.
 * 
 * [입력] 
 *  9 6
    1 2 1 3 1 1 1 2 1
 * [출력] 
 *  3
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * @author kimtaemin
 */
public class Main {
	// 내 풀이 
	public static void solution(int n, int m, int[] arr) {
		//sling window 활용 
		//1. 기준과 같으면 cnt ++ 하고 좌측 1 자른다.
		//2. 기준 보다 작으면 우측 1을 더한다. 
		//3. 기준 보다 커지면 가장 좌측 1 자른다.
		int answer = 0;
		int tempSum = 0;
		int lt=0;
		int rt=0;
		
		while(rt <= n) {
			if(tempSum == m) {
				answer++;	
				tempSum -= arr[lt++];
				if(rt == n) {
					break;
				}
			}
			else if(tempSum < m ) tempSum += arr[rt++]; 
			else tempSum -= arr[lt++];
		}
		System.out.println(answer);
	}
	
	//강의 답
	public static void solution2(int n, int m, int[] arr) {
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
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=0;
		int m=0; 
		n = sc.nextInt();
		m = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		solution2(n,m,arr);
	}
	
}
