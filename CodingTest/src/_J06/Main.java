package _J06;

import java.util.Scanner;

/**
 * 6. 중복 문자 제거 
 * 
 * 문제 설명: 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
 * 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
 * ex) ksekkset -> kset
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이 
 * @author kimtaemin
 */


public class Main {

	public static String solution(String str) {
		String answer = "";
		
		for(int i=0; i<str.length(); i++) {
			System.out.println(i + ":" + str.charAt(i) + "가장 앞에 존재하는 같은 문자 위치: " + str.indexOf(str.charAt(i)));
			
			if(str.indexOf(str.charAt(i)) == i) {
				answer += str.charAt(i);
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		System.out.println(solution(str));
		
	}

}
