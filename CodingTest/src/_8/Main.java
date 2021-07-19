package _8;

import java.util.HashMap;
import java.util.Map;

/**
 * 문제: 해시 - 위장 
 * 스파이가 옷 종류별로 위장할수 있는 경우의 수를 구하는 문제 
 * 문제 설명: 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
 * 예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 
 * 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
 * 
 * 종류	이름
 * 얼굴	동그란 안경, 검정 선글라스
 * 상의	파란색 티셔츠
 * 하의	청바지
 * 겉옷	긴 코트
 * 
 * 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
 * 
 * 링크: https://programmers.co.kr/learn/courses/30/lessons/42746
 * @author kimtaemin
 *
 */

class Main {
	
	// 1. 종류 별로 HashMap에 key로 구분하여 갯수를 구한다.
	// 2. 다른 종류를 입지 않고 1개만 있는 경우가 있기 때문에 모든 아이템의 수 + 조합 수를 구한다. 
	// 3. 아이템의 수 + 조합 수 = (각 분류 별 아이템 갯수에 +1) 누적으로 곱한 후에 마지막에 -1을 뺴는 방법으로 구할 수 있다.  
	
    public static int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String,Integer> hm = new HashMap<>();
        
        //경우의 수를 구하기 위해 종류 별로 cnt 
        for(int i=0; i<clothes.length; i++) {
            hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0)+1);    
        }
        
        //각 아이템 1개씩만 차는 경우 + 조합인 경우 
        for(int val : hm.values()) {
            answer *= (val+1);
        }
        
        return answer-1;
    }
    
    public static void main(String[] args) {
    	String[][] arr = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
    	System.out.println(solution(arr));
    }
}


