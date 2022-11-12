package check_valid_BST;

public class Solution_recursive {

    /*
    Each node will have addition two values: lower and upper.
    If value of every single node is between lower and upper (in case both lower and upper are not null), return true.
    If any of that two values(lower and upper) is null, consider that we don't need to compare it to value of the node.
     */
    public static boolean helper(TreeNode node, Integer lower, Integer upper){
        if(node == null) return true;
        int val = node.val;

        if(lower != null && val <= lower) return false;
        if(upper != null && val >= upper) return false;

        if(!helper(node.left, lower, val)) return false;
        if(!helper(node.right, val, upper)) return false;

        return true;
    }

    /*
    Time complexity: O(n)
    Space complexity: O(n)
     */
    public static boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
}