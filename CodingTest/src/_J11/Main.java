package _J11;

import java.util.Scanner;

/**
 * 11. 가장 짧은 문자거리 
 * 
 * 문제 설명: 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
 * 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
 * 단 반복횟수가 1인 경우 생략합니다.
 * ex) 입력: KKHSSSSSSSE  ,출력: K2HS7E
 * 문자열 Size MAX: 100
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이 
 * @author kimtaemin
 */

public class Main {

	
	// 내 풀이 
	public static String solution2(String s) {
		String answer = "";
		
		int chkCnt = 1;
		
		for(int i=0; i<s.length()-1; i++) {
			
			if(chkCnt == 1) answer += s.charAt(i);	// 초기 출연인 경우 문자열에 추가
	
			if(s.charAt(i) == s.charAt(i+1)) {		// 반복 출연인 경우 카운트 증가 
				chkCnt ++;
			} else if(chkCnt != 1) {
				answer += chkCnt;
				chkCnt = 1; 						// 다음 인덱스랑 다른 경우 --> 현재 카운트를 저장 하지만 카운트가 1이면 저장 안 함.
			}
			
			if(i == s.length()-2) {
				if(chkCnt > 1) answer += chkCnt;
				else answer += s.charAt(i+1);
			}
			//answer += s.charAt(i+1);
			 
		}
		
		return answer;
	}
	
	// 강의 답안 
	public static String solution(String s) {
		String answer = "";
		s=s+" ";
		int cnt = 1;
		
		for(int i=0; i<s.length()-1; i++) {
			
			if(s.charAt(i) == s.charAt(i+1)) {		// 반복 출연인 경우 카운트 증가 
				cnt ++;
			} else {
				answer += s.charAt(i);
				if(cnt>1) answer += String.valueOf(cnt);
				cnt = 1; 						    // 다음 인덱스랑 다른 경우 --> 현재 카운트를 저장 하지만 카운트가 1이면 저장 안 함.
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(solution2(str));
		System.out.println(solution(str));
	}
	
	
	
}
