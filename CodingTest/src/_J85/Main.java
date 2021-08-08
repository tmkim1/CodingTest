package _J85;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 85. 다익스트라 알고리즘  
 * 가중치 방향그래프에서 1번 정점에서 모든 정점으로의 최소 거리비용을 출력하는 프로 그램을 작성하세요. (경로가 없으면 Impossible를 출력한다)
 * 
 * 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연 결정보와 거리비용이 주어진다.
 * 
 * [입력] 
 * 

 * [출력]
 * 정점, 간선 [Line 20: 1번 정점에서 2번정점으로 가는데 12의 비용이 든다.] 
 * 6 9
   1 2 12 
   1 3 4 
   2 1 2 
   2 3 5 
   2 5 5 
   3 4 5 
   4 2 2 
   4 5 5 
   6 4 5
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */
class Edge implements Comparable<Edge>{
	public int vex;
	public int cost;
	
	public Edge(int vex, int cost) {
		this.vex = vex;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Edge eg) {
		return this.cost - eg.cost; //cost가 낮은 값을 먼저 poll()
	}
}
public class Main {
	static int n, m;
	static ArrayList<ArrayList<Edge>> graph;
	static int[] dis;
	
	public static void solution(int v) {
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		pQ.add(new Edge(v, 0));
		dis[v] = 0;
		while(!pQ.isEmpty()) {
			Edge tmp = pQ.poll();
			int now = tmp.vex;
			int nowCost = tmp.cost;
			if(nowCost > dis[now]) continue; // dis에 저장 되어 있는 최소비용 보다 큰 경우 검사할 필요가 없기 때문에 무시 
			for(Edge ob : graph.get(now)) {
				if(dis[ob.vex] > nowCost + ob.cost) { //더 적은 비용의 경로가 존재하는 경우 변경 
					dis[ob.vex] = nowCost + ob.cost;
					pQ.add(new Edge(ob.vex, nowCost+ob.cost));
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		graph = new ArrayList<ArrayList<Edge>>();
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Edge>());
		}
		dis = new int[n+1];
		Arrays.fill(dis, Integer.MAX_VALUE); // 정점 도달 최소비용에 대한 cost를 MAX_VALUE로 초기 설정
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			graph.get(a).add(new Edge(b, c)); // 각 정점마다 연결 되어있는 간선과 정점 간 cost 정보 셋팅 
		}
		
		solution(1); //1을 시작 지점으로 설정 (cost = 0)
		for(int i=2; i<=n; i++) {
			if(dis[i]!=Integer.MAX_VALUE) System.out.println(i+ ": " + dis[i]);
			else System.out.println(i+ ": impossible");
		}
	}
}
