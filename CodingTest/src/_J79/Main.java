	package _J79;
	
	import java.util.Scanner;
	
	/**
	 * 78. 섬나라 아일랜드  
	 * 
	 * N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.
	 * 
	 * 각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.
	 * 
	 * 섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.
	 * 
	 * [입력] 
	 *  7
		1 1 0 0 0 1 0
		0 1 1 0 1 1 0
		0 1 0 0 0 0 0
		0 0 0 1 0 1 1
		1 1 0 1 1 0 0
		1 0 0 0 1 0 0
		1 0 1 0 1 0 0
	
	 * [출력] 
	 * 5
	 * 
	 * 
	 * 출처: 인프런 자바 알고리즘 문제풀이
	 * 
	 * @author kimtaemin
	 */
	
	// 미로 탐색 문제를 활용하면 될듯 
	
	class Pointer {
		int x;
		int y;
		
		public Pointer(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public class Main {
		
		//상하좌우, 대각선 부분 총 8군데 이동 좌표
		public static int answer = 0, n;
		public static int[][] arr;
		public static int[] dx = {-1, -1, -1, 0, 1, 1, 0,  1};
		public static int[] dy = {-1,  0,  1, 1, 1, 0, -1, -1};
		
		public static void DFS(int x, int y) {
			
			for(int i=0; i<8; i++) { // 상하좌우 대각 순회 
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == 1) {
					arr[nx][ny] = 0; // 육지 체크 
					DFS(nx, ny); //다음 레벨 DFS 호출 
				}
			}
		}
		
		public static void solution() {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(arr[i][j] == 1) { // 섬 발견 
						answer++; 
						arr[i][j] = 0; // 체크 진행 
						DFS(i, j);
					}
				}
			}
		}
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			arr = new int[n][n];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			solution();
			System.out.println(answer);
		}
	}
