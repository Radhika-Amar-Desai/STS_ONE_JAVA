import java.util.*;

public class booth {
    static String to_binary(int num){

        String bin_str = Integer.toBinaryString(num);
        String output = "";

        for (int i = bin_str.length(); i < 4; i++) {
            output += "0";
        }

        if(bin_str.length() > 4){
            for (int i = 3; i >= 0; i--){
                output += bin_str.charAt(bin_str.length() - i - 1);
            }
        }
        else {
            for (int i = 0; i < bin_str.length(); i++){
                output += bin_str.charAt(i);
            }    
        }

        return output;
    }
    
    static String right_shift(String p){
        String output = p.charAt(0) == '0' ? "0": "1";
        for(int i = 0; i < p.length() - 1; i++){
            output += p.charAt(i);
        }
        //System.out.print(Integer.toString(p.length()) + " " + Integer.toString(output.length()) + " ");
        return output;
    }

    static String add(String p, String q){
        String acc_str = "";

        for(int i = 0; i < 4; i++){
            acc_str += p.charAt(i);
        }

        int acc_num = Integer.parseInt(acc_str, 2);
        int q_num = Integer.parseInt(q, 2);

        int res = acc_num + q_num;
        String res_bin = to_binary(res);

        String output = "";
        
        output += res_bin;

        for(int i = 4; i < p.length(); i++){
            output += p.charAt(i);
        }

        return output;
    }
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt();
        int q = sc.nextInt();


        String m_bin = to_binary(m);
        String q_bin = to_binary(q);
        String m1_bin = to_binary(-m);
        char q0 = '0';

        System.out.println(m_bin);
        System.out.println(q_bin);
        System.out.println(m1_bin);

        String p = "";
        for(int i = 0; i < 4; i++){
            p += "0";
        }

        p += q_bin;
        p += q0;

        for(int i = 0; i < 4; i++){
            
            if(p.charAt(7) == '0' && p.charAt(8) == '1'){
                p = add(p, m_bin);
            }
            
            else if(p.charAt(7) == '1' && p.charAt(8) == '0'){
                p = add(p, m1_bin);
            }
            
            p = right_shift(p);
            System.out.println(p);
        }

    }    
}
