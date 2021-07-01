package _J03;

import java.util.Scanner;

/**
 * 3. 문장 속 단어 (가장 긴 단어 찾기) 
 * 출처: 인프런 자바 알고리즘 문제풀이 
 * @author kimtaemin
 *
 */


public class Main {
	public static String solution(String str) {
		String answer = "";
		
		// 문자열을 공백을 기준으로 배열에 담는다. 
		String[] strArray = str.split(" ");
		for(String tempStr : strArray) {
			if(tempStr.length() > answer.length()) {
				answer = tempStr;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();			//문자 열을 받아야 하기 때문에 nextLine() 사용, next()만 하면 문자로 구분되어 들어옴 
		System.out.print(solution(str));
	}
}
