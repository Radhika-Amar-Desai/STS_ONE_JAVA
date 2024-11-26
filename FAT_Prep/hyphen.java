import java.util.Scanner;

public class hyphen {
    public static String move_hyphens_to_start(String input){
        String string_without_hyphen = "";
        int count = 0;
        String res = "";

        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '-'){
                count += 1;
            }
            else{
                string_without_hyphen += input.charAt(i);           
            }
        }

        for(int i = 0; i < count; i++){
            res += '-';
        }

        res += string_without_hyphen;

        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String result = input.replaceAll("[^-]", "") + input.replaceAll("-", "");
        System.out.println(result);
        sc.close();
    }
}
