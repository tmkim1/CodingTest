package _J33;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 33. 매출액 종류 구하기    
 * 
 * 문제 설명: 현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를
 * 각 구간별로 구하라고 했습니다.
 * 만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
 * 20 12 20 10 23 17 10
 * 각 연속 4일간의 구간의 매출종류는
 * 첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
 * 두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
 * 세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
 * 네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
 * N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별
 * 매출액의 종류를 출력하는 프로그램을 작성하세요.
 * 
 * [입력] 
 *  9 4
	20 12 20 10 23 17 10 11 11 
	
 * [출력] 
 * 3 4 4 3
 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * @author kimtaemin
 */

public class Main {
	
	//내 풀이 
	public static void solution(int totalNum, int contNum, int[] arr) {
		int lt = 0;
		int rt = contNum-1;
		int[] result = new int[arr.length-contNum+1];	//ex) 7일 근무 4일 연속인 경우 총 4가지의 결과 값이 나옴 
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		//Sliding Window 주어진 크기만큼 초기 셋팅 
		for(int i=0; i<contNum; i++) {
			hm.put(arr[i], (hm.getOrDefault(arr[i], 0)+1));
		}
		result[0] = hm.size();
		rt++;
		
		//sliding window 이동 
		while(rt < arr.length) {
			
			//Sliding 가장 좌측에 있는 값 제거 
			hm.put(arr[lt], (hm.get(arr[lt])-1));
			
			//lt 값 -1 만약 0이 된다면 remove 해서 size에 안 잡히도록 한다. 
			if(hm.get(arr[lt]) == 0) {
				hm.remove(arr[lt++]);
			}
			
			hm.put(arr[rt], (hm.getOrDefault(arr[rt++], 0) + 1));
			result[lt] = hm.size(); 
		}
		
		for(int c : result) {
			System.out.print(c + " ");
		}
		
	}
	
	public static void main(String[] args) {
		int totalNum = 0, contNum = 0;
		Scanner sc = new Scanner(System.in);
		
		totalNum = sc.nextInt();
		contNum = sc.nextInt();
		
		int[] arr = new int[totalNum];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		solution(totalNum, contNum, arr);
	}
}
