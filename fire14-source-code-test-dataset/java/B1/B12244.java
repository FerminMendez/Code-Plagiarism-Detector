package com.lily.acm.googleCodeJam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class RecycledNumbers
{
    public static int getRecyleCount(int n,int start,int end){
        int temp2=n;
        int count =0;
        int digit=0;
        int max=1;
        int temp =n;
        while(temp!=0){
            digit++;
            temp/=10;
            max*=10;
        }
        max/=10;
        
        HashSet<Integer> set =new HashSet<Integer>();
        for(int i=1;i<digit;i++){
            temp =n%10;
            n/=10;
            n+=temp*max;
            set.add(n);
        }
        for(int i:set){
            if(i>=start&&i<=end&&i>max&&i!=temp2) {
                count++;
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
                 os.write(("Case #"+count+++": "+lineCount(input.split(" ")[0],input.split(" ")[1])+"\r\n").getBytes());
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

    public static int lineCount(String start,String end)
    {
        int s=Integer.valueOf(start);
        int e=Integer.valueOf(end);
        int total=0;
        for(int i=s;i<=e;i++){
            total+=getRecyleCount(i,s,e);
        }
       return total/2;
    }
    public static void main(String[] args)
    {
        readInput("c://C-small-attempt0.in");
    }
}
