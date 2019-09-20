package check_valid_BST;

public class Solution_naive {

    // Recursive solution (naive)
    // Time complexity: O(n)
    // Space complexity: O(1)
    public static boolean isValidBST(TreeNode root) {
        if (root == null || (root.left==null && root.right==null))
            return true;

        int maxLeftVal = root.val - 1;
        int minRightVal  = root.val + 1;
        TreeNode maxLeft = root.left;
        TreeNode minRight = root.right;

        if(maxLeft != null){
            while(maxLeft.right != null){
                maxLeft = maxLeft.right;
            }
            maxLeftVal = maxLeft.val;
        }

        if(minRight != null){
            while(minRight.left != null){
                minRight = minRight.left;
            }
            minRightVal = minRight.val;
        }

        if(root.val == Integer.MIN_VALUE){
            if(root.left != null)
                return false;
            if(minRightVal > root.val)
                return isValidBST(root.right);
        }

        if(root.val == Integer.MAX_VALUE){
            if(root.right != null)
                return false;
            if(maxLeftVal < root.val)
                return isValidBST(root.left);
        }

        if(root.val < minRightVal && root.val > maxLeftVal)
            return isValidBST(root.left)&&isValidBST(root.right);
        else return false;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        TreeNode node1 = root.addRight(Integer.MAX_VALUE);
        TreeNode node3 = node1.addLeft(Integer.MIN_VALUE + 1);
        TreeNode node4 = node3.addRight(Integer.MIN_VALUE);
//        TreeNode node5 = node4.addRight(45);

        boolean isValid = isValidBST(root);
        System.out.println(isValid);
    }
}
