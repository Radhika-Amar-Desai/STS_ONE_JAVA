import java.util.*;

public class maze_solve {
    public static ArrayList<ArrayList<ArrayList<Integer>>> helper(int[][] maze, ArrayList<ArrayList<Integer>> path, int[] stop){
        if(stop[0] == maze.length - 1 && stop[1] == maze[0].length - 1){
            ArrayList<ArrayList<ArrayList<Integer>>> res = new ArrayList<>();
            res.add(path);
            return res;
        }
        
        ArrayList<ArrayList<ArrayList<Integer>>> results = new ArrayList<>();
        
        int[][] turns = {{0, 1}, {1, 0}};

        for(int[] turn : turns){
            
            int[] new_stop = {stop[0] + turn[0], stop[1] + turn[1]};
            
            if(new_stop[0] < maze.length && new_stop[1] < maze[0].length && maze[new_stop[0]][new_stop[1]] == 1){
                
                ArrayList<Integer> stop_wrapper = new ArrayList<>();
                
                stop_wrapper.add(new_stop[0]);
                stop_wrapper.add(new_stop[1]);
                path.add(stop_wrapper);
                
                for(ArrayList<ArrayList<Integer>> node : helper(maze, path, new_stop)){
                    results.add(node);    
                }
            }
        }
        return results;
    }
    
    public static void main(String[] args) {
        // [1, 0, 0, 0
        //  1, 1, 0, 1
        //  0, 1, 0, 0
        //  1, 1, 1, 1]
        int[][] maze = {{ 1, 0, 0, 0 },
                        { 1, 1, 0, 1 },
                        { 0, 1, 0, 0 },
                        { 1, 1, 1, 1 }};

        int[] stop = {0, 0};

        ArrayList<ArrayList<Integer>> path = new ArrayList<>();
        ArrayList<Integer> stop_wrapper = new ArrayList<>();
        
        stop_wrapper.add(stop[0]);
        stop_wrapper.add(stop[1]);
        path.add(stop_wrapper);

        ArrayList<ArrayList<ArrayList<Integer>>> solution_path = helper(maze, path, stop);
        ArrayList<ArrayList<Integer>> only_solution_path = solution_path.get(0);
        
        int[][] solution_maze = new int[maze.length][maze[0].length];
        
        for(ArrayList<Integer> node: only_solution_path){
            solution_maze[node.get(0)][node.get(1)] = 1;
        }

        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                System.out.print(solution_maze[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
