package thisiscoding.java._03;

import java.util.HashMap;

/**
 * 그리디
 * 거스름 돈 - 최소의 동전 개수 구하기
 */
public class Main3_1 {
    public static void main(String[] args) {
        int payAmount = 1260;
        int coinCount = 0;

        int[] coinTypes = {500, 100, 50, 10};
        HashMap<Integer, Integer> countByCoinType = new HashMap<>();

        for (int coin : coinTypes) {

            coinCount += payAmount / coin; //동전 개수 구하기

            countByCoinType.put(coin, payAmount / coin); // 동전 별로 사용한 개수를 구하기 위해 HashMap에 저장

            payAmount %= coin; //남은 금액 초기화
        }
        System.out.println("전체 사용 개수 = " + coinCount);

        //동전 별 사용한 개수 출력, 위에서 구하면서 출력해도 되지만 저장한 후에 출력되는 것을 보여주기 위해 for문 분리
        for(int coin : coinTypes) {
            System.out.println("동전 "+coin +"원 사용 개수: " + countByCoinType.get(coin) + "개");
        }
    }
}
