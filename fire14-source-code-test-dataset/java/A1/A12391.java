import java.io.*;

public class code3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fos = new FileWriter("outfile",false);
        BufferedWriter bw = new BufferedWriter(fos);
        int T=Integer.parseInt(br.readLine()), j=1, N , s, p, ti, i , ans ,cancellable;String str[]; 
        for(;T>0;T--,j++)
        {
            str=(br.readLine()).split(" ").clone();
            N= Integer.parseInt(str[0]);
            s= Integer.parseInt(str[1]);
            p= Integer.parseInt(str[2]);
            i=0;
            ans=0;
            cancellable=0;
            while(i<N)
            {
                               
                ti=Integer.parseInt(str[i+3]); i++;
                if(p==1 || p==0)
                {   if(ti>=p)
                        ans++;
                }
                else{
                if(ti == 3*p-4 || ti==3*p-3)
                {
                    if(s!=0)
                    {s--;ans++;cancellable++;}
                        
                }
                else if(ti >= 3*p-2)
                {
                    ans++;
                }
                }    
            }
            if(s>N-cancellable)
                ans=ans-s;
            bw.write("Case #"+j+": "+ans+"\n");
        }
        bw.close();
    }
}