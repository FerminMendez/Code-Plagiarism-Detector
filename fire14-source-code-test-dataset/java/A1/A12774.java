import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class DancingGooglers {
        public static void main(String[] args) throws IOException {
                BufferedReader fInput = new BufferedReader(new FileReader("res/inputB.in"));
                PrintWriter fOutput = new PrintWriter(new BufferedWriter(new FileWriter(
                                "res/outputB.out")));
                new DancingGooglers().run(fInput, fOutput);
                fOutput.close();
        }
        
        private void run(BufferedReader fInput, PrintWriter fOutput) throws IOException {
                int T = Integer.parseInt(fInput.readLine());
                for (int i=0; i<T; i++) {
                        int count = 0;
                        String[] inputS = fInput.readLine().split(" ");
                        
                        int N = Integer.parseInt(inputS[0]);
                        int S = Integer.parseInt(inputS[1]);
                        int p = Integer.parseInt(inputS[2]);
                        
                        for (int j=3; j<N+3; j++) {
                                int t = Integer.parseInt(inputS[j]);
                                int base = t/3;
                                
                                int max = t%3==0? base : base+1;
                                if (max >= p) {
                                        count++;
                                        continue;
                                }
                                
                                if (S == 0 || t<2 || t%3==1) continue;
                                
                                max = t%3==0? base+1 : base+2;
                                if (max >= p) {
                                        count++;
                                        S--;
                                }
                        }
                        
                        fOutput.println("Case #" + (i+1) + ": " + count);
                }
        }
}