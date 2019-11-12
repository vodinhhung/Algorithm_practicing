package game_of_life;

public class Main {
    public static void main(String[] args){
        Solution solution = new Solution();

        int[][] board = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0},
        };

        solution.gameOfLife(board);

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
