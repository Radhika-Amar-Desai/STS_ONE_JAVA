import java.util.*;

class Node {
    ArrayList<Node> neighbours = new ArrayList<>();
    int color = -1;
    int degree = 0;
    int vertex_id;

    Node(int vertex_id){
        this.vertex_id = vertex_id;
    }

    public void add_neighbour(Node node){
        this.neighbours.add(node);
        this.degree++;
    }
}

public class graph_coloring{
    
    public static boolean any_node_color_c(ArrayList<Node> nodes, int c){
        boolean result = false;
        for(Node node: nodes){
            if(node.color == c){
                return true;
            }
        }
        return false;
    }

    public static int[] color_graph(ArrayList<Node> vertices){
        
        Collections.sort(vertices, Comparator.comparingInt(v -> -v.degree));
        
        int[] vertices_and_color = new int[vertices.size()];

        for(Node vertex: vertices){
            for(int c = 0; c < vertices.size(); c++){
                if(!any_node_color_c(vertex.neighbours, c)){
                    vertex.color = c;
                    break;
                }
            }
        }

        for(Node vertex: vertices){
            vertices_and_color[vertex.vertex_id] = vertex.color;
        }

        return vertices_and_color;
    }
    
    public static ArrayList<Node> convert_adj_list_to_node_list(Map<Integer, int[]> adj_list){
        ArrayList<Node> nodes = new ArrayList<>();
        
        for(int vertex: adj_list.keySet()){
            nodes.add(new Node(vertex));
        }

        for(Node node: nodes){
            int[] neighbours = adj_list.get(node.vertex_id);
            
            for(int neighbour: neighbours){
                Node neighbour_node = nodes.get(neighbour);
                node.add_neighbour(neighbour_node);
            }
        }

        return nodes;
    }

    public static void main(String args[]){

        Map<Integer, int[]> adj_list = new HashMap<>();
        
        adj_list.put(0, new int[]{1, 2, 3});
        adj_list.put(1, new int[]{0, 2});
        adj_list.put(2, new int[]{0, 1, 3});
        adj_list.put(3, new int[]{0, 2});
    
        ArrayList<Node> vertices = convert_adj_list_to_node_list(adj_list);
        int[] vertices_and_color = color_graph(vertices);

        for(int color: vertices_and_color){
            System.out.println(color);
        }
    }
}