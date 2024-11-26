import java.util.*;

class Disjoint_set {
    int[] parents;
    
    Disjoint_set(int[] parents){
        this.parents = parents;
    }

    public int find(int node){
        if(this.parents[node] == node){
            return node;
        }
        else{
            return find(parents[node]);
        }

    }

    public boolean union(int node_one, int node_two){
        int parent_one = find(node_one);
        int parent_two = find(node_two);
        if(parent_one == parent_two){
            return false;
        }
        else{
            this.parents[find(node_one)] = find(node_two);
            return true;
        }
    }

}

public class kruskal {
    public static int get_weight(int[] edge){
        return edge[2];
    }

    public static ArrayList<int[]> MST(int[][] edges, int n){
        
        ArrayList<int[]> new_edges = new ArrayList<>();
        int parents[] = new int[n];

        for(int i = 0; i < n; i++){
            parents[i] = i;
        }

        Disjoint_set ds = new Disjoint_set(parents);
        ArrayList<int[]> arr_edges = new ArrayList<>();

        for(int[] edge: edges){
            arr_edges.add(edge);
        }

        Collections.sort(arr_edges, Comparator.comparingInt(edge -> get_weight(edge)));

        for(int[] edge: arr_edges){
            int node_one = edge[0];
            int node_two = edge[1];
            if(ds.union(node_one, node_two)){
                new_edges.add(edge);
            };
        }

        return new_edges;
    }
    public static void main(String args[]){
        // A B C D E F G H I J
        // 1 2 3 4 5 6 7 8 9 10
        int[][] edges = {
            {0, 1, 5},
            {0, 3, 4},
            {0, 4, 1},
            {1, 2, 4},
            {1, 3, 2},
            {2, 9, 2},
            {2, 7, 4},
            {2, 8, 1},
            {3, 4, 2},
            {3, 7, 2},
            {3, 6, 11},
            {3, 5, 5},
            {4, 5, 1},
            {5, 6, 7},
            {6, 7, 1},
            {6, 8, 4},
            {7, 8, 6},
            {8, 9, 0}
        };

        ArrayList<int[]> new_edges = MST(edges, 10);
        for(int[] edge: new_edges){
            System.out.print(edge[0]);
            System.out.print(" ");
            System.out.print(edge[1]);
            System.out.print(" ");
            System.out.print(edge[2]);
            System.out.println();
        };
    }
}
