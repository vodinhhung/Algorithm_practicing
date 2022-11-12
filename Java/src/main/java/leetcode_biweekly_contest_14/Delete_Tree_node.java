package leetcode_biweekly_contest_14;

public class Delete_Tree_node {
    public static int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        int[] isVisted = new int[nodes];
        int[] sum = new int[nodes];
        countSum(sum, nodes, parent, value, isVisted, 0);
        int result = 0;

        for(int i=0; i<nodes; i++){
            if(sum[i] == 0){
                for(int k=0; k<nodes; k++){
                    if(parent[k] == i) sum[k] = 0;
                }
            }
        }

        for(int i:sum){
            if(i!= 0) result++;
        }
        return result;
    }

    public static void countSum(int [] sum, int nodes, int[] parent, int[] value, int[] isVisted, int i){
        if(isVisted[i] == 0){
            sum[i] = value[i];
            for(int k=0; k<nodes; k++){
                if(i == parent[k]){
                    if(isVisted[k] == 0){
                        countSum(sum, nodes, parent, value, isVisted, k);
                        isVisted[k] =1;
                    }
                    sum[i] += sum[k];
                }
            }
            isVisted[i] = 1;
        }
    }

    public static void main(String[] args){
        int nodes = 7;
        int[] parent = {-1,0,0,1,2,2,2};
        int[] value  = {1,-2,4,0,-2,-1,-1};

        System.out.print(deleteTreeNodes(nodes, parent, value));
    }
}
