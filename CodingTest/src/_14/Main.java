package _14;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 문제: 프린터 (프로그래머스)
 * 
 * 중요도에 따른 요청 프린트 출력 순서 출력 
 * 
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/42587
 * 
 * @author kimtaemin
 *
 */

public class Main {

	//내 풀이 
	public static int solution(int[] priorities, int location) {
        int answer = 0;
        int cnt = 0;
        Queue<Integer> Q = new LinkedList<>();
        
        //Q에 모든 출력물 셋팅 
        for(int i=0; i<priorities.length; i++) {
        	Q.offer(i);
        }
        
        while(!Q.isEmpty()) {
        	int curIndex = Q.poll();
        	int curPr = priorities[curIndex]; //해당 문서의 중요도를 저장
        	boolean chk = true;
        	for(int pr : priorities) {
        		//우선순위가 더 높은게 존재하는 경우 맨 뒤로 보낸다. 
        		if(pr > curPr) {
        			Q.offer(curIndex);
        			chk = false;
        			break;
        		}
        	}
        	
        	if(chk) {
        		priorities[curIndex] = 0; //처리된 출력물은 중요도 0으로 설정 
        		cnt ++;
        		if(curIndex == location) return answer = cnt;
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] arr = {2, 1, 3, 2};
		int location = 2;
		System.out.println("예상 Return 값: 1");
		System.out.println(solution(arr, location));
		
	}

}
