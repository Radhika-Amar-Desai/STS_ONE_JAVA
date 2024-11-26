import java.util.*;

public class HamiltonCycleDetection {
    public static boolean helper(int[][] graph, int vertex, ArrayList<Integer> path, int start) {
        if(path.size() == graph.length){
            for(int neighbour: path){
                if(neighbour == start){
                    return true;
                }
            }
            return false;
        }

        for(int neighbour: graph[vertex]){
            if(!path.contains(neighbour)){
                path.add(neighbour);
                if(helper(graph, neighbour, path, start)){
                    return true;
                };
                path.remove(path.size() - 1);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Graph as adjacency list
        int[][] graph = {
            {1, 2},  // Vertex 0 is connected to vertices 1 and 2
            {0, 2, 3}, // Vertex 1 is connected to vertices 0, 2, and 3
            {0, 1, 3}, // Vertex 2 is connected to vertices 0, 1, and 3
            {1, 2}     // Vertex 3 is connected to vertices 1 and 2
        };

        ArrayList<Integer> path = new ArrayList<>();
        int startVertex = 0; // Start from vertex 0
        path.add(startVertex);

        boolean hasHamiltonianCycle = helper(graph, startVertex, path, startVertex);
        System.out.println("Hamiltonian Cycle Found: " + hasHamiltonianCycle);
    }
}
