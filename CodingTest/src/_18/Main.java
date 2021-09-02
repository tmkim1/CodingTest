package _18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 문제: 디스크 컨트롤러 
 * 
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/42627
 * 
 * @author kimtaemin
 *
 * [input]
 * jobs	
 * [[0, 3], [1, 9], [2, 6]]
 * 	
 * [output]
 * 9
 */
class Job implements Comparable<Job>{
    int requestTime;
    int workingTime;
    
    public Job(int requestTime, int workingTime) {
        this.requestTime = requestTime;
        this.workingTime = workingTime;
    }

    //시간 초과 주석 --> 작업 시간이 짧은 프로세스가 앞에 오도록 정렬, 작업 시간이 같은 경우 먼저 요청한 프로세스 먼저 처리
	@Override
	public int compareTo(Job o) {
		if(this.workingTime == o.workingTime) return this.requestTime - o.requestTime;
		return this.workingTime - o.workingTime; 
	}
    
}

class Main {
	public int solution(int[][] jobs) {
        int answer = 0;
        int currentTime = 0;
        
        PriorityQueue<Job> pq = new PriorityQueue<>();
        List<Job> list = new ArrayList<>();
        
        for(int i=0; i<jobs.length; i++) {
        	pq.offer(new Job(jobs[i][0], jobs[i][1]));
        }
        
        while(!pq.isEmpty()) {
        	list.add(pq.poll());
        }
    	
        
        //Sorting
        //Collections.sort(jobs);
        
        //Heap Setting
        for(Job job : list) {
        	System.out.println(job.requestTime + " " + job.workingTime);
        }
        
      //디스크 수행 
        while(list.size() > 0) {
        	for(int i=0; i<list.size(); i++) {
        		if(list.get(i).requestTime <= currentTime) {
            		Job curHeap = list.get(i);
            		currentTime += curHeap.workingTime;
            		answer += (currentTime - curHeap.requestTime); //요청 시간부터 처리 되기 까지의 시간 
            		list.remove(i);
            		break;
            	} 
        		//처리 가능한 프로세스 없는 경우 현재 시간 1초 증가 
        		if(i == list.size()-1) currentTime++;
        	}
        }
        //평균 산출 및 반환 
        return answer/jobs.length;
    }
	
	public static void main(String[] args) {
		Main main = new Main();
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}, {1,6}};
		System.out.println(main.solution(jobs));
	}
}