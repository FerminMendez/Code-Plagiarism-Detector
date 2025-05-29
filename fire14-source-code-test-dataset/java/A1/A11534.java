/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gcj_b;

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
public class Generate {

    private BufferedReader reader;
    private StringTokenizer token;

    public void do_processing(String filename) {
        String current_line;
        int no_of_cases;
        try {
            reader = new BufferedReader(new FileReader(filename));
            FileWriter fstream = new FileWriter("G:/my_out.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            no_of_cases = Integer.parseInt(reader.readLine());

            for (int i = 1; i <= no_of_cases; i++) {
                current_line = reader.readLine();
                out.write("Case #" + i + ": ");
                out.write(String.valueOf(do_generate(current_line)));
                //out.write(String.valueOf(3));
                System.out.println("outputttttttttttttttt " + do_generate(current_line));
                out.newLine();
                //Close the output stream
            }
            out.close();
            reader.close();
        } catch (Exception ex) {
            Logger.getLogger(Generate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int do_generate(String line) {
        int max_num = 0, temp, remain, max=0, min=10, output = 0;
        Boolean contains = false;
        int googlers, surprises, best_value;
        token = new StringTokenizer(line);
        int triplet[] = new int[3];

        googlers = Integer.parseInt(token.nextToken());
        surprises = Integer.parseInt(token.nextToken());
        best_value = Integer.parseInt(token.nextToken());
        int scores[] = new int[googlers];

        for (int i = 0; i < scores.length; i++) {
            scores[i] = Integer.parseInt(token.nextToken());
        }

        for (int i = 0; i < scores.length; i++) {
            contains = false;
            if (scores[i] == 0){
                if(best_value ==0){
                    output++;
                }
            }else{
            temp = scores[i] / 3;
            for (int j = 0; j < triplet.length; j++) {
                triplet[j] = temp;
            }
            remain = scores[i] - (temp * 3);
            System.out.print("remain " + remain + " ");
            for (int k = 0; k < remain; k++) {
                triplet[k] += 1;
            }
            for (int k = 0; k < triplet.length; k++) {
                System.out.print(triplet[k] + " ");
            }
            System.out.println();
            
            for (int k = 0; k < triplet.length; k++) {
                    if (triplet[k] >= best_value){
                        contains = true;
                    }
                }
            if (surprises > 0 && !contains){
                if (remain == 1) {
                    triplet[1] -= 1;
                    triplet[2] += 1;
                } else {
                    triplet[0] -= 1;
                    triplet[1] += 1;
                }
            }

            for (int k = 0; k < triplet.length; k++) {
                System.out.print(triplet[k] + " ");
            }
            System.out.println();

                max = 0; min = 10; contains = false;
                for (int k = 0; k < triplet.length; k++) {
                    if(triplet[k] > max)
                        max = triplet[k];
                    if(triplet[k] < min)
                        min = triplet[k];
                }
                System.out.println("max " + max);
                System.out.println("min " + min);
                
                for (int k = 0; k < triplet.length; k++) {
                    if (triplet[k] >= best_value){
                        contains = true;
                    }
                }
                if ((max - min == 2) && contains){
                    surprises--;
                    output++;
                    System.out.println("output increase ");
                } else if(contains){
                    System.out.println("contains ");
                    output++;
                }
            
            }
            
        }
        System.out.println("output: " + output);




        return output;
    }

    public void set_suprises() {
    }
}
