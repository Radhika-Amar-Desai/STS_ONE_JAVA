import java.util.*;

public class lexo_palindrome {
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            
            String s = sc.nextLine();
            Map<Character, Integer> char_and_freq = new HashMap<>();
            
            for(int i = 0; i < s.length(); i++){
                char_and_freq.put(s.charAt(i), char_and_freq.getOrDefault(s.charAt(i), 0) + 1);
            }

            Set<Character> uniq_chars_set = char_and_freq.keySet();

            Character[] uniq_chars = uniq_chars_set.toArray(new Character[0]);
            Arrays.sort(uniq_chars);
            
            int odd_freq_count = 0;
            char odd_freq_char = ' ';

            for(Character ch: uniq_chars){
                if(char_and_freq.get(ch) % 2 == 1){
                    odd_freq_count += 1;
                    odd_freq_char = ch;
                }
            }

            String half_output = "";
            for(int i = 0; i < uniq_chars.length; i++){
                for(int j = 0; j < char_and_freq.get(uniq_chars[i]) / 2; j++){
                    half_output += uniq_chars[i];
                }
            }

            String reversed_half_output = "";

            for(int i = 0; i < half_output.length(); i++){
                    reversed_half_output += Character.toString(half_output.charAt(half_output.length() - 1 - i));
            }

            if(odd_freq_count > 1){
                System.out.print("Not a palindrome");
            }
            else if(odd_freq_count == 1){
                
                char_and_freq.put(odd_freq_char, char_and_freq.get(odd_freq_char) - 1);
                System.out.println(half_output + Character.toString(odd_freq_char) + reversed_half_output);
            }
            else{

                System.out.println(half_output + reversed_half_output);
            }
            
        }
    }
}
