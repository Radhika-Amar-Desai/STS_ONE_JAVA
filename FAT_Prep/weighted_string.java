import java.util.*;

public class weighted_string{
    
    static int get_weight(String P, String Q, int i, int j){
        
        int weight = 0;
        
        for(int pt = i; pt < j + 1; pt++){
            
            char ch = P.charAt(pt);
            int ascii = (int)ch - (int)'a';

            weight += Integer.parseInt(Character.toString(Q.charAt(ascii)));
        
        }
        
        return weight;
    }
    
    static int get_substring_atmost_k_weight_count(String P, String Q, int k){
        
        HashSet<String> uniq_val = new HashSet<>();
        
        for(int len = 1; len < P.length(); len++){
    
            for(int i = 0; i < P.length() - len + 1; i++){
        
                int j = i + len - 1;
        
                if(get_weight(P, Q, i, j) <= k){
                    uniq_val.add(P.substring(i, j + 1));
                }
        
            }
        }

        //System.out.println(uniq_val);
        return uniq_val.size();    
    }
    public static void main(String args[]){
 
        String P = "acbaCBacaa";
        String Q = "12300045600078900012345000";
        int k = 2;

        int res = get_substring_atmost_k_weight_count(P.toLowerCase(), Q, k);
        
        System.out.println(res);
    }
}