package Q1;

/**
 * 주제: 문자 해독 
 * 설명: 문자를 해독하는 문제 (문자 치환 사용) 
 * 출처: 눈 떠보니 코딩테스트 전
 * @author kimtaemin
 *
 */

public class Main {

	public static void main(String[] args) {
		String[] text = {
			" + -- + - + -    ",
			" + --- + - +    ",
			" + -- + - + -    ",
			" + - + - + - +    "
		};
		
		solution(text);
	}
	
	public static void solution (String[] text) {
		for(int i=0; i<text.length; i++) {
			int n = Integer.parseInt(text[i].trim().replace(" ","").replace("+", "1").replace("-", "0"),2); // 해당 암호 문자열을 2진수 값으 변경 
			text[i] = String.valueOf((char)n); //2진수 값을 아스키코드 문자 값으로 변경 
			System.out.println(text[i]);       //암호 출력 
		}
		
	}

}
