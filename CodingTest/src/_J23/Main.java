package _J23;

import java.util.Scanner;

/**
 * 23. 임시 반장 정하기     
 * 
 * 문제 설명: 다른 학생과 같은 반이 된 횟수가 가장 많은 학생을 임시 반장으로 선정 
 * 중복으로 반이 같이 된 경우는 1번만 카운트 
 * 
 * [입력] 행: 학생 번호, 열: 학년, 아래 입력 예) 1번 학생: 1학년 2반, 2학년 3반, 3학년 1반, 4학년 7반, 5학년 3
 *  5
	2 3 1 7 3  
	4 1 9 6 8  
	5 5 2 4 4
	6 5 2 6 7
	8 4 2 2 2
	
 * [출력]
 * 4
 * 출처: 인프런 자바 알고리즘 문제풀이
 * @author kimtaemin
 */

public class Main {
	public static void solution(int n, int[][] arr) {
		int leader = 0;
		int maxCnt = 0;
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<5; k++) {
					if(arr[i][k] == arr[j][k]) {
						cnt ++;
						break; // 중복으로 반이 같이 된 경우는 1번만 카운트 하기 때문에 break;
					}
				}
			}
			if(cnt > maxCnt) {
				maxCnt = cnt;
				leader = i+1;
			}
			cnt = 0;
		}
		System.out.println(leader);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt(); 
	    int [][] arr = new int[n][5];
	    for(int i=0; i<n; i++) {
	    	for(int j=0; j<5; j++) {
	    		arr[i][j] = sc.nextInt();
	    	}
	    }
	    solution(n, arr);
	}
}
