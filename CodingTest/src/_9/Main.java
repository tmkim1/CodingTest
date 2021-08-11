package _9;

/*
 * 문제: 부족한 금액 계산하기
 * 
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/82612#
 * 
 */
public class Main {
	
	public static void main(String[] args) {
		System.out.println(solution(3, 20, 4));
		System.out.println(solution2(3, 20, 4));
	}
	
	//놀이기구 금액: 원 금액(price) * 이용횟수(count)
	//가지고 있는 금액에서 얼마가 모자란지를 확인 
	//dfs로도 가능하고 for문으로도 가능할듯 
    public static long solution(int price, long money, int count) {
        long answer = -1;
        long totalPrice = 0;
        
        for(int i=1; i<=count; i++) {
            totalPrice += price * i;     //이용횟수 만큼 곱한 금액 = 현재 인덱스에 지출 해야하는 금액을 누적 
        }
        
        if(money >= totalPrice) return 0; //놀이기구 금액이 부족하지 않은 경우 0을 return 
        else return totalPrice - money;  //놀이기구 금액이 부족하다면 부족한 금액을 return
    }
    
    //다른 사람 풀이 
    //등차 수열의 합 수식 사용 ==> n(n+1)/2. 기억해두자 
    public static long solution2(int price, long money, int count) {
    	return Math.max(price * (count * (count + 1) / 2) - money, 0);
    }
	
	
}
