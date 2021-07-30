package _J66;

import java.util.Scanner;

/**
 * 66. 합이 같은 부분집합 (DFS: 아마존 인터뷰) 
 * 
 * N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때
 * 
 * 두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면 ”NO"를 출력하는 프로그램을 작성하세요.
 * 
 * 둘로 나뉘는 두 부분집합은 서로소 집합이며, 두 부분집합을 합하면 입력으로 주어진 원래의 집합이 되어 합니다.
 * 
 * 예를 들어 {1, 3, 5, 6, 7, 10}이 입력되면 {1, 3, 5, 7} = {6, 10} 으로 두 부분집합의 합이 16으로 같은 경우가 존재하는 것을 알 수 있다.
 * 
 * [입력] 
 * 첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
 * 두 번째 줄에 집합의 원소 N개가 주어진다. 각 원소는 중복되지 않는다.
 * 
 * 6
   1 3 5 6 7 10 

 * [출력] 
 * YES
 * 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	public static int n;
	public static int totalSum = 0;
	public static String answer = "NO";
	
	public static void DFS(int L, int sum, int[] arr) {
		
		if(answer == "YES") return; //마지막 노드에 도달하면 chk[]를 검사하며 출력    
		if(sum > (totalSum/2)) return; //이미 지정 값을 넘어선 경우는 검사 할 필요 없음 
		
//		if(L == n && sum == (totalSum - sum)) {
//			answer = "YES";
		if(L == n) {
			if(sum == totalSum - sum) {
				answer = "YES";
			}
		} else {
			DFS(L+1, sum + arr[L], arr); // 해당 Level 원소를 sum에 포함하는 경우 
			DFS(L+1, sum, arr); //포함하지 않는 경우 
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //원소 갯수 
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			totalSum += arr[i];
		}
		
		DFS(0, 0, arr);
		System.out.println(answer);
		
	}
}
