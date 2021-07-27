package _J59;

import java.util.Scanner;

/**
 * 59. 부분 집합 구하기 (DFS) 
 * 
 * 첫 번째 줄부터 각 줄에 하나씩 부분집합을 아래 출력예제와 같은 순서로 출력한다.
 * 단 공집합은 출력하지 않는다.
 * 
 * [입력] 
 * 3

 * [출력] 
 * 1 2 3
 * 1 2 
 * 1 3 
 * 1 
 * 2 3 
 * 2 
 * 3 
 * 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

public class Main {
	public static int n;
	public static int[] chk;
	
	public static void DFS(int L) {
		
		//마지막 노드에 도달 하면 chk[]를 검사하며 출력
		if(L==n+1) {  
			String tmpStr = "";
			for(int i=1; i<=n; i++) {
				if(chk[i]==1) tmpStr += i + " ";
			}
			//공집합은 출력하지 않음
			if(tmpStr.length() > 0) System.out.println(tmpStr);
		} else {
			chk[L] = 1;	//나를 1로 만들고,
			DFS(L+1);   //다음 노드 호출 
			chk[L] = 0; //나를 0으로 만들고, 
			DFS(L+1);   //다음 노드 호출 
		}
	}
	
	public static void main(String[] args) {
		n=3;
		chk = new int[n+1];
		DFS(1);
		
	}
}
