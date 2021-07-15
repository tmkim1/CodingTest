package _J37;

import java.util.Scanner;
import java.util.Stack;

/**
 * 37. 괄호 문자 제거  
 * 
 * 문제 설명: 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
 * 
 * [입력] 
 * (A(BC)D)EF(G(H)(IJ)K)LM(N)

 * [출력] 
 * EFLM
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */


public class Main {
		//'(' 괄호를 만나면 스택에 넣어놓고 스택에 괄호가 존재하면 알파벳 건너띄고 
	    //')' 괄호를 만나면 스택에 있던 '(' 괄호를 제거한다.
	
		public static String solution(String str) {
			String answer = "";
			Stack<Character> stack = new Stack<>();
			
			for(char c : str.toCharArray()) {
				if( c == '(') stack.push(c);
				else if( c == ')') stack.pop(); //스택에 존재하는 '(' 문자를 pop
				else {
					if(stack.size() == 0) answer += c;//괄호 안에 있는 문자가 아님 List에 추가  
				}
			}
			
			return answer;
		}
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String str = sc.next();
			solution(str);
			System.out.println(solution(str));
			
		}
}
