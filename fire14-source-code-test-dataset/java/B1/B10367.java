/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recycle;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Recycle {

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        
         File file=new File("output.txt"); 
         int cases=0;
       
        int A[]=null,B[]=null;
        int result[]=null;
        int temp=0,digits=0;   
            
            
            
         FileInputStream fr=new FileInputStream("C:\\Users\\Sachin\\Desktop\\C-small-attempt0.in");
         @SuppressWarnings("deprecation")
         StreamTokenizer st=new StreamTokenizer(fr);
         st.eolIsSignificant(false);
         st.whitespaceChars(0,32);
         
          int learn=0,flag=0,j=0;

     while(true)
        {
        flag++;
        
        learn=st.nextToken();
        if(learn==StreamTokenizer.TT_EOF)
            break;

        if(learn==StreamTokenizer.TT_NUMBER&&flag==1)
        {
            cases=(int)st.nval;
            A=new int[cases];
            B=new int[cases];
            result=new int[cases];
        }
            
        if(learn==StreamTokenizer.TT_NUMBER&&flag==2)
            A[j]=(int)st.nval;
        

        else if(learn==StreamTokenizer.TT_NUMBER&&flag==3)
        {
            B[j]=(int)st.nval;
            flag=1;
            j++;
        }
    }
            
     
        for(int i=0;i<cases;i++)
        {
            digits=1;
            result[i]=0;
            while(A[i]/digits!=0)
                digits*=10;
            digits/=10;
            
            temp=A[i];
            if(digits==1)
                result[i]=0;
            else if(digits==10)
                while(temp<=B[i])
                {
                    int o=temp%10,t=temp/10;
                    if((o*10+t)<=B[i]&&(o*10+t)>temp)
                        result[i]++;
                    temp++;
                }
            else 
                while(temp<=B[i])
                {
                    int o=temp%10,t=(temp/10)%10,h=temp/100;
                    if((o*100+h*10+t)<=B[i]&&(o*100+h*10+t)>temp)
                        result[i]++;
                    if((t*100+o*10+h)<=B[i]&&(t*100+o*10+h)>temp)
                        result[i]++;
                    temp++;
                }
                
            
            
            
            
            
        }
        FileWriter fileWritter = new FileWriter(file.getName(),true);
    	BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        for(int i=0;i<cases;i++)
            bufferWritter.write("Case #"+(i+1)+": "+result[i]+"\n");
        bufferWritter.close();
        
        
        
    }
}
