package _J61;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 61. 송아지 찾기 
 * 
 * 현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.
 * 
 * 현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
 * 
 * 송아지는 움직이지 않고 제자리에 있다.
 * 
 * 현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
 * 
 * 최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요
 * 
 * [입력] 
 * 5 14

 * [출력] 
 * 3
 * 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	static int answer = 0;
	static int[] dis = {1, -1, 5}; //현수가 움직일수 있는 3가지 이동거리 
	static int[] chk;              //중복 제거를 위한 체크 배열
	static Queue<Integer> Q = new LinkedList<>();
	
	public static int BFS(int s, int e) {
		chk = new int[10001];
		chk[s] = 1;  //출발 지점
		Q.add(s);
		int L = 0;
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i=0; i<len; i++) {
				int x = Q.poll();
				for(int n : dis) { //현재 노드에서 이동할 수 있는 모든 경우의 수를 추가 
					int xn = x + n;
					
					if(xn == e) return L+1;  //추가 하려는 노드가 송아지의 위치인 경우 반환 
					
					if(xn >= 1 && xn <= 10000 && chk[xn]==0) { //xn이 검사 범위 내에 존재하며 이미 확인 되지 않은 경우만 Q에 추가 
						chk[xn] = 1;
						Q.add(xn);
					}
				}
			}
			L++;
		}
		return L;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int e = sc.nextInt();
		System.out.println(BFS(s, e));
	}
}
