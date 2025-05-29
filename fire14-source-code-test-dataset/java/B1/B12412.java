package taskc;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
import java.io.PrintWriter;

public class TaskC {
    
    private int[] tenPowers = new int[10];
    private int[]prevPairs = new int[10];
    private void prepareTenPowers(){
        tenPowers[0] = 1;
        for(int i = 1;i<10;i++){
            tenPowers[i]=tenPowers[i-1]*10;
        }
    }
    
    private void solve(Scanner in, PrintWriter out, int caseNum){
        int res = 0;
        int A = in.nextInt();
        int B = in.nextInt();
        for(int t = A;t<=B;t++){
            int d = t;
            int aPow = 0;
            while(d>0){
                aPow++;
                d = d/10;
            }
            int pow = 10;
            d = t/10;
            int k = 1;
            int pairsCnt = 0;
            
            while(d>0){
                int rest = t%pow;
                if(t == 123){
                    int y = 0;
                }
                if(rest!=0){
                    int pair = rest*tenPowers[aPow-k]+ d;
                    if((pair>t)&&(pair<=B)){
                        boolean ok = true;
                        check:
                        for(int i = 0;i<pairsCnt;i++){
                            if(prevPairs[i]==pair){
                                ok = false;
                                break check;
                            }
                        }
                        if(ok){
                          //System.out.println(t + " " + pair);
                            res++;
                            prevPairs[pairsCnt] = pair;
                            pairsCnt++;
                        }
                    }
                }
                k++;
                pow*=10;
                d /=10;
            }
        }
        out.format("Case #%d: %s\n", caseNum, res);
    }

    public TaskC(){
        prepareTenPowers();
        try{
            Scanner in = new Scanner(new File("1C-small-practice.in"));
            int T = in.nextInt();
            PrintWriter out = new PrintWriter("Csmall.out");
            for(int i = 0;i<T;i++){
                solve(in,out,i+1);
            }
            out.close();
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        
    }
    public static void main(String[] args) {
        TaskC instance = new TaskC();
    }
}
