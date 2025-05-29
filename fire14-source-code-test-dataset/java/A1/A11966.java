/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author DEV
 */
import java.util.*;
import java.io.*;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{

             BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
          //    BufferedReader bf = new BufferedReader(new FileReader("input.in"));
            int t = Integer.parseInt(bf.readLine());
            for(int i=0;i<t;i++){

               String si = bf.readLine();
               System.out.print("Case #"+(i+1)+": ");
               String[] a  = si.split(" ");
               int n = Integer.parseInt(a[0]);
               int s = Integer.parseInt(a[1]);
               int p = Integer.parseInt(a[2]);
               int out=0;
               for(int m=3;m<a.length;m++)
               {
                 int num = Integer.parseInt(a[m]);
                 int rem = num%3;
                 int div = num/3;
                 if(div==0){if(p==0)out++; continue;}
                 if(rem==0)
                 {
                      if((div)>=p)
                      {       out++;}
                     else
                     {

                          if((div+1)>=p&&s>0&&(div+1)<=10)
                           {
                              out++; s--;

                           }

                     }
                 }


                 else if(rem==2)
                 {
                      if((div+1)>=p)
                      {       out++;}
                     else
                     {

                         if((div+2)>=p&&s>0&&(div+2)<=10)
                     {
                             out++; s--;
                     }

                     }
                 }
                 else
                 {
                     if((div+rem)>=p)
                         out++;
                 }


               }
               System.out.println(out);

            }





        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        }

    }


