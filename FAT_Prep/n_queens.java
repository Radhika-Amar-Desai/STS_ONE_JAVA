import java.util.*;

public class n_queens {
    public static boolean is_safe(int[][] board, int[] pos){
        int n = board.length;
        int m = board[0].length;

        int row = pos[0];
        int col = pos[1];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 1){
                    if(i == row){
                        return false;
                    }
                    if(j == col){
                        return false;
                    }
                    if(Math.abs(row - i) == Math.abs(col - j)){
                        return false;
                    }
                }
            }
        }

        return true;
    };
    
    public static boolean solve_n_queens_util(int[][] board, int n){
        if(n == 0){
                for(int i = 0; i < board.length; i++){
                    for(int j = 0; j < board.length; j++){
                        if(board[i][j] == 1){
                            System.out.print("Q ");
                        }
                        else{
                            System.out.print(". ");
                        }
                    }
                    System.out.println();
                }
                return true;
        }
        for(int i = 0; i < board.length; i++){
                int[] pos = {i, n - 1};
                
                if(is_safe(board, pos)){
                    
                    board[i][n-1] = 1;
                    
                    if(solve_n_queens_util(board, n - 1)){
                        return true;
                    }

                    board[i][n-1] = 0;
                }
        }
        
        return false;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        solve_n_queens_util(board, n);
    }
}
