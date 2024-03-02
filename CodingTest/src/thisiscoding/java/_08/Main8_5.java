package thisiscoding.java._08;

import java.util.Scanner;

/**
 * 1,2,3 더하기
 */
public class Main8_5 {
    public static int[] d = new int[11];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); //test case 개수

        d[1] = 1; // 1
        d[2] = 2; // 1+1, 2
        d[3] = 4; // 1+1+1 , 1+2, 2+1, 3

        for(int i=4; i<=10; i++) {
            d[i] = d[i-1] + d[i-2] + d[i-3];
        }

        for(int i=0; i<t; i++) {
            int n = sc.nextInt();
            System.out.println(d[n]);
        }
    }
}
