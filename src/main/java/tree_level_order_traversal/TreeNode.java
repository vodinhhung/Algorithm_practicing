package tree_level_order_traversal;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode addRight(int val){
        TreeNode newNode = new TreeNode(val);
        right = newNode;
        return newNode;
    }

    public TreeNode addLeft(int val){
        TreeNode newNode = new TreeNode(val);
        left = newNode;
        return newNode;
    }
}
