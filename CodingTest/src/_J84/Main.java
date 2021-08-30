package _J84;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 84. 최대 수입 스케줄 
 * 
 * 현수는 유명한 강연자이다. N개의 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.
 * 
 * 각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.
 * 
 * 단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.
 * 
 * [입력] 
 *  6
	50 2
	20 1
	40 2
	60 3
	30 3
	30 1

 * [출력] 
 * 150
 * 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

class Schedule implements Comparable<Schedule> {
	int pay;
	int dueDay;
	
	public Schedule(int pay, int dueDay) {
		this.pay = pay;
		this.dueDay = dueDay;
	}
	
	@Override
	public int compareTo(Schedule sc) {
		if(sc.dueDay == this.dueDay) return sc.pay - this.pay; //dueDay가 같은 경우 pay 내림차순 
		return sc.dueDay - this.dueDay; //dueDay 내림차순 
		
	}
}

public class Main {
	public static int maxDueDay;
	public static int n;
	
	public static int solution(ArrayList<Schedule> sl) {
		int answer = 0;
		// PriorityQueue => 가장 작은 값을 우선으로 poll, Collections.reverseOrder() 추가 시, 가장 큰 값을 우선으로 poll 
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		Collections.sort(sl);
		
		int j = 0;
		
		for(int i = maxDueDay; i >= 1; i--) {
			for(; j<n; j++) { //j의 값이 이어짐. 
				if(sl.get(j).dueDay<i) break; 
				pq.add(sl.get(j).pay); //후보 추가 
			}
			if(!pq.isEmpty()) answer += pq.poll(); // 가장 큰 페이를 저장 
		}
		return answer; 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		maxDueDay = 0;
		n = sc.nextInt();
		
		ArrayList<Schedule> sl = new ArrayList<>();
		
		// 강의 비용, 만료 일정 셋팅 
		for(int i=0; i<n; i++) {
			int tmpPay = sc.nextInt();
			int tmpDueDay = sc.nextInt();
			sl.add(new Schedule(tmpPay, tmpDueDay));
			maxDueDay = Math.max(maxDueDay, tmpDueDay);
		}
		
		System.out.println(solution(sl));
	}
}
