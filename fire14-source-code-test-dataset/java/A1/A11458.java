   import java.util.*;
   import java.io.*;
   public class Dancing
   {
      public static void main(String[] args)
      {
         try
         {
            Scanner scan = new Scanner(new File("Dancing.in"));
            int x = Integer.parseInt(scan.nextLine());
            for(int y=0;y<x;y++)
            {
               String s=scan.nextLine();
               System.out.println("Case	 #"+(y+1)+": " + convert(s));
            }
         }
            catch(FileNotFoundException e)
            {
               System.out.println("File Not Found");
            }
      }
   
      public static int convert(String t)
      {
         int a=0;
         int b=0;
         int c=0;
         int total=0;
         String[] ar=t.split("[ ]");
         a=Integer.parseInt(ar[0]);
         b=Integer.parseInt(ar[1]);
         c=Integer.parseInt(ar[2]);
         for(int x=3;x<a+3;x++)
         {
            int temp=Integer.parseInt(ar[x]);
            if(temp>=3*c-2)
               total++;
            else if(temp>=3*c-4 && temp != 0)
            {
               if(b>0)
               {
                  b--;
                  total++;
               }
            }
         }
         return total;
      }
   }