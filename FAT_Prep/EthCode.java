import java.lang.reflect.Array;
import java.util.*;

public class EthCode{
    
    public static ArrayList<String> StrobogrammaticNum(int n){
    
        ArrayList<String> result = numDef(n,n);
        return result;
    
    }
    
    public static ArrayList<String> numDef(int n, int length){
    
        if(n == 0){
        
            ArrayList<String> res = new ArrayList<>();
        
            res.add("");
        
            return res;
        }
        
        if(n == 1){
            
            ArrayList<String> res = new ArrayList<>();
            
            res.add("1");
            res.add("0");
            res.add("8");
        
            return res;
        }


        ArrayList<String> result = new ArrayList<>();

        ArrayList<String> middles = numDef(n - 2, length);

        for(String middle: middles){
            
            if( n != length ){
            
                result.add("0" + middle + "0");
            
            }

            result.add("1" + middle + "1");
            result.add("8" + middle + "8");
            result.add("6" + middle + "9");
            result.add("9" + middle + "6");
            
        }

        return result;

    }
    public static void main(String args[]){
        System.out.println(StrobogrammaticNum(2));
    }
}