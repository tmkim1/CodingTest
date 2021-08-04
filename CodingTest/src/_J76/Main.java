package _J76;

import java.util.LinkedList;
import java.util.Queue;
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
class Point{
	public int x,y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static int[][] arr = new int[8][8];
	public static int[][] dis = new int[8][8];
	
	public static int[] dx = {-1, 0 , 1, 0};
	public static int[] dy = {0, 1 , 0, -1};
	
	public static int answer = Integer.MAX_VALUE;
	
	//레벨 별로 탐색 -> 레벨은 거리가 됨. 
	public static void BFS(int x, int y) {
		Queue<Point> Q = new LinkedList<>();
		Q.add(new Point(x, y)); //초기 포인트 추가 
		arr[x][y] = 1;
		
		while(!Q.isEmpty()) {
			Point tmp = Q.poll();
			
			//이동할 수 있는 방향 검사 
			for(int i=0; i<4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if(nx >=1 && nx <=7 && ny >=1 && ny <=7 && arr[nx][ny] == 0) { // 범위 내에 존재하며 아직 들른 곳이 아니라면 true 
					arr[nx][ny] = 1;
					Q.offer(new Point(nx, ny));
					dis[nx][ny] = dis[tmp.x][tmp.y] +1; //이동 거리 셋팅, tmp에서 1만큼 이동 
				}
			}
		}
	}
	
	public static void DFS(int x, int y, int distance) {
		if(x == 7 && y == 7) {
			answer = Math.min(answer, distance);
		} else {
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i]; // 이동 경로 4군데 확인 
				if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && arr[nx][ny] == 0) { //해당 조건인 경우만 이동 가능 
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
		//arr[1][1] = 1;
		//DFS(1, 1, 0);
		//System.out.println(answer);
		
		//BFS 실행 (1,1 부터 시작) 
		BFS(1, 1);
		if(dis[7][7] == 0) System.out.println(-1);
		else System.out.println(dis[7][7]);
	}
}
