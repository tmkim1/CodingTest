package thisiscoding.java._08;

import java.util.Scanner;

/**
 * 바닥 공사
 * 가로 N , 세로 2 (바닥)
 * 덮개 1X2, 2X1, 2X2를 사용하여 바닥을 덮는 경우의 수
 * 입력: 3
 * 출력: 5
 */
public class Main8_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n + 1];

        //초기 경우의 수 설정
        d[1] = 1; //첫 칸을 덮는 경우의 수는 2X1판자를 쓰는 경우 1개
        d[2] = 3; //두번째 칸을 덮는 경우의 수는 3개

        for (int i=3; i<=n; i++) {
            d[i] = (d[i-1] + d[i-2] * 2) % 796796;
        }
        System.out.println("n = " + d[n]);
    }
}
