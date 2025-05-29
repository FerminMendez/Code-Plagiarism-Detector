package codejam2012;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

class ProbB{
	public static void main(String[] args) throws FileNotFoundException{
                
                File in;
                File out;
                Scanner sc;
                PrintWriter pw;
                int T;
		
                in = new File("B2.in");
                out = new File("B.out");
                
                sc = new Scanner(in);
                pw = new PrintWriter(out); 
                
                T = sc.nextInt();
                sc.nextLine();
                
                for(int j = 1; j<=T; j++){
                    int N = sc.nextInt();
                    int S = sc.nextInt();
                    int S2 = S;
                    int p = sc.nextInt();
                    int ans = 0;
                    for(int u = 1; u<=N; u++){
                        int a = sc.nextInt();
                        int e = isEligible(a, p);
                        switch(e){
                            case 2:
                                ans++;
                                break;
                            case 1:
                                S--;
                                ans++;
                                break;
                        }
                       
                    }
                    if(S<0){
                            ans = ans + S;
                        }
                    pw.println("Case #" + j + ": " + ans);
                }
		pw.close();
                
	}
        static int isEligible(int a, int p){
            int lo = a/3;
            int me = (a - lo)/2;
            int hi = a - lo - me;
            
            if(hi>=p){
                return 2;
            }
            if(hi==me && hi+1>=p && me != 0){
                return 1;
            }
            else{
                return 0;
            }
        }
	
}