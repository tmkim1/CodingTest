package _4;
import java.util.HashMap;

/**
 * 문제: 전화번호 목록 (프로그래머스)
 * 링크: https://programmers.co.kr/learn/courses/30/lessons/42577
 * @author kimtaemin
 *
 */

 class Solution {
     public boolean solution(String[] phone_book) {
    	 
         // Arrays.sort(phone_book);
         // for(int i=0; i<phone_book.length-1; i++) {
         //     if(phone_book[i+1].startsWith(phone_book[i])) {
         //         return false;
         //     }            
         // }
         // return true;
         // 해시맵 사용
         
    	 HashMap<String, Integer> hm = new HashMap<>();
         
         //배열에 담긴 값을 해시맵에 put
         for(int i=0; i<phone_book.length; i++) {
             hm.put(phone_book[i],null);
         }
         
         //contatinsKey와 substring을 이용하여 접두어 check
         for(int i=0; i<phone_book.length; i++) {
             for(int k=0; k<phone_book[i].length(); k++) {
                 if(hm.containsKey(phone_book[i].substring(0,k))) return false;
             }
         }
         return true;
     }
 }
