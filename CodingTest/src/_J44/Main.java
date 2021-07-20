package _J44;

import java.util.Scanner;

/**
 * 44. 선택 정렬 
 * 
 * 
 * [입력] 
 * 6
   13 5 11 7 23 15

 * [출력] 
 * 5 7 11 13 15 23
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	public static int[] solution(int n, int[] arr) {
		int indexMain;
		int temp;
		for(int i=0; i<arr.length; i++) {
			indexMain = i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j] < arr[indexMain]) indexMain = j;
			}
			
			temp = arr[indexMain];
			arr[indexMain] = arr[i];
			arr[i] = temp;
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
