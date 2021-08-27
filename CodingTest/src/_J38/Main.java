package _J38;

import java.util.Scanner;
import java.util.Stack;

/**
 * 38. 크레인 인형뽑기 게임 (카카오)
 * 
 * 문제 설명: 게임 화면은 1 x 1 크기의 칸들로 이루어진 N x N 크기의 정사각 격자이며 위쪽에는 크레인이 있고 오른쪽에는 바구니가 있습니다.
 * (위 그림은 5 x 5 크기의 예시입니다). 각 격자 칸에는 다양한 인형이 들어 있으며 인형이 없는 칸은 빈칸입니다.
 * 모든 인형은 1 x 1 크기의 격자 한 칸을 차지하며 격자의 가장 아래 칸부터 차곡차곡 쌓여 있습니다.
 * 게임 사용자는 크레인을 좌우로 움직여서 멈춘 위치에서 가장 위에 있는 인형을 집어 올릴 수 있습니다. 집어 올린 인형은 바구니에 쌓이게 되는 데,
 * 이때 바구니의 가장 아래 칸부터 인형이 순서대로 쌓이게 됩니다.
 * 다음 그림은 [1번, 5번, 3번] 위치에서 순서대로 인형을 집어 올려 바구니에 담은 모습입니다.
 * 
 * 크레인 작동 시 인형이 집어지지 않는 경우는 없으나 만약 인형이 없는 곳에서 크레인을 작동시키는 경우에는 아무런 일도 일어나지 않습니다.
 * 또한 바구니는 모든 인형이 들어갈 수 있을 만큼 충분히 크다고 가정합니다. (그림에서는 화면표시 제약으로 5칸만으로 표현하였음)
 * 게임 화면의 격자의 상태가 담긴 2차원 배열 board와 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves가 매개변수로 주어질 때,
 * 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 구하는 프로그램을 작성하세요.

 * [입력] 
 *  5
	0 0 0 0 0
	0 0 1 0 3
	0 2 5 0 1
	4 2 4 4 2
	3 5 1 3 1
	8
	1 5 3 5 1 2 1 4

 * [출력] 
 * 4
 * 
 * [관련 메서드] 
 * stack.peek() 값을 뺴지는 않고 가장 상단에 있는 애를 가져온다 stack.get(stack.length-1) 대신 사용이 가능 
 * 
 * 출처: 2019 카카오 개발자 겨울 인턴십 문제 
 * 참고: 인프런 자바 알고리즘 문제풀이, https://programmers.co.kr/learn/courses/30/lessons/64061
 * 
 * @author kimtaemin
 */

// 내 풀이 
public class Main {
		public static int solution(int[][] board, int[] moves) {
			int answer = 0;
			
			Stack<Integer> stack = new Stack<>();
			
			for(int m : moves) {
				for(int j=0; j<board.length; j++) { // 해당 줄의 크기 만큼 돌게하고,
					// 맨 마지막부터 순차적으로 도는데 x면 무시-> push하면 기존 값 x처리
					int target = board[j][m-1];
					if(target != 0) {
						if(!stack.isEmpty() && stack.peek() == target) {	//target과 같은 인형이라면 제거하고 answer += 2;
							stack.pop();            //stack에 있던 target과 같은 인형도 없어지며,
							board[j][m-1] = 0;      //인형을 뽑았으니 target 자리도 0으로 만들어주고,
							answer += 2;            //사라진 인형 2개에 대한 카운트 처리 
							break;
						} else {					//아니라면 인형을 stack에 추가하고 기존 배열에 값은 0으로 변경 
							stack.push(target);
							board[j][m-1] = 0;
							break;
						}
					}
				}
			}
			return answer;
		}
	
	    public static void main(String[] args) {
	    	Scanner sc = new Scanner(System.in);
	    	int n = sc.nextInt();
	    	int[][] board = new int[n][n];
	    	
	    	for(int i=0; i<n; i++) {
	    		for(int j=0; j<n; j++) {
	    			board[i][j] = sc.nextInt();
	    		}
	    	}
	    	
	    	int m = sc.nextInt();
	    	int[] moves = new int[m];
	    	for(int i=0; i<m; i++) {
	    		moves[i] = sc.nextInt();
	    	}
	    	
	    	System.out.println(solution(board, moves));
	    	
	    }
}
