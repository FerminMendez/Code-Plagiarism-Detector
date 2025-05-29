/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2012codejam;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Nimos
 */
public class QuestionC {

    public static void main(String args[]) {
        try {
            File input = new File("C:\\Users\\Nimos\\Desktop\\INPUTS\\2012\\C-small-attempt0(1).in");
            FileReader fr = new FileReader(input);
            BufferedReader br = new BufferedReader(fr);
            PrintWriter out = new PrintWriter(new File("C:\\Users\\Nimos\\Desktop\\INPUTS\\2012\\C-small-ans.in"));
            String no = br.readLine();
            int number = Integer.parseInt(no);
            for (int h = 0; h <= number - 1; h++) {
                int done =0;
                String nos = br.readLine();
                String[] n = nos.split(" ");
                int s = Integer.parseInt(n[0]);
                int e = Integer.parseInt(n[1]);
                int size = n[0].length();
               // ArrayList al = new ArrayList();
                
                for (int i=s;i<=e;i++){
                    String t = Integer.toString(i);
                    for (int j = 1;j<size;j++){
                        t= t.substring(1,size)+t.substring(0,1);
                        //System.out.print(j+" ");
                        int k = Integer.parseInt(t);
                        if (k>i && k<=e && k>=s){
                            done++;
                            //System.out.println(done + " " + i);
                            //al.add(t); 
                        }
                                                
                    }
                }

                int m = 1 + h;
                String ans = "Case #" + m + ": " + done;
                out.println(ans);
                out.flush();

            }


            br.close();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
