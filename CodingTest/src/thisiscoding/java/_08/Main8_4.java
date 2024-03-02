package thisiscoding.java._08;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 효율적인 화폐 구성
 * 입력
 * 2 15
   2
   3
 * 출력: 5
   입력
   3 4
   3
   5
   7
   출력: -1
 */
public class Main8_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //화폐 단위 개수
        int m = sc.nextInt(); //만들기 위한 금액
        int[] moneys = new int[n];
        int[] d = new int[m + 1];

        for(int i=0; i<moneys.length; i++) {
            moneys[i] = sc.nextInt();
        }

        Arrays.fill(d, 10001);

        d[0] = 0;
        for(int i=0; i<n; i++) {
            for(int j=moneys[i]; j<=m; j++) {
                // (i-k)원을 만드는 방법이 존재하는 경우 -> 이미 이전 값을 구한 경우
                if(d[j - moneys[i]] != 10001) {
                    d[j] = Math.min(d[j], d[j - moneys[i]] + 1);
                }
            }
        }

        if(d[m] == 10001) System.out.println("answer = " + -1);
        else System.out.println("answer = " + d[m]);

    }
}
