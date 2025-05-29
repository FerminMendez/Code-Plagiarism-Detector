import java.util.*;
import java.io.*;
  


      
  class gcj002{
    

      public static String RotateNumber(String aaa)
      {
        /*
        int start = Integer.parseInt(aaa);
         int number = Integer.parseInt(aaa);
            int numdigits = (int) Math.log10((double)number); // would return numdigits - 1
            int multiplier = (int) Math.pow(10.0, (double)numdigits);
            //System.out.println(numdigits);
            //System.out.println(multiplier);
           
                  int q = number / 10;
                  int r = number % 10;
                  //1234 = 123;
                  number = number / 10;
                  number = number + multiplier * r;
                  return number+"";
                  */
        
        String ret="";
           String str,str1;
          // str=""+number;
           str=aaa;
           int numdigits=str.length();
           char c;
           
           c=str.charAt(numdigits-1);
           
           str1=c+str.substring(0,numdigits-1);
           //number=Integer.parseInt(str1);
            //return number;
          // return  ret=""+number;
           return str1;
      }     
      
    public static void main (String[] args) throws IOException{
      
      //String str="",str1="";
      //char c;
      
      FileReader fin=new FileReader("C-small-attempt0.in");
      FileWriter fout=new FileWriter("out.out");       
      
      Scanner scan=new Scanner(fin);
      Scanner scan1=new Scanner(fin);
      
      int count=scan.nextInt();
      int num1=0,num2=0,temp=0,length=0,ans,rnum,j=0,k=0;
      String str="",pp="",rt="";
      
      for (int i=0;i<count;i++)
      {
        ans =0;
        num1=scan.nextInt();
        num2=scan.nextInt();
        j=0;
        k=0;
        for(j=num1;j<num2;j++)
        {
         for(k=j+1;k<=num2;k++)
         {
           str=""+num1;
           length=str.length();
           
           temp=j;
           rnum=k;
           pp=rnum+"";
          // System.out.println("j---->>>"+j+"    K------>>>"+k);
           for(int z=0;z<length;z++)
           {
            //pp=rnum+"";
           // pp=rnum+"";
            //rt=pp;
           // System.out.println(pp);
            pp=RotateNumber(pp);
            
            rnum=Integer.parseInt(pp);
            //System.out.println(rnum);
            if (temp==rnum)
            {
             ans+=1; 
             //System.out.println("temp--->>>"+temp+"   k------>>>"+k);
            }
          
           }

         }
          
        }
       //System.out.println("length ----------"+length); 
      // System.out.println("Count======"+i);
      // System.out.println(ans+"\n");
       // System.out.println("Case #"+(i+1)+": "+ans+"\n");
       fout.write("Case #"+(i+1)+": "+ans+"\n");
      }
      
      fin.close();
      fout.close();
    }
    
  }