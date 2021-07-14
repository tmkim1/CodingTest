package _J32;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * 32. 아나그램   
 * 
 * 문제 설명: Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
 * 예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로
 * 알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
 * 길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.
 * 
 * [입력] 
 *  AbaAeCe
	baeeACA	
	
 * [출력] 
 * YES
 
 * [입력] 
 *  abaCC
	Caaab	
	
 * [출력] 
 * NO
 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * @author kimtaemin
 */


public class Main {
	
	//내 풀이 
	public static String solution(String s1, String s2) {
		//완주하지 못한 선수 풀이 처럼 HashMap value값을 +1 한 다음,
		//2번째 검사 문자 value	 값은 -1 해서 값을 확인하여 결정하는 방법이 존재 
		
		HashMap<Character, Integer> hm = new HashMap<>();
		for(char c : s1.toCharArray()) {
			hm.put(c, hm.getOrDefault(c, 0) + 1);
		}
		
//		for(char c : s2.toCharArray()) {
//			hm.put(c,  hm.getOrDefault(c, 0) - 1);
//		}
		
		//강의 답안 차이 부분
		//아예 해당 key가 없으면 아나그램이 아니기 떄문에 사전에 NO 처리
		for(char c : s2.toCharArray()) {
			if(!hm.containsKey(c) || hm.get(c) == 0) return "NO";
			hm.put(c, hm.get(c) -1 );
		}
		
		for(Entry<Character, Integer> entry : hm.entrySet()) {
			if(entry.getValue() != 0) {							//값이 0이 아니라면 두 문자열의 각 문자 출연 횟수가 다름을 의미 
				return "NO";
			}
		}
		return "YES";
	}
	
	public static void main(String[] args) {
		String s1,s2;
		Scanner sc = new Scanner(System.in);
		
		s1 = sc.next();
		s2 = sc.next();
		
		System.out.println(solution(s1, s2));
		
	}

}
