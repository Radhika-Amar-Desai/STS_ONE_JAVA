import java.util.*;

public class leaders {
    public static void main(String args[]){
        
        ArrayList<Integer> nums = new ArrayList<>();
        
        nums.add(16);
        nums.add(17);
        nums.add(4);
        nums.add(3);
        nums.add(5);
        nums.add(2);
        
        //System.out.println(nums);

        Collections.reverse(nums);

        //System.out.println(nums);

        ArrayList<Integer> leaders = new ArrayList<>();

        int max_so_far = nums.get(0);

        leaders.add(max_so_far);

        for(int i = 0; i < nums.size(); i ++){
            
            if(nums.get(i) > max_so_far){

                leaders.add(nums.get(i));
                max_so_far = nums.get(i);

            }    
        
        }

        Collections.reverse(leaders);
        System.out.println(leaders);

    }
}
