package _ect_6_1;

import java.util.Scanner;

/**
 * 문제: 1로 만들기 
 * 
 * 나누기 연산 같은 경우 나누어 떨어지는 경우만 수행 가능
 * 
 * 입력된 x의 값이 1로 만드는데 드는 연산 횟수의 최솟값을 출력 
 * 
 * 1. -1 
 * 2. /5
 * 3. /3
 * 4. /2
 * 
 * 출처: 이것이 코딩 테스트다 (저자: 나동빈)
 * 
 * [입력]
 * 4
   1 3 1 5
 * [출력]
 * 8
 * @author kimtaemin
 *
 */

public class Main2 {
	
	//x의 최댓값: 30000
	public static int d[] = new int[30001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		for (int i=2; i<=x; i++) {
			//1. 1로 뺀 경우 
			d[i] = d[i-1] + 1;
			//2. 현재의 수가 2로 나누어 떨어지는 경우 
			if(d[i] % 2 == 0) d[i] = Math.min(d[i], d[i/2] + 1);
			//3. 현재의 수가 2로 나누어 떨어지는 경우 
			if(d[i] % 3 == 0) d[i] = Math.min(d[i], d[i/3] + 1);
			//4. 현재의 수가 2로 나누어 떨어지는 경우 
			if(d[i] % 5 == 0) d[i] = Math.min(d[i], d[i/5] + 1);
		}
		System.out.println(d[x]);
	}

}
