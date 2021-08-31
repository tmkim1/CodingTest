package _ect3;

/**
 * [그리디 알고리즘]- 0~9로 이루어진 문자열에 +, * 연산을 사용하여 가장 큰 값 구하기. 
 * 
 * 문자열 길이 0 ~ 20
 * 
 * 일반적인 연산 우선순위와 별개로 +,* 상관 없이 앞에서부터 연산이 수행됨
 * 
 * 제한: 가장 큰 값은 20억 이하여야 함. 
 * 
 * [참조]
 *  
 *  1. 이것이 취업을 위한 코딩 테스트다. 
 * 
 * @author kimtaemin
 */

public class Main {

	public static void main(String[] args) {
		String numStr = "20319253";
		solution(numStr);
		solution2(numStr);
	}
	
	
	//내 풀이 
	public static void solution(String numStr) {
		// 1이하인 경우는 곱하는 것보다 더하는게 더 큰수를 구할수있음. 
		// 문자열을 문자 배열로 변환한 후, 각 문자를 숫로 변환하여 최종 값을 구하도록 한다.
		
		char[] charArr = numStr.toCharArray();
		long result = Character.getNumericValue(charArr[0]);
		
		for (int i=1; i<charArr.length; i++) {
			
			int num = Character.getNumericValue(charArr[i]);
			
			
			if(result != 0 && result != 1 && num != 0 && num != 1 ) {
				result *= num;
			} else {
				result += num;
			}
		}
		System.out.println("최종 값: " + result);
		
	}
	
	//답안 
	//포인트는 같지만 조건문에서 0, 1을 답안처럼 1보다 작은으로 표현하는게 훨씬 간편한데 그렇게 하지 않았음.

	public static void solution2(String numStr) {
		long result = numStr.charAt(0) - '0';		//charAt 메서드를 사용 후, 아스키 코드 값 0을 뺴주는 아이디어 사용. 
		
		for (int i=1; i<numStr.length(); i++) {
			int num = numStr.charAt(i) - '0';
			
			if(num <= 1 || result <= 1) {
				result += num;
			} else {
				result *= num;
			}
		}
		System.out.println("최종 값: " + result);
	}
	

}
