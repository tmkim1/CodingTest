package _J18;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 18. 뒤집은 소수  
 * 
 * 문제 설명: N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
 * 예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다. 
 * 첫 자리부터의 연속된 0은 무시한다.
 * 
 * [입력] 
 * 9
   32 55 62 20 250 370 200 30 100
 * [출력]
 * 23 2 73 2 3
 * 출처: 인프런 자바 알고리즘 문제풀이 
 * @author kimtaemin
 */

public class Main {
	public static boolean solution(int n) {
		if(n == 0 || n == 1) return false; // 0과 1은 소수가 X
		
		for(int i=2; i<n; i++) {
			if(n % i == 0) return false;   // 2부터 자기 자신보다 1작은 수까지 딱 나누어 떨어지는 값이 있는 경우 소수가 아님 
		}
		
		return true;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			int number = sc.nextInt();
			//들어온 값 뒤집기, char형식으로 뒤집지 말고 int형 그대로 두고 뒤집는 방법 
			int res = 0;
			while(number > 0) {
				
				//321 % 10 = 1, 
				int t = number % 10;	//나머지 값을 담을 변수 
				res = res * 10 + t;     //뒤집힌 값을 담을 변수 
				number = number / 10;   //입력 받은 값 
			}
			// res = 뒤집힌 정수 
			if(solution(res)) System.out.print(res + " ");
			
		}
	}
	
	
}
