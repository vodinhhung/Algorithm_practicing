package lowest_common_ancestor;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<TreeNode, Boolean> paOfP = new HashMap<>();
    Map<TreeNode, Boolean> paOfQ = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(isCommonPa(root, p, q)){
            if(!isCommonPa(root.left, p, q) && !isCommonPa(root.right, p, q))
                return root;
            if(isCommonPa(root.left, p, q))
                return lowestCommonAncestor(root.left, p, q);
            else
                return lowestCommonAncestor(root.right, p, q);
        }
        return null;
    }

    public boolean isCommonPa(TreeNode node, TreeNode p, TreeNode q){
        if(node == null) return false;
        return isPa(node, p, paOfP)&&isPa(node, q, paOfQ);
    }

    public boolean isPa(TreeNode node, TreeNode p, Map<TreeNode, Boolean> paOfP){
        if(!paOfP.containsKey(node)){
            if(node == null) return false;
            if(node == p) paOfP.put(node, true);
            else {
                Boolean isPa = isPa(node.left, p, paOfP) || isPa(node.right, p, paOfP);
                paOfP.put(node, isPa);
            }
        }
        return paOfP.get(node);
    }
}
