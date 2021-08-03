package _J72;

import java.util.Scanner;

/**
 * 72. 조합 경우의 수 구하기 (메모이제이션) 
 * nCr 조합 경우의 수 구하기 
 * 
 * [입력] 
 * 5 3 

 * [출력] 
 * 10 
 * 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	public static int[][] arr;
	
	//nCr = (n-1Cr-1) + (n-1Cr) 해당 공식을 이용하여 재귀를 사용한다. 
	public static int DFS(int n, int r) {
		if(n == r || r == 0) return 1; // 3C3과 같이 n과r이 같은 경우, 3C0 과 같이 r이 0인 경우는 1을 반환 
		else {
			if(arr[n][r] != 0) return arr[n][r]; //메모이제이션: 이미 구한 값은 배열에서 얻어와 리턴하여 시간 복잡도를 줄인다. 
			return arr[n][r] = DFS(n-1,r-1) + DFS(n-1, r); //공식을 사용하여 DFS 재귀 호출 실행 
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		
		arr = new int [n+1][r+1];
		
		System.out.println(DFS(n, r));
	}
}
