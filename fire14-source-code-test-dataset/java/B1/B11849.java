/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recycle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;

/**
 *
 * @author akila
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream fstream = new FileInputStream("C-small-attempt0.in");
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        File file = new File("write.txt");

        BufferedWriter output = new BufferedWriter(new FileWriter(file));
        String st = br.readLine();
        int k = Integer.parseInt(st);
        for (int i = 0; i < k; i++) {
            int tot = 0;
            String st1 = br.readLine();
            String[] strin = st1.split(" ");
            String st2 = strin[0];
            //System.out.println(st2);
            String st3 = strin[1];
            //System.out.println(st3);
            int first = Integer.parseInt(st2);
            int second = Integer.parseInt(st3);
            for (int j = first; j <= second; j++) {
                for (int l = second; l > j; l--) {
                    boolean b = check(j, l);
                    if (b) {
                        tot += 1;
                        // System.out.println("here");
                    }

                }

            }
            output.write("Case #"+(i+1)+": "+tot);
            output.newLine();
           
            
            // TODO code application logic here
        }
        output.close();
    }

    public static boolean check(int n, int m) {
        String st1 = Integer.toString(n);
        String st2 = Integer.toString(m);
        if (st1.equalsIgnoreCase(st2)) {
            return false;
        } else if (st1.length() != st2.length()) {
            return false;
        } else if (st1.length() == 1) {
            return false;
        } else {
            char a = st2.charAt(0);

            for (int i = 1; i < st1.length(); i++) {
                if (st1.charAt(i) == a) {
                    String stnew1 = st1.substring(i);
                    String stnew2, output;
                    if (i != 0) {
                        stnew2 = st1.substring(0, i);
                        output = stnew1.concat(stnew2);
                      
                    } else {
                        String s1 = Character.toString(st1.charAt(0));
                        output = stnew1.concat(s1);

                    }
                    if (output.equalsIgnoreCase(st2)) {
                        return true;
                    }
                }
            }
        }
//        if (st1.length() != st2.length()) {
//            return false;
//        }else if(st1.length()==1) {
//        return  false;
//        }
//        else {
//           // System.out.println(st1 +"          "+st2);
//           if(st1.equalsIgnoreCase(st2)){
//            char a = st2.charAt(0);
//          //System.out.println(a);
//            for (int i = 1; i < st1.length(); i++) {
//                if(st1.charAt(i)==a){
//
//                String newst = st1.substring(i)+st1.substring(0, i-1);
//                    System.out.println(newst);
//                   // System.out.println(newst);
//                if(newst.equalsIgnoreCase(st2)){
//                   // System.out.println(newst);
//                return true;
//                }
//                }
//            }
//        }
//        }

        return false;
    }
}
