package _ect3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * [그리디 알고리즘] - 큰 수의 법칙 
 * 다양한 수로 이루어진 배열이 주어짐. 
 * M번을 더하여 가장 큰 수 만들기. 
 * 단, 특정한 인덱스의 수가 연속해서 K번을 초과하여 더할수 없음. 
 * 
 * ex) 2,4,5,4,6 // M = 8, K = 3  
 * 6+6+6+5+6+6+6+5 = 46 
 * 
 *  * 참조 강의 - 이코테
 * @author kimtaemin
 *
 */
public class Main2 {
	
	public static void main(String[] args) {
		int[] arr = {2,4,5,4,6};
		solution(arr,8,3);
		solution(arr,10,3);
		solution2();
	}
	
	/**
	 * 내 풀이 
	 * Point: 가장 큰 수를 사용해야 함
	 * 배열 중 가장 큰 2개의 값을 찾는다. 
	 * 
	 * 1. 가장 큰 수를 찾는다
	 * 2. K번 만큼 더하고
	 * 3. 다음 큰 수를 찾는다 
	 * 4. 1번만 더 하고 다시 1번으로 돌아가 K번 만큼 + 될때까지 반복 
	 * @param arr
	 */
	public static void solution(int[] arr, int m, int k) {
		int maxNum = 0, secondNum = 0, sum = 0, cnt = 0; 
		
		// 가장 큰 값 2개 구하기 위함. 
		for(int n : arr) {
			if(n > maxNum) {
				secondNum = maxNum;
				maxNum = n;
			} else if(n > secondNum) {
				secondNum = n;
			}
		}
		
		for(int i=0; i<m; i++) { // m번 만큼 더해야 하기 때문에 m번 만큼 반복 
			if(cnt < k) {
				sum += maxNum;
				cnt++;
			} else {
				sum += secondNum; // 딱 한번만 2번째로 큰 값을 더하고, 다시 cnt (k반복 검열 인덱스) 0으로 초기화 
				cnt = 0; 
			}
		}
		
		System.out.println("최종 값: " + sum);
	}
	
	/**
	 * 교재 풀이
	 */
	
	public static void solution2() {
		Scanner sc = new Scanner(System.in);
		
		// N, M, K를 공백을 기준으로 구분하여 입력 받기 
		int n = sc.nextInt();	// 배열 크기 
		int m = sc.nextInt();	// + 해줄 횟수 
		int k = sc.nextInt();   // 한 인덱스 최대 반복 횟수 
		
		// N개의 수를 공백을 기준으로 구분하여 입력 받기 
		int[] arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		// * 가장 큰 수 2개를 찾기 위해 Arrays.sort(arr) 메서드를 활용
		Arrays.sort(arr);
		int first = arr[n-1];
		int second = arr[n-2];
		
		// 가장 큰 수가 더해지는 횟수 계산, 보고나면 이해는 가는데 이런 식의 계산을 어떻게 도출 해내는지 수학적 아이디어를 이용해야 함. 
		// 수학적 아이디어를 얻기 위해서는 ==> 반복되는 수열에 대해서 파악 
		
		int cnt = (m / (k+1)) * k; 	//k만큼 더 하고 2번쨰 값 더하는 +1 횟수를 합쳐주고 
		cnt += m % (k + 1);         //2번째 값 + 없이 도중에 잘릴수 있으니 나머지 값을 추가로 + 
		
		int result = 0;
		result += cnt * first;
		result += (m-cnt) * second;
		System.out.println(result);
		
	}

}
