package _3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 문제: 완주하지 못한 선수 (프로그래머스)
 * 링크: https://programmers.co.kr/learn/courses/30/lessons/42576
 * 모범 답안 참조: https://codevang.tistory.com/289
 * @author kimtaemin
 *
 */
//완주하지 못한 선수
public class Main {
	public static void mains(String[] args) {
		
	}


    public String solution(String[] participant, String[] completion) {
        String answer = "";
        ArrayList<String> strList = new ArrayList<>();
        
        for (int i=0; i<completion.length; i++) {
        	strList.add(completion[i]);
        }
        
        for (int i =0; i<participant.length; i++) {
        	if(!strList.contains(participant[i])) {
        		answer = participant[i];
        		break;
        	} else { // 동명이인 검사 확인 기존 completion에서 없애줘야 함. 
        		
        		//strList.set(i, "완주 확인 완료"); // 이렇게 하면 리스트 인덱스와 컴플리션 인덱스가 달라서 X // 리스트에 저장된 인덱스 값을 알아야 함.
        		strList.set(strList.indexOf(participant[i]), "완주 확인 완료"); // 해당 방법 시간 초과 발생. 
        	}
        }
        return answer;
    }
    
    public String solution2(String[] participant, String[] completion) {
        String answer = "";
        // ArrayList로 복사하여 사용하니 시간 초과 발생. 
        // 배열에서 처리 하는 방법으로 변경 
        
	    Arrays.sort(participant);
	    Arrays.sort(completion);
	    
	    //index out 고려, 더 길이가 짧은 completion을 기준으로 반복 
	    for (int i =0; i<completion.length; i++) {
	    	if(!completion[i].equals(participant[i])) {
	    		return participant[i];      
	    	}
	    }
	    //마지막에 위치하는 경우 처리, 
	    return participant[participant.length-1];
    }
    
    //문제 카테고리가 해시맵이기 때문에 해시맵을 사용하는 방법을 익혀야 함. 
    public String solution3(String[] participant, String[] completion) {
    	String answer = "";
    	HashMap<String, Integer> hm = new HashMap<>();
    	
    	//participant 배열의 모든 값을 해시맵에 담는다. 
    	for(String p : participant) {
    		//해당 참가자가 이미 해시맵에 존재하면 value값을 가져오고 없으면 0을 가져와서 +1 
    		hm.put(p, hm.getOrDefault(p, 0)+1);
    	}
    	
    	//completion 배열의 모든 값을 해시맵에 담는다.  ==> idea: participant에서 추가한 참가자를 토대로 찾아서 value값을 -1 처리한다. 
    	//최종적으로 value값이 1인 사람은 완주하지 못 한 사람을 뜻 함. 
    	for(String c : completion) {
    		hm.put(c, hm.getOrDefault(c, 0)-1);
    	}
    	
    	//사용 지양 코드 
    	//이유: HashMap은 map과 같이 key와 value값을 갖는 Entry 객체를 사용하여 데이터를 저장 
    	//keySet()메서드를 통해 순회하는 것까지는 괜찮지만 get(key)메서드를 사용하는 경우 매 건마다 전체 검색을 하게 된다. 
    	//hash 자체가 빨라서 문제가 되지 않을수 있지만, 좀 더 나은 방식의 방법을 제공하고 있다. 
    	for(String key : hm.keySet()) {
    		if(hm.get(key) != 0) {
    			answer = key;
    		}
    	}
    	
    	//지향하는 방법 
    	for(Entry<String, Integer> entry : hm.entrySet()) {
    		if(entry.getValue() > 0) {
    			answer = entry.getKey();
    			break;
    		}
    	}
    	
    	return answer; 
    }

}
