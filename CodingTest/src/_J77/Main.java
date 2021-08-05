package _J77;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 77. 토마토  
 * 현수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다.
 * 토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다.
 * 창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면,
 * 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
 * 하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며,
 * 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 현수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
 * 토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,
 * 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
 * 
 * [입력] 
 *  6 4
	0 0 -1 0 0 0
	0 0 1 0 -1 0
	0 0 -1 0 0 0
	0 0 0 0 -1 1

 * [출력] 
 * 4
 * 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

/*
 * BFS를 이용하여 토마토가 익는데 까지 걸리는 일 수를 계산한다. 
 * 
 * 레벨 탐색을 통하여 주변 상,하,좌,우에 대한 토마토를 익은 토마토로 변경한 후, 날짜(레벨)를 증가시킨다.  
 * 
 * 1. 0Level에 해당하는 좌표를 Q에 모두 저장 ==> 다음 레벨에 해당하는 좌표를 점차적으로 체크 
 * 
 * 6 4
	0 0 -1 0 0 0
	0 0 1 0 -1 0
	0 0 -1 0 0 0
	0 0 0 0 -1 1
 */

class Pointer {
	int x;
	int y;
	
	public Pointer(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Main {
	
	public static int n, m;
	public static int[][] arr;
	public static int[][] days;
	public static int[][] ch;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	public static Queue<Pointer> Q = new LinkedList<>();
	
	public static void BFS() {
		while(!Q.isEmpty()) {
			Pointer tmp = Q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				
				//검사 할 토마토 지정: 범위 안에 존재하며, 빈 토마토가 아니고, 검사를 하지 않은 토마토인 경우 진입 
				if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] != -1 && ch[nx][ny] == 0) {
					ch[nx][ny] = 1; //체크 true
					days[nx][ny] = days[tmp.x][tmp.y] +1; // 익는데 걸리는 날짜 지정 (뻗은 날짜로 부터 +1일) 
					Q.add(new Pointer(nx, ny)); //현재 위치 Q에 추가 
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt(); //열 
		n = sc.nextInt(); //행 
		arr = new int[n][m];
		days = new int[n][m];
		ch = new int[n][m];
		int cnt = 0;
		int answer = 0;
		boolean chkAvail = true;
		
		//토마토 셋팅 
		for(int i=0; i<n; i++) { // 행 
			for(int j=0; j<m; j++) { // 열  
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 1) {
					Q.add(new Pointer(i,j)); // 익은 토마토인 경우 Q에 저장 
					ch[i][j] = 1; //체크 true  
					cnt ++;
				} else if(arr[i][j] == -1) {
					ch[i][j] = 1; //빈 공간 또한 체크가 된걸로 지정 
				}
			}
		}
		
		if(cnt == m*n) System.out.println(0); //애초에 모두 익어있는 상태라면 0 출력 
		
		//BFS 시작 
		BFS();
		
		// 체크 되지 않은 토마토가 있는 경우 
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(ch[i][j] != 1) chkAvail = false;
			}
		}
				
		//익는데 가장 오래 걸리는 토마토 탐색 
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				answer = Math.max(answer, days[i][j]); 
			}
		}
		
		if(!chkAvail) { //모든 토마토가 익을수 없다면 -1 출력 
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}
}
