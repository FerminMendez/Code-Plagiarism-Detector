
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProblemC {

    public static int eval(int A, String n, int B){
        int r = 0;
        for(int i = 1; i < n.length(); i++){
            int nn = Integer.parseInt((n));
            String ini = n.substring(0, n.length() - i);
            String end = n.substring(n.length() - i);
            
            if(Integer.parseInt(String.valueOf(end.charAt(0))) >= Integer.parseInt(String.valueOf(ini.charAt(0)))){
                int m = Integer.parseInt((end+ini));
                if( A <= m && nn < m && m <= B  ){
                    r++;
                }
            }
            
        }
        return r;
    }
    
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new FileWriter("C.out"));
        int cas = s.nextInt();
                
        for( int i = 0; i < cas; i++){
            int r = 0;
            int A = s.nextInt();
            int B = s.nextInt();
            
            for(int n = A; n <= B; n++){
                r += eval(A,String.valueOf(n),B);
            }
            //System.out.println("Case #"+(i+1)+": "+r);
            pw.println("Case #"+(i+1)+": "+r);
        }
        
        pw.close();
        s.close();
    }
}
