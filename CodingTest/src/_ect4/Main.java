package _ect4;

import java.util.Scanner;

/**
 * [구현]
 * 
 * 문제: 상하좌우 
 * 
 * 제한된 격자 판에서 이동 입력에 따른 최종 좌표 구하기 
 * 
 * [입력]
 * 5
   R R R U D D
 * 
 * [출력]
 * 3 4
 * 
 * [참조]
 *  
 *  1. 이것이 취업을 위한 코딩 테스트다. 
 * 
 * @author kimtaemin
 */

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //격자 크기 
		sc.nextLine();
		char[] plans = sc.nextLine().replaceAll(" ", "").toCharArray(); //이동 계획 (L,R,U,D)
		
		//초기 좌표 위치 설정 
		int x = 1, y = 1;
		
		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};
		char[] moveTypes = {'L', 'R', 'U', 'D'};
		
		//이동 계획 확인 -> plans 순회 
		for(int i=0; i<plans.length; i++) {
			int nx = -1, ny = -1;
			for (int j=0; j<moveTypes.length; j++) {
				if(plans[i] == moveTypes[j]) {
					nx = x + dx[j];
					ny = y + dy[j];
					break;
				}
			}
			//이동 범위 유효성 체크 
			if(nx < 1 || ny < 1 || nx > n || ny > n) continue;
			x = nx;
			y = ny;
		}
		
		System.out.println(x + " " + y);
	}

}
