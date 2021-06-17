package Q2;

import java.util.ArrayList;

/**
 * 문제: 자바 독과 함께 
 * 1. 징검다리를 건너야 함, 각 돌들이 얼마나 버틸수 있는지 내구도를 배열에 저장. 
 * 2. 징검다리를 건너는 각 독의 개인정보가 객체 배열로 주어짐. 
 * 3. 각 돌에 착지할때 독의 몸무게 만큼 내구도가 줄어든다.  
 * 4. 독들의 점프력은 각기 다르다.
 * 5. 각 독들은 순서대로만 다리를 건넌다. 
 * 출처: 눈 떠보니 코딩테스트 전
 * @author kimtaemin
 *
 */
public class Main {

	public static void main(String[] args) {
		//int[] stonArr = {1, 2, 1, 4};
		int[] stonArr = {5, 3, 4, 1, 3, 8 ,3};
		int chkNum = 0;
		
		ArrayList<String> survivorList = new ArrayList<String>();
		
		Doc[] docArr = { // jump, weight 
				new Doc("루비독", "95년생", 3, 4),
				new Doc("피치독", "95년생", 3, 3),
				new Doc("씨독", "72년생", 2, 1),
				new Doc("코볼독", "59년생", 1, 1)
		};
		
		//독 순서대로 돌다리 건너기 루프 
		for(int i=0; i<docArr.length; i++) {
			boolean svYN = true;                       // 생존 여부 확인 
			chkNum = docArr[i].jump;
			
			while(chkNum < stonArr.length) {           // 돌다리를 다 건널때까지 반복 
				stonArr[chkNum-1] = stonArr[chkNum-1] - docArr[i].weight;
				
				if(stonArr[chkNum-1] < 0) {            // 돌다리가 무너져 사망 
					svYN = false;
					break;	 
				} else {	                           // 한번 더 앞으로 점프 
					chkNum += docArr[i].jump;      
				}
			}
			
			if(svYN) survivorList.add(docArr[i].name); //생존자 명단에 추가
			chkNum = 0;
		}
		System.out.println("생존자: " + survivorList.toString());
	}
}

// 결과: 정답 
// for문을 향상된 for문을 사용하는 부분이 다름, 생존 플래그 반복 점프 합산, 생존자 ArrayList 추가 부분은 동일 
// -> for(doc i: docArr) { } => 이 코드가 훨씬 깔끔 // 어차피 개체수 만큼 전체 도는 거라면 향상된 for문을 사용하자. 