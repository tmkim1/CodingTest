package _J13;

import java.util.Scanner;

/**
 * 13. 큰 수 출력하기
 * 
 * 문제 설명: 큰 수 출력하기
 * N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
 * (첫 번째 수는 무조건 출력한다) 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이 
 * @author kimtaemin
 */

public class Main {

	public static void solution(int[] intArr) {
		System.out.print(intArr[0]+" ");
		
		for(int i=0; i<intArr.length-1; i++) {
			if(intArr[i] < intArr[i+1]) {
				System.out.print(intArr[i+1]+" ");
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//숫자 입력 받고 값 비교 
		int size = sc.nextInt();
		int[] intArr = new int[size];
		
		for(int i=0; i<size; i++) {
			intArr[i] = sc.nextInt();
		}
		
		solution(intArr);
	}

}
