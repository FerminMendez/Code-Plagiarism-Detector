/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package c;
 

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Leo
 */
public class C {
  public static void main(String[] args) throws FileNotFoundException, IOException {
       
  new C().run();
  }
    
    String inputFile = "txt.in";
     Scanner in;
	
     public void run() throws FileNotFoundException, IOException{
        in = new Scanner(new FileReader(inputFile));
		
        int cases = in.nextInt();
      
          for(int i=1;i<=cases;i++)
          {
        int d=0;
          int  A = in.nextInt();
           int  B = in.nextInt();
          d=howManyDigits(B);
          int c = resolve(A,B,d);
           System.out.println("Case #" + i + ": " + A + " " + B + " " + c);
      
          }

     }

     
     public  int resolve(int a , int b, int d)
     {
        
         int comp1=0;
         int comp2=0;
   
      int m=0;
      int n=0;
       
         
         for(int j=a;j<=b;j++){
         
        if(d==2) {
             m = this.permuteDigits(j);
             if(a<=m && m<=b){ comp1++;}
         }
        
          if(d==3) {
             m = this.permuteDigits3A(j);
             n = this.permuteDigits3B(j);
             if(a<=m && m<=b){ comp2++;}
             if(a<=n && n<=b){ comp2++;}
         }
        
          
         }
         return (comp1)/2 + comp2;
      
         
         }
         
    
     
     
  
  
int howManyDigits(int x){
  
 if(x<10)   return 1;  

    if(10<=x && x<=99)   return 2;  
     if(100<=x && x<=999)   return 3;  
return 0;
}


int permuteDigits3A(int x){
  
int m =0;
int n = 0;
int t=0;
int f=0;

m=x%100;
m=m%10;
n = x/100;
f=x/10;
f=f%10;
t = m*100+n + f*10;
if((m==n && n==f) ||   f==0) t=0;
return t;
}

int permuteDigits3B(int x){
  
int m =0;
int n = 0;
int t=0;
int f=0;

m=x%100;
n = x/10;
f=x%100;
t = m*100+n;
if((m==n && n==f) ||   m==0 ) t=0;
return t;
}

int permuteDigits(int x){
  
int m =0;
int n = 0;
int t=0;

m=x%10;
n = x/10;
t = m*10+n;
if(m==n || n==0 || m==0 ) t=0;
return t;
}

}

