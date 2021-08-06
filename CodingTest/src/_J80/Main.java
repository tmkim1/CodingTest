package _J80;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 80. 피자 배달 거리(삼성 SW역량평가 기출문제 : DFS활용)
 * 
 * N×N 크기의 도시지도가 있습니다. 도시지도는 1×1크기의 격자칸으로 이루어져 있습니다.
 * 
 * 각 격자칸에는 0은 빈칸, 1은 집, 2는 피자집으로 표현됩니다. 각 격자칸은 좌표(행번호, 열 번호)로 표현됩니다.
 * 
 * 행번호는 1번부터 N번까지이고, 열 번호도 1부터 N까지입니다.
 * 
 * 도시에는 각 집마다 “피자배달거리”가 았는데 각 집의 피자배달거리는 해당 집과 도시의 존재하는
 * 
 * 피자집들과의 거리 중 최소값을 해당 집의 “피자배달거리”라고 한다.
 * 
 * 집과 피자집의 피자배달거리는 |x1-x2|+|y1-y2| 이다.
 * 
 * 예를 들어, 도시의 지도가 아래와 같다면
 * 
 * 0 1 0 0 
 * 0 0 2 1 
 * 0 0 1 0
 * 1 2 0 2 
 * 
 * (1, 2)에 있는 집과 (2, 3)에 있는 피자집과의 피자 배달 거리는 |1-2| + |2-3| = 2가 된다.
 * 
 * 최근 도시가 불경기에 접어들어 우후죽순 생겼던 피자집들이 파산하고 있습니다.
 * 
 * 도시 시장은 도시에 있는 피자집 중 M개만 살리고 나머지는 보조금을 주고 폐업시키려고 합니다.
 * 
 * 시장은 살리고자 하는 피자집 M개를 선택하는 기준으로 도시의 피자배달거리가 최소가 되는 M개의 피자집을 선택하려고 합니다.
 * 
 * 도시의 피자 배달 거리는 각 집들의 피자 배달 거리를 합한 것을 말합니다.
 * 
 * 
 * [입력] 
 *  4 4
	0 1 2 0
	1 0 2 1
	0 2 1 2
	2 0 1 2

 * [출력] 
 *  6
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이 - 삼성 SW역량평가 기출문제
 * 
 * @author kimtaemin
 */
//좌표를 보유해야하기 때문에 Pointer Class 생성
class Pointer {
	int x;
	int y;
	
	public Pointer(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	public static ArrayList<Pointer> pl, hl; //피자집 리스트, 가정집 리스트 
	public static int[][] arr; //지도 배열 
	public static int[] combi; //조합 정리
	public static int n, m, len, answer = Integer.MAX_VALUE;
	 public static void solution() {
			
			
	 }
		
	//조합을 구하는 메서드는 자동적으로 나오도록 연습 
	public static void DFS(int L, int s) { //Level, start
		if(L == m) {
			// L개 피자집 중 m개를 뽑는 1개의 완성된 조합이 combi 배열에 들어 온다.
			// 이제 이걸 토대로 최소 거리 합을 구한다.
			// 각 집 별로 가장 가까운 피자집의 거리를 구한 후 Sum에 담는다. 
			
			int minDisSum = 0;
			
			for(int i=0; i < hl.size(); i++) {
				int minDis = Integer.MAX_VALUE;
				for(int j=0; j<combi.length; j++) {
					//거리 정보: |1-2| (가정집.x - 피자집.x) + |2-3| (가정집.y - 피자집.y) = 2
					int tmpDis = (Math.abs(hl.get(i).x - pl.get(combi[j]).x )) + (Math.abs(hl.get(i).y - pl.get(combi[j]).y));
					minDis = Math.min(minDis, tmpDis);
				}
				minDisSum += minDis;
			}
						
			//최소거리 고려 후, 변경
			answer = Math.min(answer, minDisSum);
			
		} else {
			for(int i=s; i<len; i++) {
				combi[L] = i;
				DFS(L+1, i+1);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //지도 크기 
		m = sc.nextInt(); //생존 피자집 갯수 
		
		arr = new int[n][n]; 
		
		pl = new ArrayList<>();
		hl = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int tmpNum = sc.nextInt();
				if(tmpNum == 1) hl.add(new Pointer(i, j));
				else if(tmpNum == 2) pl.add(new Pointer(i, j));
			}
		}
		
		//전체 피자집의 수 중에서 m개만 계속 운영 ex) 6개 피자집 중 4개만 살린다. => lenCm 6C4 
		len = pl.size();
		combi = new int[m]; 
		DFS(0,0);
		System.out.println(answer);
		
	}
}
