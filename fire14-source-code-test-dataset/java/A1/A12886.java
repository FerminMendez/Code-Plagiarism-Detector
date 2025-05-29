
import java.util.Scanner;

public class BDancingWithGooglers {
    public static void main(String[] ags)   {
      //System.setIn(new FileInputStream("src/com/afarok/google/codejam2012/qualificationround/B-small-attempt1.in"));
      //System.setOut(new PrintStream(new File("src/com/afarok/google/codejam2012/qualificationround/B-small-attempt1.out")));
        Scanner stdIn = new Scanner(System.in);
        int t = stdIn.nextInt();
        for(int tCase=1;tCase<=t;++tCase) {
            int n = stdIn.nextInt();
            int ns = stdIn.nextInt();
            int p = stdIn.nextInt();
            
            int y =0;
            for(int i=0;i<n;++i) {
                int nextTotal = stdIn.nextInt();
                int d = nextTotal/3;
                int r = nextTotal%3;
                
                if(nextTotal<p) continue;
                
                if(d>=p) {
                    ++ y;
                    continue;
                }
                
                if(p-d>2) continue;
                
                if(p-d==1) {
                    if(r>0) {
                        ++y;
                        continue;
                    } else {
                        if(ns>0) {
                            ++y;
                            --ns;
                            continue;
                        }
                    }
                } else {
                    if(ns>0 && r==2) {
                        ++y;
                        --ns;
                        continue;
                    }
                }
                
                
            }
            System.out.println("Case #"+tCase+": "+y);
        }
    }
}
