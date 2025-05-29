package codejam;

import java.io.*;
import java.util.HashSet;
public class Numb {
    public static void main(String[] args)throws IOException{
        HashSet<Integer> hs;
        BufferedReader cin=new BufferedReader(new FileReader("i3.in"));
        PrintWriter cout=new PrintWriter(new BufferedWriter(new FileWriter("out3.txt")));
        String[] in;
        int x,y,j,num,count;
        int t=Integer.parseInt(cin.readLine());
        for(int i=0;i<t;i++){
            count=0;
            in=cin.readLine().split(" ");
            x=Integer.parseInt(in[0]);
            y=Integer.parseInt(in[1]);
            if(y<10){ cout.println("Case #"+(i+1)+": 0");continue;}
            for(j=x;j<=y;j++){
                hs=new HashSet<Integer>();
                    String s=Integer.toString(j);
                    int l=s.length();
                    for(int k=l-1;k>0;k--){
                        if(s.charAt(k)=='0') continue;
                        num=Integer.parseInt(s.substring(k)+s.substring(0,k));
                        if(num>j && num<=y && !hs.contains(num)){
                            hs.add(num);
                            count++;
                        }
                    }
            }
            cout.println("Case #"+(i+1)+": "+count);
        }
        cout.flush();
    }
}
