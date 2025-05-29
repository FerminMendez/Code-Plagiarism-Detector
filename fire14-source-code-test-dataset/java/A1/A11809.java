
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProblemB {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new FileWriter("B.out"));
        int cas = s.nextInt();
        
        for( int i = 0; i < cas; i++){
            
            int N = s.nextInt();
            int S = s.nextInt();
            int p = s.nextInt();
            
            int noS = 0;
            int Pmaxs = 0;
            for( int n = 0; n < N; n++){
                int t = s.nextInt();
                int ter = t/3;
                
                    switch(t%3){
                        case 0:{
                            if(ter >= p){
                                Pmaxs++;
                            }else if(ter+1 >= p && ter+1 <= 10 && ter+1 <= t && ter-1 >= 0 ){
                                noS++;
                                Pmaxs++;
                            }
                            break;
                        }
                        case 1:{
                            if(ter >= p){
                                Pmaxs++;
                            }else if(ter+1 >= p && ter+1 <= 10){
                                Pmaxs++;
                            }
                            break;
                        }
                        case 2:{
                            if(ter >= p){
                                Pmaxs++;
                            }else if(ter+1 >= p && ter+1 <= 10){
                                Pmaxs++;
                            }else if(ter+2 >= p && ter+2 <= 10){
                                noS++;
                                Pmaxs++;
                            }
                            break;
                        }
                    }
                
            }
            if(noS > S){ Pmaxs -= (noS - S); }
            pw.println("Case #"+(i+1)+": "+Pmaxs);
        }
        pw.close();
        s.close();
    }
}
