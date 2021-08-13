package _13;

import java.util.*;
import java.util.Map.Entry;

/**
 * 문제: 직사각형 완성하기 (프로그래머스)
 * 
 * 직사각형을 만드는 데 필요한 4개의 점 중 3개의 좌표가 주어질 때, 나머지 한 점의 좌표를 구하려고 합니다. 
 * 
 * 점 3개의 좌표가 들어있는 배열 v가 매개변수로 주어질 때, 직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 return 하도록 solution 함수를 완성해주세요. 
 * 
 * 단, 직사각형의 각 변은 x축, y축에 평행하며, 반드시 직사각형을 만들 수 있는 경우만 입력으로 주어집니다.
 * 
 * 출처: 프로그래머스 코딩테스트 데모 테스트 문제 
 * 
 * @author kimtaemin
 *
 */


/*
 * 처음에는 좌표 끼리의 값을 사칙연산으로 차이를 구하려 했지만, 좌표 특징을 본 결과 
 * 
 * 필요한 좌표는 위에서 언급된 좌표의 3개중 중복되지 않은 좌표임을 알게 되었고, 
 * 
 * 2번이 아닌 1번만 출연한 좌표가 정답으로 필요한 좌표임을 파악
 *
 * x, y 각 각 값이 다르기 때문에 x와 y를 찾을 HashMap을 구별하여 생성한 후에 
 * 
 * 중복된 값에 대해서는 카운트를 해주고, 최종적으로 중복되지 않은 값을 가져와 answer 배열에 넣어주었다. 
 * 
 * 프로그래머스: 완주하지 못한 선수와 비슷한 풀이법! 
 * 
 */
class Main {
    public int[] solution(int[][] v) {
        int[] answer = new int[2];
        //x, y 모두 1개만 나온 좌표가 추가로 필요한 좌표가 된다.
        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();

        for(int i=0; i<v.length; i++) {
            //2개 숫자는 중복, 2개 숫자는 1번만 출연 (정답 좌표)
            //j가 0일때 x좌표 -> fl에 저장, 1일때 y좌표 -> sl에 저장
            //이미 리스트에 존재하면 중복 기존 값 제거 
            xMap.put(v[i][0], xMap.getOrDefault(v[i][0], 0)+1);
            yMap.put(v[i][1], yMap.getOrDefault(v[i][1], 0)+1);
        }
        
        for(Entry<Integer, Integer> entry : xMap.entrySet()) {
    		if(entry.getValue() == 1) {
    			answer[0] = entry.getKey();
    			break;
    		}
    	}
        
        for(Entry<Integer, Integer> entry : yMap.entrySet()) {
    		if(entry.getValue() == 1) {
    			answer[1] = entry.getKey();
    			break;
    		}
    	}
        
        System.out.println("Hello Java");

        return answer;
    }
}