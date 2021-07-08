package J_15;

import java.util.Scanner;

/**
 * 15. 가위 바위 보
 * 
 * 문제 설명: 큰 수 출력하기 
 * 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보
 * 
 * [입력] 
 * 5
 * 2 3 3 1 3
   1 1 2 2 3
 * [출력]
 * A
 * B
 * A
 * B
 * D
 * 출처: 인프런 자바 알고리즘 문제풀이 
 * @author kimtaemin
 */

public class Main {
	public static void solution(int[] aArr, int[] bArr) {
		// 1:가위, 2:바위, 3:보 
		// 1 ::  상대: 2 lose, 3 win 
		// 2 ::  상대: 3 lose, 1 win 
		// 3 ::  상대: 1 	lose, 2 win 
		for(int i=0; i<aArr.length; i++) {
			if(aArr[i] == 1) {				//A가 가위를 낸 경우 
				if(bArr[i] == 1) {
					System.out.println("D");
				} else if(bArr[i] == 2) {
					System.out.println("B");
				} else {
					System.out.println("A");
				}
			} else if(aArr[i] == 2) {		//A가 바위를 낸 경우
				if(bArr[i] == 1) {
					System.out.println("A");
				} else if(bArr[i] == 2) {
					System.out.println("D");
				} else {
					System.out.println("B");
				}
			} else {                        //A가 보를 낸 경우
				if(bArr[i] == 1) {
					System.out.println("B");
				} else if(bArr[i] == 2) {
					System.out.println("A");
				} else {
					System.out.println("D");
				}
			}
		}
		
	}
	
	// 강의 답안
	public static void solution2(int[] aArr, int[] bArr) {

		for(int i=0; i<aArr.length; i++) {
			
			// 비긴 경우와 A가 이긴 경우만 찾으면 나머지는 else로 처리하면 됨. 
			if(aArr[i] == bArr[i]) System.out.println("D");
			else if (aArr[i] == 1 && bArr[i] == 3) System.out.println("A");
			else if (aArr[i] == 2 && bArr[i] == 1) System.out.println("A");			
			else if (aArr[i] == 3 && bArr[i] == 2) System.out.println("A");		
			else System.out.println("B");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] aArr = new int[size];  
		int[] bArr = new int[size];
		
		for(int i=0; i<2; i++) {
			for(int j=0; j<size; j++) {
				if(i == 0) aArr[j] = sc.nextInt();
				else bArr[j] = sc.nextInt();
			}
		}
		solution(aArr, bArr);
		solution2(aArr, bArr);
	}
}
