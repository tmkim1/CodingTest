package _ect_6_1;

import java.util.Scanner;

/**
 * 문제: 개미 전사 (DP) 
 * 
 * 출처: 이것이 코딩 테스트다.
 * 
 * [입력]
 * 4
   1 3 1 5
 * [출력]
 * 8
 * @author kimtaemin
 *
 */

public class Main {
	
	public static int[] d = new int[100];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		//식량 정보 입력 
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		//초깃값(0, 1) 셋팅 
		d[0] = arr[0];
		d[1] = Math.max(arr[0], arr[1]);
		
		//초깃값을 이용하여 최적의 해를 구함, dp 보텀업
		for(int i=2; i<n; i++) {
			d[i] = Math.max(d[i-1], d[i-2] + arr[i]);
		}
		
		System.out.println(d[n-1]);
	}

}
