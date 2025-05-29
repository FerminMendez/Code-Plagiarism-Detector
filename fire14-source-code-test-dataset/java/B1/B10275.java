
package recyclednumbers;

 


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RecycledNumbers {

    public static void main(String[] args) {
      
        int result= 0 ,x,y,counter,num,count;

        String SoX,temp;

       int[] array = new int[7];
 
       int cntarray=0;

       boolean flag = true;

       PrintWriter pw = null;
 
      Scanner sc = null;
  
      try {
   
             sc = new Scanner(new FileReader("C:\\Users\\gad\\Downloads\\C-small-attempt0.in"));
 
             pw = new PrintWriter(new FileWriter("D:\\mystudy\\RCoutput.out"));

             int  cc=Integer.parseInt(sc.nextLine());
   
             for(int cnt=0;cnt<cc;cnt++)

                {
                   
                   x=sc.nextInt();

                   y=sc.nextInt();
                     for(int j=x;j<=y;j++){

                             SoX=String.valueOf(j);
 
                             counter=SoX.length();
                             count=counter;

                             array[cntarray]=j;

                             cntarray++;

                             temp=SoX;
 
                       while(count>1)

                        {

                           temp =  temp.substring(1,counter) + temp.charAt(0);

                            num = Integer.parseInt(temp);

                            for (int t=0;t<cntarray;t++)

                                if(num==array[t])
  
                                    {
   
                                      flag=false;
 
                                      break;
 
                                    }

                               if(flag==true)
  
                                   {
      
                                      array[cntarray]=num;
                   
                                      cntarray++;
  
                                  }
    
                               if(num<=y&&num>=x&&j<num&&flag)
 
                                 {
                                  result++;
  
                                }
      
                      count--;
   
                      flag=true;
   
                     }
   
                     cntarray=0;
  
                      flag=true;
    
                }
        
            pw.println("Case #"+(cnt+1)+": "+result);
    
            result=0;
  
            cntarray=0;
   
             }
     
   } 
catch (IOException ex) {

            Logger.getLogger(RecycledNumbers.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            pw.flush();

            pw.close();
         
   sc.close();

        }
    }

          }
          


