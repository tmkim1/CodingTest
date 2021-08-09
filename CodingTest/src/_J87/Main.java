package _J87;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 87. 원더랜드 (최소 스패닝 트리 : 크루스칼 Union & find 활용) 
 * 
 * 원더랜드에 문제가 생겼다. 원더랜드의 각 도로를 유지보수하는 재정이 바닥난 것이다.
 * 
 * 원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지 도로는 폐쇄하려고 한다.
 * 
 * 
 * 
 * [입력] 
 *  9 12
	1 2 12
	1 9 25
	2 3 10
	2 8 17
	2 9 8
	3 4 18
	3 7 55
	4 5 44
	5 6 60
	5 7 38
	7 8 35
	8 9 15

 * [출력] 
 * 196
 * 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */
class Edge implements Comparable<Edge>{
	public int v1;
	public int v2;
	public int cost;
	
	Edge(int v1, int v2, int cost ) {
		this.v1 = v1;
		this.v2 = v2;
		this.cost = cost;
	}
	
	@Override 
	public int compareTo(Edge ob) {
		return this.cost - ob.cost;
	}
	
}
public class Main {
	static int[] unf;
	public static int Find(int v) {
		if(v == unf[v]) return v;
		else return unf[v] = Find(unf[v]);
	}
	
	public static void Union(int a, int b) {
		int fa = Find(a);
		int fb = Find(b);
		if(fa != fb) unf[fa] = fb;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		unf = new int[n+1];
		ArrayList<Edge> el = new ArrayList<>();
		for(int i=1; i<=n; i++) unf[i] = i;
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			el.add(new Edge(a, b, c));
		}
		
		int answer = 0;
		Collections.sort(el);
		for(Edge ob : el) {
			int fv1 = Find(ob.v1);
			int fv2 = Find(ob.v2);
			if(fv1 != fv2) {
				answer += ob.cost;
				Union(ob.v1, ob.v2);
			}
		}
		
		System.out.println(answer);
	}
}
