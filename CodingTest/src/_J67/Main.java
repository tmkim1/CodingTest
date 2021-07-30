package _J67;

import java.util.Scanner;

/**
 * 67. 바둑이 
 * 철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C킬로그램 넘게 태울수가 없다.
 * 철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.
 * N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.
 * 
 * [입력] 
 * 259 5
	81
	58
	42
	33
	61

 * [출력] 
 * 242
 * 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	public static int capWeight; //수용 가능 무게 
	public static int maxWeight; //가장 큰 무게 
	public static int n; //강아지 수 
	public static int[] arr; 
	public static int total;
	
	public static void DFS(int L, int totalSum) {
		
		if(totalSum > capWeight) return; //수용 가능 무게를 초과한 경우 return
		
		if(L == n) {
//			if(maxWeight <= totalSum) {
//				maxWeight = totalSum;
//			}
			maxWeight = Math.max(maxWeight, totalSum);
		} else {
			DFS(L+1, totalSum+arr[L]); // 포함 
			DFS(L+1, totalSum);        // 미포함 
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		capWeight = sc.nextInt();
		n = sc.nextInt();
		arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		DFS(0, 0);
		System.out.println(maxWeight);
	}
}
