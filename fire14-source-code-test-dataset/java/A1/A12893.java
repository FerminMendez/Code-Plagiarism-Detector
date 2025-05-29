
//package b;


import java.io.*;
import java.util.*;
public class Main {
    static int[] good = {0,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,9,9,9,10,10,10};
    static int[] bad = {0,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,9,9,9,10,10,10,10,10};
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader("B.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("B.out")));
        int T = Integer.parseInt(in.readLine());
        for(int C = 1; C <= T; C++) doit(C, in, out);
        in.close();
        out.close();
        System.exit(0);
    }
    
    private static void doit(int C, BufferedReader in, PrintWriter out) throws IOException{
        StringTokenizer tok = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(tok.nextToken());
        int surprise = Integer.parseInt(tok.nextToken());
        int P = Integer.parseInt(tok.nextToken());
        
        int[] num = new int[N];
        for(int i = 0; i < N; i++) num[i] = Integer.parseInt(tok.nextToken());
        
        //SOLUTION
        Arrays.sort(num);
        int ans = 0;   
        int countSurprise = 0;
        
        for(int i = 0; i < N; i++){
            if(num[i] >= 2 && num[i] < 28 && good[num[i]] != bad[num[i]] && countSurprise < surprise){
                if(bad[num[i]] >= P) {
                    ans++;
                    countSurprise++;
                }
            }
            else if(good[num[i]] >= P) ans++;
        }
        
        out.println("Case #" + C + ": " + ans);
    }
}
