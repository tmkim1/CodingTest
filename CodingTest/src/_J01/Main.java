package _J01;

import java.util.Scanner;

/**
 * 1. 문자 출연 횟수 구하기 
 * 출처: 인프런 자바 알고리즘 문제풀이 
 * 
 * @author kimtaemin
 *
 */

public class Main {

	public int solution(String str, char t) {
		int answer = 0;
		str = str.toUpperCase();       //대문자로 변환 
		t = Character.toUpperCase(t);
		
//		for (int i=0; i<str.length(); i++) {
//			if(t == str.charAt(i)) {
//				answer++;
//			}
//		}
		
		for(char x : str.toCharArray()) {
			if(t == x) answer++;
		}
		
		return answer; 
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();			//String 받기 
		char c = sc.next().charAt(0);   //char 받기 
	    System.out.print(T.solution(str, c));
		
	}

}
