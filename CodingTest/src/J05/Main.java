package J05;

import java.util.Scanner;

/**
 * 5. 특정 문자 뒤집기
 * 문제: 길이 100이하의 문자열이 주어지는데 각 처음과 끝을 swap해주도록 한다.
 * 단, 해당 문자가 알파벳인 경우만 swap하고 아니라면 건너띈다. 
 * 출처: 인프런 자바 알고리즘 문제풀이 
 * @author kimtaemin
 */

public class Main {

	public static String solution(String str) {
		
		//1. 받은 문자열을 char[]로 변환
		char[] charArr = str.toCharArray();
		int lt = 0, rt = charArr.length-1;
		char tmpChar;
		
		while(lt < rt) {
			//2. 알파벳인 경우만 swap 해주도록 조건 추가 
			//if(charArr[lt] >= 'a' && charArr[lt] <= 'Z' && charArr[rt] >= 'a' && charArr[rt] <= 'Z') {
			
			if(!Character.isAlphabetic(charArr[lt])) {
				lt++;
			} else if (!Character.isAlphabetic(charArr[rt])) {
				rt--;
			} else {
				tmpChar = charArr[rt];
				charArr[rt] = charArr[lt];
				charArr[lt] = tmpChar;
				lt++;
				rt--;
			}
		}
		
		return String.valueOf(charArr);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		System.out.println(solution(str));
	}

}
