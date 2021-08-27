package _J36;

import java.util.Scanner;
import java.util.Stack;

/**
 * 36. 올바른 괄호 (스택의 대표적인 문제)       
 * 
 * 문제 설명: 
 * 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
 * (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
 * 
 * [입력] 
 *  (()(()))(()
 *  )(()(()))(()

 * [출력] 
 * NO
 * 
 * 경우의 수 구하기, TreeSet 활용 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * @author kimtaemin
 */

public class Main {
	
	//내 풀이 
	public static String solution(String str) {
		
		int chkCnt=0;
		
		for(char c : str.toCharArray()) {
			
			if( c == ')' && chkCnt ==0) return "NO";
			else if(c == '(') chkCnt++;
			else if(c == ')') chkCnt--;
		}
		
		if(chkCnt == 0 ) return "YES";
		else return "NO";
		
	}
	
	//강의 답안(스택을 이용한 방법)
	public static String solution2(String str) {
		String answer = "YES";
		Stack<Character> stack = new Stack<>();
		
		for(char c : str.toCharArray()) {
			if( c == '(') stack.push(c);
			else {
				if(stack.isEmpty()) return "NO";
				stack.pop(); 
			}
		}
		if(!stack.isEmpty()) return "NO";
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(solution(str));
		System.out.println(solution2(str));
		
	}
}
