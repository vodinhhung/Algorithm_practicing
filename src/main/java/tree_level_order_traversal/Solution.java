package tree_level_order_traversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<TreeNode>> nodeList = new ArrayList<>();
        if(root == null)
            return result;

        List<TreeNode> nodeLayer = new ArrayList<>();
        nodeLayer.add(root);

        while(nodeLayer.size() != 0){
            List<TreeNode> cur = new ArrayList<>();
            List<Integer> curInt = new ArrayList<>();
            for(TreeNode node: nodeLayer){
                curInt.add(node.val);
                if(node.left != null)
                    cur.add(node.left);
                if(node.right != null)
                    cur.add(node.right);
            }
            result.add(curInt);
            nodeLayer = cur;
        }

        return result;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode node1 = root.addLeft(9);
        TreeNode node2 = root.addRight(20);
        TreeNode node3 = node2.addLeft(15);
        TreeNode node4 = node2.addRight(7);

        List<List<Integer>> result = levelOrder(root);
        System.out.println(result);
    }
}
