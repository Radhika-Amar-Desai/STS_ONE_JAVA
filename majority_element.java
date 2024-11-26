import java.util.*;

public class majority_element {
    public static void main(String[] args){
        int[] arr = {3,3,2,2,2,2};
        
        Map<Integer,Integer> char_and_freq = new HashMap<>();
        
        for(int num : arr){
            char_and_freq.put(num, char_and_freq.getOrDefault(num, 0) + 1);
        }
        
        for(int num: char_and_freq.keySet()){
            if(char_and_freq.get(num) > arr.length / 2){
                System.out.print(num);
                break;
            }
        }
    }    
}
