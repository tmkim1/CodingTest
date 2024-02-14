package thisiscoding.java._05;

import java.util.Scanner;

public class Main5_0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n + "! = " + factorialIterative(n));

    }

    public static int factorialIterative(int n) {
        if(n <= 1) return 1;
        return n * factorialIterative(n-1);
    }
}
