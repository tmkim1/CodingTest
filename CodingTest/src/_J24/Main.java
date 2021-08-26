package _J24;

import java.util.Scanner;

/**
 * 24. 멘토링 
 * 
 * 문제 설명: 현수네 반 선생님은 반 학생들의 수학 점수를 향상시키기 위해 멘토링 시스템을 만들려고 합니다.
 * 멘토링은 멘토(도와주는 학생)와 멘티(도움을 받는 학생)가 한 짝이 되어 멘토가 멘티의 수학공부를 도와주는 것입니다.
 * 선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.
 * 만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.
 * M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 출력하는 프로그램을 작성하세요.
 * 
 * [입력] 
 *  4 3
    3 4 1 2
    4 3 2 1
    3 1 4 2
 * [출력] 
 * 3
 * 출처: 인프런 자바 알고리즘 문제풀이
 * @author kimtaemin
 */


public class Main {
	
	public static int solution(int n, int m, int[][] arr) {
		int answer = 0;
		for(int i=1; i<=n; i++) {		        //멘토, 멘티 가능한 경우의 수 만큼 반복 //i: 멘토, j: 멘티 
			for(int j=1; j<=n; j++) {
				int cnt = 0;
				for(int k=0; k<m; k++) {		// 테스트 수 만큼 돌리기 
					int pi=0, pj=0;
					for(int s=0; s<n; s++) {    // 랭킹 수 만큼 돌린다.
						if(arr[k][s]==i) pi=s;	// 해당 테스트에서 0등~n등 한 사람이 누구인지 확인// 내가 고려하는 경우의 수의 학생이라면 등수를 저장  
						if(arr[k][s]==j) pj=s;  // 위와 마찬가지로 멘티의 등수를 저장. 
					}
					if(pi<pj) cnt++;			// 멘토의 랭킹이 더 작은 경우만 가능하기 때문에 해당 조건을 만족하면 ++ 
				}
				if(cnt == m) {
					answer ++;                  // 모든 테스트 수 만큼의 cnt 충족 되었다면 멘토/멘티 형성 가능 
				}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int studentNum = sc.nextInt();
		int testNum = sc.nextInt();
		
		int[][] scoreArr = new int[testNum][studentNum];
		
		for(int i=0; i<testNum; i++) {
			for(int j=0; j<studentNum; j++) {
				scoreArr[i][j] = sc.nextInt();
			}
		}
		System.out.println(solution(studentNum, testNum, scoreArr));
	}
}
