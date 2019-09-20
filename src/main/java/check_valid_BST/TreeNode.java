package check_valid_BST;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
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
