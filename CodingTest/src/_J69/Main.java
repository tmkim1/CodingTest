package _J69;

import java.util.Scanner;

/**
 * 69. 중복 순열 
 * 
 * n * n 중복 순열 출력 
 * (m은 배열 크기)
 * 
 * [입력] 
 * n m 
 * 3 2 

 * [출력] 
 * 1 1 
 * 1 2 
 * 1 3 
 * 2 1 
 * 2 2 
 * 2 3
 * 3 1
 * 3 2
 * 3 3 
 * 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	public static int n;
	public static int m;
	public static Integer[] pm;
	
	//DFS 사용 
	public static void DFS(int L) {
		// 배열 크기를 레벨로 잡아서 구분점을 잡는다. 
		if(L == m) {
			for(int x: pm) System.out.print(x + " ");
			System.out.println();
		} else {
			// 표현 하려는 n값 까지 순회 시켜준다. 
			for(int i=1; i<=n; i++) {
				pm[L] = i;
				DFS(L+1);
			}
		}
	}
	
	//일반 반복분 사용 
	public static void test() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.println(i + " " + j);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
	        m = sc.nextInt(); 
		
		pm = new Integer[m];
		DFS(0);
		test();
		
	}
}
