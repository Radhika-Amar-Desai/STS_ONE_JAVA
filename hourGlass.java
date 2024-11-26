public class hourGlass {
    public static int getHourGlassSum(int[][] arr, int r, int c){
        //Scanner sc = new Scanner(System.in);
        
        int hourGlassSum = 0;
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(!((i == 1 & j == 0) | (i == 1 & j == 2))){
                    //System.out.print(arr[r + i][c + j]);
                    //System.out.print(' ');
                    hourGlassSum += arr[r + i][c + j];
                }
            }
            //System.out.print('\n');
        }
        //System.out.println("Sum is ");
        //System.out.println(hourGlassSum);
        return hourGlassSum;
    }

    public static int getMaxHourGlassSum(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int maxHourGlassSum = 0;

        for(int r = 0; r < n - 2; r++){
            for(int c = 0; c < m - 2; c++){
                maxHourGlassSum = Math.max(maxHourGlassSum, getHourGlassSum(arr, r, c));
            }
        }

        return maxHourGlassSum;
    }
    public static void main(String args[]){
        
            // int n = sc.nextInt();
            // int m = sc.nextInt();

            int[][] arr = {{1,2,4,5,6},{7,5,2,3,6},{0,0,0,0,0},{7,5,1,3,5},{0,0,0,0,0}};

            // for(int i = 0; i < n; i++){
            //     for(int j = 0; j < m; j++){
            //         arr[i][j] = sc.nextInt();
            //     }
            // }

            int maxHourGlassSum = getMaxHourGlassSum(arr);

            System.out.print(maxHourGlassSum);

    }
}