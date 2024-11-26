import java.util.*;

public class sorted_permutations {
    public static ArrayList<String> get_sorted_permutations(String input, String output){
        if (input.length() == 0) {
            ArrayList<String> result = new ArrayList<String>();
            result.add(output);
            return result;
        }
        
        ArrayList<String> res = new ArrayList<>();
        
        for (int i = 0; i < input.length(); i++){
            String new_input = "";
            
            for(int j = 0; j < input.length(); j++){
                if(i != j){
                    new_input += input.charAt(j);
                }
            }

            ArrayList<String> subres = get_sorted_permutations(new_input, output + input.charAt(i));
            for(int k = 0; k < subres.size(); k++){
                res.add(subres.get(k));
            }
        }

        return res;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String input_str = sc.next();
        
        ArrayList<String> permutations_sorted = get_sorted_permutations(input_str, "");

        Collections.sort(permutations_sorted);
        
        for (int i = 0; i < permutations_sorted.size(); i++){
            System.out.println(permutations_sorted.get(i));
        }
        sc.close();
    }
}
