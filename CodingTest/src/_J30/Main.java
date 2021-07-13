package _J30;

import java.util.Scanner;

/**
 * 30. 최대 길이 연속부분수열 
 * 
 * 문제 설명: 0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 
 * 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
 * 만약 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
 * 1 1 0 0 1 1 0 1 1 0 1 1 1 0 1
 * 여러분이 만들 수 있는 1이 연속된 연속부분수열은
 * 1 1 0 0 1 1 0 1 1 1 1 1 1 1 1
 * 이며 그 길이는 8입니다.

 * [입력] 
 *  14 2
	1 1 0 0 1 1 0 1 1 0 1 1 0 1
 * [출력] 
 *  8
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * @author kimtaemin
 */

public class Main {

	public static void solution(int n, int k, int[] arr) {
		//최대 연속 길이를 저장할 변수가 필요. 
		int answer = 0, // 최대 길이 
			cnt = 0,    // 0을 1로 바꾼 횟수 상태 값 // 0 ~ k 
			lt = 0;     // two pointer
		for(int rt = 0; rt < n; rt++) {
			if(arr[rt] == 0) cnt ++; 
			while(cnt > k) {
				if(arr[lt] == 0) cnt --; // k번을 초과한 경우 lt쪽에 변경 된 1을 다시 0으로 초기화 
				lt++;
			}
			answer = Math.max(answer, rt-lt+1);
		}
		System.out.println(answer);
		
	}
	
	public static void main(String[] args) {
		int n=0, k=0;
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		solution(n, k, arr);
	}
}
