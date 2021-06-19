package _ect1;

/**
 * 
 * @author kimtaemin
 * 가장 보편적인 그리디 알고리즘의 예) 거스름 돈
 * 그리디 알고리즘은 현 상황에서의 최선의 선택만을 고려
 * .따라서 최종 결과는 최선의 결과가 아닐 수 있지만, 근접하게 됨
 * 위와 같은 거스름 돈 알고리즘 같은 경우는
 * 큰 단위가 항상 작은 단위의 배수이므로 작은 단위의 동전들을 종합해 다른 해가 나올수 없기 때문에 정당성에 맞음
 * 화폐 단위 만큼 반복 // 단위 별 몇개를 거슬러 주었는지는 복잡도 상관X 
 * 
 * 강의에서는 전체 환산된 갯수를 구하지만, 화폐 단위 별로 거슬러준 갯수를 구하기 위해 수정함 
 * 참조 강의 - 이코테
 */
    
public class Main {

	public static void main(String[] args) {
		
		int change = 3890; //거스름 돈 입력 값 
		int[] coinType = {1000, 500, 100, 50, 10}; // 화폐 단위 
		int[] coinTypeNum = new int[coinType.length]; // 화폐 단위 별 거슬러준 갯수 넘버링 배열 
		
		for (int i=0; i<coinType.length; i++) {
			coinTypeNum[i] = change / coinType[i];
			change = change % coinType[i];
		}
		
		System.out.println("거스름 돈 출력");
		
		for(int i=0; i<coinType.length;i++) {
			// System.out.println(coinType[i]+":"+coinTypeNum[i]+" 개");
			// 좀 더 예쁘게 출력 
			System.out.printf("%5d원: %1d개,",coinType[i],coinTypeNum[i]);
		}

	}

}
