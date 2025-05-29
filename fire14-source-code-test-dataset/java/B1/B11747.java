/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

import java.awt.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Vector;
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
        ArrayList<String> ar = new ArrayList<>();
        java.util.List<String> kr;
        try {
            fin = new FileReader("input.txt");
            fout = new FileWriter("Output.txt");
            BufferedWriter out = new BufferedWriter(fout);
            BufferedReader in = new BufferedReader(fin);
            int t;
            t = Integer.parseInt(in.readLine());
            int j = 0,A,B;
            String[] k;
            while (t > j) {
                
                int count = 0;
                ar.clear();
                k = in.readLine().split(" ");
                A = Integer.parseInt(k[0]);
                B = Integer.parseInt(k[1]);
                
                for (int i = A; i <= B; i++) {
                    ar.add(Integer.toString(i));
                }
                
                StringBuilder n;
                
                for (int m = 1; m < ar.size(); m++) {
                    
                    ArrayList<String> li = new ArrayList<>();
                    n = new StringBuilder(ar.get(m));
                    char c;
                    for (int i = 0; i < n.length(); i++) {
                        li.add(n.toString());
                        c = n.charAt(0);
                        n.deleteCharAt(0);
                        n.append(c);
                    }
                    
                    kr = ar.subList(0, m-1);
                    
                    for (int i = 0; i < li.size(); i++) {
                        if (kr.contains(li.get(i))) {
                            count ++;
                        }
                    }
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
