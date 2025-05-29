package com.lily.acm.googleCodeJam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class DancingWiththeGooglers
{
    public static final int[] SUM_P =
    { 0, 1, 2, 2,2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9,
            9, 10, 10, 10, 10, 10 };
    public static final int[] SUM =
    { 0, 1,1,1,2,2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8,
            8, 9, 9, 9, 10, 10, 10};



    static int getPropertMaxPerson(String[] input)
    {
        int count = 0;
        int s = Integer.valueOf(input[1]);
        int p = Integer.valueOf(input[2]);
        Arrays.sort(input, 3, input.length);
        for (int i = input.length - 1; i >=3 ; i--) {
            int sum = Integer.valueOf(input[i]);
            if (s > 0) {
                if (SUM[sum] >= p) {
                    count++;
                }
                else if (SUM_P[sum] >= p) {
                    count++;
                    s--;
                }
            }
            else  {
                if (SUM[sum] >= p)  {
                    count++;
                }
            }
        }
        return count;
    }
    
    public static void readInput(String fileName){
        BufferedReader is= null;
        FileOutputStream os =null;
        int count=1;
        try
        {
             is  =  new BufferedReader(new FileReader(fileName));
             os = new FileOutputStream(new File("c://output.txt"));
             String input="";
            
             if(is.readLine()==null) return ;
             while((input= is.readLine())!=null){
                 os.write(("Case #"+count+++": "+getPropertMaxPerson(input.split(" "))+"\r\n").getBytes());
                 os.flush();
            }
            
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally{
            try
            {
                is.close();
                os.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)
    {
        readInput("c://B-small-attempt1.in");
    }

}
