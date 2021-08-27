package _J42;

import java.util.Scanner;
import java.util.Stack;

/**
 * 42. 시간표 짜기 
 * 
 * 현수는 1년 과정의 수업계획을 짜야 합니다.
 *
 * 수업중에는 필수과목이 있습니다. 이 필수과목은 반드시 이수해야 하며, 그 순서도 정해져 있습니다.
 * 
 * 만약 총 과목이 A, B, C, D, E, F, G가 있고, 여기서 필수과목이 CBA로 주어지면 필수과목은 C, B, A과목이며 이 순서대로 꼭 수업계획을 짜야 합니다.
 * 
 * 여기서 순서란 B과목은 C과목을 이수한 후에 들어야 하고, A과목은 C와 B를 이수한 후에 들어야 한다는 것입니다.
 * 
 * 현수가 C, B, D, A, G, E로 수업계획을 짜면 제대로 된 설계이지만
 * 
 * C, G, E, A, D, B 순서로 짰다면 잘 못 설계된 수업계획이 됩니다.
 * 
 * 수업계획은 그 순서대로 앞에 수업이 이수되면 다음 수업을 시작하다는 것으로 해석합니다.
 * 
 * 수업계획서상의 각 과목은 무조건 이수된다고 가정합니다.
 * 
 * 필수과목순서가 주어지면 현수가 짠 N개의 수업설계가 잘된 것이면 “YES", 잘못된 것이면 ”NO“를 출력하는 프로그램을 작성하세요.
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
					chk = true;                   //필수 과목 검사 확인 플래그 true로 변경하고 선행 과목이 존재한다면 추가, 없다면 return "NO"
					if(stack.contains(core.charAt(i-1))) {
						stack.push(c);
					}
					else return "NO";
				} 
			}
			if(!chk) stack.push(c);               //필수 과목 아닌 경우 바로 추가, 이미 추가 된 필수 과목 중복을 막기 위해 flag 사용 
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
