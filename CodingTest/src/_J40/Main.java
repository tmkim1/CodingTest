package _J40;

import java.util.Scanner;
import java.util.Stack;

/**
 * 40. 쇠막대기 레이저 자르기 
 * 
 * 여러 개의 쇠막대기를 레이저로 절단하려고 한다. 효율적인 작업을 위해서 쇠막대기를 아래에서 위로 겹쳐 놓고,
 * 
 * 레이저를 위에서 수직으로 발사하여 쇠막대기들을 자른다. 쇠막대기와 레이저의 배치는 다음 조건을 만족한다.
 * 
 * • 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있다. - 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되,
 * 
 * 끝점은 겹치지 않도록 놓는다.
 * 
 * • 각 쇠막대기를 자르는 레이저는 적어도 하나 존재한다.
 * 
 * • 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않는다.
 * 
 * 아래 그림은 위 조건을 만족하는 예를 보여준다. 수평으로 그려진 굵은 실선은 쇠막대기이고, 점은 레이저의 위치,
 * 
 * 수직으로 그려진 점선 화살표는 레이저의 발사 방향이다.
 * 
 * 
 * [입력] 
 * ()(((()())(())()))(())

 * [출력] 
 * 17
 * 
 * 
 * 참고: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	
	//1. () 레이저를 만나면 while문을 돌려 이전에 들어왔던 막대기를 잘라내서 cnt 해야 한다. 
	//2. '(' 여는 괄호는 다 stack에 push 한 후, 레이저를 만나면 stack에 쌓인 만큼 cnt에 더해준다.
	//3. ')' 닫는 괄호는 직전 문자가 '(' 닫는 괄호인 경우가 레이저이고 그게 아니라면 막대의 끝을 의미, 
	//       따라서 갯수를 1개 추가하고 stack에 있는 여는 괄호를 pop하여 막대를 없애준다.
	
	//-:: 60 line, 64 line에 있는 stack.pop()을 위에서 1번에 처리한 것 빼고 답안과 같음.
	
	public static int solution(String str) {
		int answer = 0;
		Stack<Character> stack = new Stack<>(); 
		
		char prev;
		char[] charArr = str.toCharArray();
		
		
		for(int i=0; i<charArr.length; i++) {
			
			if(charArr[i] == '(') {
				stack.push(charArr[i]);
			} else {
				if(charArr[i-1] == '(') {	//직전 문자 값이 '('라면 () => 레이저인 경우 
					stack.pop();
					answer += stack.size(); //아직 남아있는 막대기 수 
				} else {                    //막대가 끝난 경우 
					answer++;
					stack.pop();
				}
			}
		}
		
		return answer; 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(solution(s));
	}
}
