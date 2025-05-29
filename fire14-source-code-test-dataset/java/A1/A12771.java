package Qualification_Round_2012;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("B-small-attempt0.in"));
        PrintWriter out = new PrintWriter("b.out");
        StringTokenizer k;
        int t,n,s,p,count,player,reminder;
        t=Integer.parseInt(in.readLine().trim());
        for (int i = 1; i <= t; i++) {
            k=new StringTokenizer(in.readLine());
            n=Integer.parseInt(k.nextToken());
            s=Integer.parseInt(k.nextToken());
            p=Integer.parseInt(k.nextToken());
            if(p==0){
                out.append("Case #"+i+": "+n+"\n");
                continue;
            }
            count=0;
            for (int j = 0; j < n; j++) {
                player=Integer.parseInt(k.nextToken());
                if(player==0)continue;
                reminder=player%3;
                switch (reminder){
                    case 0:
                        if(player/3>=p)
                            count++;
                        else if(s>0 && (player/3)+1>=p){
                            count++;
                            s--;
                        }
                        break;
                    case 1:
                        if((player/3)+1>=p)
                            count++;
                        break;
                    case 2:
                        if((player/3)+1>=p)
                            count++;
                        else if(s>0 && (player/3)+2>=p){
                            count++;
                            s--;
                        }
                        break;
                }
            }
            out.append("Case #"+i+": "+count+"\n");
        }
        out.close();
    }
}