package _J39;

import java.util.Scanner;
import java.util.Stack;

/**
 * 39. 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
 * 만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다. 
 * 
 * 문제 설명: 첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
 * 식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.
 * 
 * 
 * [입력] 
 *  352+*9-

 * [출력] 
 * 12
 * 
 * [입력] 
 * 352+*9/

 * [출력] 
 * 2
 * 
 * 
 * 참고: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	//후위식 연산 
	//1. 숫자가 나오면 스택에 넣는다.
	//2. 연산기호가 나오면 스택에 2 숫자를 연산 처리한다. 이때 좌측에 오는 숫자는 먼저 들어와 있던 숫자가 된다. 
	// 내 풀이 
	public static int solution(String str) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		
		
		//연산 처리 중에서도 '-' 와 '/' 같은 경우는 순서에 따라 값이 변하기 때문에 먼저 들어온 값이 연산자 좌측에 올수 있도록 처리 
		for(char c: str.toCharArray()) {
			if(c == '+') 
			{
				stack.push(stack.pop() + stack.pop());
			} else if(c == '-') 
			{
				int result = stack.get(stack.size()-2) - stack.pop();
				stack.pop();
				stack.push(result);
			} else if(c == '*') 
			{
				stack.push(stack.pop() * stack.pop());
			} else if(c == '/') 
			{
				int result = stack.get(stack.size()-2) / stack.pop();
				stack.pop();
				stack.push(result);
			} else 
			{
				int tempNum = Character.getNumericValue(c);
				stack.push(tempNum);
			} 
		}
		answer = stack.pop();
		return answer; 
	}
	
	//답안 :rt, lt를 이용하여 애초에 숫자를 꺼내고 연산이 되어 공통화 시킴 훨씬 깔끔 
	public static int solution2(String str) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		
		
		//연산 처리 중에서도 '-' 와 '/' 같은 경우는 순서에 따라 값이 변하기 때문에 먼저 들어온 값이 연산자 좌측에 올수 있도록 처리 
		for(char c: str.toCharArray()) {
			if(Character.isDigit(c)) stack.push(c - 48); // 숫자인 경우는 아스키 코드 값을 이용하여 숫자로 stack에 저장 
			else {
				int rt = stack.pop();
				int lt = stack.pop();
				
				if(c == '+') stack.push(rt+lt);
				else if(c == '-') stack.push(lt-rt);
				else if(c == '*') stack.push(rt*lt);
				else if(c == '/') stack.push(lt/rt);
			}
		}
		
		answer = stack.pop();
		return answer; 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(solution(str));
		System.out.println(solution2(str));
	}
	
}
