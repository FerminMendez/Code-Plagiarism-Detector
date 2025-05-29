

//Author KNIGHT0X300 

import java.util.Scanner;




public class Main {
    
    public static void main(String[] args) {
       Scanner s=new Scanner(System.in);
       int t=s.nextInt();
      
       for(int i=0;i<t;i++)
       {  int tot=0;
           int N=s.nextInt();
           int S=s.nextInt();
           int p=s.nextInt();
   int A=0;     
           for(int j=0;j<N;j++)
           {
               
               A=s.nextInt();
            //  System.out.print(" "+A);
      if(p>=2)
      {    if(S>0)
       {  if((A==(3*p-4))||(A==(3*p-3)))
       {    tot++; S--;              }
       }
       if(A>=3*p-2)
           tot++;
           }
       if(p==0)
       {
       tot++;
       }
       if(p==1)
       {  
       if(A>=1)
       {//System.out.println("sdk");
           tot++;}
       }}
           
           
           
        System.out.println("Case #"+(i+1)+": "+tot);
                      
          
       }
        
    }
}
