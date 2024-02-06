package thisiscoding.java._03;

/**
 * https://leetcode.com/problems/container-with-most-water/description/
 */

public class Leet3_1 {
    // 가장 많은 물을 담을 수 있는 영역을 구하자
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int answer = 0;

        while(left < right) {
            if(height[left] < height[right]) {
                answer = Math.max(answer, (right-left) * height[left++]);
                //left++;
            } else {
                // width(right - left) * heigth (right height)
                answer = Math.max(answer, (right-left) * height[right--]);
            }
        }

        return answer;
    }
}
