package _3;
import java.util.ArrayList;
import java.util.Arrays;

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

}
