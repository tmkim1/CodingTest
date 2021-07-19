package _J41;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 41. 공주 구하기 
 * 정보 왕국의 이웃 나라 외동딸 공주가 숲속의 괴물에게 잡혀갔습니다.
 * 
 * 정보 왕국에는 왕자가 N명이 있는데 서로 공주를 구하러 가겠다고 합니다.
 * 
 * 정보왕국의 왕은 다음과 같은 방법으로 공주를 구하러 갈 왕자를 결정하기로 했습니다.
 * 
 * 왕은 왕자들을 나이 순으로 1번부터 N번까지 차례로 번호를 매긴다.
 * 
 * 그리고 1번 왕자부터 N번 왕자까지 순서대로 시계 방향으로 돌아가며 동그랗게 앉게 한다.
 * 
 * 그리고 1번 왕자부터 시계방향으로 돌아가며 1부터 시작하여 번호를 외치게 한다.
 * 
 * 한 왕자가 K(특정숫자)를 외치면 그 왕자는 공주를 구하러 가는데서 제외되고 원 밖으로 나오게 된다.
 * 
 * 그리고 다음 왕자부터 다시 1부터 시작하여 번호를 외친다.
 * 
 * 이렇게 해서 마지막까지 남은 왕자가 공주를 구하러 갈 수 있다.
 * 
 * 예를 들어 총 8명의 왕자가 있고, 3을 외친 왕자가 제외된다고 하자. 처음에는 3번 왕자가 3을 외쳐 제외된다.
 * 
 * 이어 6, 1, 5, 2, 8, 4번 왕자가 차례대로 제외되고 마지막까지 남게 된 7번 왕자에게 공주를 구하러갑니다.
 * 
 * [입력] 
 * 8 3

 * [출력] 
 * 7
 * 
 * 참고: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	
	//n: 왕자의 수, 배열의 크기, k: 제외 될 인덱스 값 
	//내 풀이: stack 구현 
	public static int solution(int n, int k) {
		int cnt = 0;

		Stack<Integer> stack = new Stack<>();
		
		for(int i=n; i>0; i--) {
			stack.push(i);			//작은 수가 위로 올라와야 순서대로 조절하기 편함. 
		}
		
		while(stack.size() > 1) {   //왕자가 1명만 남을때까지 반복
			
			for(int i=stack.size()-1; i>-1; i--) {
				cnt++;
				if(cnt == k) {
					stack.remove(i); //제외 인덱스에 걸렸다면 제거
					cnt = 0;         //1명 제외 했으니 다시 cnt = 0 초기화 
				}
			}
		}
		
		return stack.pop();
	}
	
	//답안: Queue 사용 
	public static int solution2(int n, int k) {
		int answer = 0;
		Queue<Integer> Q = new LinkedList<>();
		
		for(int i=1; i<=n; i++) {
			Q.offer(i);
		}
		
		while(!Q.isEmpty()) {
			for(int i=1; i<k; i++) Q.offer(Q.poll()); //맨 좌측 값을 꺼내서 맨 우측에 넣는다.
			Q.poll();                                 //제외 대상은 Queue에서 완전히 제거 
			if(Q.size() == 1) answer = Q.poll();
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int n=0, k=0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		System.out.println(solution(n, k));
		System.out.println(solution2(n, k));
	}
}
