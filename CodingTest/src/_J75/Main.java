package _J75;

import java.util.Scanner;

/**
 * 75. 미로 탐색 (DFS)  
 * 
 * 7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.
 * 
 * 출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다.
 *
 * 격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
 * 
 * 위의 지도에서 출발점에서 도착점까지 갈 수 있는 방법의 수는 8가지이다.
 * 
 * [입력] 
 * 0 0 0 0 0 0 0
   0 1 1 1 1 1 0
   0 0 0 1 0 0 0
   1 1 0 1 0 1 1
   1 1 0 0 0 0 1
   1 1 0 1 1 0 0
   1 0 0 0 0 0 0

 * [출력] 
 * 8
 * 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

/*
 *방문 했던 곳을 재방문 X ch[][] 필요 
 *
 * 상하좌우를 담을 배열 필요 int[] dx, dy  <= x, y 에 적용 
 *         
 * 얘도 어쨋든 dfs 가지수 고려하면서 뻗어나가는 완전 탐색 알고리즘이 필요 
 * 
 * 격자는 7,7 고정 
 *
 */
public class Main {
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	
	public static int arr[][] = new int[8][8];
	public static int ch[][] = new int[8][8];
	public static int b[] = new int[2];
	public static int answer = 0;
	
	public static void dfs(int x, int y) {
		//7,7 좌표에 도착하면 탈출, 갈 곳이 없는 경우 return  
		if(x==7 && y==7) answer++;
		
		else {
			for(int i=0; i<4; i++) { // 상, 우, 하, 좌 이동 순회 확인  
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx >=1 && nx <=7 && ny >=1 && ny <=7 && arr[nx][ny] == 0) {
					arr[nx][ny] = 1;
					dfs(nx, ny);
					arr[nx][ny] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//격자 셋팅 
		for(int i=1; i<8; i++) {
			for(int j=1; j<8; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		arr[1][1] = 1;
		dfs(1,1);
		System.out.println(answer);
	}
}
