package _J68;

import java.util.Scanner;

/**
 * 60. 최대 점수 구하기
 * 
 * 이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
 * 
 * 각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
 * 
 * 제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
 * 
 * (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)
 * 
 * 
 * [입력] 
 * 문제/점수, 시간  
 *  5 		20
	10 		5
	25 		12
	15 		8
	6 		3
	7 		4

 * [출력] 
 * 
 * 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	public static int m;
	public static int maxTime;
	public static int[] time; 
	public static int[] score;
	public static int maxSum;
	
	//시간 확인, 점수 확인 
	public static void DFS(int L, int totalSum, int totalTime) {
		if(totalTime > maxTime) return;
		
		if(L == m) {
			maxSum = Math.max(totalSum, maxSum);
		} else {
			DFS(L+1,totalSum+score[L],totalTime + time[L]);
			DFS(L+1,totalSum,totalTime);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		maxTime = sc.nextInt();
		
		//시간과 점수를 모두 고려 
		time = new int[m];
		score = new int[m];
		
		for(int i=0; i<m; i++) {
			score[i] = sc.nextInt();
			time[i] = sc.nextInt();
		}
		
		DFS(0,0,0);
		System.out.println(maxSum);
		
	}
}
