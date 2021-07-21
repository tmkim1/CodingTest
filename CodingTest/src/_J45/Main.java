package _J45;

import java.util.Scanner;

/**
 * 45. 버블 정렬 
 * N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
 * 정렬하는 방법은 버블정렬입니다.
 * 
 * [입력] 
 * 11
   13 5 11 7 23 15 21 1 5 8 2 1

 * [출력] 
 * 5 7 11 13 15 23
 * 
 * 
 * 참고: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	public static int[] solution(int n, int[] arr) {
		int temp = 0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		return arr; 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int num : solution(n, arr)) {
			System.out.print(num + " ");
		}
	}
}
