import java.util.*;

public class longest_seq_of_ones {
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            String s = sc.nextLine();
            int k = sc.nextInt();
            
            int left = 0;
            int right = 0;

            int zeros_count = s.charAt(left) == '0' ? 1 : 0;
            int max_len = 0;
            
            while(right < s.length() - 1){
                if(s.charAt(right) == '1'){
                    right++;
                }
                if(s.charAt(right) == '0'){ 
                    if(zeros_count < k){
                        zeros_count += 1;
                        right++;
                    }
                    else if(zeros_count == k){
                        max_len = Math.max(max_len, right - left);
                        left++;
                        zeros_count = s.charAt(left) == '0' ? 1 : 0;
                    }
                }
            }

            System.out.print(max_len);
        }
    }
}
