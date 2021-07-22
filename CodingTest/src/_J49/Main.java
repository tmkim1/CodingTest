package _J49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 49. 장난꾸러기 
 *
 * 새 학기가 시작되었습니다. 철수는 새 짝꿍을 만나 너무 신이 났습니다.
 * 
 * 철수네 반에는 N명의 학생들이 있습니다.
 * 
 * 선생님은 반 학생들에게 반 번호를 정해 주기 위해 운동장에 반 학생들을 키가 가장 작은 학생부터 일렬로 키순으로 세웠습니다.
 * 
 * 제일 앞에 가장 작은 학생부터 반 번호를 1번부터 N번까지 부여합니다. 철수는 짝꿍보다 키가 큽니다.
 * 
 * 그런데 철수가 앞 번호를 받고 싶어 짝꿍과 자리를 바꿨습니다.
 * 
 * 선생님은 이 사실을 모르고 학생들에게 서있는 순서대로 번호를 부여했습니다.
 * 
 * 철수와 짝꿍이 자리를 바꾼 반 학생들의 일렬로 서있는 키 정보가 주어질 때 철수가 받은 번호와 철수 짝꿍이 받은 번호를
 * 
 * 차례로 출력하는 프로그램을 작성하세요.
 * 
 * 
 * [입력] 
 * 9
   120 125 152 130 135 135 143 127 160

 * [출력] 
 * 3 8 
 * 
 * 
 * 참고: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	//1. 철수 키 > 짝꿍 키 
	//2. 철수는 자신의 다음 인덱스보다 키가 크고, 짝꿍은 자신의 이전 인덱스보다 키가 작음 ==> 정렬에 위반 됨.
	//3. 해당 특징을 토대로 철수의 위치와 짝꿍의 위치를 찾아낸다. 

	public static int[] solution(int n, int[] arr) {
		int[] answer = {0, 0};
		for(int i=0; i<n-1; i++) {
			if((answer[0] == 0) && (arr[i] > arr[i+1])) answer[0] = i+1;         //철수 위치 중복 체크를 막기 위해 answer[0] == 0 조건을 추가  
			else if((answer[0] != 0) && (arr[i] > arr[i+1]) ) answer[1] = i+2;   //짝궁 위치 
		}
		
		return answer; 
	}
	
	//정렬 배열 생성 후, 비교
	public static ArrayList<Integer> solution2(int n, int[] arr) {
		ArrayList<Integer> answer = new ArrayList<>();
		int[] temp = arr.clone();
		Arrays.sort(temp);
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != temp[i]) answer.add(i+1);
		}
		
		return answer; 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int num : solution2(n, arr)) {
			System.out.print(num + " ");
		}
	}
}
