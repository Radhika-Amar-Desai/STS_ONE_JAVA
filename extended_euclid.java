import java.util.Scanner;

public class extended_euclid {
    static class Result{
        int x, y;
        Result(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static int get_extended_gcd(int a, int b, Result res){
        if(a == 0){
            res.x = 0;
            res.y = 1;
            return b;
        }
        Result tempRes = new Result(1, 1);
        int gcd = get_extended_gcd(b % a, a, tempRes);
        res.x = tempRes.y - (b / a) * tempRes.x;
        res.y = tempRes.x;
        return gcd;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        Result res = new Result(1, 1);
        int gcd = get_extended_gcd(n, m, res);

        System.out.println(gcd);
        System.out.println(Integer.toString(res.x) + " " + Integer.toString(res.y));
    }
}
