package _7;

import java.util.Arrays;

/*
 * H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
 * 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
 * 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
 * 
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/42746
 * @author kimtaemin
 * 
 */

public class Main {
	
	// 1. 인용 횟수가 적은 값이 앞에 오도록 정렬
	// 2. 발표한 논문 수 만큼 반복문을 돌면서 h-index의 값이 유효한지 확인 
	// (발표한 논문 수 = h 최대값 1씩 차감하며 확인) 
	
	public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);							
 
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
 
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
 
        return answer;
    }
	
	public static void main(String[] args) {
		int[] arr = {3, 0, 6, 1, 5, 6, 2};
		System.out.println(solution(arr));
	}

}
