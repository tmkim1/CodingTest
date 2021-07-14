package _J35;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 35. k번쨰 큰 숫자 합 찾기       
 * 
 * 문제 설명: 
 * 현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.
 * 현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.
 * 기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.
 * 만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.
 * 
 * [입력] 
 *  10 3
	13 15 34 23 45 65 33 11 26 42

 * [출력] 
 * 143
 * 
 * 경우의 수 구하기, TreeSet 활용 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * @author kimtaemin
 */

public class Main {
	
	public static void solution(int n, int k, int[] arr) {
		TreeSet<Integer> ts = new TreeSet<>(Collections.reverseOrder()); //큰 수가 위로 와야 하기 때문에 reverseOrder
		
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				for(int p=j+1; p<n; p++) {
					ts.add(arr[i]+arr[j]+arr[p]);
				}
			}
		}
		
		int cnt = 0;
		for(int num : ts) {
			cnt++;
			if(cnt == k) System.out.print(num);
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=0, k=0;
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		solution(n, k, arr);
	}
}
