/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class CodeJam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileReader fin = null;
        FileWriter fout = null;
        try {
            fin = new FileReader("input.txt");
            fout = new FileWriter("Output.txt");
            BufferedWriter out = new BufferedWriter(fout);
            BufferedReader in = new BufferedReader(fin);
            int t;
            t = Integer.parseInt(in.readLine());
            int j = 0,N,S,P;
            String[] k;
            while (t > j) {
                k = in.readLine().split(" ");
                N = Integer.parseInt(k[0]);
                S = Integer.parseInt(k[1]);
                P = Integer.parseInt(k[2]);
                int arr;
                int count = 0;
                int f,mod,ml,temp;
                for (int i = 0; i < N; i++) {
                    arr = Integer.parseInt(k[i + 3]);
                    f = arr / 3;
                    mod = arr%3;
                    if (f>= P) {
                        count++;
                    }
                    else if(f == P-1)
                    {
                        if(mod >= 1)
                        {
                            count++;
                        }
                        else
                        {
                          if(f != 0 && S > 0)
                          {
                              count++;
                              S--;
                          }
                        }
                    }
                    else if(f == P-2&& S > 0)
                    {
                        if(mod >= 2)
                        {
                            count++;
                            S--;
                        }
                    }
//                    if(P == 0)
//                    {
//                        count++;
//                        continue;
//                    }
//                    if(arr == 0) {
//                        continue;
//                    }
//                    f = arr / P;
//                    mod = arr%P;
//                    if (f >= 3) {
//                        count ++;
//                    }
//                    else if(f == 1)
//                    {
//                        continue;
//                    }
//                    else
//                    {
//                        ml = P;
//                        temp = (ml - mod)/2;
//                        ml -= temp;
//                        mod += temp;
//                        if (P - mod > 2) {
//                            continue;
//                        }
//                        else if (P - mod == 2)
//                        {
//                            if(S > 0)
//                            {
//                                S --;
//                                count ++;
//                            }
//                        }
//                        else
//                        {
//                            count ++;
//                        }
//                    }
                }
                out.write("Case #" + (j + 1) + ": " + count + "\n");
                out.flush();
                j ++;
            }
        } catch (IOException ex) {
            Logger.getLogger(CodeJam.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fin.close();
                fout.close();
            } catch (IOException ex) {
                Logger.getLogger(CodeJam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
    }
}
