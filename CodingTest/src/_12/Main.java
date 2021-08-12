package _12;

import java.util.Arrays;

/**
 * 문제: 입국심사 (프로그래머스)
 * 
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/43238?language=java
 * 
 * @author kimtaemin
 *
 */

public class Main {
	
	public static long solution(int n, int[] times) {
        long answer = 0;
        long min = 0;
        long mid = 0;
        long max = 0; 
        
        //심사관 별 처리 시간, 오름차순 정렬 
        Arrays.sort(times);
        //가장 오랜 시간이 걸리는 시간 max에 부여
        max = n * times[times.length-1];
        
        //이분 탐색 시작 
        while(min <= max) {
            int tmpN = 0;
            mid = (min + max) / 2;
            //주어진 시간에 각 심사관 별 심사 가능 사람 수를 누적 
            for(int i=0; i<times.length; i++) {
                tmpN += mid/times[i]; 
            }
            
            //주어진 시간에 심사한 사람 수가 더 많은 경우 시간을 줄인다. 
            // 심사한 사람 수가 목표하는 수와 같다면 최소 시간을 찾아야 하기 때문에 계속 탐색 
            if(tmpN >= n) {
                max  = mid - 1;
                answer = mid;
            } 
            //주어진 시간에 심사한 사람 수가 더 적은 경우 시간을 늘린다.
            else if(tmpN < n) min = mid + 1;   
            
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int[] times = {7, 10};
		
		System.out.println(solution(6, times));
	}

}
