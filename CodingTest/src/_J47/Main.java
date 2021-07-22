package _J47;

import java.util.Scanner;

/**
 * 47. LRU
 * 
 * 캐시메모리는 CPU와 주기억장치(DRAM) 사이의 고속의 임시 메모리로서 CPU가 처리할 작업을 저장해 놓았다가
 * 
 * 필요할 바로 사용해서 처리속도를 높이는 장치이다. 워낙 비싸고 용량이 작아 효율적으로 사용해야 한다.
 * 
 * 철수의 컴퓨터는 캐시메모리 사용 규칙이 LRU 알고리즘을 따른다.
 * 
 * LRU 알고리즘은 Least Recently Used 의 약자로 직역하자면 가장 최근에 사용되지 않은 것 정도의 의미를 가지고 있습니다.
 * 
 * 캐시에서 작업을 제거할 때 가장 오랫동안 사용하지 않은 것을 제거하겠다는 알고리즘입니다.
 * 
 * 캐시의 크기가 주어지고, 캐시가 비어있는 상태에서 N개의 작업을 CPU가 차례로 처리한다면 N개의 작업을 처리한 후
 * 
 * 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램을 작성하세요.
 * 
 * [입력] 
 * 5 9
   1 2 3 2 6 2 3 5 7

 * [출력] 
 * 7 5 3 2 6
 * 
 * 
 * 참고: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	
	//1. 배열 안에 해당 값이 존재하지 않는 경우 -> size-1부터 0까지 우측으로 1씩 이동 -> 해당 값은 맨 앞 인덱스에 위치 
	//2. 배열 안에 해당 값이 존재한는 경우 -> 해당 값 위치 -1부터 우측으로 1씩 이동 -> 해당 값은 맨 앞 인덱스에 위치 
	public static int[] solution(int size, int n, int[] arr) {
		int[] cache = new int[size];
		int temp = 0;
		
		//process 호출 수 만큼 반복 
		for(int num : arr) {
			int pos = -1;
			
			for(int i=0; i<size; i++) if(num == cache[i]) pos=i; 
			
			if((pos == -1)) { //기존 캐시 메모리에 없는 경우: 전체 다 우측으로 밀고 0번 인덱스에 추가 
				for(int i=cache.length-1; i>=1; i--) {
					cache[i] = cache[i-1];
				}
			} else {         // 캐시 메모리에 있는 경우: 기존 위치까지만 우측으로 밀고 0번 인덱스에 추가 
				for(int i=pos; i>=1; i--) {
					cache[i] = cache[i-1];
				}
			}
			
			cache[0] = num;
		}
		return cache; 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int num : solution(size, n, arr)) {
			System.out.print(num + " ");
		}
	}
}
