import java.util.*;

public class rough{
    static int[][] moves = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1},
    {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
    
    public static int count_onward_moves(int[][] board, int[] pos){
        
        int count = 0;

        for(int[] move: moves){
            
            int[] new_pos = new int[]{move[0] + pos[0], move[1] + pos[1]};
            
            if(0 <= new_pos[0] && new_pos[0] < 8 && 0 <= new_pos[1] && new_pos[1] < 8){
                if(board[new_pos[0]][new_pos[1]] == 0){
                count ++;}
            }
        }

        return count;
    }

    public static boolean helper(int[][] board, int n, int[] pos){
        if(n == 1){
            return true;
        }

        ArrayList<int[]> possible_moves = new ArrayList<>();

        for(int[] move: moves){
            int[] new_pos = new int[] {pos[0] + move[0], pos[1] + move[1]};
            if(0 <= new_pos[0] && new_pos[0] < 8 && 0 <= new_pos[1] && new_pos[1] < 8 && board[new_pos[0]][new_pos[1]] == 0){
                possible_moves.add(new int[]{new_pos[0], new_pos[1]});
            }
        }

        Collections.sort(possible_moves, Comparator.comparingInt(move -> count_onward_moves(board, move)));

        for(int[] move: possible_moves){
            
            board[move[0]][move[1]] = n - 1;
            
            if(helper(board, n - 1, move)){
                return true;
            }

            board[move[0]][move[1]] = 0;
        }

        return false;
    }
    public static void main(String args[]){
        int n = 8;
        int[][] board = new int[8][8];
        boolean res = helper(board, 64, new int[]{0, 0});
        if(res){
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board.length; j++){
                    System.out.print(board[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }
        };
    }
}