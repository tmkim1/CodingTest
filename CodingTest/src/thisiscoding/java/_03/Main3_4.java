package thisiscoding.java._03;

import java.util.Scanner;

/**
 * 1이 될때까지
 * 1. N에서 1을 뺸다.
 * 2. N에서 K를 나눈다.
 */
public class Main3_4 {

    public static void main2(String[] args) {
        //N:17, K:4, 17-1 = 16 /4 /4 = 1 (3번의 연산을 수행)
        int N = 17;
        int K = 4;
        int answer = 0;
        //1번을 수행하는것보다 2번을 수행하는게 연산에 있어 효율적이니 우선순위를 2번으로 정한다.

        while(true) {
            if(N % K == 0){
                N /= K;
            } else {
                N--;
            }
            answer++;
            if(N == 1) break;
        }

        System.out.println("answer = " + answer);
    }

    //solution
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, K를 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;

        while (true) {
            // N이 K로 나누어 떨어지는 수가 될 때까지만 1씩 빼기
            int target = (n / k) * k;
            result += (n - target);
            n = target;
            // N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
            if (n < k) break;
            // K로 나누기
            result += 1;
            n /= k;
        }

        // 마지막으로 남은 수에 대하여 1씩 빼기
        result += (n - 1);
        System.out.println(result);
    }

}
