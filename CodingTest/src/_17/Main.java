package _17;

import java.util.PriorityQueue;

/**
 * 문제: 더 맵게 (프로그래머스 - 힙)
 * 
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/42626
 * 
 * numbers	return
 * "17"	    3
 * "011"	2
 * 
 * @author kimtaemin
 *
 */
class Solution {
	public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        //heap setting 
        for(int num : scoville) {
            heap.offer(num);
        }
        
        //스코빌 지수 혼합 
        //K보다 작다면 가장 작은 지수를 가진 2개의 원소를 혼합 
        //해당 원소가 K이상이 될때까지 반복 
        while(heap.peek() < K) {
        	if(heap.size() == 1) return -1;
            //혼합 진행 
            int firstMinNum = heap.poll();
            int secondMinNum = heap.poll();
            int mixedScoville =  firstMinNum + (secondMinNum * 2);
            heap.offer(mixedScoville);
            answer++;
            }
        return answer;
    }
}