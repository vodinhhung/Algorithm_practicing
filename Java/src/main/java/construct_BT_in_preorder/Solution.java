package construct_BT_in_preorder;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    static int pre;

    public static  TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return tree(0,inorder.length-1,preorder,map);
    }

    public static TreeNode tree(int start,int end,int[] preorder,Map<Integer,Integer> map){
        if(start>end)return null;
        TreeNode root=new TreeNode(preorder[pre]);
        int r=pre;
        pre++;
        root.left=tree(start,map.get(preorder[r])-1,preorder,map);
        root.right=tree(map.get(preorder[r])+1,end,preorder,map);
        return root;
    }

    public static void main(String[] args){
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};

        TreeNode root = buildTree(preorder, inorder);
    }
}
