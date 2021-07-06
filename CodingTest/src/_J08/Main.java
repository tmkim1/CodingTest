package _J08;
import java.util.*;
/**
 * 8. 팰린드롬 판별 
 * 
 * 문제 설명: 회문 문자 판별과 비슷하지만 문자열이라는게 다름 
 * 회문 문자열 : YES , 아닌 경우 : NO 반환
 * 대소문자 구별하지 않고 알바펫만 확인  
 * ex) ksekkset -> kset
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이 
 * @author kimtaemin
 */

public class Main {

	public static String solution(String s) {
		String answer = "NO";
		s = s.toUpperCase().replaceAll("[^A-Z]", ""); //replace는 정규식 사용 불가 but rplaceAll은 사용 가능, ^: 부, [A-Z] 범위 -> A부터 Z까지의 범위에 들지 않는다면 이라는 의  
		String tmpStr = new StringBuilder(s.toUpperCase()).reverse().toString();
		if(s.equals(tmpStr)) answer = "YES";
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(solution(str));
		
	}

}
