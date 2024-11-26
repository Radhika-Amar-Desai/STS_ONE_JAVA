import java.util.*;

public class Josephus {
    public static int helper(ArrayList<Integer> people, int k, int index){
        if(people.size() == 1){
            return people.get(0);
        }
        int killed = (index + k) % people.size();    
        people.remove(killed);
        return helper(people, k, killed);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        ArrayList<Integer> people = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            people.add(i);
        }

        int index = 0;
        int res = helper(people, k - 1, index);
        System.out.println(res);
    }
}