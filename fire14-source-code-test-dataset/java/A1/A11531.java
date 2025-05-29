/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googlecodejam2012;

import java.io.FileNotFoundException;

/**
 *
 * @author Pavlos
 */
public class ProblemB {
    
      public static void main(String[] args) throws FileNotFoundException {
        Read.OpenFile("B-small-attempt2.in");
        Write.OpenFile("solB.txt");
        int T = Read.readInt();
        for (int zz = 1; zz <= T; zz++) {
            int N = Read.readInt();
            int S = Read.readInt();
            int p = Read.readInt();
            int t[] = new int[N];
            for (int i = 0; i < t.length; i++) {
                t[i] = Read.readInt();
            }
            int counter = 0;
            for (int i = 0; i < t.length; i++) {
                if(t[i] >= p){
                int temp = t[i] - 3*p;
                if(temp >= -2)
                    counter++;
                else if(temp >= -4 && temp < -2 && S > 0)
                {
                    counter++;
                    S--;
                }
                }
                
            }
            //counter  -= S;
            
            if(counter > 3)
                counter  = 3;
            Write.WriteToFile(String.format("Case #%d: %d\n",zz, counter));
            
        }//end zz
        Write.CloseFile();
    }
}

