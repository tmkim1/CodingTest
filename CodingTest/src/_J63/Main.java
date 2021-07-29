package _J63;

import java.util.Scanner;

/**
 * 63. 
 * 
 * 
 * [입력] 
 * 5 9
   1 2
   1 3
   1 4
   2 1
   2 3
   2 5
   3 4
   4 2
   4 5 
 * [출력] 
 * 
 * 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	static int n, m, answer = 0;
	static int[][] graph;
	static int[] ch;
	
	public static void DFS(int v) {
		if(n == v) answer++;
		else {
			for(int i=1; i<=n; i++) { //각 정점 별 이동할 수 있는 정점의 경우의 수를 탐색 
				if(graph[v][i]==1 && ch[i] == 0) { // 해당 정점으로 갈 수 있는지와 방문한 적이 없는지를 확인. 
					ch[i] = 1;
					DFS(i);
					ch[i] = 0; // backtracking, 취소 
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();   //목표 정점
		m = sc.nextInt();	//간선 이동 수 
		graph = new int[n+1][n+1];
		ch=new int[n+1];  //방문 했는지 체크하는 배열 
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = 1;
		}
		ch[1] = 1; //시작 정점 
		DFS(1);
		System.out.println(answer);
		
		
	}
}
