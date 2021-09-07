package _ect_6_1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 문제: 효율적인 화폐 구하기 
 * 
 * 
 * 출처: 이것이 코딩 테스트다 (저자: 나동빈)
 * 
 * [입력]
 * 2 15
   2
   3
   
 * [출력]
 * 5
 * @author kimtaemin
 *
 */

public class Main3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = -1;
		int n = sc.nextInt(); //화폐 갯수 
		int m = sc.nextInt(); //만들고자 하는 금액 
		
		int[] d = new int[m+1]; //도달 하고자 하는 금액 만큼 배열 생성  
		int[] coin = new int[n]; //화폐 저장 
		Arrays.fill(d, Integer.MAX_VALUE);
		
		//화폐 셋팅 
		for (int i=0; i<n; i++) {
			coin[i] = sc.nextInt();
		}
		
		d[0] = 0;
		
		for (int i=1; i<=m; i++) {
			//해당 금액을 만들기 위한 화폐 셋팅 
			for(int j=0; j<n; j++) {
				if(i - coin[j] >= 0) {
					if(d[i-coin[j]] != Integer.MAX_VALUE) {
						d[i] = Math.min(d[i], d[i-coin[j]]+1);
					}
				}
			}
		}
		
		if(d[m] != Integer.MAX_VALUE) answer = d[m];
		System.out.println(answer);
	}

}
