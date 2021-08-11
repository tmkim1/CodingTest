package _10;

/*
 * 문제: 상호 평가 (프로그래머스: 위클리 첼린지 2주차) 
 * 
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/83201
 * 
 */

public class Main {
	
	/* 
	    자기 자신을 평가한 점수가 "유일한" 최고점 또는 최저점이라면 점수를 제외 
		90점 이상	A
		80점 이상 90점 미만	B
		70점 이상 80점 미만	C
		50점 이상 70점 미만	D
		50점 미만	F
		인덱스가 같으면 자기 자신과 같으면 점수 제외 여부 확인 
	*/
	
	public static String solution(int[][] scores) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<scores.length; i++) {
			double avgScore = 0;
			int myScore = 0;
			int maxScore = Integer.MIN_VALUE;
			int minScore = Integer.MAX_VALUE;
			int totalScore = 0;
			int cnt = scores.length;
			
			for(int j=0; j<scores.length; j++) {
				
				// 한 학생이 받은 점수를 순회 하기 위해 y를 고정
				 
				
				
				// i == j 나 자신을 평가한 항목의 점수
				if(i == j) { 
					myScore = scores[j][i];
				} else {
					maxScore = Math.max(maxScore, scores[j][i]);
					minScore = Math.min(minScore, scores[j][i]);
				}
				totalScore += scores[j][i];
				 
				//마지막 점수까지 검사 
				if(j == scores.length-1) {
					//유일한 최고점이거나 최저점인경우 평균에서 제외 
					if(myScore > maxScore || myScore < minScore) {
						totalScore -= myScore;
						cnt --;
					} 
				}
			}
			//학점 변환 후 answer에 저장 
			avgScore = (double)totalScore / cnt;
			sb.append(calc(avgScore));
        }  
		return sb.toString(); 
	}
	
	public static char calc(double score) {
		char creditScore;
		if(score >= 90)  creditScore = 'A';
		else if(score >=80) creditScore = 'B';
		else if(score >=70) creditScore = 'C';
		else if(score >=50) creditScore = 'D';
		else creditScore = 'F';
		
		return creditScore;
	}
	
	public static void main(String[] args) {
		int[][] scores = {
							{100,	90,	98,	88,	65},
							{50,	45,	99,	85,	77},
							{47,	88,	95, 80,	67},
							{61,	57,	100, 80, 65},
							{24,	90,	94,	75,	65}
						};
		int[][] scores2 = {
				{50, 90},	{50,	87}
			};
		
		int[][] scores3 = {
				{70,49,90},{68,50,38},{73,31,100}
			};
		
		System.out.println(solution(scores));
		System.out.println(solution(scores2));
		System.out.println(solution(scores3));
	}

}
