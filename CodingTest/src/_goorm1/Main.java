package _goorm1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays; 

/**
 * [일반 프로그래밍 문제] 문제 선정하기 
 * 
 * N개의 문제가 주어지며 각 문제마다 LEVEL이 존재함 
 * 
 * 1 <= N, LEVEL <= 10 
 * 
 * 문제1 < 문제2 < 문제3 조건이 이루어 져야 함. 
 * 
 * 이때 주어진 문제와 레벨을 검사하여 3개의 문제를 이룰 수 있으면 YES 아니면 NO를 출력. 
 * 
 * 출처:구름 코딩 테스트 기출 문제 1 
 * @author kimtaemin
 *
 */
public class Main {
	
	public static void main(String[] args) throws Exception {
		//Scanner가 아닌 BufferedReader를 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] problem = new int[n];
		
		String Level = br.readLine();
		
		String[] split = Level.split(" ");
		
		for(int i=0; i<n; i++) {
			problem[i] = Integer.parseInt(split[i]);
		}
		
		// 문제 갯수를 얻었고 난이도도 얻었으니, 받은 10개의 문제가 3개의 난이도로 출제가 가능한지 확인. 
		// 오름차순 정렬 
		Arrays.sort(problem);
		
		// 맨 처음 요소는 cnt증감 여부 확인이 필요하지 않음. 
		int cnt = 1;
		int before = problem[0];
		
		for(int i=1; i<problem.length; i++) {
			if(cnt !=3 && problem[i] != before) {			// 오름 차순 정렬된 배열에서 이전 요소랑 값이 같지 않다는 것은 더 큰 값을 가지고 있다는 이야기 
				cnt ++; 						            // 조건에 만족하니 cnt를 늘려주고 before 값을 바꾸어준다. 
				before = problem[i];
			} else if (cnt == 3) {
				System.out.println("YES");
				break; 
			}
		}
		
		if(cnt < 3) System.out.println("NO");
		
		br.close();
	}

}
