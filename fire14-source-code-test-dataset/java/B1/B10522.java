/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**
 *
 * @author Sagar
 */
public class Recycled_Numbers
{

    Map m;
    int no_of_test_cases = 0;
    StringBuffer [] sb;
    Integer []output ;
    String inputfile = "";
    String outputfile = "";
    Integer [][] input ;
    int no_of_digits = 0;

    public Recycled_Numbers()
    {
        m = new HashMap();

    }


    public void setInputOutput(String input, String output)
    {
        inputfile = input;
        outputfile = output;
    }

    public void readFile()
    {
        String line="";
        boolean firstTime = true;
        int i = 0;
         try
        {
            FileReader filename = new FileReader(inputfile);
            BufferedReader reader = new BufferedReader(filename);
            while((line=reader.readLine()) !=null)
            {
                if(firstTime)
                {
                    firstTime = false;
                    no_of_test_cases = Integer.parseInt(line);
                    System.out.println("testcases:"+no_of_test_cases);
                    output = new Integer[no_of_test_cases];
                    for (int s = 0;s<no_of_test_cases;s++)
                        output[s]= new Integer(0);
                    input = new Integer[no_of_test_cases][2];
                    //for(int j=0;j<no_of_test_cases;j++)
                     //   output[j] = new Integer;
                }
                else
                {
                   String [] tokens = line.split(" ");

                   input[i][0]=Integer.parseInt(tokens[0]);
                   input[i++][1]=Integer.parseInt(tokens[1]);
                }
            }

         /*   for(int k=0;k<no_of_test_cases;k++)
            {
                System.out.println(input[k][0] + " " + input[k][1] );
            } */
        }
        catch(IOException e)
        {
            System.out.println("Input File not found");
        }
    }

    public void processFile()
    {
        HashMap <String, Integer> map = new HashMap();
        for (int i=0;i<no_of_test_cases;i++)
        {

            for(Integer j=input[i][0];j<input[i][1];j++)
            {
                StringBuffer num = new StringBuffer(j.toString());
               // System.out.println("Num 1: "+ num.toString());
                no_of_digits = num.length();
                for(int k=0; k<no_of_digits-1;k++)
                {
                    StringBuffer outputbuf = new StringBuffer();
                    outputbuf.append(num.substring(no_of_digits-1));
                    outputbuf.append(num.substring(0, no_of_digits-1));

                 //   System.out.println("outputbuf : "+ outputbuf.toString());
                    
                    Integer m = Integer.parseInt(outputbuf.toString());
                   // System.out.println("M : "+ m+  " J: "+ j);
                    if(m>j && (m<=input[i][1]))
                    {
                        if(!map.containsKey(outputbuf.toString()))
                            map.put(outputbuf.toString(),new Integer(1));
                    }
                    num = new StringBuffer(outputbuf.toString());
                   // System.out.println("Num 2: "+ num.toString());

                }
                //System.out.println("Map size " + map.size());
                output[i] = output[i] + new Integer (map.size());
                map.clear();
            
            }
           // System.out.println("OutPut"+i+ +output[i]);
        }
    }

    public void displayOutput()
    {
        try
        {
            // Create file
            FileWriter fstream = new FileWriter(outputfile);
            BufferedWriter out = new BufferedWriter(fstream);
            for(int i=0;i<no_of_test_cases;i++)
            {
                out.write("Case #"+(i+1)+": ");
                out.write(output[i].toString());
                out.newLine();

            }
            //Close the output stream
            out.close();
        }
        catch (Exception e)
        {//Catch exception if any
            System.err.println("Error: " + e.toString());
        }

        
    }
    public static void main(String []args)
    {
        Recycled_Numbers obj = new Recycled_Numbers();
        obj.setInputOutput("C:\\Users\\Sagar\\Desktop\\myWork\\C-small-attempt0.in", "C:\\Users\\Sagar\\Desktop\\myWork\\output2.txt");
        obj.readFile();
        obj.processFile();
        obj.displayOutput();
    }

}
