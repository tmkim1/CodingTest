package _J17;

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
		
		for(int i=2; i<=Math.sqrt(number); i++) {
			if(check[i]) continue;                  //소수가 아닐 경우 skip
			
			for(int j=i*i; j<check.length; j += i) {
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
