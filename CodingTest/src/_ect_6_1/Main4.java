package _ect_6_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 금광 
 * 
 * 출처: 이것이 코딩 테스트다 (저자: 나동빈)
 * 
 * [입력]
 * 3 4 
   1 3 3 2 2 1 4 1 0 6 4 7 
   
 * [출력]
 * 19
 * 
 * @author kimtaemin
 *
 */

public class Main4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		//금광 셋팅 
		int[][] arr = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
		/*
		 * 1. 첫 행 어느 위치에서나 출발이 가능하다.
		 * 2. 이동은 현재 위치에서 오른쪽과, 오른쪽 대각 {[-1,1], [0,1], [1,1]} 
		 * 3. 출발지로부터 이동 가능한 경로로 이동하며 취득한 금광을 가장 큰 값으로 셋팅 해주도록 한다. 
		 *  - 2차원 배열은 clone을 사용해도 깊은 복사가 되지 않음.  (int[][] d = arr.clone();)
		 * --| 교재 답안과 차이점: 나는 현재 위치에서 갈 수 있는 경우의 수를 찾아 셋팅, 교재는 현재 위치를 어느 지점에서 왔는지로 셋팅 (복잡도는 똑같음)
		 */
		
		int[][] d = new int [n][m];
		for(int i=0; i<n; i++) {
			d[i][0] = arr[i][0];
		}
		
		int[] dx = {-1, 0, 1};
		int[] dy = {1, 1, 1};
		int maxScore = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				for(int k=0; k<3; k++) {
					//이동 가능한 범위인지 확인 
					if(i + dx[k] >= 0 && i + dx[k] < n && j + dy[k] >= 0 && j + dy[k] < m) {
						//dp 값 갱신 
						int newScore = d[i][j] + arr[i+dx[k]][j+dy[k]];
						d[i+dx[k]][j+dy[k]] = Math.max(d[i+dx[k]][j+dy[k]], newScore);
						System.out.println(i+","+j+"->"+"x:"+(i+dx[k])+", y:"+(j+dy[k])+", newscore:"+newScore);
						maxScore = d[i+dx[k]][j+dy[k]];
					}
				}
			}
		}
		System.out.println(maxScore);
	}
}
