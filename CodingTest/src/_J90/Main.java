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

/*
 * 0 ~ 거스름 돈에 해당 하는 모든 범위의 배열을 생성 해야함.
 * ex) 200
 * 0 ~ 200원 총 201개의 인덱스 생성 
 * 
 * 각 금액 별로 동전 단위 별로 최소로 환산 되는 동전 갯수를 초기화 해나가는 과정을 가짐.
 * 
 * 1. 1원으로 거슬러준 경우로 셋팅
 * 
 * 2. 3원으로 거슬러준 경우로 셋팅 
 * 
 * .... 
 * 
 * 따라서 1원으로 거슬러준 경우에는 dy[3]의 값이 3이지만,
 * 
 * 3원으로 거슬러준 경우로 다시 초기화 되기 때문에 dy[3]의 값이 1로 초기화 됨.
 * 
 * 이후 dy[6]을 구할때에는 3원으로 환산할 때, dy[6-3]의 값을 가져온 후 +1을 진행 
 * 
 * 내가 사용 할 동전 화폐의 값을 뺀 가격이 가지고 있는 최소 화폐 갯수를 가져와서 +1을 해주는 과정을 거침. 
 * 
 * 
 */

public class Main {
	public static int n, m;
	public static int[] dy;
	
	public static int solution(int[] coin) {
		Arrays.fill(dy, Integer.MAX_VALUE);
		dy[0] = 0;
		for(int i=0; i<n; i++) { //모든 동전 단위로 산출 
			for(int j=coin[i]; j<=m; j++) { //동전 단위 금액 이상 부터 확인  
				dy[j] = Math.min(dy[j], dy[j-coin[i]]+1); //dp 활용, 핵심: dy[j-coin[i]]+1 : 해당 화폐 단위를 사용하기 전에 최소 갯수를 받아온 후, 화폐 사용 갯수를 1증가 
			}
		}
		return dy[m]; //최종 거슬러 줄 동전의 최소 개수를 출력 
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
