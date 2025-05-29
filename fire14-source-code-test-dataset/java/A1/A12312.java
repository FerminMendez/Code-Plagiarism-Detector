package gcodejam2012;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
/**
 * @author alei
 */
public class B {
    public static void main(String[]Args) throws FileNotFoundException{
        Scanner sn = new Scanner(new FileInputStream("B.in"));
        System.setOut(new PrintStream("B.out"));
        int nCases = sn.nextInt();        
        for(int i=0;i<nCases;i++){
            sn.nextLine();
            int N = sn.nextInt();
            int S = sn.nextInt();
            int P = sn.nextInt();
            int[]totalPoints = new int[N];
            for(int j=0;j<N;j++){
                totalPoints[j] = sn.nextInt();                
            }
            int result = solve(totalPoints,S,P);
            System.out.println("Case #"+(i+1)+": "+result);
        }
                
    }
    public static int solve(int[]totalPoints,int S,int P){
        int m = 0;
        int min = 3*P-4;
        min = min<0?P:min+0;        //the right
        //min = min<0?0:min+0;
        int max = 3*P+4;
        //System.out.println("["+min+";"+max+"]");
                
        int c=0,a=0,ssp=0,sns=0;
        int gigants = 0;
        
        int s1 = 3*P-4;
        int s2 = 3*P-3;
        int s3 = 3*P+3;
        int s4 = 3*P+4;
        for(int i=0;i<totalPoints.length;i++){
            int point = totalPoints[i];
            if(point<=max && point>=min){
                m++;
                if(point==s1 || point==s2||point==s3||point==s4){
                    int n1 = (point+2)/3;
                    if(n1>=P){
                        //System.out.println("sns++->"+point);
                        sns++;
                    }
                    c++;
                }
                else{
                    int n1 = (point+2)/3;
                    if(n1>=P){
                        ssp++;
                    }
                }
            }
            else if(point >max){
                gigants++;
                m++;
            }
            else{
                a++;
            }
        }
        //System.out.println("m->"+m+"->gig->"+gigants+"->a->"+a+"->S->"+S+"->c->"+c+"<->nsp->"+ssp);
                
        if(S>c){
            S-=c;
            if(S>0){
                S-=gigants;
                if(S>0){
                   S-=a;
                   if(S>0){
//                       System.out.println("finalSubst->"+m+"-s:"+S);
                       int reaNsp = Math.min(S, ssp);
                       m = m-S+reaNsp;
                   }
                }
            }            
        }
        else{            
            //sns = Math.min(S, sns);
            int fns = c-S;
            //System.out.println("fns->"+fns+"<->sns->"+sns);
            if(sns>=fns){
                
            }
            else{
                m = m - fns + sns;
            }
        }
        
        return m;
    }
}
