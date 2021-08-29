package _16;

import java.util.ArrayList;

/**
 * 문제: 소수 찾기 (프로그래머스 - 완전탐색)
 * 
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 * 
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 * 
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/42839
 * 
 * numbers	return
 * "17"	    3
 * "011"	2
 * 
 * @author kimtaemin
 *
 */

public class Main {
	
	/*
	 * 1. String으로 들어온 문자열을 자리 별로 구분 지어 배열에 저장 
	 * 
	 * 2. 받아온 숫자로 구성할 수 있는 조합을 구함 (DFS 사용)
	 * 
	 * 3. 조합한 숫자가 소수인지 판별
	 *  
	 */

	
	static ArrayList<Integer> answerList = new ArrayList<>();
	
	public static void DFS(int L, int[] pm, char[] arr, int[] chk) {
		
		
		if(L == pm.length) { // 열의 크기가 레벨의 기준 
			int tempNum = 0;
			for(int num : pm) {
				tempNum = tempNum * 10 + num; //구한 조합을 숫자로 변환 
			}
			
			//소수인지 판별 
			primeCheck(tempNum);
			
		} else {
			for(int i=0; i<arr.length; i++) {
				if(chk[i] != 1 ) {
					pm[L] = arr[i]-48;
					chk[i] = 1; 
					DFS(L+1, pm, arr, chk);
					chk[i] = 0;
				}
			}
		}
	}
	
	public static void primeCheck(int num) {
		if(num <= 1) return;
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num % i == 0) return;
		}
		if(!answerList.contains(num)) answerList.add(num);
	}

	public static int solution(String numbers) {
        
        //중복을 막기 위한 체크 
        int[] chk = new int[numbers.length()];
        
        //순열 구성을 채워줄 DFS 
       for(int i=1; i<=numbers.length(); i++) {
    	   //순열을 담을 변수 , 한자리 수 조합부터 numbers.length 자리의 수 조합까지 모두 구해야 함. ex) 17 => 1, 7, 17, 71
    	   int[] pm = new int[i];
    	   DFS(0, pm, numbers.toCharArray(), chk);
       }
        
        return answerList.size();
    }
	
	public static void main(String[] args) {
		String numbers = "17";
		System.out.println("예상 Return 값: 3");
		System.out.println(solution(numbers));
		
		answerList.clear();
		
		numbers = "011";
		System.out.println("예상 Return 값: 2");
		System.out.println((solution(numbers)));

		
	}

}
