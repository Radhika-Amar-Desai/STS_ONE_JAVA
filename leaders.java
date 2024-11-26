import java.util.*;

public class leaders {
    public static ArrayList<Integer> getLeaders(int[] nums){
        ArrayList<Integer> leaders = new ArrayList<>();
        int[] right_max = new int[nums.length];
        for(int i = nums.length - 1; i > 0; i--){
            // 2 3 1 4 5 2
            // 5 5 5 5 5 2
            if(i == nums.length - 1){
                right_max[i] = nums[nums.length - 1];
                leaders.add(nums[nums.length - 1]);
            }
            else{
                if(nums[i] > right_max[i + 1]){
                    leaders.add(nums[i]);
                    right_max[i] = nums[i];
                }
                else{
                    right_max[i] = right_max[i + 1];
                }
            }
        }
        return leaders;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            String[] str_nums = sc.nextLine().split(" ");
            
            int[] nums = new int[str_nums.length];
            
            for(int i = 0; i < nums.length; i++){
                nums[i] = Integer.parseInt(str_nums[i]);
            }

            ArrayList<Integer> leaders = getLeaders(nums);
            
            Collections.reverse(leaders);
            
            for(int leader: leaders){
                System.out.print(leader);
                System.out.print(' ');
            }
        }
    }
}
