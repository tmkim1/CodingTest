package _J42;

import java.util.Scanner;
import java.util.Stack;

/**
 * 42. 시간표 짜기 
 * 
 * 
 * [입력] 
 * CBA
   CBDAGE 

 * [출력] 
 *  YES
 * 
 * 
 * 참고: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	
	//1. 필수 과목이 순서에 맞게 모두 시간표에 포함 돼 있어야 함.
	//2. 필수 과목을 배열로 분리하여 선수 과목이 있는지 체크하는 로직 구현
	//3. Stack의 Contains 활용 예정 
	
	public static String solution(String core, String schedule) {
		String answer = "YES";
		Stack<Character> stack = new Stack<>();
		boolean chk = false;
		
		
		//전체 과목 확인 
		for(char c : schedule.toCharArray()) {
			for(int i=1; i<core.length(); i++) {  //필수 과목 확인 
				if(c == core.charAt(i) && !chk) { //필수 과목이 맞고 이미 확인 되지 않은 경우라면 
					chk = true;                   //필수 과목 검 확인 플래그 true로 변경 후, 선행 과목이 존재한다면 추가 없다면 return "NO"
					if(stack.contains(core.charAt(i-1))) {
						stack.push(c);
					}
					else return "NO";
				} 
			}
			if(!chk) stack.push(c);               //필수 과목 아닌 경우 바로 추가, 이미 추가 된 필수 과목 중복을 막기 위해 flag 사
			chk = false;
		}
		
		//최종 검사 
		for(char c : core.toCharArray()) {
			if(!stack.contains(c)) return "NO";
		}
		
		return answer; 
	}
	
	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>(); 
		
		Scanner sc = new Scanner(System.in);
		String core = sc.next();
		String schedule = sc.next();
		
		System.out.println(solution(core,schedule));
	}
}
