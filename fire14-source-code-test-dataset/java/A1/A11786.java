
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class DancingGooglers{
    public static void main(String[] args)
    throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            String in = br.readLine();
            String[] inp = in.split(" ", 4);
            int N = Integer.parseInt(inp[0]);
            int S = Integer.parseInt(inp[1]);
            int p = Integer.parseInt(inp[2]);
            int nos = 0;
            String[] input = inp[3].split(" ");
            int[] t = new int[N];
            int[] r = new int[N];
            for(int j=0;j<N;j++){
                t[j] = Integer.parseInt(input[j]);
                r[j] = t[j]%3;
                t[j] /= 3;
                if(t[j] >= p)
                    nos++;
                if(t[j] == p - 1){
                    if(r[j] > 0)
                        nos++;
                    else if(t[j]>0){
                        nos++;
                        S--;
                    }
                }
                if(t[j] == p-2){
                    if(r[j] == 2){
                        nos++;
                        S--;
                    }
                }
            }
            if(S<0)
                nos += S;
            bw.write("Case #"+(i+1)+": "+nos+"\n");
        }
        bw.close();
    }
}