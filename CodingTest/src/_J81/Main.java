package _J81;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 81. 씨름 선수 
 * 
 * 현수는 씨름 감독입니다. 현수는 씨름 선수를 선발공고를 냈고, N명의 지원자가 지원을 했습니다.
 * 
 * 현수는 각 지원자의 키와 몸무게 정보를 알고 있습니다.
 * 
 * 현수는 씨름 선수 선발 원칙을 다음과 같이 정했습니다.
 * 
 * “A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은(크고, 무겁다) 지원자가
 * 
 * 존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.”
 * 
 * N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지 알아내는 프로그램을 작성하세요 
 * 
 * [입력] 
 *  5
	172 67
	183 65
	180 70
	170 72
	181 60

 * [출력] 
 *  3
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */
//키와 몸무게를 저장 Person

class Person implements Comparable<Person> {
	int height;
	int weight;
	
	public Person(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Person p) { //키를 기준으로 내림차순 
		return p.height - this.height;
	}
}

public class Main {
	public static int[][] arr;
	
	//O(n) 풀이 -> 키 순으로 정렬 후, 몸무게만 비교 
	public static int solution(ArrayList<Person> pl) {
		int answer = 0;
		int maxWeight = 0;
		//키를 기준으로 정렬 
		Collections.sort(pl);
		
		for(Person p : pl) {
			if(p.weight > maxWeight) {
				maxWeight = p.weight;
				answer ++;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = 0;
		ArrayList<Person> pl = new ArrayList<>();
		
		//선수 명단 셋팅 
		for(int i=0; i<n; i++) {
			int tmpHeight = sc.nextInt();
			int tmpWeight = sc.nextInt();
			pl.add(new Person(tmpHeight, tmpWeight));
		}
		
		//n^2 풀이 
		answer = pl.size();
		for(int i=0; i<pl.size(); i++) {
			for(Person ps : pl) {
				if(ps.height > pl.get(i).height && ps.weight > pl.get(i).weight) { 
					answer--;
					break;
				}
			}
		}
		
		System.out.println(answer);
		
		System.out.println(solution(pl));
	}
}
