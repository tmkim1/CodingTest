package _J09;

import java.util.Scanner;

/**
 * 9. 숫자만 추출  
 * 
 * 문제 설명: 주어지는 문자열에서 숫자만 추출 
 * ex) g0en2T0s8eSoft -> 208
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이 
 * @author kimtaemin
 */


public class Main {

	//정규식 사
	public static int solution(String s) {
		int answer = 0;
		answer = Integer.parseInt(s.replaceAll("[^0-9]", "")); 
		
		return answer;
	}
	
	//ASCII 코드와 10진수 특징 사용 
	public static int solution2(String s) {
		int answer = 0;
		
		for(char c : s.toCharArray()) {
			if(c >= 48 && c <= 57) answer = answer * 10 + (c-48);
		}
		
		return answer;
	}
	
	//문자 메서드 활용 
	public static int solution3(String s) {
		String answer = "";
		
		for(char c : s.toCharArray()) {
			if(Character.isDigit(c)) answer += c;
		}
		
		return Integer.parseInt(answer);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(solution(str));
		System.out.println(solution2(str));
		System.out.println(solution3(str));
	}

}
