/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googlejam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author AEK
 */
public class Problem_C_small {
    public static void main(String[] args)throws IOException {

        
        BufferedReader reader = new BufferedReader(new FileReader("C-small-attempt0.in"));
        FileWriter writer = new FileWriter("C-small-output0");
        int amount_of_test_case = Integer.parseInt(reader.readLine());
        
        for(int test_case = 1;test_case <= amount_of_test_case;test_case++) {
            Scanner parser = new Scanner(reader.readLine());
            int A = Integer.parseInt(parser.next());
            int B = Integer.parseInt(parser.next());

            int count = 0;

            for(Integer n = A;n < B;n++) {

                String outer = n.toString();
                int length = outer.length();
                for(int begin = 0;begin < outer.length();begin++) {
                    String substring = outer.substring(begin) + outer;
                    substring = substring.substring(0, length);
                    Integer m = Integer.parseInt(substring);
                    //Integer m = Integer.parseInt(outer.substring(begin) + outer.substring(0, begin));

                    if(A <= n && n < m && m <= B) {
                        count+=1;
                    }
                }// end inner loop
            }// end outer loop

            //System.out.println(count);
            writer.write("Case #" + test_case + ": " + count + "\n");
        }
        
        reader.close();
        writer.close();
        
    }// end function
    
}
