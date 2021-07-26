package _J55;

import java.util.Scanner;

/**
 * 55. 재귀함수를 이용한 이진수 출력 
 * 
 * 10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하세요. 
 * 단 재귀함수를 이용해서 출력해야 합니다. 
 * 
 * [입력] 
 * 11

 * [출력] 
 * 1011 
 * 
 * 
 * 참고: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	public static void DFS(int n) {
		//2진수 출력
		if(n == 0) return;
		else {
			DFS(n/2);
			System.out.print(n%2);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		DFS(n);
	}
}
