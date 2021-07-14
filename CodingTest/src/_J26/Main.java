package _J26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 26. 공통 원소 구하기 
 * 
 * 문제 설명: A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
 * 
 * [입력] 
 *  5
	1 3 9 5 2
	5
	3 2 5 7 8
 * [출력] 
 *  2 3 5
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * @author kimtaemin
 */

public class Main {

	//내 풀이, 답안과 코드 동일 함 
	public static void solution(int n, int[] arr, int m, int[] arr2) {
		// 2개의 배열이 들어오면 -> 정렬하고, 2pointer 사용해서 값이 같으면 ArrayList에 추가
		int lp = 0, op = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//12359
		//23578
		Arrays.sort(arr);
		Arrays.sort(arr2);
		
		// 작으면 인덱스 증가, 같으면 추가, 반복은 1개의 배열이 끝까지 다 돌때까지 
		while(lp<arr.length && op<arr2.length) {
			if(arr[lp] == arr2[op]) {	//같으면 리스트에 추가하고, 두 배열 모두 인덱스 증가 
				list.add(arr[lp]);
				lp++;
				op++;
			} else if(arr[lp] < arr2[op]) lp++;
			else op++;
		}
		
		for(int num : list) {
			System.out.print(num + " ");
		}
		
	}
 	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,m;
		
		n = sc.nextInt();
		int[] intArr = new int[n];
		for(int i=0; i<intArr.length; i++) {
			intArr[i] = sc.nextInt();
		}
		
		m = sc.nextInt();
		int[] intArr2 = new int[n];
		for(int i=0; i<intArr2.length; i++) {
			intArr2[i] = sc.nextInt();
		}
		
		solution(n,intArr,m,intArr2);
	}
	
	
}

