/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package codejam2;

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

        try{
            FileReader input = new FileReader("Input.txt");
            BufferedReader bufRead = new BufferedReader(input);
            String line;
            line = bufRead.readLine();
            int testCases = Integer.parseInt(line);

            
            for (int i=0; i<testCases; i++)
            {
                line = bufRead.readLine();
                String[] numbers = line.split(" ");
                int Googlers = Integer.parseInt(numbers[0]);
                int Surprising = Integer.parseInt(numbers[1]);
                int Limit = Integer.parseInt(numbers[2]);

                int[] GooglerPoints = new int[Googlers];

                for (int j=0; j<Googlers; j++)
                {
                    GooglerPoints[j] = Integer.parseInt(numbers[3+j]);
                }

                int LimitPass = 0;

                for (int x : GooglerPoints)
                {
                    double minNum = Math.floor(x/3);
                    double remPts = x - (3*minNum);
                    if (minNum>=Limit)
                        LimitPass++;
                    else if (remPts!=0 && minNum+1>=Limit)
                        LimitPass++;
                    else if (Surprising!=0)
                    {
                        if(remPts==2 && minNum+2>=Limit){
                            LimitPass++;
                            Surprising--;
                        }
                        else if(remPts==0 && minNum+1>=Limit && minNum!=0){
                            LimitPass++;
                            Surprising--;
                        }
                    }
                }
                final_output = final_output+"Case #"+(i+1)+": "+LimitPass+"\n";

            }
            bufRead.close();
        }
        finally{

        }

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
