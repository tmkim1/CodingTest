package thisiscoding.java._03;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/array-partition/description/
 */
public class Leet3_2 {
    //주어진 숫자들을 pair로 묶고, pair로 묶인 애들 중 작은 값들 끼리의 합이 가장 큰 숫자를 구하자.
    public int arrayPairSum(int[] nums) {
        //큰 숫자들을 살리기 위해서는 가장 큰 값들을 pair로 묶어 줘야 한다.
        int answer = 0;

        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++) {
            if(i % 2 == 0) answer += nums[i];
        }

        return answer;
    }
}
