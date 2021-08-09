package _J90;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 90. 동전 교환 (냅색 알고리즘)  
 * 
 * 거슬러 줄 동전의 최소 개수를 출력 
 * 
 * [입력] 
 *  3
	1 2 5
	15
	
 * [입력2]
	4
	1 3 5 8
	211

 * [출력] 
 * 3
 * 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	public static int n, m;
	public static int[] dy;
	
	public static int solution(int[] coin) {
		Arrays.fill(dy, Integer.MAX_VALUE);
		dy[0] = 0;
		for(int i=0; i<n; i++) { //모든 동전 단위로 산출 
			for(int j=coin[i]; j<=m; j++) { //동전 단위 금액 이상 부터 확인  
				dy[j] = Math.min(dy[j], dy[j-coin[i]]+1); //dp 활용 
			}
		}
		return dy[m]; 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] coin = new int[n];
		
		for(int i=0; i<n; i++) { //동전 종류 셋팅 
			coin[i] = sc.nextInt();
		}
		
		m = sc.nextInt();  //거스름 돈 금액 
		dy = new int[m+1]; 
		System.out.println(solution(coin));
	}
}
