package codejam;

import java.io.*;
public class Dance {
    public static void main(String[] args)throws IOException{
        BufferedReader cin=new BufferedReader(new FileReader("i2.in"));
        PrintWriter cout=new PrintWriter(new BufferedWriter(new FileWriter("out1.txt")));
        String[] in;
        int x,y,n,p,s,count,a;
        int t=Integer.parseInt(cin.readLine());
        for(int i=0;i<t;i++){
            count=0;
            in=cin.readLine().split(" ");
            n=Integer.parseInt(in[0]);
            s=Integer.parseInt(in[1]);
            p=Integer.parseInt(in[2]);
            int sum=3*p-3;
            for(int j=3;j<n+3;j++){
                a=Integer.parseInt(in[j]);
                if(a==0){
                    if(p==0) count++;
                    continue;
                }
                if(a>sum){
                    count++;
                    continue;
                }
                if(a>=sum-1 && s>0){
                    count++;
                    s--;
                }
            }
            cout.println("Case #"+(i+1)+": "+count);
        }
        cout.flush();
    }
}
