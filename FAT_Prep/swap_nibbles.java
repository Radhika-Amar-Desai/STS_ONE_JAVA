import java.util.*;

public class swap_nibbles {
    
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();

        int res = ((n & 0xF0) >> 4) | ((n & 0x0F) << 4);
        System.out.println(res);
    }
}
