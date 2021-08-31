package _ect4;

import java.util.Scanner;

/**
 * [구현]
 * 
 * 문제: 시각  
 * 
 * 정수 N이 입력되면 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서 3이 하나라도 포함되는 모든 경우의 수를 구하는 프로그램을 작성하시오. 
 * 
 * 예를 들어 1을 입력했을 때 다음은 3이 하나라도 포함되어 있으므로 세어야 하는 시각이다.
 * 
 * •00시 00분 03초 •00시 13분 30초
 * 
 * 반면에 다음은 3이 하나도 포함되어 있지 않으므로 세면 안 되는 시각이다.
 * 
 * •00시 02분 55초 •01시 27분 45초
 * 
 * 입력 조건 • 첫째 줄에 정수 N이 입력된다. (0 ≤ N ≤ 23 )
 * 
 * 출력 조건 • 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서 3이 하나라도 포함되는 모든 경우의 수를 출력한다.
 * 
 * [입력]
 * 5
 * 
 * [출력]
 * 11475
 * 
 * [참조]
 *  
 *  1. 이것이 취업을 위한 코딩 테스트다 with 파이썬  : 취업과 이직을 결정하는 알고리즘 인터뷰 완벽 가이드, C/C++, 자바 코드 제공 | 나동빈 저
 * 
 * @author kimtaemin
 */

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int cnt = 0;
		
		//정해진 '시' 구간 까지 검사  
		for (int i=0; i <=h; i++) {
			for(int j=0; j<=60; j++) {
				for(int k=0; k<=60; k++) {
					if(threeCountCheck(i, j, k)) cnt ++;
				}
			}
		}
		System.out.println(cnt);
	}

	//숫자 3이 포함 되었는지 체크 
	private static boolean threeCountCheck(int h, int m, int s) {
		if(h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3) return true;
		else return false;
	}

}
