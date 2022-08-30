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
		String[] strArray = str.split(" "); // 문자열을 공백 기준으로 잘라서 단어 단위로 배열에 담는다. 
		
		for(String tempStr : strArray) {
			if(tempStr.length() > answer.length()) {
				answer = tempStr;
			}
		}
		
		return answer;
	}
	
	public static String solution2(String str) {
		String answer = "";
		int pos = 0;
		
		while((pos=str.indexOf(' ')) != -1) { //공백을 발견할때까지 반복 
			String tmp = str.substring(0, pos);
			str = str.substring(pos+1);
			
			if(tmp.length() > answer.length()) {
				answer = tmp;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();			//문자 열을 받아야 하기 때문에 nextLine() 사용, next()만 하면 문자로 구분되어 들어옴 
		System.out.println(solution(str));
		System.out.print(solution2(str));
	}
}
