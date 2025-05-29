

//Author KNIGHT0X300 

import java.util.Scanner;




public class Main {
    
    public static void main(String[] args) {
       Scanner s=new Scanner(System.in);
       int t=s.nextInt();
     long time = System.nanoTime();  
       for(int i=0;i<t;i++)
       {  int tot=0;
           int A=s.nextInt();
           int B=s.nextInt();
             int sz= (int)Math.log10(B);//digits-1
           //  System.out.println(sz);
         for(int j=B;j>A;j--)
         {  int y=j ;
           
             
         for(int k=1;k<sz+1;k++)
         {  
             int p=j%(int)Math.pow(10, k);
     //  if((p==0))
            //   continue;
         y= (int) (Math.floor(j/Math.pow(10, k))+p*(int)Math.pow(10, sz+1-k));
          
            // System.out.println(y);
//          if((p==0))//&&(p==0))
//          {  System.out.println("fahnsfjqnfjqfdjqn  "+y);}
             if((y<j)&&(y>=A)){tot++;
           System.out.println(j+" "+y);
//             if(j-y<=0)  
//                 System.out.println("wfjhdddddhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
//               if((p==0))//&&(p==0))
//                 System.out.println("fahnsfjqnfjqfdjqn");
             }
         
         }
         
         
         
         }
           
           
           
           
           
           
        System.out.println("Case #"+(i+1)+": "+tot);
                      
          
       }
       
 System.out.println("Finished in: " + (System.nanoTime() - time) / Math.pow(10, 6) + "ms");
    }
}
