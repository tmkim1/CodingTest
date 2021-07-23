package _J51;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 51. 이분 검색  
 * 
 * [입력] 
 * 8 32
   23 87 65 12 57 32 99 81
   
 * [출력] 
 * 3
 * 
 * 참고: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	//이분 검색 
	//1. 정렬된 배열을 받는다. 
	//2. 가운데를 기준으로 반으로 나누면서 원하는 값을 찾을때까지 반복한다. 
	public static Integer solution(int target, int[] arr) {
		Integer answer = -1;
		Arrays.sort(arr);
		int lt = 0;
		int rt = arr.length-1;
		 
		
		
		while(lt <= rt) {
			int mid = (lt+rt)/2;
			if(arr[mid] == target) return mid+1;	 //값을 찾으면 return
			else if(arr[mid] > target) rt = mid -1;  //target보다 중간 값이 크다면 왼쪽을 탐색 해야하니 rt = mid-1로 설정 
			else lt = mid +1;                        //위와 반대인 경우 오른쪽을 탐색하도록 lt = mid+1
		}
		return answer; 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(solution(m, arr));
	}
}
