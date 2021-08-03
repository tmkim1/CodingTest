package _J70;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 70. 동전 교환
 * 
 * 
 * [입력] 
 * 3
   1 2 5
   15

 * [출력] 
 * 3
 * 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	
	public static Integer[] ck;
	public static int cash;
	public static int answer = 99999999;
	
	//가장 큰 숫자로 먼저 나누어 주어야 함.
	//배열을 내림 차순 정렬하여 % 계산 진행 
	public static int solution(int n) {
		int answer = 0;
		
		for(int k : ck) {
			if(cash > 0) {
				answer += cash / k; 
				cash %= k;
			}
		}
		 
		return answer;
	}
	
	
	//L = 동전 갯수로 생각 
	public static void DFS(int L, int sum) {
		
		if(sum > cash) return;
		if(L >= answer) return; // <-* 고려하지 못 했음, 걸려줘야 하는 부분들 꼭 체크해야함 
		if(sum == cash) {
			answer = Math.min(answer, L);
		} else {
			for(int i=0; i<ck.length; i++) {
				DFS(L+1,sum+ck[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //동전 갯수 
		ck = new Integer[n]; //동전 종류
		
		for(int i=0; i<n; i++) {
			ck[i] = sc.nextInt();
		}
		
		cash = sc.nextInt(); //거스름 돈 

		Arrays.sort(ck, Collections.reverseOrder());
		
		//System.out.println(solution(n));
		DFS(0,0);
		System.out.println("DFS: "+ answer);
	}
}
