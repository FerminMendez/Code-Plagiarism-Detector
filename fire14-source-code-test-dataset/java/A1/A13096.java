/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problemb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Dr. Reda M. Hussien
 */
public class ProblemB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        String DataFile = "E:\\B-small-attempt5.in";
        FileReader fileReader;
        fileReader = new FileReader(DataFile);
        BufferedReader br = new BufferedReader(fileReader);
        int N, S, P, ti, x, r, googlers, surprise;
        String[] values;
        String nextLine = br.readLine();
        int T = Integer.parseInt(nextLine);
        for (int i = 0; i < T; i++) {
            googlers = 0;
            surprise = 0;
            values = br.readLine().split(" ");
            N = Integer.parseInt(values[0]);
            S = Integer.parseInt(values[1]);
            P = Integer.parseInt(values[2]);
            for (int n = 3; n < N + 3; n++) {
                ti = Integer.parseInt(values[n]);
               
                x = ti / 3;
                r = ti % 3;
                switch (r) {
                    case 0:
                        if (x >= P) {

                            googlers++;
                        } else {
                            // check for surprise case:
                            if (S > 0 && x > 0 && x + 1 >= P) {
                                googlers++;
                                S--;
                            }
                        }


                        break;
                    case 1:
                        if (x >= P || x + 1 >= P) {
                            googlers++;

                        } else {
                            // surprise case:
                            if (S > 0 && x + 1 >= P) {

                                googlers++;
                                S--;
                            }
                        }


                        break;
                    case 2:
                         if (x + 1 >= P || x >= P)
          {
            
            googlers++;
          }
          else
          {
            if (S > 0 && x + 2 >= P)
            {
              
              googlers++;
              S--;
            }
          }

         
          break;

                }

                
            }
            System.out.println("Case #" + (i + 1) + ": " + googlers);
        }
    }
}
