package _J60;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 60. 이진트리 레벨 탐색 (BFS: Breadth Fisrt Search)
 * 
 * 트리 루트(Level 0)부터 마지막 노드까지 레벨 순으로 순차 탐색 
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
	
	public void BFS(Node root) {
		Queue<Node> Q = new LinkedList<>();
		Q.add(root);
		int L=0;
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			System.out.print(L + ": ");
			
			for(int i=0; i<len; i++) {
				Node cur = Q.poll();
				System.out.print(cur.data+" ");
				if(cur.lt != null) Q.add(cur.lt);
				if(cur.rt != null) Q.add(cur.rt);
			}
			L++;
			System.out.println();
		}
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
		tree.BFS(tree.root);
	}
}
