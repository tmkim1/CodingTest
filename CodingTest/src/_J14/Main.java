package _J14;

import java.util.Scanner;

/**
 * 14. 보이는 학생 구하기 
 * 
 * 문제 설명: 큰 수 출력하기 
 * 선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는
 * 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
 * 출처: 인프런 자바 알고리즘 문제풀이 
 * 입력: 8  // 130 135 148 140 145 150 150 153
 * 출력: 5
 * @author kimtaemin
 */

public class Main {

	public static int solution(int[] intArr) {
		int answer = 1;
		int maxNum = intArr[0];
		
		for(int i=1; i<intArr.length; i++) {
			if(intArr[i] > maxNum) {
				maxNum = intArr[i];
				answer ++;
			}
		}
		
		return answer; 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] intArr = new int[size];
		
		for(int i=0; i<size; i++) {
			intArr[i] = sc.nextInt();
		}
		
		System.out.println(solution(intArr));
	}

}
