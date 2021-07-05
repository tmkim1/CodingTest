package _J04;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 4. 단어 뒤집기 
 * 출처: 인프런 자바 알고리즘 문제풀이 
 * @author kimtaemin
 */

public class Main {
	
	
	//StringBuilder를 사용한 방법
	public static ArrayList<String> solution(String[] str) {
		ArrayList<String> strList = new ArrayList<>();
		
		for(String word : str) {
			String tmpWord = new StringBuilder(word).reverse().toString();
			strList.add(tmpWord);
		}
		
		for(int i=0; i<strList.size(); i++) {
			
		}
		
		return strList; 
	}
	
	//특수한 경우를 위해 직접 뒤집기 
	public static ArrayList<String> solution2(String[] str) {
		ArrayList<String> strList = new ArrayList<>();
		
		for(String word : str) {
			char[] charArr = word.toCharArray();	//String을 각 문자 별로 swap 해주기 위해서 char[]로 변환 
			int lt = 0, rt = charArr.length-1;		//시작점과 끝점을 지정 
			
			while(lt < rt) {						//swap
				char tmpChar;
				tmpChar = charArr[rt];
				charArr[rt] = charArr[lt];
				charArr[lt] = tmpChar;
				lt ++;
				rt --;
			}
			
			strList.add(String.valueOf(charArr));	//ArrayList<String>에 추가, char[]을 String 으로 변환하는 방법 String.valueOf(char)
		}
		
		return strList; 
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String[] str = new String[n];
		
		for(int i=0; i<n; i++) {
			str[i] = sc.next();
		}
		
		for(String word : solution(str)) {
			System.out.println(word);
		}
		
		System.out.println("---------------------");
		
		for(String word : solution2(str)) {
			System.out.println(word);
		}
	}
}
