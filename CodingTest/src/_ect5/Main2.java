package _ect5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 문제: 음료수 얼려 먹기
 *
 * 얼음 갯수 판별, 상하좌우 연결된 얼음은 이어져서 1개의 얼음이 됨. 
 * 
 * [입력] 
 *  7
	1 1 0 0 0 1 0
	0 1 1 0 1 1 0
	0 1 0 0 0 0 0
	0 0 0 1 0 1 1
	1 1 0 1 1 0 0
	1 0 0 0 1 0 0
	1 0 0 0 1 0 0

 * [출력] 
 * 5
 * 
 * 출처: 이것이 코딩 테스트다 
 * 
 * @author kimtaemin
 */

/*
 * 섬나라 아일랜드 문제랑 똑같음. 
 * 
 * 섬 찾기, 얼음 찾기 등등 상하좌우를 탐색하여 덩어리 갯수를 찾는 문제 
 * 
 * 1. BFS 시작점을 찾는다 --> 얼음(1) 탐색 
 * 
 * 2. 얼음 시작점을 찾았다면 상하좌우로  너비 탐색을 수행 --> 방문한 얼음은 0으로 만들어 주어야 1번을 수행할떄 반복 확인이 되지 않음.
 * 
 * 3. BFS 수행 시 범위내에 존재하는지 확인, 얼음이 맞는지 확인
 * 
 * 4. 얼음이 맞다면 0으로 초기화 후 상하좌우 확인 (깊이 탐색 )  
 * 
 * DFS와 가장 큰 차이는 Stack 구조와 Queue 구조의 차이 
 * 
 * BFS는 Queue를 이용하여 레벨 탐색을 진행 
 * 
 */

class Pointer {
	int x;
	int y;
	public Pointer(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main2 {
	
	public static int n;       //얼음판 크기 
	public static int[][] arr; //얼음판
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
	
	public static void bfs(int x, int y) {
		Queue<Pointer> Q = new LinkedList<>();
		Q.offer(new Pointer(x, y));
		
		while(!Q.isEmpty()) {
			Pointer temp = Q.poll();
			
			//상하좌우 확인 
			for(int i=0; i<dx.length; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				
				if(nx >=0 && nx < n && ny >= 0 && ny <n && arr[nx][ny] == 1) {
					arr[nx][ny] = 0;
					Q.offer(new Pointer(nx, ny));
				}
			}
		}
		
	}

	public static int solution() {
		int answer = 0;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				//얼음 시작점을 만나면 answer (갯수 1 증가) 
				if(arr[i][j] == 1) {
					answer ++;
					arr[i][j] = 0; 
					bfs(i, j);
				}
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		arr = new int[n][n];

		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(solution());
	}
	
}

