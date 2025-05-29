/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam2012;

/**
 *
 * @author Abdelrahman
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CaseC {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File f1 = new File("E:\\new c++\\Google\\codejame 2011\\2012\\inputCodejame.txt");
        BufferedReader reader = new BufferedReader(new FileReader(f1));
        int count = Integer.parseInt(reader.readLine());
        for (int i = 0; i < count; i++) {
            int counter = 0; 
            String line = reader.readLine();
            String[] twoInt = line.split(" ");
            long A = Long.parseLong(twoInt[0]);
            long B = Long.parseLong(twoInt[1]);
            long n = A;
            for (long j = A; j < B; j++) {
                String t = Long.toString(n);
                int len=t.length();
                HashMap<Long,Long> dis=new HashMap<Long, Long>();
                for (int k = 1; k < len; k++) {
                    
                    String t2=t.substring(len-k) + t.substring(0, len-k);
                    long m = Long.parseLong(t2);
                    if (m > n && m <= B &&!dis.containsValue(m)) {
                        dis.put(n, m);
                        counter++;
                    }
                }
                n++;
            }
            System.out.println("Case #" + (i + 1) + ": " + counter);
        }
    }
}
