
import java.util.Scanner;

public class booth {
    public static String to_binary(int n){
        String n_bin = Integer.toBinaryString(n);
        String output = "";

        if(n_bin.length() < 4){
            for(int i = 0; i < 4 - n_bin.length(); i++){
                output += "0";
            }
            output += n_bin;
        }
        else{
            for(int i = 3; i >= 0; i--){
                output += n_bin.charAt(n_bin.length() - 1 - i);
            }
        }
        //System.out.println(n_bin);
        //System.out.println(output);
        return output;
    }

    public static String add(String p, String m){
        String acc_str = "";
        for(int i = 0; i < 4; i++){
            acc_str += p.charAt(i);
        }

        int m_num = Integer.parseInt(m, 2);
        int acc_num = Integer.parseInt(acc_str, 2);

        String output = "";
        String add_res = to_binary(m_num + acc_num);
        
        output += add_res;
        
        for(int i = 4; i < p.length(); i++){
            output += p.charAt(i);
        }

        return output;
    }

    public static String right_shift(String p){
        //return to_binary(Integer.parseInt(p, 2) >> 1);
        String output = p.charAt(0) == '0' ? "0": "1";
        for(int i = 0; i < p.length() - 1; i++){
            output += p.charAt(i);
        }
        //System.out.print(Integer.toString(p.length()) + " " + Integer.toString(output.length()) + " ");
        return output;
    }
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            int m = sc.nextInt();
            int q = sc.nextInt();

            String m_bin = to_binary(m);
            String q_bin = to_binary(q);
            String m1_bin = to_binary(-m);
            
            String p = "";
            for(int i = 0; i < 4; i++){
                p += "0";
            }
            p += q_bin;
            p += "0";

            // System.out.println(p);

            // System.out.println(m_bin + " " + m1_bin + " " + q_bin + " " + p);
            for(int j = 0; j < 4; j++){
                if(p.charAt(7) == '1' & p.charAt(8) == '0'){
                    p = add(p, m1_bin);
                }
                else if(p.charAt(7) == '0' & p.charAt(8) == '1'){
                    p = add(p, m_bin);
                }
                p = right_shift(p);
                System.out.println(p);
            }
    //        System.out.println(m_bin + " " + q_bin + " " + m1_bin);
        }
    }
}
