import java.util.*;

public class majority {
    static int get_majority_element(ArrayList<Integer> nums){

        Map<Integer, Integer> num_freq = new HashMap<>();

        for(int num: nums){
            if(num_freq.keySet().contains(num)){
                num_freq.put(num, num_freq.get(num) + 1);
            }
            else{
                num_freq.put(num, 1);
            }
        }


        int majority_freq = (int)(nums.size() / 2);
        
        //System.out.println(num_freq);
        //System.out.println(majority_freq);

        for(int num: num_freq.keySet()){
            if(num_freq.get(num) >= majority_freq){
                return num;
            }
        }

        return -1;
    }
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> nums = new ArrayList<>();
        // nums.add(1);
        // nums.add(2);
        // nums.add(3);
        // nums.add(4);
        // nums.add(4);
        // nums.add(4);

        for(int i = 0; i < n; i++){
            nums.add(sc.nextInt());
        }

        int majority_element = get_majority_element(nums);    
        
        System.out.println(majority_element);
    }
}
