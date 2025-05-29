package Qualification_Round_2012;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class C {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("C-small-attempt0.in"));
        PrintWriter out = new PrintWriter("c.out");
        StringTokenizer k;
        int t,a,b,x,y,count;
        HashSet<Integer> h;
        String s;
        int ar [] = new int[7];
        ar[0]=1;
        ar[1]=10;
        ar[2]=100;
        ar[3]=1000;
        ar[4]=10000;
        ar[5]=100000;
        ar[6]=1000000;
        t=Integer.parseInt(in.readLine().trim());
        for (int i = 1; i <= t; i++) {
            count=0;
            k=new StringTokenizer(in.readLine());
            a=Integer.parseInt(k.nextToken());
            b=Integer.parseInt(k.nextToken());
            for (int j = a; j <= b; j++) {
                h=new HashSet<Integer>(6);
                x=j;
                s=j+"";
                for (int l = 0; l < s.length()-1; l++) {
                    y=x%10;
                    y*=ar[s.length()-1];
                    y+=x/10;
                    if(y>j && y<=b && y!=x){
                        if(h.add(y))
                            count++;
                    }
                    x=y;
                }
            }
            out.append("Case #"+i+": "+count+"\n");
        }
        out.close();
    }
}
