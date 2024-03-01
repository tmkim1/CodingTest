package thisiscoding.java._08;

import java.util.Scanner;

/**
 * 개미전사
 * 최대 식량 얻기, 인접한 공간은 식량을 얻을 수 없다.
 * [입력]
 * 4
   1 3 1 5
 * [출력]
 * 8
 */
public class Main8_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n+1];
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        d[0] = arr[0];
        d[1] = Math.max(arr[0], arr[1]);

        for(int i=2; i<arr.length; i++) {
            d[i] = Math.max(d[i-1], d[i-2] + arr[i]);
        }

        System.out.println("최대 식량 = " + d[n-1]);
    }
}
