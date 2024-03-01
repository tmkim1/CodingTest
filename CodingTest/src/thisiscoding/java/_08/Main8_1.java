package thisiscoding.java._08;

import java.util.Scanner;

/**
 * 1로 만들기
 * 1) X가 5로 나누어떨어지면, 5로 나눈다.
 * 2) X가 3으로 나누어떨어지면, 3으로 나눈다.
 * 3) X가 2로 나누어떨어지면, 2로 나눈다.
 * 4) X에서 1을 뺀다.
 * 연산을 수행하는 횟수의 최솟값을 구하시오.
 * ex) 26
 * 26-1 = 25
 * 25/5 = 5
 * 5/5 = 1
 * answer = 3
 */
public class Main8_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n+1];

        //Bottom Up
        for(int i=2; i<=n; i++) {
            //1로 빼는 경우 (기본 초깃값), 이전 수행 카운트에서 +1
            d[i] = d[i-1] + 1;
            //2로 나누어 떨어지는 경우
            if(i % 2 == 0) d[i] = Math.min(d[i], d[i/2] + 1);
            //3으로 나누어 떨어지는 경우
            if(i % 3 == 0) d[i] = Math.min(d[i], d[i/3] + 1);
            //5로 나누어 떨어지는 경우
            if(i % 5 == 0) d[i] = Math.min(d[i], d[i/5] + 1);
        }
        System.out.println("answer = " + d[n]);
    }
}
