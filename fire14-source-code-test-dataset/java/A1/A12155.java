import java.io.*;
import java.util.*;
import java.lang.*;
public class problemB
{
    public static void main(String args[])throws Exception
    {
        Scanner cin=new Scanner(System.in);
        int numcases = cin.nextInt();
        int N,S,P,T;
        double avg,s;
        int v;
        for(int i=0;i<numcases;i++){
            v = 0;
            N = cin.nextInt();
            S = cin.nextInt();
            P = cin.nextInt();
            for(int n=0;n<N;n++){
                T = cin.nextInt();    
                avg = ((double)(T + 2.0)/3.0);
                if(avg >= P){
                    v++;
                }else if(S > 0 && T >= P){
                    avg = ((double)(T + 4.0)/3.0);
                    if(avg >= P){
                        S--;
                        v++;
                    }
                }
            }
            System.out.println("Case #"+ (i+1) + ": " + v);
        }
    }

}
