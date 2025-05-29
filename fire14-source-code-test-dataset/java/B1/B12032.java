import java.io.*;
import java.util.*;

public class RecycledNumbers{
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int n = Integer.parseInt(in.readLine());
        
        for(int i = 0; i < n; ++i){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            boolean[] done = new boolean[10000000];
            int ans = 0;
            for(int j = A; j <= B; ++j){
                if(done[j]){
                    continue;
                }
                int d = (int)Math.log10(j);
                int rightMost = (int)Math.pow(10, d);
                int temp = j;
                int tempAns = 0;
                for(int k = 0; k < d; ++k){
                    temp = temp%rightMost*10 + temp/rightMost;
                    if(temp > j && temp <= B && !done[temp]){
                        done[temp] = true;
                        ++tempAns;
                    }
                }
                ans += tempAns*(tempAns+1)/2;
            }
            
            out.println("Case #"+(i+1)+": "+ans);
        }
        out.close();
    }
}

    