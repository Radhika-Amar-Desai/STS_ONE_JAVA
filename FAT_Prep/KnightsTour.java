import java.util.ArrayList;
import java.util.Comparator;

public class KnightsTour {
    // Possible knight moves
    static int[][] moves = { {2, 1}, {2, -1}, {-2, 1}, {-2, -1}, 
                             {1, 2}, {1, -2}, {-1, 2}, {-1, -2} };

    // Method to add a position to the path
    public static void add_to_path(ArrayList<ArrayList<Integer>> path, int[] new_pos) {
        ArrayList<Integer> new_pos_wrapper = new ArrayList<>();
        new_pos_wrapper.add(new_pos[0]);
        new_pos_wrapper.add(new_pos[1]);
        path.add(new_pos_wrapper);
    }

    // Count the number of onward moves from a given position
    public static int countOnwardMoves(int[][] board, int row, int col) {
        int count = 0;
        for(int[] move: moves){
            int new_row = row + move[0];
            int new_col = col + move[1];
            if(0 <= new_row && new_row < 8 && 0 <= new_col && new_col < 8 && board[new_row][new_col] == 0){
                count ++;
            }
        }
        return count;
    }

    // Recursive helper function with Warnsdorff's Rule
    public static boolean helper(int[][] board, int n, int[] pos, ArrayList<ArrayList<Integer>> path) {
        if(n == 1){
            return true;
        }

        ArrayList<int[]> possible_moves = new ArrayList<>();

        for(int i = 0; i < moves.length; i++){
            int[] new_pos = {pos[0] + moves[i][0], pos[1] + moves[i][1]};
            possible_moves.add(new_pos);
        }

        possible_moves.sort(Comparator.comparingInt(m -> countOnwardMoves(board, m[0], m[1])));

        for(int[] new_pos : possible_moves){
            if(0 <= new_pos[0] && new_pos[0] < 8 && 0 <= new_pos[1] && new_pos[1] < 8 && board[new_pos[0]][new_pos[1]] == 0) {
                board[new_pos[0]][new_pos[1]] = 1;
                add_to_path(path, new_pos);
            
                if (helper(board, n - 1, new_pos, path)){
                    return true;
                }
            
                board[new_pos[0]][new_pos[1]] = 0;
                path.remove(path.size() - 1);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int n = 64; // Total squares on an 8x8 board
        int[][] board = new int[8][8];
        int[] startPos = {0, 0}; // Starting position

        // Initialize the path and mark the starting position
        ArrayList<ArrayList<Integer>> path = new ArrayList<>();
        add_to_path(path, startPos);
        board[startPos[0]][startPos[1]] = 1;

        // Solve the Knight's Tour using Warnsdorff's Rule
        if (helper(board, n, startPos, path)) {
            System.out.println("Knight's Tour completed:");
            System.out.println(path);
        } else {
            System.out.println("No solution exists.");
        }
    }
}
