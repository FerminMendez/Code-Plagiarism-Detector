import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class GCJ2012QA
{

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(new FileReader("A-input.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("A-output.txt"));
        
        final int CASE_COUNT = sc.nextInt();
        for(int caseNum = 1; caseNum<= CASE_COUNT; caseNum++){
            pw.print("Case #" + caseNum + ": ");
            //HERE WE SOLVE STUFF
            int ans = 0;
            
            int N = sc.nextInt();
            int S = sc.nextInt();
            int sp = sc.nextInt();
            for(int i =0; i<N; i++){
                int score = sc.nextInt();
                int kk = score % 3;
                int base = (score - kk)/3;
                
                if(base >= sp){
                    ans++;
                } else if( kk > 0 && (base + 1) >= sp && (base - 1) >= 0){
                    ans++;
                } else if(S>0) {
                    if(kk == 0 && (base+2) >= sp && (base - 1) >= 0){
                        ans++;
                        S--;
                    }
                    if(kk == 1 && (base+2) >= sp && (base - 1) >= 0){
                        ans++;
                        S--;
                    }
                    if(kk == 2 && (base+2) >= sp){
                        ans++;
                        S--;
                    }
                }
                 
            }
            
            //PUT ANSWER HERE
            pw.println(ans);
        }
        
        pw.flush();
        pw.close();
        sc.close();
    }

    
}
