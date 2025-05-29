
//package c;


import java.io.*;
import java.util.*;
public class Main {
   
    public static void main(String args[]) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader("C.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C.out")));
        int T = Integer.parseInt(in.readLine());
        for(int C = 1; C <= T ; C++) doit(C, in, out);
        in.close();
        out.close();
        System.exit(0);
    }

    public static void doit(int C, BufferedReader in, PrintWriter out) throws IOException{
        StringTokenizer tok = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(tok.nextToken());
        int B = Integer.parseInt(tok.nextToken());
        //SOLUTION
        long ans = 0;
        for(int i = A; i <= B; i++){
            int[] arr = rotateString( i + "" );
            int kl = arr.length;
            for(int k = 0; k < kl; k++){
                if(arr[k] >= A && arr[k] <= B && arr[k] > i) ans++;
            }
        }
        
        out.println("Case #" + C + ": " + ans);
    }
    
    public static int[] rotateString(String s){
        Set<Integer> list = new HashSet<Integer>();
        int L = s.length();
        if(L == 1) return new int[]{};
        
        for(int i = 1; i < L ; i++) {
            list.add(Integer.parseInt( s.substring(i) + s.substring(0, i)));
            
        }
        
        int size = list.size();
        int[] arr = new int[size];
        int now = 0;
        for(Integer num : list) arr[now++] = num; 
        
        return arr;
    }

}