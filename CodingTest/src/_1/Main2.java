package _1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {

	public static void main(String[] args) {
		int[] tempArray = {1,3,4,5};
		
		System.out.println(solution(tempArray));
		       
	}
	public static int[] solution(int[] numbers) {
        int tempNum = 0;
        
        List<Integer> tempList = new ArrayList<>();

        for(int i=0; i < numbers.length-1; i++) {
            for (int j=1; j < numbers.length; j++) {
                tempNum = numbers[i] + numbers[j]; 
                if(!tempList.contains(tempNum)) {
                    tempList.add(tempNum);
                }                      
            }
        }
        
        int[] answer = new int[tempList.size()];
        for(int i=0; i<tempList.size(); i++) {
            answer[i] = tempList.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
       
    }

}
