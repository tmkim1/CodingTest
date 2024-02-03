package thisiscoding.java._03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 숫자 카드 게임
 * 랜덤으로 주어지는 숫자 카드로 이루어진 N*M 행렬이 주어진다.
 * 행을 선택, 가장 낮은 숫자를 뽑아야 하는 규칙 속에서 가장 큰 값을 골라보자.
 */
public class Main3_3 {
    public static void main(String[] args) {
        //각 행별로 가장 작은 값을 구한다.
        //그 중에서 가장 큰 값이 정답
        int N=3;
        int M=3;
        int answer = 0;
        int[][] arr = {{3, 1, 2}, {4, 1, 4}, {2, 2, 2}};
        for(int i=0; i<N; i++) {
            int minNumInRow = 10000;
            for(int j=0; j<M; j++) {
                //행 안에서 가장 작은 수 구하기
                minNumInRow = arr[i][j] < minNumInRow ? arr[i][j] : minNumInRow;
            }
            System.out.println("minNumInRow = " + minNumInRow);
            answer = minNumInRow > answer ? minNumInRow : answer;
        }
        System.out.println("answer = " + answer);
    }

    //solution
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M을 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;

        // 한 줄씩 입력 받아 확인하기
        for (int i = 0; i < n; i++) {
            // 현재 줄에서 '가장 작은 수' 찾기
            int min_value = 10001;
            for (int j = 0; j < m; j++) {
                int x = sc.nextInt();
                min_value = Math.min(min_value, x);
            }
            // '가장 작은 수'들 중에서 가장 큰 수 찾기
            result = Math.max(result, min_value);
        }

        System.out.println(result); // 최종 답안 출력
    }
}
