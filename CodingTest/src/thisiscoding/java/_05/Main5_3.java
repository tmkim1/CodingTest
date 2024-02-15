package thisiscoding.java._05;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main5_3 {
}


/**
 * LeetCode
 * https://leetcode.com/problems/cousins-in-binary-tree/
 * *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class TreeNode {
    int val;
    int level;
    int parentNodeVal;
    TreeNode left;
    TreeNode right;


    TreeNode() {}
    TreeNode(int val) {this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode getLeft() {
        return this.left;
    }

    public TreeNode getRight() {
        return this.right;
    }

    public int getVal() {
        return this.val;
    }

    public int getLevel() {
        return this.level;
    }

    public int getParentNodeVal() {
        return this.parentNodeVal;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setParentNodeVal(int parentNodeVal) {
        this.parentNodeVal = parentNodeVal;
    }

}

// 부모 노드가 다르면서 같은 level의 노드인 경우 cousins -> true
// value unique
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {

        //validation check, root node는 단 1개이기 때문에 같은 level의 cousin이 존재하지 않는다.
        if(x == 1 || y == 1) {
            return false;
        }

        Queue<TreeNode> q = new LinkedList<>();
        HashMap<Integer, TreeNode> nodeMaps = new HashMap<>();
        boolean isFoundX = false;
        boolean isFoundY = false;

        root.setLevel(1);
        q.offer(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode leftNode = node.getLeft();
            TreeNode rightNode = node.getRight();

            if(leftNode != null) {
                leftNode.setParentNodeVal(node.getVal());
                leftNode.setLevel((node.getLevel()+1));
                nodeMaps.put(leftNode.getVal(), leftNode);
                q.offer(leftNode);
            }

            if(rightNode != null) {
                rightNode.setParentNodeVal(node.getVal());
                rightNode.setLevel(node.getLevel() + 1);

                nodeMaps.put(rightNode.getVal(), rightNode);
                q.offer(rightNode);
            }

            //x, y를 다 찾은 경우는 q를 더 이상 꺼내 볼 필요가 없다.
            if(leftNode != null && leftNode.getVal() == x || rightNode != null && rightNode.getVal() == x) {
                isFoundX = true;
            }
            if(leftNode != null && leftNode.getVal() == y || rightNode != null && rightNode.getVal() == y) {
                isFoundX = true;
            }

            if(isFoundX && isFoundY) break;
        }

        TreeNode xNode = nodeMaps.get(x);
        TreeNode yNode = nodeMaps.get(y);

        //서로 parentNode가 다르고, level이 같다면 cousin true
        if(xNode.getParentNodeVal() == yNode.getParentNodeVal() || xNode.getLevel() != yNode.getLevel()) {
            return false;
        }

        return true;
    }
}