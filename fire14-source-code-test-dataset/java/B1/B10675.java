/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package codejam3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Albatross
 */
public class Main {

    
    public static void main(String[] args) throws FileNotFoundException, IOException {

        String final_output="";
        FileReader input = new FileReader("Input.txt");
        BufferedReader bufRead = new BufferedReader(input);

        try{

            String line;
            line = bufRead.readLine();
            int testCases = Integer.parseInt(line);

            

            for (int i=0; i<testCases; i++)
            {
                //System.out.println("Case "+i);
                int pairs = 0;
                line = bufRead.readLine();
                String[] numbers = line.split(" ");

                Integer A = Integer.parseInt(numbers[0]);
                Integer B = Integer.parseInt(numbers[1]);

                for (int j=A; j<B; j++)
                {
                    String numA = Integer.toString(j);
                    for (int k=j+1; k<=B; k++)
                    {
                        String numB = Integer.toString(k);
                        for (int t=1; t<=numB.length(); t++)
                        {
                            //System.out.println("NumA:"+numA);
                            //System.out.println(numB);
                            String prefix = numB.substring(0, t);
                            //System.out.println(prefix);
                            String suffix = numB.substring(t, numB.length());
                            //System.out.println(suffix);
                            if ((suffix+prefix).equals(numA) && suffix.length()!=0){
                                pairs++; //System.out.println("pair!"); break;
                                //System.out.println(numA+" "+numB);
                            }
                        }
                    }
                }

                //System.out.println(pairs);
                final_output = final_output+"Case #"+(i+1)+": "+pairs+"\n";
            }

        }
        finally{}

        FileWriter output_file = new FileWriter("Output.txt");
        BufferedWriter bufWrite = new BufferedWriter(output_file);
        try{

            bufWrite.write(final_output);
        }
        finally{
            bufWrite.close();
        }

    }

}
