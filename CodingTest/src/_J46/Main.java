package _J46;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 46. 삽입 정렬 
 * N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
 * 정렬하는 방법은 삽입정렬입니다.
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
		for(int i=1; i<arr.length; i++) {
			int temp=arr[i];
			int prev=i-1;
			
			while((prev >= 0) && (arr[prev] > temp)) {
				arr[prev+1] = arr[prev];
				prev--;
			}
			arr[prev+1] = temp;
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
		
		//Integer -> long 변환 테스트 
//		Integer n = 563;
//		long num = 612;
//		Scanner sc = new Scanner(System.in);
//		ArrayList<Long> personIdList = new ArrayList<>();
//		
//		personIdList.add(Long.valueOf(n));
//		personIdList.add(num);
		
		
	}
}
