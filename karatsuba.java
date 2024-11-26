// public class karatsuba {
//     public static void main(String args[]){
//         int n = 1234;
//         int m = 5678;

//         String a = "";
//         String b = "";
//         String c = "";
//         String d = "";

//         String n_str = Integer.toString(n);
//         String m_str = Integer.toString(m);

//         int N = n_str.length();
//         int M = m_str.length();

//         for(int i = 0; i < N / 2 + N % 2; i++){
//             a += n_str.charAt(i);
//         }

//         for(int i = N / 2 + N % 2; i < N; i++){
//             b += n_str.charAt(i);
//         }

//         for(int i = 0; i < M / 2 + N % 2; i++){
//             c += m_str.charAt(i);
//         }

//         for(int i = M / 2 + M % 2; i < M; i++){
//             d += m_str.charAt(i);
//         }

//         System.out.println(a + " " + b + " " + c + " " + d);

//         int ac = Integer.parseInt(a) * Integer.parseInt(c);
//         int bd = Integer.parseInt(b) * Integer.parseInt(d);

//         int abcd = (Integer.parseInt(a) + Integer.parseInt(b)) * (Integer.parseInt(c) + Integer.parseInt(d));
    
//         int res = abcd - bd - ac;

//         int output = (int) (res * Math.pow(10, 4) + bd + ac * Math.pow(10, 2));
//         System.out.print(output);
//     }
// }
