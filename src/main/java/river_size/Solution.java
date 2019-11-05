package river_size;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> riverSizes(int[][] matrix) {
        int height = matrix.length;
        int weight = matrix[0].length;
        int[][] isVisited = new int[height][weight];

        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<height; i++){
            for(int j=0; j<weight; j++){
                if(isVisited[i][j]==0){
                    int count = riverSize(matrix, i, j, isVisited);
                    if(count != 0) result.add(count);
                }
            }
        }
        return result;
    }

    private static int riverSize(int[][] matrix, int i, int j, int[][] isVisited){
        if(matrix[i][j] == 0 || matrix[i][j]==1 && isVisited[i][j]==1) return 0;
        isVisited[i][j] = 1;

        ArrayList<Integer[]> neighbor = new ArrayList<>();
        if(i>0) neighbor.add(new Integer[]{i-1, j});
        if(j>0) neighbor.add(new Integer[]{i, j-1});
        if(i<matrix.length-1) neighbor.add(new Integer[]{i+1, j});
        if(j<matrix[0].length-1) neighbor.add(new Integer[]{i, j+1});

        int size = 1;
        for(Integer[] child: neighbor){
            size += riverSize(matrix, child[0], child[1], isVisited);
        }
        return size;
    }
}
