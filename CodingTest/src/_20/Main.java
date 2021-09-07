package _20;

/**
 * 문제: 타겟 넘버 
 * 
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/43165
 * 
 * @author kimtaemin
 *
 * [입출력]
 *  numbers	        target	      return
   [1, 1, 1, 1, 1]	3	          5
   
 */


class Main {
	//주어진 숫자 길이가 dfs의 기준점이 되고, 레벨에 따라 숫자를 부여하고, 그 안에서 +, - 분기를 발생 시킨다. 
    private int count = 0;
    
    public void dfs(int[] numbers, int target, int L, int totalSum) {
        if(L == numbers.length) {
            if(target == totalSum) count++;
            return;
        }
        
        dfs(numbers, target, L+1, totalSum + numbers[L]);
        dfs(numbers, target, L+1, totalSum - numbers[L]);
          
    }
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers, target, 0, 0);
        answer = count;
        return answer;
    }
	
	public static void main(String[] args) {
		Main main = new Main();
		int[] numbers = {1,1,1,1,1};
		System.out.println(main.solution(numbers, 3));
	}
}