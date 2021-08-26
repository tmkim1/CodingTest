package _J17;

/**
 * 17. 소수 구하기 (에라토스테네스 체) 
 * 
 * 문제 설명: 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
 * 
 * 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다
 * 
 * [입력] 
 *  20	
 * [출력]
 * 8
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이 
 * 
 * 에라토스테네스의 체 알고리즘 설명: https://firework-ham.tistory.com/8
 * 
 * @author kimtaemin
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(" ");
		System.out.println("0~"+n+"까지의 소수의 갯수: "+makePrime(n));
		
	}
	
	//소수 구하기 (에라토스테네스 체) 
	public static Integer makePrime(int number) {
		
		ArrayList<Integer> list = new ArrayList<>();;
		
		boolean[] check = new boolean[number+1];	//소수 판별 true: 비소수, false: 소수 
		check[0] = check[1] = true;				    //0과 1은 소수가 아니므로 true 
		System.out.println(number + "의 제곱근: " + Math.sqrt(number));
		for(int i=2; i<=Math.sqrt(number); i++) {   //Math.sqrt: 제곱 근 구하기 
			if(check[i]) continue;                  //소수가 아닐 경우 skip
			
			for(int j=i+i; j<check.length; j+=i) {
				check[j] = true;
			}
		}
		for(int i=0; i<check.length; i++) {
			if(!check[i]) {
				list.add(i);
				System.out.print(i + " ");
			}
		}
		return list.size();
	}
}
