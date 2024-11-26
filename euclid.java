
import java.util.Scanner;

public class euclid {
    public static int get_gcd(int num1, int num2){
        if(num2 == 0){
            return num1;
        }
        int a = Math.min(num1, num2);
        int b = Math.max(num1, num2);
        return get_gcd(a, b % a);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int gcd = get_gcd(Math.min(num1, num2), Math.max(num1, num2));
        System.out.println(gcd);
    }
}
