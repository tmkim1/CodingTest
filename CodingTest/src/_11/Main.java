package _11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 문제: 기능개발 (프로그래머스)
 * 
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/42586
 * 
 * @author kimtaemin
 *
 */
/*

진도가 100%일 때 서비스에 반영 가능

뒤에 있는 기능이 먼저 개발 될수 있지만, 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포
*/

public class Main {

    public int[] solution(int[] progresses, int[] speeds) {
        //하루에 배포되는 수를 순서대로 return 
        //0인 날은 무시 
        
        int day = 1;
        int spIndex = 0;
        int pushNum = 0;
        ArrayList<Integer> al = new ArrayList<>();
        
        Queue<Integer> Q = new LinkedList<>();
        
        //선입 선출 규칙을 이용
        for(int num : progresses) {
            Q.add(num);    
        }
        
        while(!Q.isEmpty()) {
            if(Q.peek() + day * speeds[spIndex] >= 100) { // 배포 가능
                Q.poll();
                spIndex++;
                pushNum++;
            } else { //배포 불가능 
                if(pushNum > 0) { //배포한 숫자 리스트에 추가 후, 0으로 갱신 
                    al.add(pushNum);
                    pushNum = 0;
                }
                day++;
            }  
        }  
        al.add(pushNum); //마지막 배포에 대한 pushNum 저장 
        int[] answer = new int[al.size()];
        
        for(int i=0; i<al.size(); i++) {
        	answer[i] = al.get(i);
        }
        
        return answer;
    }
    
}




