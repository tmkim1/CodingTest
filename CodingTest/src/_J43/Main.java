package _J43;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 43. 응급실 
 * 
 * 메디컬 병원 응급실에는 의사가 한 명밖에 없습니다.
 * 
 * 응급실은 환자가 도착한 순서대로 진료를 합니다. 하지만 위험도가 높은 환자는 빨리 응급조치를 의사가 해야 합니다.
 * 
 * 이런 문제를 보완하기 위해 응급실은 다음과 같은 방법으로 환자의 진료순서를 정합니다.
 * 
 * • 환자가 접수한 순서대로의 목록에서 제일 앞에 있는 환자목록을 꺼냅니다.
 * 
 * • 나머지 대기 목록에서 꺼낸 환자 보다 위험도가 높은 환자가 존재하면 대기목록 제일 뒤로 다시 넣습니다. 그렇지 않으면 진료를 받습니다.
 * 
 * 즉 대기목록에 자기 보다 위험도가 높은 환자가 없을 때 자신이 진료를 받는 구조입니다.
 * 
 * 현재 N명의 환자가 대기목록에 있습니다.
 * 
 * N명의 대기목록 순서의 환자 위험도가 주어지면, 대기목록상의 M번째 환자는 몇 번째로 진료를 받는지 출력하는 프로그램을 작성하세요.
 * 
 * 대기목록상의 M번째는 대기목록의 제일 처음 환자를 0번째로 간주하여 표현한 것입니다.
 * 
 * [입력] 
 * 5 2
   60 50 70 80 90

 * [출력] 
 * 3
 * 
 * 
 * 참고: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	
	/*
	 * 1. 순서대로 Q에 대입 
	 * 2. 우선순위가 더 높은 환자가 있으면 맨 뒤로 이동 
	 * 3. m번째 환자가 치료 될때까지 반복 
	 */
	public static int solution(int n, int targetNum, int[] arr) {
		int answer = 0;
		boolean chk = false;
		int cnt = 0;
		
		Queue<Patient> Q = new LinkedList<>();
		
		for(int i=0; i<arr.length; i++) {
			Patient patient = new Patient(i,arr[i]);
			Q.add(patient);
		}
		
		//Q값 확인 
//		for(Patient p : Q) {
//			System.out.println("환자 순번: " +p.num+ "위험도: " + p.risk);
//		}
		
		while(true) {
			Patient tmpTarget = Q.peek();
			for(Patient p : Q) {
				if(tmpTarget.risk < p.risk) {
					Q.add(Q.poll()); //risk가 더 높은 환자가 존재한다면 뒤로 이동 
					tmpTarget = null;
					break;			 //이미 뒤로 보냈기 때문에 반복문 빠져 나오도록 break; 
				}
			}
			
			if(tmpTarget != null) {     //null이 아니라는 것은 Q에서 가장 위험도가 높다는 뜻
				answer ++;
				if(tmpTarget.num == targetNum) return answer;
				Q.poll();			 //치료 진행
			}
		} 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(solution(n, m, arr));
	}
	
	public static class Patient {
		Integer num;
		Integer risk;
		
		public Patient(Integer num, Integer risk) {
			super();
			this.num = num;
			this.risk = risk;
		}
	}
}


