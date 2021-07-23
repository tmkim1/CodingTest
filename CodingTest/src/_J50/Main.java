package _J50;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 50. 좌표 정렬  
 * 
 * N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
 * 
 * 정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.
 * 
 * [입력] 
 * 5
   2 7
   1 3
   1 2  
   2 5
   3 6

 * [출력] 
 * 
 * 1 2
 * 1 3
 * 2 5
 * 2 7
 * 3 6
 * 
 * 참고: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */


public class Main {
	//1. x를 기준으로 정렬한다. 
	//2. x과 같은 경우 y를 기준으로 정렬한다. 
	//좌표 정렬과 같은 경우는 compareTo 메서드를사용하면 매우 편리하게 해결이 가능.
	public static class Point implements Comparable<Point> {
		Integer x;
		Integer y;
		
		public Point(Integer x, Integer y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if(this.x == o.x) return this.y - o.y; // this가 앞으로 => 오름차순 정렬, 음수 값이 return 
			else return this.x - o.x;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		ArrayList<Point> pointList = new ArrayList<Main.Point>();
		
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			pointList.add(new Point(x,y));
		}
		
		Collections.sort(pointList);	//클래스에서 재정의한 compareTo 메서드를 기준으로 정렬 
		
		for(Point o : pointList) {
			System.out.println(o.x + " " + o.y);
		}
	}
	
//	public static int[][] solution(int n, int[][] arr) {
//		int[][] answer = new int[n][2];
//		int x = 0, y = 0;
//		
//		
//		for(int i=0; i<n-1; i++) {
//			x = arr[i][0];
//			y = arr[i][1];
//			
//			if((x > arr[i+1][0]) && ( x == arr[i+1][0] && y > arr[i+1][1])) {
//				arr[i][0] = arr[i+1][0];
//				arr[i][1] = arr[i+1][1];
//			}
//		}
//		
//		return answer; 
//	}

}
