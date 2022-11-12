package four_sum;

public class Main {
    public static void main(String[] args){
        Solution_naive solutionNaive = new Solution_naive();
        Solution_optimal solution_optimal = new Solution_optimal();

        int[] A = {-1, -1};
        int[] B = {-1, 1};
        int[] C = {-1, 1};
        int[] D = {1, -1};

        int result = solutionNaive.fourSumCount(A, B, C, D);
        System.out.print(result);

        int result2 = solution_optimal.fourSumCount(A, B, C, D);
        System.out.print(result2);
    }
}
