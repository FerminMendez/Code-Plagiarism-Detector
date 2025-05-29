import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class ProblemB {
    public static void main(String[] args) throws IOException {
        BufferedReader leer= new BufferedReader(new InputStreamReader(System.in));
        int T=intS(leer.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st= new StringTokenizer(leer.readLine());
            int N=intS(st.nextToken());
            int S=intS(st.nextToken());
            int p=intS(st.nextToken());
            int[][] g= new int[N][3];
            for (int j = 0; j < N; j++){
                int v=intS(st.nextToken());
                g[j][0]=v/3;
                g[j][1]=v%3;
                int score[]={g[j][0],g[j][0],g[j][0]};
                if(g[j][1]>=1)
                    score[0]++;
                if(g[j][1]==2)
                    score[1]++;
                if(score[0]>=p)
                    g[j][2]=2;
                else if(score[0]+1>=p && score[0]-score[1]==0 && score[0]!=0 )
                    g[j][2]=1;
                else
                    g[j][2]=0;
            }
            int r=0;
            for (int j = 0; j < N; j++){
                if(g[j][2]==1 && S>0){
                    g[j][2]=2;
                    S--;
                }
                if(g[j][2]==2)
                    r++;
            }
            System.out.println("Case #"+i+": "+r);
        }
    }
    static int intS(String s){
        return Integer.parseInt(s);
    }
}
