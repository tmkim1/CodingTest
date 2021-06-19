package _ect2;

import java.util.Scanner;

/**
 * 문제) 1이 될때까지 
 * 첫째 줄에 N(1 <= N <= 100,000)과 K(2 <= K <= 100,000)가 공백을 기준으로 자연수로 주어짐. 
 * 1. N에서 1을 뺸다.
 * 2. N을 K로나눈다 
 * 첫쨰 줄에 N 1이 되기까지 1~2번의 과정 최소 횟수를 구하라. 
 * 예시) 25, 5     출력) 2 
 * 참조 강의 - 이코테
 * @author kimtaemin
 *
 */
public class Main {
	public static void main(String[] args) {
		// 고민: N을 1로 뺀후에 K로 딱 나누어 떨어지는지 확인해야함. 
		// 딱 나누어 떨어지지 않는다면 -1을 해줘야 함
		// key point: 1로 뺴는 것보다 K로 나누는 것이 우선되어야 함.
		solution(25,5);    //답: 2
		solution(25,3);    //답: 6
		
		//강의 풀이 
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int result = 0; // cnt
		
		while(true) {
			//N이 K로 나누어 떨어지는 수가 될때까지 빼기, (n/k)하면 나누어 지지 않은 소수가 떨궈지기 떄문 
			int target = (n/k) * k;            
			result += (n - target);
			n = target;
			//N이 K보다 작을 때 (더 이상 나눌 수 없을때) 반복문 탈출
			if(n < k) break;
			//k로 나누기 
			result += 1;
			n /= k;
		}
		// 마지막으로 남은 수에 대하여 1씩 빼기
		result += (n-1);
		System.out.println(result);
		
		
	}
	
	//내 풀이
	public static void solution(int num1, int num2) {
		int cnt = 0;
		
		while(num1 != 1) {
			if(num1 % num2 == 0) {
				num1 = num1 / num2;    // 딱 나누어 떨어진다면 바로 나눠준 후 수행한 횟수가 되는 몫을 카운트로 추가
				cnt++;
			} else {
				num1--;                // 딱 나누어 떨어지지 않는다면 -1수행 후 cnt++ 
				cnt++; 
			}
		}
		System.out.println("총 수행 횟수: " + cnt);
	}
}
