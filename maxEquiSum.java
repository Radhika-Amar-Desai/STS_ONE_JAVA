import java.util.*;

public class maxEquiSum {
    public static int getMaxEquipSum(ArrayList<Integer> nums){
        int min_diff = Integer.MAX_VALUE;
        int sum_nums = 0;
        int prefix = 0;
        int res = 0;

        for(int num : nums){
            sum_nums += num;
        }
        
        for(int i = 0; i < nums.size() / 2 + 1; i++){
            prefix += nums.get(i);
            if(min_diff > sum_nums - 2 * prefix){
                min_diff = sum_nums - 2 * prefix;
                if(min_diff >= 0){
                    res = prefix;
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            String s = sc.nextLine();
            String[] str_nums = s.split(" " );
            
            ArrayList<Integer> nums = new ArrayList<>();
            
            for(String num: str_nums){
                nums.add(Integer.valueOf(num));
            }

            System.out.println(getMaxEquipSum(nums));
        }
    }
}
