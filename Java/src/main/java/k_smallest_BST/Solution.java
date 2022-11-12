package k_smallest_BST;

import java.util.ArrayList;
import java.util.List;

/*
Leetcode 230
 */
public class Solution {
    public static int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        List<Integer> ascendingList = new ArrayList<>();
        addList(ascendingList, root);

        return ascendingList.get(k-1);
    }

    public static void addList(List<Integer> list, TreeNode node){
        if(node.left != null) addList(list, node.left);
        list.add(node.val);
        if(node.right != null) addList(list, node.right);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);

        TreeNode node1 = new TreeNode(3);
        root.left = node1;
        TreeNode node2 = new TreeNode(6);
        root.right = node2;

        TreeNode node3 = new TreeNode(2);
        node1.left = node3;
        TreeNode node4 = new TreeNode(4);
        node2.right = node4;

        TreeNode node5 = new TreeNode(1);
        node3.left = node5;

        int result = kthSmallest(root, 3);
        System.out.println(result);
    }
}
