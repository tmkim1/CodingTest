package _J10;

import java.util.Scanner;

/**
 * 10. 가장 짧은 문자거리 
 * 
 * 문제 설명: 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력
 * ex) teachermode e -> 1 0 1 2 1 0 1 2 2 1 0
 * 문자열 Size MAX: 100
 * 출처: 인프런 자바 알고리즘 문제풀이 
 * @author kimtaemin
 */

public class Main {
	
	//내 풀이, indexOf, lastIndexOf 활용 
	public static String solution2(String s, char target) {
		String answer = "";
		char[] charArr = s.toCharArray();
		int[] sizeArr = new int[charArr.length];
		int ls=0;
		int rs=0;

		System.out.println(charArr.length);
		for(int i=0; i<charArr.length; i++) {
			if(charArr[i] == target) sizeArr[i] = 0;
			else if(i == charArr.length-1) {
				sizeArr[i] = ls = (s.substring(0).length())-(s.substring(0).lastIndexOf(target)); 
				break;
			}
			else {
				ls = (s.substring(0,i+1).length()-1)-(s.substring(0,i+1).lastIndexOf(target));	// 검사 대상 좌측으로 검사 
				//System.out.println("ls:" + s.substring(0,i+1));
				rs = s.substring(i).indexOf(target);      										 // 검사 대상 우측으로 검사
				//System.out.println("rs:" + s.substring(i));
				if(ls != -1 && ls <= rs) sizeArr[i] = ls;
				else sizeArr[i] = rs;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int c : sizeArr) {
			sb.append(c + " ");
		}
		
		answer = String.valueOf(sb.toString());
		return answer;		
	}
	
	//강의 풀이 
	public static String solution(String s, char target) {
		String answer = "";
		int[] answerArr = new int[s.length()];
		int p = 1000;	//떨어진 거리, 없는 경우를 대비하여 1000으로 설정 
		
		//좌측으로 떨어진 거리
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == target) {
				p = 0;
				answerArr[i] = 0;
			} else {
				p++;
				answerArr[i] = p;
			}
		}
		
		p = 1000;
		
		//우측으로 떨어진 거리 
		for(int i=s.length()-1; i>=0; i--) {
			if(s.charAt(i) == target) {
				p = 0;
			} else {
				p++;
				answerArr[i] = Math.min(answerArr[i], p);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int c : answerArr) {
			sb.append(c + " ");
		}
		
		answer = String.valueOf(sb.toString());
		
		return answer;		
	}
		
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char c = sc.next().charAt(0);
		
		System.out.println(solution(str, c));
		//System.out.println(solution2(str, c));
	}
}
