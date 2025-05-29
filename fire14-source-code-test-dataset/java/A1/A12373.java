package taskb;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
import java.io.PrintWriter;

public class TaskB {
    
    private void solve(Scanner in, PrintWriter out, int caseNum){
         int res = 0;
         int N = in.nextInt();
         int S = in.nextInt();
         int p = in.nextInt();
         
         int []usual = new int[N];
         int []surprise  = new int[N];
         
         for(int i = 0;i<N;i++){
             int t = in.nextInt();
             if(t==0)
                 continue;
             if(t==1){
                 usual[i] = 1;
                 surprise[i] = -1;
                 continue;
             }
             if(t==2){
                 usual[i] = 1;
                 surprise[i] = 2;
                 continue;
             }
             if(t%3==0){
                 usual[i] = t/3;
                 surprise[i] = t/3+1;
             }
             if(t%3==1){
                 usual[i] = t/3+1;
                 surprise[i] = t/3+1;
             }
             if(t%3==2){
                 usual[i] = t/3 + 1;
                 surprise[i] = t/3+2;
             }
         }
         
         int sLeft = S;
         for(int i = 0;i<N;i++){
             if(usual[i]>=p){
                 res++;
             } else{
                 if(sLeft < 1)
                     continue;
                 if(surprise[i]>=p){
                     res++;
                     sLeft--;
                 }
             }
             
         }
         
        
         out.format("Case #%d: %s\n", caseNum, res);
    }

    public TaskB(){
        
        try{
            Scanner in = new Scanner(new File("B-small-attempt0.in"));
            int T = in.nextInt();
            PrintWriter out = new PrintWriter("Bsmall.out");
            for(int i = 0;i<T;i++){
                solve(in,out,i+1);
            }
            out.close();
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        
    }
    public static void main(String[] args) {
        TaskB instance = new TaskB();
    }
}
