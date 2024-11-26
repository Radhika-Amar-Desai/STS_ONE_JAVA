import java.util.*;

public class hourglass {
    static int compute_hourglass_sum(int[][] matrix, int row, int col, int h){
        
        int res = 0;

        for(int i = row; i < row + h; i++){
            for(int j = col; j < col + h; j++){

                res += matrix[i][j];

            }
        }
        return res;
    }
    public static void main(String args[]){
        
        int[][] matrix = {
            {1, 2, 4, 5, 6},
            {7, 5, 2, 3, 6},
            {0, 0, 0, 0, 0},
            {7, 5, 1, 3, 5},
            {0, 0, 0, 0, 0}
        };

        int h = 3;
        int n = 5;
        int m = 5;
        

        ArrayList<Integer> hourglass_sum = new ArrayList<>();

        for(int i = 0; i < n - h + 1; i++){
            
            for(int j = 0; j < m - h + 1; j++){
            
                hourglass_sum.add(compute_hourglass_sum(matrix, i, j, h));
            
            }
        }

        System.out.println(Collections.max(hourglass_sum));

    }
}
