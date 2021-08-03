package _J73;

import java.util.Scanner;

/**
 * 73. 수열 추측하기 
 * 
 * 가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀 있다. 그리고 둘째 줄부터 차례대로 파스칼의 삼각형처럼 위의 두개를 더한 값이 저장되게 된다.
 * 
 * 가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀 있다. 그리고 둘째 줄부터 차례대로 파스칼의 삼각형처럼 위의 두개를 더한 값이 저장되게 된다.
 * 
 * N과 가장 밑에 있는 숫자가 주어져 있을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하시오.
 * 
 * 단, 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력하여야 한다.
 * 3 1 2 4
 *  4 3 6
 *   7 9 
 *   16
 * 
 * [입력] 
 * 4 16

 * [출력] 
 * 3 1 2 4 
 * 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

/* 4가지인 경우 
 * 3C0 3C1 3C2 3C3 
 *  1   3   3   1  (곱하는 횟수) 
 *  해당 규칙을 이용 
 */
public class Main {
	public static int[] b;
	public static int[] p, ch;// 첫 줄을 만들 수 있는 구성을 담을 배열 
	public static int n; // 첫 줄에서 가장 큰 값 
	public static int lastNum;// 마지막 숫자 
	public static int[][] dy = new int[35][35];
	public static boolean flag = false;
	
	
	public static int combi(int n, int r) {
		if(dy[n][r] > 0) return dy[n][r]; //이미 구한 이력이 있는 경우 값 반환
		if(r == 0 || n == r) return 1 ;
		else return dy[n][r] = combi(n-1, r) + combi(n-1, r-1);
	}
	
	
	
	public static void DFS(int L, int sum) {
		
		if(lastNum < sum) return; 
		if(flag) return;
		if(L == n) {
			if(lastNum == sum) {
				for(int num : p) System.out.print(num + " "); //p에 담긴 모든 숫자 출력
				flag = true;
			}
		} else {
			
			for(int i=1; i<=n; i++) {
				if(ch[i] == 0) {
					ch[i] = 1;
					p[L] =i;
					DFS(L+1, sum + (p[L] * b[L])); 
					ch[i] = 0;
				}
				
				
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		lastNum = sc.nextInt();
		
		p = new int[n];
		b = new int[n];
		ch = new int[n+1];
		
		for(int i=0; i<n; i++) {
			b[i] = combi(n-1,i);  // 순열 규칙을 담기 위한 배열 
		}
		
		DFS(0, 0);
	}
}
