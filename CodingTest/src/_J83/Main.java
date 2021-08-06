package _J83;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 83. 결혼식 
 * 
 * 현수는 다음 달에 결혼을 합니다.
 * 
 * 현수는 결혼식 피로연을 장소를 빌려 3일간 쉬지 않고 하려고 합니다.
 * 
 * 피로연에 참석하는 친구들 N명의 참석하는 시간정보를 현수는 친구들에게 미리 요구했습니다.
 * 
 * 각 친구들은 자신이 몇 시에 도착해서 몇 시에 떠날 것인지 현수에게 알려주었습니다.
 * 
 * 현수는 이 정보를 바탕으로 피로연 장소에 동시에 존재하는 최대 인원수를 구하여 그 인원을 수용할 수 있는 장소를 빌리려고 합니다. 여러분이 현수를 도와주세요.
 * 
 * 만약 한 친구가 오는 시간 13, 가는시간 15라면 이 친구는 13시 정각에 피로연 장에 존재하는 것이고 15시 정각에는 존재하지 않는다고 가정합니다.
 * 
 * [입력] 
 *  5
	14 18
	12 15
	15 20
	20 30
	5 14

 * [출력] 
 * 2
 * 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

class Time implements Comparable<Time>{
	int time;
	char type;
	public Time(int time, char type) {
		this.time = time;
		this.type = type;
	}
	
	//시간과 타입을 구분하여 정렬한 후 동시에 결혼식장에 존재하는 인원을 찾아야 함. 
	@Override
	public int compareTo(Time t) {
		if(this.time == t.time) return this.type - t.type;
		return this.time - t.time; 
	}
}

public class Main {
	public static int solution(ArrayList<Time> tl) {
		int answer = 0;
		int maxCnt = 0;
		
		Collections.sort(tl);
		
		for(Time t : tl) {
			if(t.type == 'e') { //t.type == 'e' 나가는 시간이, 들어오는 시간보다 먼저 처리 되어야 함. 
				maxCnt --;
			} else {
				maxCnt ++;      //t.type == 's' 인 경우는 새로운 사람이 들어온 것을 뜻함. 인원 추가 후, 동시 최대 인원수인지 확인 후 값 변경 
				answer = Math.max(answer, maxCnt);
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		ArrayList<Time> tl = new ArrayList<>();
	
		for(int i=0; i<n; i++) {
			int tmpSt = sc.nextInt();
			tl.add(new Time(tmpSt, 's'));
			
			int tmpEt = sc.nextInt();
			tl.add(new Time(tmpEt,'e'));
		}
		
		System.out.println(solution(tl));
		
	}
}
