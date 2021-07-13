package _J25;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 25. 두 배열 합치기  
 * 
 * 문제 설명: 정렬 된 2개의 배열을 합쳐서 정렬하시오. 
 * 
 * [입력] 
 * 3
   1 3 5
   5
   2 3 6 7 9
 * [출력] 
 * 1 2 3 3 5 6 7 9
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * @author kimtaemin
 */

public class Main {
 
	//내 풀이 
	public static void solution(int n, int m, int[] firstArr, int[] secondArr) {
		int p1=0, p2=0;
		int[] mergeArr = new int[n+m];	//첫번째 배열과 두번째 배열을 합치기 때문에 새로우 배열에 전체 length도 2개의 배열 크기를 더한 값으로 생성
		
		for(int i=0; i<n+m; i++) {
			
			if(p1 == firstArr.length) {
				while(p2 < secondArr.length) {
					mergeArr[i] = secondArr[p2];
					p2++;
					i++;
				}
				break;
			} else if(p2 == secondArr.length) {
				while(p1 < firstArr.length) {
					mergeArr[i] = firstArr[p1];
					p1++;
					i++;
				}
				break;
			}
			
			if(firstArr[p1] < secondArr[p2]) {
				mergeArr[i] = firstArr[p1];
				p1++;
			} else {
				mergeArr[i] = secondArr[p2];
				p2++;
			}
			
		}
		
		for(int num : mergeArr) {
			System.out.print(num + " ");
		}
	}
	
	//강의 답안 
	public static void solution2(int n, int m, int[] a, int[] b) {
		int p1=0, p2=0;
		ArrayList<Integer> answer = new ArrayList<>();
		
		while(p1<n && p2<m) {				//two pointes 사용
			if(a[p1]<b[p2]) answer.add(a[p1++]);	//더 작은 값을 List에 추가하고 더 작은 쪽의 pointer 값을 1 증가 
			else answer.add(b[p2++]);
		}
		
		while(p1<n) answer.add(a[p1++]);		//아직 정리 되지 않은 채 남아 있는 값들에 대한 처리
		while(p2<m) answer.add(b[p2++]);
		
		for(int num : answer) {
			System.out.print(num + " ");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] firstArr = new int[n];
		
		for(int i=0; i<n; i++) {
			firstArr[i] = sc.nextInt();
		}
		
		int m = sc.nextInt();
		int[] secondArr = new int[m];
		
		for(int i=0; i<m; i++) {
			secondArr[i] = sc.nextInt();
		}
		
		solution(n, m, firstArr, secondArr);
		System.out.println("");
		solution2(n, m, firstArr, secondArr);
	}
	
	

}
