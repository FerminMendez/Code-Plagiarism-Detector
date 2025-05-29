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
public class Dancing_With_the_Googlers
{

    Map m;
    int no_of_test_cases = 0;
    StringBuffer [] sb;
    Integer []output ;
    String inputfile = "";
    String outputfile = "";
    Integer [][] input ;
    int no_of_digits = 0;



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
                    sb = new StringBuffer[no_of_test_cases];
                    for(int j=0;j<no_of_test_cases;j++)
                        sb[j] = new StringBuffer();
                }
                else
                {
                    sb[i++].append(line);
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
            int p=0, special_cases=0,no_of_inputs=0;
            String [] tokens;
          for (int i=0;i<no_of_test_cases;i++)
          {
               System.out.println(sb[i].toString());
              tokens = sb[i].toString().split(" ");
              //System.out.println("Tokens"+tokens[0]+ " " +tokens[1]+ " " +tokens[2]);
              no_of_inputs = Integer.parseInt(tokens[0]);
              special_cases = Integer.parseInt(tokens[1]);
              p = Integer.parseInt(tokens[2]);

              for(int j = 0;j<no_of_inputs;j++)
              {
                int number = Integer.parseInt(tokens[j+3]);

                int result =0;
                if(number !=0 ||(number==0 && special_cases==0))
                {
                    if(number%3==0)
                    {
                        result = (number /3);
                        if(result>=p)
                            output[i]=output[i]+1;
                        else
                        {
                            if((p-result)==1 && special_cases>0)
                            {
                                output[i]=output[i]+1;
                                special_cases--;
                            }
                        }
                    }
                    else if(number%3==1)
                    {
                        result = (number/3);

                        if(result >=p || result+1 >=p)
                            output[i]=output[i]+1;
                        else if((p-result+1)==1 && special_cases>0)
                            {
                                output[i]=output[i]+1;
                                special_cases--;
                            }
                    }
                    else if(number%3==2)
                    {
                        result = (number/3);

                        if(result >=p || result+1 >=p)
                        {
                            output[i]=output[i]+1;
                        }
                        else if (result+2>=p &&special_cases>0)
                        {
                            output[i]=output[i]+1;
                            special_cases--;
                        }
                        else if((p-result+1)==1 && special_cases>0)
                            {
                                output[i]=output[i]+1;
                                special_cases--;
                            }

                    }
                }

     
              }
                //System.out.println("OutPut"+i+ +output[i]);
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
        Dancing_With_the_Googlers obj = new Dancing_With_the_Googlers();
        obj.setInputOutput("C:\\Users\\Sagar\\Desktop\\myWork\\B-small-attempt0.in", "C:\\Users\\Sagar\\Desktop\\myWork\\output4.txt");
        obj.readFile();
        obj.processFile();
        obj.displayOutput();
    }

}
