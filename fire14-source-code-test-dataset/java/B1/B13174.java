package recycle;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Recycle {

    public static void main(String[] args) throws Exception {
    
     FileInputStream fr=new FileInputStream("/home/priyankle/Desktop/recycle.txt");
     StreamTokenizer st=new StreamTokenizer(fr);
     st.eolIsSignificant(false);
     st.whitespaceChars(0,32);
     int i=1,j=0,cases=0,count=0;
     int A[]=null;
     int B[]=null;
     
    File file=new File("output.txt");
    FileWriter fileWritter = new FileWriter(file.getName(),true);
    BufferedWriter bufferWritter = new BufferedWriter(fileWritter);

     int learn=0,flag=0;

     while(true)
        {
        flag++;
        learn=st.nextToken();
        if(learn==StreamTokenizer.TT_EOF)
            break;

        if(learn==StreamTokenizer.TT_NUMBER&&flag==1)
        {
            cases=(int)st.nval;
            A=  new int[cases+1];
            B=  new int[cases+1];
        }

        if(learn==StreamTokenizer.TT_NUMBER&&flag==2)
            A[i]=(int)st.nval;

        else if(learn==StreamTokenizer.TT_NUMBER&&flag==3)
        {
            B[i]=(int)st.nval;
            flag=1;
            i++;
        }   
    }

     int resultant=0;
    
    int y1=0,y2=0,y3=0,temp=0;

    for(j=1;j<=cases;j++)
    {
    count=0;
    for(i=A[j];i<=B[j];i++)
    {
        y1=i/100;
        temp=i%100;
        y2=temp/10;
        y3=temp%10;
    
        if(y1==0&&y2==0&&y3==0)
        { 
            count=0;
        }
        
        else if(y1==0&&y2!=0)
        {
            if(y3>y2)
            {
                resultant=y3*10+y2;
                   if(resultant<=B[j])
                    count++;
            }   
        }
        
        else
        {
            if((y2>y1)||(y2==y1&&y2<y3))
            {
            resultant=y2*100+y3*10+y1;
                if(resultant<=B[j])
                  count++;
            }
        
            if((y3>y1)||(y3==y1&&y3>y2))
            {
            resultant=y3*100+y1*10+y2;
                if(resultant<=B[j])
                  count++;
            }
        }
    }
    bufferWritter.write("Case #"+j+": "+count+"\n");    
    }
    bufferWritter.close();

    }
}
