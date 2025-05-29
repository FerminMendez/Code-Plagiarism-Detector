
package gcj12_dancinggooglers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class GCJ12_DancingGooglers {

    public static void main(String[] args) {
        if (args.length != 2)
        {
            System.out.println("Usage: GCJ12_DancingGooglers <PATH TO INPUT FILE> <PATH TO OUTPUT FILE>");
            return;
        }
        
        /*******************************************************************
        * 
        * Declaring all variables
        * 
        *******************************************************************/

        FileInputStream fstream;
        DataInputStream in;
        BufferedReader br;
            
        int testCases = 1;
        String firstLine, strLine;
        List<String> inputList = new LinkedList<String>();
       // List<Integer> splitArr = new LinkedList<Integer>();
        
        int N = 0;
        int S = 0;
        int p = 0;
        List<Integer> t = new LinkedList<Integer>();
        List<Integer> h = new LinkedList<Integer>();
        int noOfWinningCases = 0;
        int c = 0 ;

        String outputStr = "";
        List<String> outputList = new LinkedList<String>();
        FileWriter f_write_stream;
        BufferedWriter out;
        
        /*******************************************************************
        * 
        * Code for reading the INPUT
        * 
        *******************************************************************/
        
        
        try
        {
            //"G:/Programming/GOOGLE Code Jam/GCJ_StoreCredits/src/gcj_storecredits/input.in"
            fstream = new FileInputStream(args[0]);
            in = new DataInputStream(fstream);
            br = new BufferedReader(new InputStreamReader(in));
            
            
            firstLine = br.readLine();
            testCases = Integer.parseInt(firstLine);
            //System.out.println(testCases);
            
            int counter=0;
            while((strLine = br.readLine())!= null)
            {
                inputList.add(strLine);
                //System.out.println(inputList.get(counter) + "Counter#: " + counter);
                ++counter;
            }
            
            in.close();
        }
        catch (Exception e)
        {
          System.err.println("Error: " + e.getMessage());
        }
        
        
        for (int i=0; i<testCases; i++)
        {
            /******************************************************************
            *
            * Code for populating values
            * 
            ******************************************************************/
            //System.out.println("Case#" + (i+1) + ": ");
            String[] arr = inputList.get(i).split(" ");
            
            N = Integer.parseInt(arr[0]);
            S = Integer.parseInt(arr[1]);
            p = Integer.parseInt(arr[2]);
            noOfWinningCases = 0;
            t.clear();
            h.clear();
            c = 0 ;
            
            for (int j=0, m=3; j<N; j++,m++)
            {
                t.add(Integer.parseInt(arr[m]));
            }
            //System.out.println(t);
            //System.out.println(h);
            /******************************************************************
            *
            * Code for calculating the triplets scoring equal or above best value
            * 
            ******************************************************************/
           
            for (int k=0; k<N; k++)
            {
                if (t.get(k)%3 == 0 )
                {
                    h.add(t.get(k)/3);
                    if (h.get(k) == p-1 && t.get(k) > p)
                    {
                        h.set(k, (t.get(k)/3)+1);
                        ++c;
                    }
                }
                else if (t.get(k)%3 == 1 )
                {
                    h.add((t.get(k)/3)+1);
                }
                else if (t.get(k)%3 == 2 )
                {
                    h.add((t.get(k)/3)+2);
                    ++c;
                    if ((t.get(k)/3) < p-2 && (t.get(k)/3) >= p)
                    {
                        h.set(k,(t.get(k)/3)+1);
                        --c;
                    }
                }
            }
           // System.out.println("Case#" + (i+1) +":\t T: " + t + "\t\t H: " 
             //       + h +"\t ST: " + S + "\t WT: " + noOfWinningCases);
            
            if (c < S)
            {
                for (int k=0; k<N && c<S; k++)
                {
                    if (t.get(k)%3 == 0 )
                    {
                        if (h.get(k)- (t.get(k)/3) != 1)
                        {
                            h.set(k, (t.get(k)/3)+1);
                            ++c;
                        }
                    }
                    else if (t.get(k)%3 == 2 )
                    {
                        if (h.get(k)- (t.get(k)/3) != 2)
                        {
                            h.set(k, (t.get(k)/3)+2);
                            ++c;
                        }
                    }                        
                }
            }
            else if (c > S)
            {
                for (int k=0; k<N && c>S; k++)
                {
                    if (t.get(k)%3 == 0 )
                    {
                        if (h.get(k)- (t.get(k)/3) == 1)
                        {
                            h.set(k, (t.get(k)/3));
                            --c;
                        }
                    }
                    else if (t.get(k)%3 == 2 )
                    {
                        if (h.get(k)- (t.get(k)/3) == 2)
                        {
                            h.set(k, (t.get(k)/3)+1);
                            --c;
                        }
                    }                        
                }
            }
            
            for (int k=0; k<N; k++)
            {
             if (h.get(k) >= p)
                ++noOfWinningCases;   
            }
            
            //System.out.println("H: " + h +"\nST: " + S + "\t WT: " + noOfWinningCases);
            //System.out.println("Case#" + (i+1) +":\t T: " + t + "\t\t H: " 
              //      + h +"\t ST: " + S + "\t WT: " + noOfWinningCases);
            outputStr = noOfWinningCases+"";
            /******************************************************************
            *
            * Code for printing the OUTPUT
            * 
            ******************************************************************/

           outputList.add("Case #" + (i+1) + ": " + outputStr);
        }
        
        /******************************************************************
        *
        * Code for writing the OUTPUT to the output file
        * 
        ******************************************************************/
        
        try
        {
            //"G:/Programming/GOOGLE_Code_Jam/GCJ_StoreCredits/src/Output/output.in"
            f_write_stream = new FileWriter(args[1]);
            out = new BufferedWriter(f_write_stream);
            for (int count=0; count<testCases; count++)
            {
                out.write(outputList.get(count));
                out.newLine();
            }
            out.close();
        }
        catch (Exception e)
        {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
