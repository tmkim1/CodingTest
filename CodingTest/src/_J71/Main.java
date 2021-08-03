package _J71;

import java.util.Scanner;

/**
 * 71. 순열 (중복 불가) 
 * 10이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합 니다.
 * 
 * [입력] 
 *  3 2
	3 6 9 

 * [출력] 
 *  36
	39
	63
	69 
	93 
	96
 * 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	public static int[] arr;
	public static int[] pm;
	
	//중복 순열과 차이 -> 0번 레벨에서 지정 된 값이 다음 레벨에서 지정되면 안 된다. 
	//그 외 같음 
	public static void DFS(int L) {
		
		if(L == pm.length) { // 열의 크기가 레벨의 기준 
			for(int num : pm) System.out.print(num + " ");
			System.out.println();
		} else {
			for(int i=0; i<arr.length; i++) {
				if(pm[0] != arr[i]) {
					pm[L] = arr[i];
					DFS(L+1);
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //표현 할 숫자 갯수 
		int m = sc.nextInt(); //배열 크기 
		
		arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		pm = new int[m];
		
		DFS(0);
		
	}
}
