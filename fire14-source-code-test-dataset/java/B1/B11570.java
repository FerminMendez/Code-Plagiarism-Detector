/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googlecodejam2012;

import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author Pavlos
 */
public class ProblemC {
    
      public static void main(String[] args) throws FileNotFoundException {
        Read.OpenFile("C-small-attempt0.in");
        Write.OpenFile("solC.txt");
        int T = Read.readInt();
        for (int zz = 1; zz <= T; zz++) {
            int A = Read.readInt();
            int B = Read.readInt();
            
            int size = String.valueOf(A).length();
            ArrayList<Integer> As = new ArrayList<>();
            ArrayList<Integer> Temps = new ArrayList<>();
            
            for (int i = A; i <= B; i++) {
                int temp = i;
                for (int j = 0; j < size; j++) {    
                    int suf = temp%10;
                    temp /= 10;
                    temp += suf*(Math.pow(10, size-1));
                    if(temp <= B && temp >= A && i < temp && temp != i)
                    {
                        if(As.indexOf(i)== Temps.indexOf(temp) && As.indexOf(i) != -1 && Temps.indexOf(temp)!=-1)
                            continue;
                         As.add(i);
                         Temps.add(temp);
                    }
                }
                
            }
           
            Write.WriteToFile(String.format("Case #%d: %d\n",zz,As.size()));
            
        }//end zz
        Write.CloseFile();
    }
}

