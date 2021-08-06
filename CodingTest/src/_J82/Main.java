package _J82;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 82. 회의실 배정  
 * 
 * 한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들려고 한다.
 *
 * 각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.
 * 
 * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
 * 
 * [입력] 
 *  5
	1 4
	2 3
	3 5
	4 6
	5 7

 * [출력] 
 * 3
 * 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

/*
 * 끝나는 시간이 빠를수록 좋기 때문에 EndTime을 기준으로 정렬 (오름차순)
 * 아래와 같은 입력인 경우 오답이 발생하기 때문에 
 *  3
	3 3
	1 3
	2 3
	
 * + 끝나는 시간이 같은 경우 -> 시작 시간으로 정렬  
 */
class Time implements Comparable<Time>{
	int st;
	int et;
	
	public Time(int st, int et) {
		this.st = st;
		this.et = et;
	}
	
	@Override
	public int compareTo(Time t) {
		if(this.et == t.et) return this.st - t.st;
		return this.et - t.et; 
	}
	
}

public class Main {
	
	public static int solution(ArrayList<Time> tl) {
		int answer = 0;
		int maxEt = 0;
		
		//종료 시간 기준 오름 차순 
		Collections.sort(tl);
		
		for(Time t : tl) {
			if(maxEt <= t.st) {
				answer++;
				maxEt = t.et;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Time> tl = new ArrayList<Time>();
		
		for(int i=0; i<n; i++) {
			int tmpSt = sc.nextInt();
			int tmpEt = sc.nextInt();
			tl.add(new Time(tmpSt, tmpEt)); 
		}
		
		System.out.println(solution(tl));
	}
}
