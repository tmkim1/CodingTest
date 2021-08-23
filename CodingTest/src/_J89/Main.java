package _J89;

import java.util.Scanner;

/**
 * 89. 최대 부분 증가 수열  
 * 
 * N개의 자연수로 이루어진 수열이 주어졌을 때, 그 중에서 가장 길게 증가하는(작은 수에서 큰 수로) 원소들의 집합을 찾는 프로그램을 작성하라.
 * 
 * 예를 들어, 원소가 2, 7, 5, 8, 6, 4, 7, 12, 3 이면 가장 길게 증가하도록 원소들을 차례대로 뽑아내면 2, 5, 6, 7, 12를 뽑아내어
 * 
 * 길이가 5인 최대 부분 증가수열을 만들 수 있다.
 * 
 * [입력] (3 <= n <= 1000) 
 *  8
	5 3 7 8 6 2 9 4
 * [출력] 
 *  4 (5, 7, 8, 9)
 * 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

/*
 * 순서를 유의해서 최대 부분 증가 수열을 찾아내야 함. 
 * 
 * 해당 원소가 마지막에 오는 경우로 최대 몇 까지 수열을 이룰 수 있는지 탐색 
 * ex) 2, 7, 5, 8, 6, 4, 7, 12, 3 
 * 
 * dy[0] = 1 (2) // 원소 2는 최대 길이 2를 갖는 지점에 속함을 의미      
 * dy[2] = 2 (2, 5)    // 원소 5는 최대 길이 2를 갖는 지점에 속함을 의미      
 * dy[4] = 3 (2, 5, 6) ...
 * 
 * 위와 같이 해당 원소가 가질수 있는 순번 최댓값을 찾고,
 * 
 * 각 원소마다 마지막에 배치된다는 걸 가정하에 최대 길이를 구한다. 
 * 
 * 글로만 봐서는 이해가 잘 안 되니 손코딩을 꼭 해보는걸 권장하는 문제 
 * 
 * 나보다 작은 값 중에서 최대값을 찾아서 +1 을 진행. 
 * 
 */

public class Main {
	public static int solution(int[] arr) {
		int answer = 0;
		int[] dy = new int[arr.length]; //각각 원소의 최대 부분 증가 수열을 도출하여 순번이 최댓값을 갖는 것을 탐색
		dy[0] = 1; //직관적인 답 도출이 가능한 경우 미리 셋팅 (첫번째 인덱스는 맨 첫 순서이기 떄문에, 1이 최댓값)
		for(int i=1; i<arr.length; i++) {
			int max = 0;
			for(int j=i; j>=0; j--) {
				if(arr[j] < arr[i] && dy[j] > max) max = dy[j]; //검사 항목보다 작은 값을 가진 경우만 수열 최댓값을 가져오도록
			}
			dy[i] = max+1;
			answer = Math.max(answer, dy[i]); //최대 수열 변경 및 확인 
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(solution(arr));
	}
}
