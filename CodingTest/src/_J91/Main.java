package _J91;

import java.util.Scanner;

/**
 * 91. 최대 점수 구하기 (냅색 알고리즘)  
 * 이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
 * 
 * 각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
 * 
 * 제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
 * 
 * (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)
 * 
 * [입력] 
 *  5 20
	10 5
	25 12
	15 8
	6 3
	7 4

 * [출력] 
 * 41
 * 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

/*
 * 문제를 중복해서 풀면 안 되기 때문에, 동전 교환과 다르게 뒤에서 부터 검사하도록 한다. 
 * 
 */
public class Main {
	public static int n, m; 
	
	public static String solution(String str) {
		String answer = "";
		
		return answer; 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //문제 갯수 
		m = sc.nextInt(); //주어진 시간 
		int[] dy = new int[m+1];
		
		for(int i=0; i<n; i++) {
			int ps = sc.nextInt(); //점수 
			int pt = sc.nextInt(); //시간
			for(int j=m; j>=pt; j--) {
				dy[j] = Math.max(dy[j], dy[j-pt]+ps); // 해당 문제를 푸는데 걸리는 시간을 차감한 시간에서 얻은 점수 + 풀고난 후 점수 
			}
		}
		System.out.println(dy[m]);
		
	}
}
