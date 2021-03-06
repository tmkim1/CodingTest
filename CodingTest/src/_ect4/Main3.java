package _ect4;

import java.util.Scanner;

/**
 * [구현]
 * 
 * 행복 왕국의 왕실 정원은 체스판과 같은 8 × 8 좌표 평면이다. 왕실 정원의 특정한 한 칸에 나이트가 서 있다. 나이트는 매우 충성스러운 신하로서 매일 무술을 연마한다.
 * 나이트는 말을 타고 있기 때문에 이동을 할 때는 L자 형태로만 이동할 수 있으며 정원 밖으로는 나갈 수 없다. 나이트는 특정한 위치에서 다음과 같은 2가지 경우로 이동할 수 있다.
 * 1. 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동하기 
 * 2. 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동하기
 * 8 × 8 좌표 평면상에서 나이트의 위치가 주어졌을 때 나이트가 이동할 수 있는 경우의 수를 출력하는 프로그램을 작성하시오. 
 * 
 * 이때 왕실의 정원에서 행 위치를 표현할 때는 1부터 8로 표현하 며, 열 위치를 표현할 때는 a부터 h로 표현한다.
 * 예를 들어 만약 나이트가 a1에 있을 때 이동할 수 있는 경우의 수는 다음 2가지이다. a1의 위치는 좌표 평면에서 구석의 위치에 해당하며 나이트는 정원의 밖으로는 나갈 수 없기 때문이다.
 * 
 * 1. 오른쪽으로 두 칸 이동 후 아래로 한 칸 이동하기(c2 ) 
 * 2. 아래로 두 칸 이동 후 오른쪽으로 한 칸 이동하기(b3 )
 * 
 * [입력]
 * a1
 * 
 * [출력]
 * 2
 * 
 * [참조]
 * 이것이 취업을 위한 코딩 테스트다 with 파이썬  : 취업과 이직을 결정하는 알고리즘 인터뷰 완벽 가이드, C/C++, 자바 코드 제공 | 나동빈 저
 * 
 * @author kimtaemin
 */
	
public class Main3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 초기 위치 
		String inputData = sc.nextLine();
		int x = inputData.charAt(1) - '0'; //x
		int y = inputData.charAt(0) - 'a' + 1; //y 
		
		// 해당 규칙에 따르면 나이트가 이동할 수 있는 최대 경우의 수는 8가지 
		// 격자 안에서 이동할 수 있는 경우가 판별하여 카운트 해야 함. 
		int[] dx = {-2,2,-2,2,-1,1,-1,1};
		int[] dy = {-1,-1,1,1,-2,-2,-2,2};
		
		// 이동 가능한지 체크 
		int result = 0; 
		for (int i=0; i<dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 1 && nx <=8 && ny >= 1 && ny <=8) result++;
		}
		System.out.println(result);
	}
}
