package _J58;

/**
 * 58. 이진 트리 순회  
 * 
 * 이진 트리 개념 숙지 
 * [DFS - Depth First Search] 
 * 
 * 전위 순회, 중위 순회, 후위 순회 코드 분석 
 * 해당 구조를 확실하게 이해하고 직접 그려보며 순회하는 순서를 알아야 함. 
 * 
 * 출처: 인프런 자바 알고리즘 문제풀이
 * 
 * @author kimtaemin
 */
class Node {
	int data;
	Node lt, rt;
	
	public Node(int val) {
		data = val;
		lt=rt=null;
	}
}

public class Main {
	Node root;
	
	
	//root 순회 순서를 기준으로 이름이 매겨짐 
	//1. 전위 순회 (root를 가장 먼저 출력)  
	public void DFS1(Node root) { 
		if(root == null) return;
		else {
			System.out.print(root.data+" ");
			DFS1(root.lt);
			DFS1(root.rt);
		}
	}
	
	//2, 중위 순회 (root를 가운데 지점에서 출력), 이진 트리는 항상 우측이 아닌 왼쬑 부터 탐색 
	public void DFS2(Node root) {
		if(root == null) return;
		else {
			DFS2(root.lt);
			System.out.print(root.data+" ");
			DFS2(root.rt);
		}
	}
	
	//3. 후위 순회 (root를 가장 나중에 출력)
	public void DFS3(Node root) {
		if(root == null) return;
		else {
			DFS3(root.lt);
			DFS3(root.rt);
			System.out.print(root.data+" ");
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
		tree.DFS1(tree.root);
		System.out.println();
		tree.DFS2(tree.root);
		System.out.println();
		tree.DFS3(tree.root);
		
		
	}
}
