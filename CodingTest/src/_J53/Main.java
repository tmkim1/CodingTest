package _J53;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 53. 마구간 정하기  
 * 
 * N개의 마구간이 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마구간간에 좌표가 중복되는 일은 없습니다.
 * 
 * 현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다. 각 마구간에는 한 마리의 말만 넣을 수 있고,
 * 
 * 가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.
 * 
 * C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램을 작성하세요
 * 
 * [입력] 
 * 5 3
   1 2 8 4 9
 * 
 * [출력] 
 * 3
 * 
 * 
 * 참고: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	
	//말을 알맞게 마굿간에 배치하도록 --> 서로 간 최대한 떨어지게 
	//Array Sort: 1 2 4 8 9 // 1,4,8 에 넣는게 베스트 
	//말 간의 거리는 1 ~ 배열에 들어 있는 최대값 -1 
	//1. 마굿간 좌표 집계  
	public static Integer solution(int n, int m, int arr[]) {
		Integer answer = -1;
		int lt = 1;
		int rt = Arrays.stream(arr).max().getAsInt()-1;
		int mid, cnt, ep;
		
		Arrays.sort(arr);
		
		while(lt <= rt) {
			cnt = 1;
			ep = arr[0];               //마굿간 간의 거리를 구하기 위해 point설정이 필요 
			mid = (lt + rt) / 2;
			
			for(int i=1; i<arr.length; i++) {
				if(arr[i]-ep >= mid) {  //거리 조건에 만족한다면 cnt를 늘리고 point 현재 위치로 설정 
					cnt ++;
					ep = arr[i];     
				}
			}
			
			if(cnt >= m) {             //모든 말을 포용 할 수 있다면 OK 
				if(mid > answer) answer = mid;
				lt = mid + 1;
			} else {
				rt = mid -1;		   //모든 말을 배치 하지 못 했다면 NO 더 거리를 좁혀야 함. 
			}
		}
		return answer; 
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();   // 마굿간 수 
		int m = sc.nextInt();   // 말의 수 
		int[] arr = new int[n]; // 마굿간 좌표 
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(solution(n, m, arr));
	}
}
