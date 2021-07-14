package _J34;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 34. 전체 아나그램 횟수 구하기      
 * 
 * 문제 설명: S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
 * 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
 * 
 * [입력] 
 *  bacaAacba
	abc
	
 * [출력] 
 * 3 
 * 출력설명: {bac}, {acb}, {cba} 3개의 부분문자열이 "abc"문자열과 아나그램입니다 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * @author kimtaemin
 */

public class Main {
	
	//내 풀이, HashMap 비교 힌트 받음.  
	public static void solution(String s1, String s2) {
		int answer = 0;
		char[] arr = new char[s1.length()];
		
		int lt=0;
		int rt=s2.length()-1;	//부분 문자 크기만큼 잘라서 검사
		
		arr = s1.toCharArray();
		
		HashMap<Character, Integer> am = new HashMap<>();
		HashMap<Character, Integer> bm = new HashMap<>();
		
		//부분 문자 HashMap Setting 
		for(char c : s2.toCharArray()) {
			am.put(c, am.getOrDefault(c, 0) + 1);
		}
		
		
		//Sliding window setting 
		for(int i=0; i<s2.length()-1; i++) {
			bm.put(arr[i], bm.getOrDefault(arr[i], 0) + 1);
		}
		
		//Sliding window start
		while(rt < s1.length()) {
			//우측 1칸 추가 
			bm.put(arr[rt], bm.getOrDefault(arr[rt], 0) + 1);
			rt++;
			
			//HashMap 2개의 값이 같다면 ++ 
			if(am.equals(bm)) answer++;
			
			//lt는 -- 또는 제거 
			bm.put(arr[lt], bm.get(arr[lt]) - 1);
			if(bm.get(arr[lt]) == 0) bm.remove(arr[lt]); 
			lt++;
		}
		System.out.print(answer);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s1 = "", s2 = "";
		
		s1 = sc.next();
		s2 = sc.next();
		solution(s1, s2);
	}

}
