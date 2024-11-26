import java.util.Scanner;

public class bin_palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String n_str = Integer.toBinaryString(n);
        int N = n_str.length();

        boolean output = true;
        for(int i = 0; i < N / 2 + N % 2; i++){
            if(n_str.charAt(i) != n_str.charAt(N - 1 - i)){
                output = false;
            }
        }
        System.out.print(n_str + ' ');
        
        if(output){
            System.out.print("Is palindrome");
        }
        else{
            System.out.print("Not palindrome");
        }
    }
}
