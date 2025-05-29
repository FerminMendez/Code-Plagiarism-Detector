import java.io.*;
import java.util.*;

public class DancingWithTheGooglers{
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int n = Integer.parseInt(in.readLine());
        
        for(int i = 0; i < n; ++i){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int T = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int[] normal = new int[T];
            int[] surprising = new int[T];
            for(int j = 0; j < T; ++j){
                int sum = Integer.parseInt(st.nextToken());
                if(sum%3 == 2){
                    normal[j] = sum/3+1;
                    if(sum/3+2 <= 10)
                        surprising[j] = sum/3+2;
                    else
                        surprising[j] = sum/3+1;
                }else if(sum%3 == 1){
                    normal[j] = sum/3+1;
                    surprising[j] = sum/3+1;
                }else{
                    normal[j] = sum/3;
                    if(sum/3 - 1 >= 0 && sum/3+1 <= 10)
                        surprising[j] = sum/3+1;
                    else
                        surprising[j] = sum/3;
                }
            }
            int ans = 0;
            for(int j = 0; j < T; ++j){
                if(S > 0 && normal[j] < p && surprising[j] >= p){
                    --S;
                    ++ans;
                }else if(normal[j] >= p){
                    ++ans;
                }
            }
            out.println("Case #"+(i+1)+": "+ans);
        }
        out.close();
    }
}

    