package codejam2012;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProblemC {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        int T, n, A, B, recycle, lastN = 0, lastM = 1;
        
        ProblemC c = new ProblemC();
        
        Scanner sc = new Scanner(new FileReader("C-small-attempt3.in.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("outputPC.txt"));
        
        T = sc.nextInt();
        
        for(int i = 0; i < T; i++){
            
            A = sc.nextInt();
            B = sc.nextInt();
            recycle = 0;
            
            for(n = A; n < B; n++){
            
                int digits = Integer.toString(n).length();

                if(digits > 1){
                    
                    char[] num = new char[digits];
                    
                    for(int j = 0; j < digits; j++){
                        
                        num[j] = Integer.toString(n).charAt(j);
                        
                    }
                    
                    for(int j = 0; j < digits - 1; j++){
                        
                        c.rotateNum(num);
                        
                        if(Integer.parseInt(c.charToString(num)) <= B && Integer.parseInt(c.charToString(num)) > n){
                            
                            if(lastN == n && lastM == Integer.parseInt(c.charToString(num))){
                                recycle--;
                            }
                            
                            lastN = n;
                            lastM = Integer.parseInt(c.charToString(num));
                            
                            recycle++;
                            
                        }
                    }
                }
                
            }
            
            
            pw.print("Case #" + (i + 1) + ": ");
            pw.println(recycle);

        }
        
        pw.flush();
        pw.close();
        sc.close();
        
    }
    
    public String charToString(char[] c){
        String result = "";
        
        for(int i = 0; i < c.length; i++){
            result += c[i];
        }
        
        return result;
    }
    
    public void rotateNum(char[] c){
        char aux = c[c.length - 1];
        
        for(int i = c.length - 1; i > 0; i--){
            c[i] = c[i - 1];
        }
        
        c[0] = aux;
    }
    
}
