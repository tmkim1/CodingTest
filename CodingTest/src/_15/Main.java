package _15;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 문제: 모의고사 (프로그래머스 - 완전탐색)
 * 
 * 수포자 제일 잘 찍은 학생 출력  
 * 
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/42587
 * 
 * answers	    return
 * 1,2,3,4,5	[1]
 * 1,3,2,4,2	[1,2,3]
 * 
 * 
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

 * @author kimtaemin
 *
 */

public class Main {

	//내 풀이 
	public static int[] solution(int[] arr) {
        int[] score = new int[3];
        int maxScore = 0;
        
        ArrayList<Integer> answerList = new ArrayList<>(); 
         
        //각 수포자 별 정답 패턴 셋팅 
        int[] std1 = {1, 2, 3, 4, 5};
        int[] std2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] std3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        //맞춘 정답 갯수 셋팅
        for(int i=0; i<arr.length; i++) {
        	if(arr[i] == std1[i % std1.length]) score[0]++;
        	if(arr[i] == std2[i % std2.length]) score[1]++;
        	if(arr[i] == std3[i % std3.length]) score[2]++;
        }
        
        //최대 점수 셋팅 
        for(int num :  score) {
        	maxScore = Math.max(num, maxScore);
        }
        
        for(int i=0; i<score.length; i++) {
        	if(maxScore == score[i]) answerList.add(i+1); //가장 많이 맞춘 수포자 아이디 리스트에 추가 
        }
        
        int[] answer = new int[answerList.size()];
        
        for(int i=0; i<answerList.size(); i++) {
        	answer[i] = answerList.get(i);
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] answer = {1,2,3,4,5};
		System.out.println("예상 Return 값: 1");
		
		System.out.println(Arrays.toString(solution(answer)));
		
		//1번: 1, 2, 3, 4, 5 
		//2번: 2, 1, 2, 3, 2, 4, 2, 5
		//3번: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5
		
		int[] answer2 = {1,3,2,4,2};
		System.out.println("예상 Return 값: 1,2,3");
		System.out.println(Arrays.toString(solution(answer2)));

		
	}

}
