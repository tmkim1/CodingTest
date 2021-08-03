package _J76;

import java.util.Scanner;

/**
 * 76. 미로의 최단거리 탈출 경로 구하기  
 * 
 * 7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램을 작성하세요.
 * 
 * 경로의 길이는 출발점에서 도착점까지 가는데 이동한 횟수를 의미한다.
 * 
 * 출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 도로이다.
 * 
 * 격자판의 움직임은 상하좌우로만 움직인다.
 * 
 * 이동횟수가 가장 적은 경로를 구하라. 
 * 
 * [입력] 
 * 0 0 0 0 0 0 0
   0 1 1 1 1 1 0
   0 0 0 1 0 0 0
   1 1 0 1 0 1 1
   1 1 0 1 0 0 0
   1 0 0 0 1 0 0
   1 0 1 0 0 0 0

 * [출력] 
 * 12 
 * 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	public static int[][] arr = new int[8][8];
	
	public static int[] dx = {-1, 0 , 1, 0};
	public static int[] dy = {0, 1 , 0, -1};
	
	public static int answer = Integer.MAX_VALUE;
	
	
	public static void DFS(int x, int y, int distance) {
		if(x == 7 && y == 7) {
			answer = Math.min(answer, distance+1);
		} else {
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i]; // 이동 경로 4군데 확인 
				if(nx >= 1 && nx <= 7 && ny >=1 && ny <=7 && arr[nx][ny] == 0) { //해당 조건인 경우만 이동 가능 
					arr[nx][ny] = 1;
					DFS(nx, ny, distance+1);
					arr[nx][ny] = 0; 
					distance--;
				}
			}
		}

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//격자 셋팅 
		for(int i=1; i<=7; i++) {
			for(int j=1; j<=7; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		//출발점 지정, DFS 실행 
		arr[1][1] = 1;
		DFS(1, 1, 1);
		System.out.println(answer);
	}
}
