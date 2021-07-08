package _J20;

import java.util.Scanner;

/**
 * 20. 등수 구하기    
 * 
 * 문제 설명:N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
 * 같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
 * 즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.
 * 
 * [입력] 
 * 5
   87 89 92 100 76
 * [출력]
 * 4 3 2 1 5
 * 출처: 인프런 자바 알고리즘 문제풀이
 * @author kimtaemin
 */

public class Main {
	
	//내 풀이, 답안하고 같음 
	public static void solution(int[] arr) {
		int[] rankArr = new int[arr.length];
		//점수가 중복되는 경우가 문제
		int rank=1;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(arr[i] < arr[j]) {			// 동일 점수: 높은 등수로 동일 처리에 따라서 검사하는 숫자보다 작은 경우만 rank를 1씩 더해주면 됨.  
					rank++;
				} 
			}
			rankArr[i] = rank;
			rank = 1;
		}
		for(int r : rankArr) {
			System.out.print(r + " ");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		solution(arr);
	}
}
