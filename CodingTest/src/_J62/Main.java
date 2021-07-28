package _J62;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 62. 말단 노드까지의 가장 짧은 경로 (DFS, BFS)
 * 
 * - 말단 노드란 자식 노드가 없는 노드를 뜻함. 
 *   최단 거리를 구하는 경우는 BFS를 쓰는게 효율적
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */

class Node {
	int data;
	Node lt, rt;
	
	public Node(int val) {
		this.data = val;
		lt=rt=null;
	}
}

public class Main {
	
	Node root;
	
	public int DFS(int L, Node root) {
		if(root.lt == null && root.rt == null) return L; //말단 노드인 경우 Level 반환 
		else return Math.min(DFS(L+1, root.lt), DFS(L+1, root.rt)); //말단 노드가 아닌 경우 더 작은 레벨을 갖는 말단 노드 까지의 거리를 구하기 위해 호출 
	}
	
	public int BFS(Node root) {
		Queue<Node> Q = new LinkedList<>();
		Q.add(root);
		int L = 0;
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i=0; i<len; i++) {
				Node cur = Q.poll();
				if(cur.lt == null && cur.rt == null) return L; //말단 노드인 경우 Level 반
				else if(cur.lt != null) Q.add(cur.lt);         //말단 노드 아닌 경우 자식 노드 Q에 추가 
				else if(cur.rt != null) Q.add(cur.rt);
			}
			L++;                                               //Level 1개층이 돌았다면 Level++;
		}
		return L;
	}
	
	public static void main(String[] args) {
		Main tree = new Main();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		tree.root.rt.lt = new Node(6);
		tree.root.rt.rt = new Node(7);
		tree.root.lt.lt = new Node(8);
		tree.root.lt.rt = new Node(9);
		
		System.out.println(tree.DFS(0, tree.root));
		System.out.println(tree.BFS(tree.root));
	}
}
