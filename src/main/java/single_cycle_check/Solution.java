package single_cycle_check;

public class Solution {
    public static int nextIndex(int[] arr, int cur){
        int jump = arr[cur] % arr.length;
        int next = (cur + jump) % arr.length;
        return next>=0? next : next+arr.length;
    }

    public static boolean hasSingleCycle(int[] array) {
        // Write your code here.
        int cur = 0;
        int len = array.length;

        for(int i=0; i<len; i++){
            if(i>0 && cur==0) return false;
            cur = nextIndex(array, cur);
        }

        return cur == 0;
    }

    public static void main(String[] args){
        int[] nums = {2,2,-1};
        boolean isCycle = hasSingleCycle(nums);

        System.out.println(isCycle);
    }
}
