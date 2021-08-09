package _J88;

import java.util.Scanner;

/**
 * 88. 계단 오르기 
 * 
 * 철수는 계단을 오를 때 한 번에 한 계단 또는 두 계단씩 올라간다. 만약 총 4계단을 오른다면 그 방법의 수는
 * 
 * 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2 로 5가지이다.
 * 
 * 그렇다면 총 N계단일 때 철수가 올라갈 수 있는 방법의 수는 몇 가지인가?
 * 
 * 
 * [입력] 
 * 7
 * 
 * [출력] 
 * 21
 * 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

/*
 * 피보나치와 거의 똑같은 문제 
 * 
 * DP로 해결 
 * 
 * 1, 2단계의 답을 먼저 구한 후에 하나씩의 문제로 간주하여 해결해 나가도록 한다. 
 * 
 * 이때 메모이제이션을 꼭 사용 
 * 
 */

public class Main {
	public static int[] arr;
	public static int solution(int s) {
		if(s == 1) return 1;
		if(s == 2) return 2;
		if(arr[s] != 0) return arr[s];
		return arr[s] = solution(s-2) + solution(s-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n+1];
		System.out.println(solution(n));
	}
}
