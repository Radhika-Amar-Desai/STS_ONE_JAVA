public class combination {
    public static void get_combinations(String input, int n, String output){
        if(n == 0){
            System.out.println(output);
        }
        for(int i = 0; i < input.length(); i++){
            String new_input = "";

            for(int j = 0; j < input.length(); j++){
                if(i != j){
                    new_input += input.charAt(j);
                }
            }

            get_combinations(new_input, n - 1, output + input.charAt(i));
        }
    }

    public static void main(String[] args){
        String s = "12345";
        int n = 4;
        get_combinations(s, n, "");
    }
}
