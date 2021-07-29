package _J64;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 64. 경로 탐색 (인접 리스트) 
 * 
 * 방향 그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하시오.
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
 * 6
 * 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	static int n, m;
	static int answer = 0;
	static ArrayList<ArrayList<Integer>> graph;
	static int ch[];
	
	public static void DFS(int v) {
		if(v == n) answer ++;
		else {
			for(int nv : graph.get(v)) {
				if(ch[nv] == 0) {
					ch[nv] = 1;
					DFS(nv);
					ch[nv] = 0;
				}
			}
		}
 	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		graph = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<=n; i++) {  //정수를 담는 ArrayList를 정점 갯수만큼 생성 
			graph.add(new ArrayList<Integer>());
		}
		ch = new int[n+1];
		
		for(int i=0; i<m; i++) {  //이동 가능한 정점 간의 간선 관계를 List에 추가한다. 
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b);
		}
		ch[1]=1;
		DFS(1);
		System.out.println(answer);
		
	}
}
