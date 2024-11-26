public class crt {
    public static void main(String args[]){
        int[] divisors = new int[]{3, 4, 5};
        int[] reminders = new int[]{2, 3, 1};

        int number = 1;
        while (true) { 
            
            int i;
            for(i = 0; i < divisors.length; i++){
                if (number % divisors[i] != reminders[i]){
                    break;
                }
            }
            
            if(i == divisors.length){
                System.out.println(number);
                break;
            }

            number++;
        }
    }
}
