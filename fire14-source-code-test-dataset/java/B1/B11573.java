/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gcj_c;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kay
 */
public class Arrange {

    private int first;
    private int last;
    private BufferedReader reader;
    private StringTokenizer token;

    public void do_processing(String filename) {
        String current_line;
        int no_of_cases;
        try {
            reader = new BufferedReader(new FileReader(filename));
            FileWriter fstream = new FileWriter("G:/out.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            no_of_cases = Integer.parseInt(reader.readLine());

            for (int i = 1; i <= no_of_cases; i++) {
                current_line = reader.readLine();
                out.write("Case #" + i + ": ");
                out.write(String.valueOf(do_arrange(current_line)));
                //out.write(String.valueOf(3));
                //System.out.println("outputttttttttttttttt " + do_arrange(current_line));
                out.newLine();
                //Close the output stream
            }
            out.close();
            reader.close();
        } catch (Exception ex) {
            Logger.getLogger(Arrange.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int do_arrange(String line) {
        int output = 0, temp,temp2, tens = 1, no_of_digits = 0, new_num = 0, mod = 1, add_tens = 1;
        token = new StringTokenizer(line);
        first = Integer.parseInt(token.nextToken());
        last = Integer.parseInt(token.nextToken());
        System.out.println(first + "" +last);
        temp = first;
        while (temp > 0) {
            temp /= 10;
            no_of_digits++;
        }
        
        if (no_of_digits == 1) {
            output = 0;
        } else {
           
            for (int i = first; i <= last; i++){
                temp = i;
                tens = 1;
                add_tens = 1;
                
                for (int j = 1; j < no_of_digits; j++){
                    add_tens = 1;
                    temp = i;
                    temp2 = i;
                    temp2 /= (tens * 10);
                    temp %= (tens * 10);
                    //System.out.println(temp);
                    for (int k=1; k<=(no_of_digits - j); k++){
                        add_tens *= 10;
                    }
                    //System.out.println("add tens" + add_tens);
                    tens *=10;
                    
                    new_num = (temp * add_tens) + temp2;
                    //System.out.println("newwwwwwwww " + new_num);
                    
                    //System.out.println("iiiiiiii "+ i);
                    if((new_num >= first) && (new_num > i) && (new_num <= last)){
                     //System.out.println("adddedd outtput");
                     output++;
                     
                 }
                }
                
                 
                
            }
        }
        System.out.println("output   " + output);
        return output;
    }
}
