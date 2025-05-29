import java.io.*;
import java.util.*;

class MyReader{
    private BufferedReader reader = null;
    private StringTokenizer tokenizer = null;
    MyReader(Reader r) throws IOException{
        reader = new BufferedReader(r);
    }
    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
    public long nextLong() throws IOException{
        return Long.parseLong(nextToken());
    }
    public double nextDouble() throws IOException{
        return Double.parseDouble(nextToken());
    }
    public String nextLine() throws IOException{
        return reader.readLine();
    }
    public String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }
}


public class Temp {
    public static boolean cycled(int n, int m){
        String s = String.valueOf(m);
        for (int i = 0; i < s.length(); ++i){
            String str = s.substring(i) + s.substring(0,i);
            int k = Integer.valueOf(str);
            if (n==k) return true;                  
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        MyReader reader = new MyReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter("C.out");
        int t = reader.nextInt();
        for (int tt = 0; tt < t; ++tt){
            int a = reader.nextInt();
            int b = reader.nextInt();
            int ans=0;
            Set<Integer> set = new HashSet<Integer>();
            for (int i=a; i<=b; ++i)
                for (int j=i+1; j<=b; ++j)
                    if (cycled(i,j)) { set.add(j); ans++; }
            writer.println("Case #" + (tt + 1) + ": " + ans);
        }
        writer.close();
    }
}
