package _6;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 문제: 가장 큰 수
 * 문제 설명
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 * 제한 사항
 * numbers의 길이는 1 이상 100,000 이하입니다.
 * numbers의 원소는 0 이상 1,000 이하입니다.
 * 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 * 입출력 예
 * numbers	return
 * 6, 10, 2]	"6210"
 * [3, 30, 34, 5, 9]	"9534330"
 * 
 * 링크: https://programmers.co.kr/learn/courses/30/lessons/42746
 * @author kimtaemin
 *
 */

public class Main {
	// 내 풀이 
	public static String solution(int[] numbers) {
		String answer = "";
		String[] strArr = new String[numbers.length];
		
		//1. int 배열을 String 배열에 담는다. 
		for(int i=0; i<strArr.length; i++) {
			strArr[i] = String.valueOf(numbers[i]);
		}
		
		//오름 차순, 내림 차순 정렬 기능 사용 
		//내림차순 : return (o2+o1).compareTo(o1+o2);
		//오름차순 : return (o1+o2).compareTo(o1+o2);
		
		Arrays.sort(strArr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return(o2 + o1).compareTo(o1 + o2);
			}
		});
		
	
		StringBuilder sb = new StringBuilder();
		
		//if(strArr[0].startsWith("0")) {
		if(strArr[0].equals("0")) {				//정렬된 상태에서 맨 앞에 값이 0인 경우는 결과에 0만을 대입 
			sb.append("0");
		} else {
			for(String n : strArr) {
				sb.append(n);
			}
		}
		
		answer = sb.toString();
		return answer;
	}
	
	public static void main(String[] args) {
		int[] numbers = {0,0,0,0};
		int[] numbers2 = {6,2,10};
		System.out.println(solution(numbers));
		System.out.println(solution(numbers));
	}

}
