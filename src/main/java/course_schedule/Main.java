package course_schedule;

public class Main {
    public static void main(String[] args){
        Solution_dfs solutionDfs = new Solution_dfs();

        int[][] pre = {
                {1,0},
                {0,1},
        };
        int nums = 3;

        boolean canFinish = solutionDfs.canFinish(nums, pre);
        System.out.println(canFinish);
    }
}
