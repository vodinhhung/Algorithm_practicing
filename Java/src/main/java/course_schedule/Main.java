package course_schedule;

public class Main {
    public static void main(String[] args){
        Solution_dfs solutionDfs = new Solution_dfs();
        Solution_topological solutionTopological = new Solution_topological();

        int[][] pre = {
                {1,0},
                {0,1},
        };
        int nums = 3;

        boolean canFinish = solutionTopological.canFinish(nums, pre);
        System.out.println(canFinish);
    }
}
