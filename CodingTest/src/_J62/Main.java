package _J62;

/**
 * 62. 말단 노드까지의 가장 짧은 경로 (DFS)
 * 
 * - 말단 노드란 자식 노드가 없는 노드를 뜻함. 
 *   최단 거리를 구하는 경우는 BFS를 쓰는게 효율적이지만 DFS의 성질을 알아보기 위한 문제 
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
	}
}
