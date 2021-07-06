package _J07;

import java.util.Scanner;

/**
 * 7. 회문 문자열 판별 
 * 
 * 문제 설명: 회문 문자열 (거꾸로 해도 똑같은 문자열) 판별 진
 * 회문 문자열 : YES , 아닌 경우 : NO 반환 
 * ex) ksekkset -> kset
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이 
 * @author kimtaemin
 */


public class Main {

	public static String solution(String str) {
		String answer = "YES";
		
		//lt, rt를 이용하여 끝까지 같으면 YES, 같지 않으면 NO로 판별
		int lt = 0;
		int rt = str.length()-1;
		char[] charArr = str.toCharArray();
		
		while (lt < rt) {
			if(Character.toUpperCase(charArr[lt]) != Character.toUpperCase(charArr[rt])) {
				answer = "NO"; 
				break;
			}
			lt++;
			rt--;
		}
		
		return answer;
	}
	
	//강의 풀이 
	public static String solution2(String str) {
		String answer = "YES";
		String tmpStr = new StringBuilder(str).reverse().toString();
		if(str.equals(tmpStr)) answer = "YES" ;
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		String str = sc.next();
		
		System.out.println(solution(str));
		System.out.println(solution2(str));
	}
	
	

}
