package _J48;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 48. 중복 확인 
 * 
 * 배열에 중복된 배열이 있는지 확인하여 존재하면 D 출력 
 * 
 * 현수네 반에는 N명의 학생들이 있습니다.
 * 
 * 선생님은 반 학생들에게 1부터 10,000,000까지의 자연수 중에서 각자가 좋아하는 숫자 하나 적어 내라고 했습니다.
 * 
 * 만약 N명의 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D(duplication)를 출력하고,
 * 
 * N명이 모두 각자 다른 숫자를 적어냈다면 U(unique)를 출력하는 프로그램을 작성하세요.
 * 
 * [입력] 
 * 8
   20 25 52 30 39 33 43 33

 * [출력] 
 * D
 * 
 * 
 * 참고: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	
	//1. 전체 배열의 값을 순회
	//2. 순회하며 중복이 있는지 체크 ==> 중복이 있으면 return 'D'
	public static char solution(int size, int[] arr) {
		char answer = 'U';
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {   //이미 확인된 i 이전 인덱스는 무시 해도 되기 때문에 j=i+1로 지정 
				if(arr[i] == arr[j]) return 'D';
			}
		}
		
		return answer; 
	}
	
	// 정렬 후, 확인 
	public static char solution2(int size, int[] arr) {
		char answer = 'U';
		Arrays.sort(arr);
		
		for(int i=0; i<arr.length-1; i++) {
				if(arr[i] == arr[i+1]) return 'D';
		}
		
		return answer; 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(solution(size, arr));
		System.out.println(solution2(size, arr));
	}
}
