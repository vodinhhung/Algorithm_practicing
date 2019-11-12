package game_of_life;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public void gameOfLife(int[][] board) {
        int height = board.length;
        int depth = board[0].length;
        int[][] result = new int[height][depth];

        for(int i=0; i<height; i++){
            for(int j=0; j<depth; j++){
                int live = countNode(board, i, j);
                if(board[i][j]==0 && live==3) result[i][j] = 1;
                if(board[i][j]==1){
                    if(live<2 || live>3) result[i][j] = 0;
                    else result[i][j] = 1;
                }
            }
        }

        for(int i=0; i<height; i++){
            for(int j=0; j<depth; j++){
                board[i][j] = result[i][j];
            }
        }
    }

    private int countNode(int[][] arr, int i, int j){
        int live = 0;
        List<Integer> neigh = getNeighbor(arr, i, j);

        for(int k: neigh){
            if(k!=0) live++;
        }

        return live;
    }

    private List<Integer> getNeighbor(int[][] arr, int i, int j){
        int height = arr.length;
        int depth = arr[0].length;
        List<Integer> neigh = new ArrayList<>();

        if(i != 0) neigh.add(arr[i-1][j]);
        if(i != height-1) neigh.add(arr[i+1][j]);
        if(j != 0) neigh.add(arr[i][j-1]);
        if(j != depth-1) neigh.add(arr[i][j+1]);
        if(i != 0 && j != 0) neigh.add(arr[i-1][j-1]);
        if(i != 0 && j != depth-1) neigh.add(arr[i-1][j+1]);
        if(j != 0 && i != height-1) neigh.add(arr[i+1][j-1]);
        if(j != depth-1 && i!= height-1) neigh.add(arr[i+1][j+1]);

        return neigh;
    }
}