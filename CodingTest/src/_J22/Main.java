package _J22;

import java.util.Scanner;

/**
 * 22. 봉우리 개수 구하기     
 * 
 * 문제 설명: 지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
 * 각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
 * 격자의 가장자리는 0으로 초기화 되었다고 가정한다.
 * 만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.
 * 
 * [입력] 
 *  5
	5 3 7 2 3
	3 7 1 6 1
	7 2 5 3 4
	4 3 6 4 1
	8 7 3 5 2
	
 * [출력]
 * 10
 * 출처: 인프런 자바 알고리즘 문제풀이
 * @author kimtaemin
 */

public class Main {

	//내 풀이 
	public static void solution(int n, int[][] numArr) {
		//미리 0을 채워 넣으면 가장 편하겠지만 공간 낭비가 생기니 채워 넣지 않고 풀어보자. 
		int answer = 0;
		boolean chk;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				chk = true;
				//최상단은 상 검사 불필요, 최하단은 하 검사 불필요 
				//맨 좌측(i==0)은 왼쪽 검사 불필요, 맨 우측(i==n-1)은 오른쪽 검사 불필요 
//				if(j == 0 && numArr[i][j] > numArr[i][j+1]) answer++; 	
//				else if(j == n-1 && numArr[i][j] > numArr[i][j-1]) answer++;
//				else if(j > 0 && j < n-1 && numArr[i][j] > numArr[i][j+1] && numArr[i][j] > numArr[i][j-1]) answer++;
				int currentNum = numArr[i][j];
				// 맨 위에 자리가 아니라면 위에 항목 검사, 맨 아래 자리가 아니라면 아래 항목 검사 -> 이런 식으로 처리하는게 더 효율적!  
				if(i > 0 && currentNum <= numArr[i-1][j]) chk = false;  
				if(i < n-1 && currentNum <= numArr[i+1][j]) chk = false;  
				if(j > 0 && currentNum <= numArr[i][j-1]) chk = false;  
				if(j > n-1 && currentNum <= numArr[i][j+1]) chk = false;
				
				if(chk) answer ++;
				
			}
		}
		System.out.println(answer);
	}

	//강의 답안 --> 상하좌우 좌표를 만드는 값을 배열에 담아 처리 
	
	public static void solution2(int n, int[][] arr) {
		int answer = 0;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				boolean flag = true;
				for(int k=0; k<4; k++) {
					int nx = i+dx[k];
					int ny = j+dy[k];
					if(nx>=0 && nx <n && ny>=0 && ny<n && arr[nx][ny] >= arr[i][j]) {
						flag=false;
						break;
					}
				}
				if(flag) answer++;
			}
		}
		System.out.println(answer);
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] numArr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				numArr[i][j] = sc.nextInt();
			}
		}
		solution(n, numArr);
		solution2(n, numArr);
	}

}
