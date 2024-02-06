package thisiscoding.java._03;

import java.util.*;

/**
 * 큰 수의 법칙
 * 다양한 수로 이루어진 배열이 있을 때
 * M번 더하여 가장 큰 수를 만든다. 같은 수를 K번 초과하여 더할 수 없다.
 * 배열의 크기 2 <= N <= 1000
 */
public class Main3_2 {
    public static void main(String[] args) {
        //가장 큰 수와 두 번째 큰 수를 찾는다.
        //가장 큰 수를 M번 만큼 더하고 M번보다 많아지는 순간 두번째 큰 수를 더하고 M Count Index를 0으로 초기화한다.
        Integer[] numArr = {2, 4, 5, 4, 6};

        int n = numArr.length; //제시된 숫자의 개수 (5)
        int m = 8; //더하기 횟수
        int k = 3; //반복 제한 횟수

        int maxNum = 0;
        int secondMaxNum = 0;

        int answer = 0;
        int limitedCnt= 0;

        //가장 큰 수 , 두번째 수로 큰 수를 찾기 위해 정렬
        Arrays.sort(numArr);

        maxNum = numArr[n-1];
        secondMaxNum = numArr[n-2];

        for(int i=0; i<m; i++) {
            if(limitedCnt < k) {
                answer += maxNum;
                limitedCnt ++;
            } else {
                answer += secondMaxNum;
                limitedCnt = 1;
            }
        }

        System.out.println("answer = " + answer);
    }


    //solution
    public static void main2(String[] args) {
        //input: 5, 8, 3 {2,4,5,4,6}
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        // N개의 수를 공백을 기준으 구분하여 입력 받기
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int first = arr[n - 1];
        int second = arr[n - 2];

        int cnt = (m / (k+1)) * k;
        cnt += m % (k + 1);

        int result = 0;
        result += cnt * first; //가장 큰 수 더하기
        result += (m - cnt) * second;

        System.out.println("result = " + result);

    }
}
