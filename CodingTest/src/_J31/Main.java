package _J31;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

/**
 * 31. 학급 회장  
 * 
 * 문제 설명:학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
 * 투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.
 * 선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.
 * 반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.
 * 
 * [입력] 
 *  15
	BACBACCACCBDEDE
	
 * [출력] 
 * C
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * @author kimtaemin
 */


public class Main {
	
	//내 풀이 
	//프로그래머스: 완주하지 못한 선수와 문제가 유사했음. 
	
	public static char solution(String result) {
		HashMap<Character, Integer> hm = new HashMap<>();
		int maxValue = 0;
		char answer = 0;
		
		for(char c : result.toCharArray()) {
			hm.put(c, hm.getOrDefault(c, 0)+1);
		}
		
		for(Entry<Character, Integer> entry : hm.entrySet()) {
    		if(entry.getValue() > maxValue) {
    			maxValue = entry.getValue();
    			answer = entry.getKey();
    		}
    	}
		
		//강의 풀이 
//		for(char key : hm.keySet()) {
//			if(hm.get(key) > maxValue) {
//				maxValue = hm.get(key);
//				answer = key;
//			}
//		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		String result = "";
		result = sc.next();
		
		System.out.println(solution(result));
		
	}

}
