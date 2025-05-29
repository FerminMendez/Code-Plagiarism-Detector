/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package codejam.practice;

/**
 *
 * @author Saikat Roy
 */
import java.io.*;
public class Main2 {
    
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    public void input() throws IOException
    {
       int k=1;
       int n=Integer.parseInt(br.readLine());
       while(n--!=0)
       {
           int flag=0;
           String[] str2=new String[25];
           String str1=br.readLine();
           String stcpy="";
           str2=str1.split("[ ]");
           int i=(int) Math.pow(10,str2[0].length()-1);
           for(int x=Integer.parseInt(str2[0]);x<=Integer.parseInt(str2[1]);x++)
           {
             if(i!=1){
                 String mx=String.valueOf(x);
                 
                 for(int l=1;l<mx.length();l++)
                 {
                     int mark=1;
                     String st="";
                     for(int m=l;m<mx.length();m++)
                     st+=mx.charAt(m);
                     for(int m=0;m<l;m++)
                         st+=mx.charAt(m);
                     //System.out.println(st);
                     if(Integer.parseInt(st)>Integer.parseInt(mx)&&Integer.parseInt(st)<=Integer.parseInt(str2[1]))
                     {
                         if(stcpy.equals(st))
                         mark=0;
                         
                         if(mark!=0)
                         {
                        flag++;
                        stcpy="";
                        stcpy+=st;
                        //System.out.println(mx+":"+st);
                         }}
                 }
             }  
             else
                 flag=0;
               
           }
          System.out.print("Case #"+k+": "+flag);
          System.out.println();
           //System.out.println(Integer.parseInt("201")<Integer.parseInt("012")?true:false);
           k++;
       }
           }
     public static void main(String[] args) throws IOException {
        Main2 ob=new Main2();
        ob.input();
    }
    
}
