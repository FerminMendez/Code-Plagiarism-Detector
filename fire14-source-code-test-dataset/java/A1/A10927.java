package programminginjava;
import java.io.*;
import java.util.*;
import java.lang.Math;

class dancingGooglers {
    
    
    public static void main(String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("dancingGooglers.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dancingGooglers.out")));
        
        int T = Integer.parseInt(f.readLine());
        
        for(int i=0; i<T; i++){
            
           String line = f.readLine();
           String [] lines = line.split(" ");
           
           int pointer = 0;
           
           int N = Integer.parseInt(lines[pointer++]);
           int S = Integer.parseInt(lines[pointer++]);
           int P = Integer.parseInt(lines[pointer++]);
           
           int minMaybe, minConfirm;
           if(P == 0){
               minConfirm = 0; minMaybe = 0;
           }
           else if(P == 1){
               minConfirm = 1; minMaybe = 1;
           }
           else {
               int req = P * 3; 
               minConfirm = req-2; 
               minMaybe = req-4; 
           }
           
           int confirmed=0, maybe=0, sum;
           
           for(int j=0; j<N; j++){
               sum = Integer.parseInt(lines[pointer++]);
               if(sum >= minConfirm)
                   confirmed++;
               else if (sum >= minMaybe)
                   maybe++; 
           }
           
           confirmed += (maybe < S ? maybe : S);
           
           out.println("Case #"+(i+1)+": "+confirmed);
        }
        
        out.close();
        System.exit(0);
        
    }
    
}