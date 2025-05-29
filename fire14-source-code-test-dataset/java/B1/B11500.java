   import java.util.*;
   import java.io.*;
   public class Recycle
   {
      public static void main(String[] args)
      {
         try
         {
            Scanner scan = new Scanner(new File("Recycle.in"));
            int x = Integer.parseInt(scan.nextLine());
            for(int y=0;y<x;y++)
            {
               String s=scan.nextLine();
               calc(123,231,100);
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
         int ret=0;
         String[] ar=t.split("[ ]");
         int a=Integer.parseInt(ar[0]);
         int b=Integer.parseInt(ar[1]);
         if(a == 0 && b == 0)
            return 0;
         if(b<a)
         {
            int c=a;
            a=b;
            b=a;
         }
         int max=1;
         while(max*10<=a)
            max*=10;
         for(int x=a;x<=b;x++)   
            for(int y=a;y<=b;y++)
               ret+=calc(x,y,max);
         return ret/2;
      }
   	
      public static int calc(int x,int y,int max)
      {
         for(int z=10;z<=max;z=z*10)
            if(x!=y) 
               if(x%z==(y-y%(max*10/z))*z/max/10)
                  if(y%(max*10/z)==(x-x%z)/z)
                     return 1;
         return 0;
      }
   }