package _J21;

import java.util.Scanner;

/**
 * 21. 격자 판 합 구하기    
 * 
 * 문제 설명: N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
 * 
 * [입력] 
 *  5
	10 13 10 12 15
	12 39 30 23 11
	11 25 50 53 15
	19 27 29 37 27
	19 13 30 13 19
 * [출력]
 * 155
 * 출처: 인프런 자바 알고리즘 문제풀이
 * @author kimtaemin
 */

public class Main {

	//내 풀이 
	public static void solution(int n, int[][] arr) {
		//가로, 세로, 대각선 
		int maxSum = 0;
		int tempSum = 0, tempSum2 = 0;
		int DiagSum = 0;
		int DiagSum2 = 0; 
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				tempSum += arr[i][j];	// 가로 합  
				tempSum2 += arr[j][i];
				if(i == j) {
					DiagSum += arr[i][j];	// 대각 1
				} 
			}
			
			if(tempSum > maxSum && tempSum > tempSum2) maxSum = tempSum;
				
			else if(tempSum2 > maxSum && tempSum2 > maxSum) maxSum = tempSum2;
			
			tempSum = tempSum2 = 0;
			
			// 반대 대각선은 n-i의 성질을 가짐 0 4, 1 3 , 2 2 , 3 1 , 4 0
			DiagSum2 += arr[i][(n-1)-i];
		}
		
		// 대각선 합 비교 
		if(DiagSum < DiagSum2) DiagSum = DiagSum2;
		
		// 최종 maxSum 결정  
		if(DiagSum > maxSum) maxSum = DiagSum;
		System.out.println(maxSum);
	}
	
	//강의 답안 
	public static void solution2(int n, int[][] arr) {
		//가로, 세로, 대각선 
		int answer = 0;
		int sum1 = 0, sum2=0;
		
		for(int i=0; i<n; i++) {
			sum1=sum2=0;
			for(int j=0; j<n; j++) {
				sum1 += arr[i][j];	// 가로 합  
				sum2 += arr[j][i]; // 세로 합 
			}
			answer = Math.max(answer, sum1); //if문 대신 Math.max 사용 
			answer = Math.max(answer, sum2);
		}
		//대각선 합
		sum1=sum2=0;
		for(int i=0; i<n; i++) {
			sum1 += arr[i][i];
			sum2 += arr[i][n-i-1];
		}
		
		answer = Math.max(answer, sum1); 
		answer = Math.max(answer, sum2);
		
		System.out.println(answer);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//격자 값 2차원 배열에 셋팅 
		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		solution(n,arr);
		solution2(n,arr);
	}

}
