package _J27;

import java.util.Scanner;

/**
 * 27. 최대 매출 구하기 
 * 
 * 문제 설명: 현수의 아빠는 제과점을 운영합니다. 
 * 
 * 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
 * 
 * 만약 N=10이고, 10일 간의 매출 기록이 아래와 같습니다. 이때 K=3이면
 * 
 * 12 15 11 20 2510 20 19 13 15
 * 
 * 연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
 * 
 * [입력] 
 *  10 3
	12 15 11 20 25 10 20 19 13 15
	
 * [출력] 
 *  56
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * @author kimtaemin
 */

public class Main {
	
	// 내 풀이: 이중 for문 사용에 따른 타임 아웃 발생 
	public static void solution(int totalDay, int contDay, int[] arr) {
		int maxSum = 0;
		int tempSum = 0;
		for(int i=0; i<arr.length-contDay; i++) {	// 전체 길이의 연속된 날짜를 뺸만큼 까지만 반복문이 돌면 된다. 
			for(int j=0; j<contDay; j++) {          // 연속된 일 수 만큼 누적 합이 반복 되기 떄문에 연속일을 반복 조건으로 사용하며  
				tempSum += arr[i+j];		// 현재 위치에서 연속일 수 만큼을 누적으로 더 해주도록 한다.  
			}
			if(tempSum > maxSum) maxSum = tempSum;  // 값을 비교하여 연속 최대 매출액을 결정한다. 
			tempSum = 0;
		}
		System.out.println(maxSum);
 	}
	
	//강의 답안: sliding window 사용 
	public static void solution2(int totalDay, int contDay, int[] arr) {
		int answer = 0, tempSum = 0;
		for(int i=0; i<contDay; i++) tempSum += arr[i]; 
		answer = tempSum;
	
		for(int i=0; i<arr.length-contDay; i++) {	// 전체 길이의 연속된 날짜를 뺸만큼 까지만 반복문이 돌면 된다. 
			tempSum -= arr[i];  			        // sliding window 영역에서 기존 첫번쨰 요소를 제거
			tempSum += arr[i+contDay];          	// sliding window 영역에서 새로운 요소를 추가 
			answer = Math.max(answer, tempSum);
		}
		System.out.println(answer);
 	}
	
	public static void solution3(int totalDay, int contDay, int[] arr) {
		int answer = 0, tempSum = 0;
		for(int i=0; i<contDay; i++) tempSum += arr[i]; //연속 일 총 합 초기 셋팅 
		answer = tempSum;
		
		for(int i=0; i<totalDay - contDay; i++) {
			tempSum -= arr[i];
			tempSum += arr[i+contDay];
			Math.max(answer, tempSum);
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalDay;
		int contDay; 
		totalDay = sc.nextInt();
		contDay = sc.nextInt();
		int[] arr = new int[totalDay];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		solution2(totalDay, contDay, arr);
		solution3(totalDay, contDay, arr);
		
	}
}
