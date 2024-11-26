

public class gcd {
    static class Result {
        int x, y;
        Result(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int gcdExtended(int a, int b, Result result) {
        if(a == 0){
            result.x = 0;
            result.y = 1;
            return b;
        }

        Result temp_res = new Result(1, 1);
        
        int ans = gcdExtended(b % a, a, temp_res);

        result.x = (b / a) * temp_res.x - temp_res.y;
        result.y = temp_res.x;

        return ans;
    }
    public static void main(String[] args) {
        int a = 35, b = 15;
        Result result = new Result(1, 1);
        int g = gcdExtended(a, b, result);
        System.out.println("GCD is " + g);
        System.out.println("x is " + result.x + ", y is " + result.y);
    }
}
