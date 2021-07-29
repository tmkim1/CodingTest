package _J65;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 65. 그래프 최단거리 (BFS)
 * 
 * 1번 정점에서 각 정점으로 가는 최소 이동 간선 수 구하기 
 * 
 * [입력] 
 * 6 9 
   1 3
   1 4
   2 1 
   2 5
   3 4
   4 5
   4 6
   6 2 
   6 5 

 * [출력] 
 * 
 * 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	static int n, m;
	static int[] ch;
	static int[] dis;
	static ArrayList<ArrayList<Integer>> graph;
	
	
	public static void BFS(int v) {
		Queue<Integer> Q = new LinkedList<>();
		ch[v] = 1; //체크 배열 
		dis[v] = 0; //거리 배열, 시작은 1번 정점 => 0으로 셋팅 
		Q.add(v);
		while(!Q.isEmpty()) {
			int cv = Q.poll(); //Q에 있는 값을 빼 오고 검사 정점으로 채택 => 갈 수 있는 정점을 확인 후, 거리를 셋팅한다.  
			for(int nv : graph.get(cv)) { //ArrayList에 저장한 갈 수 있는 정점 확인 
				if(ch[nv] == 0) { //아직 체크 안 된 정점이라면 셋팅 
					ch[nv] = 1;   //체크 
					Q.add(nv);    //다음 검사 정점으로 삼기 위해 Q에 추가 
					dis[nv] = dis[cv] + 1; // cv 정점에서 연결된 정점이기 때문에 거리 1을 증가. 
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); //정점 갯수 
		m = sc.nextInt(); //간선 갯수 
		
		//정점 갯수 만큼 ArrayList<Integer> 생성 후, 추가 
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		ch = new int[n+1];
		dis = new int[n+1];
		
		
		//간선 셋팅 
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b);
		}
		
		BFS(1);
		for(int i=2; i<=n; i++) {
			System.out.println(i + ": " + dis[i]);
		}
		
	}
}
