import java.io.*;
import java.util.*;
class Problems 
{
    public static void main (String [] args) throws Exception 
    {
        BufferedReader f = new BufferedReader(new FileReader("input.java"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.java")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int T=Integer.parseInt(st.nextToken());
        for(int t=0;t<T;t++) {
            st=new StringTokenizer(f.readLine());
            int N=Integer.parseInt(st.nextToken());
            int S=Integer.parseInt(st.nextToken());
            int p=Integer.parseInt(st.nextToken());
            int[] scores=new int[N];
            for(int i=0;i<N;i++) {
                scores[i]=Integer.parseInt(st.nextToken());
            }
            int res=0;
            int minScoreWithSurprise=p+2*(p-2);
            int minScoreWithoutSurprise=p+2*(p-1);
            for(int i=0;i<N;i++) {
                if(scores[i]==0) {
                    if(p==0) res++;
                } else if(scores[i]==1) {
                    if(p==1||p==2) res++;
                }
                else if(minScoreWithoutSurprise<=scores[i]) res++;
                else if(minScoreWithSurprise<=scores[i]&&S>0) {
                    res++;
                    S--;
                }
            }
            out.println("Case #"+(t+1)+": "+res);
        }
        out.close();
        System.exit(0);
    }
}
