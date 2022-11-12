package lowest_common_ancestor;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        root.left = node1;
        TreeNode node2 = new TreeNode(4);
        root.right = node2;

        Solution solution = new Solution();
        TreeNode result = solution.lowestCommonAncestor(root, node1, node2);
        System.out.println(result.val);
    }
}
