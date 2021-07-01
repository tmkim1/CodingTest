package _J02;

import java.util.Scanner;

/**
 * 2. 입력된 문자열: 대소문자 변환 
 * 출처: 인프런 자바 알고리즘 문제풀
 * @author kimtaemin
 *
 */


public class Main {
	
	//메서드 활용 
	public static String solution(String str) {
		String answer = "";
		
		for(char x : str.toCharArray()) {
			if(Character.isLowerCase(x)) {
				answer += Character.toUpperCase(x);
			} else {
				answer += Character.toLowerCase(x);
			}
		}
		
		return answer;
	}
	
	//ASCII 값 활용 
	public static String solution2(String str) {
		String answer = "";
		
		for(char x : str.toCharArray()) {
			
			if(x >= 'a' && x <= 'z') {         //if(x >= 97 && x <= 122) {
				answer += (char)(x-('a'-'A')); //answer += (char)(x-32);
			} else {
				answer += (char)(x+32);
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(solution(str));
		System.out.print(solution2(str));
	}

}
