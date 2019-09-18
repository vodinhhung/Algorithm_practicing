package inorder_traversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        if(root == null){
            return result;
        }

        if(root.left != null){
            List<Integer> leftList = inorderTraversal(root.left);
            result.addAll(leftList);
        }
        result.add(root.val);
        if(root.right != null){
            List<Integer> rightList = inorderTraversal(root.right);
            result.addAll(rightList);
        }

        return result;
    }
}
