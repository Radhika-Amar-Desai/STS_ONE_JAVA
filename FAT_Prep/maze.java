import java.util.*;

public class maze {
    public static ArrayList<String> helper(int[][] maze, int n, int m, String path, int[] stop){
        if(stop[0] == (n-1) && stop[1] == (m-1)){
            ArrayList<String> result = new ArrayList<>();
            result.add(path);
            return result;
        }
        
        ArrayList<String> all_results = new ArrayList<>();
        int[][] turns = {{0, 1}, {1, 0}};
        
        for(int i = 0; i < turns.length; i++){
            
            int[] new_stop = {stop[0] + turns[i][0], stop[1] + turns[i][1]};
            String new_stop_path = " (" + String.valueOf(new_stop[0]) + "," + String.valueOf(new_stop[1]) + ")";
            
            if(new_stop[0] < n && new_stop[1] < m && maze[new_stop[0]][new_stop[1]] == 1){
            
            ArrayList<String> option = helper(maze, n, m, path + new_stop_path, new_stop);

            for(int j = 0; j < option.size(); j++){
                    all_results.add(option.get(j));
                }
            }
        }
        return all_results;
    };
    public static void main(String args[]){
        int[][] maze = {{1, 0, 0, 0},
        {1, 1, 0, 1},
        {0, 1, 0, 0},
        {1, 1, 1, 1}};
        String path = "";
        int[] stop = {0, 0};
        
        ArrayList<String> res = helper(maze, 4, 4, path, stop);
        for(int i = 0; i < res.size(); i++ ){
            System.out.println(res.get(i));
        }
    }
}
