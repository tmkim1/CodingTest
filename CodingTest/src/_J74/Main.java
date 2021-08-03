package _J74;

import java.util.Scanner;

/**
 * 74. 조합 구하기 
 * 
 * 1부터N까지번호가적힌구슬이있습니다.
 * 
 * 이중 M개를뽑는방법의수를출력하는프로그 램을 작성하세요.
 * 
 * [입력] 
 * 4 2
 * 
 * [출력] 
 * 1 2
 * 1 3
 * 1 4
 * 2 3 
 * 2 4 
 * 3 4
 * 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

/*
 * 1부터 n개 까지의 구슬 -> level 
 * 
 * M개를 뽑는 방법의 수 -> p 배열 크기 
 * 
 * 1행 2행 
 * 1   2 
 * 1   3
 * 1   4
 * 2   3
 * 2   4 
 * 
 * 위와 같이 2행에 해당하는 부분은 1행보다 +1 큰 숫자부터 지정된 숫자까지라는 규칙을 가지고 있음 
 * 
 * 이를 조절 하는 변수를 함께 dfs에 매개변수로 전달. 
 */
public class Main {
	public static int n, m;
	public static int[] arr, p;
	
	public static void dfs(int L, int s) {
		if(L == m) {
			for(int num : p) System.out.print(num + " ");
			System.out.println();
		} else {
			for(int i=s; i<=n; i++) { 
					p[L] = i;
					dfs(L+1, i+1);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt(); //한번에 뽑는 구슬의 수 
		p = new int[m]; // 한번에 뽑을수 있는 구슬의 수 만큼 배열 크기 조정 
		
		dfs(0,1);
		
	}
}
