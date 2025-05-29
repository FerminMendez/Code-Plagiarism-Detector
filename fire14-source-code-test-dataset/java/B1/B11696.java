/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package recycled;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeSet;

/**
 *
 * @author Alfred
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    try {
            FileInputStream fstream = new FileInputStream("C-small-attempt0.in");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            FileWriter outFile = new FileWriter("out.txt");
            PrintWriter out = new PrintWriter(outFile);
            String line;
            line = br.readLine();
            int cases = Integer.parseInt(line);
            for (int i=1; i<=cases;i++){
                line = br.readLine();
                String[] values = line.split(" ");
                int A = Integer.parseInt(values[0]);
                int B = Integer.parseInt(values[1]);
                int total=0;
                for (int n=A; n<=B;n++){
                    TreeSet<String> solutions = new TreeSet<String>();
                    for (int k=1;k<values[1].length();k++){
                        String m = circshift(n,k);
                        int mVal = Integer.parseInt(m);
                        if(mVal<=B && mVal!=n  && mVal> n && !m.startsWith("0") && m.length()==Integer.toString(n).length() )
                        {
                            solutions.add(m);
                        }                   
                    }
                    total+=solutions.size();
                }
                out.println("Case #"+i+": "+total);
            }
            in.close();
            out.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

}

    private static String circshift(int n, int k) {
        String nString=Integer.toString(n);
        int len=nString.length();
        String m =  nString.substring(len-k)+nString.subSequence(0, len-k);
        //System.out.println(n+" "+m);
        return m;
    }

}
