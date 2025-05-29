/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

import java.io.*;

/**
 *
 * @author Ka
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic her
        File f = new File("C-small-attempt0.in");
        FileWriter fstream = new FileWriter("output.txt");
        BufferedWriter out = new BufferedWriter(fstream);
        //Solution s = new Solution(f);
        //s.scores();
       // s.output(out);
        Recy r = new Recy(f);
        r.scores();
        r.output(out);
    }
}
