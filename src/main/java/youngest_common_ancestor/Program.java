package youngest_common_ancestor;

import java.util.HashMap;
import java.util.Map;

public class Program {
    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        // Write your code here.
        Map<AncestralTree, Boolean> check = new HashMap<>();
        generateAncestor(topAncestor, descendantOne, check);

        while(descendantTwo != null){
            // System.out.println(descendantTwo.name);
            if(check.containsKey(descendantTwo)) return descendantTwo;
            descendantTwo = descendantTwo.ancestor;
        }
        return null;
    }

    public static void generateAncestor(AncestralTree root, AncestralTree p, Map<AncestralTree, Boolean> check){
        while(p.ancestor != null){
            check.put(p, true);
            p = p.ancestor;
        }
        check.put(root, true);
        for(AncestralTree node: check.keySet()){
            System.out.println(node.name);
        }
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}
