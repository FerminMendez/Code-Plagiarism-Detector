import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author ZIYAN
 */
public class Test {

    /**
     * @param args the command line arguments
     */
       public static void main(String[] args) throws FileNotFoundException, IOException {
        
        
         Scanner scanner = new Scanner(new File("C:\\Documents and Settings\\ZIYAN\\Desktop\\C-small-attempt0.IN"));
       
       
        FileWriter fstream = new FileWriter("C:\\Documents and Settings\\ZIYAN\\Desktop\\out.txt");
        BufferedWriter out = new BufferedWriter(fstream);
        
        int cases=scanner.nextInt();
        for(int l=0;l<cases;l++)
        {
            out.write("Case #"+(l+1)+": ");
        int a,b;
        a=scanner.nextInt();
        b=scanner.nextInt();
        
        int[] x=new int[b-a+1];
        x[0]=a;
        for(int i=1;i<b-a+1;i++)
        {
           x[i]= x[i-1]+1;
        
            
        }
        int rslt=0;
        for(int m=0;m<x.length;m++)
        {
        String sr="";
        
        sr+=x[m];
        
        
        char[] c=new char[chkdgt(a)];
        c=sr.toCharArray();
        
        for(int p=0;p<c.length;p++)
        {
            
            String br=new String(c);
            int var=Integer.parseInt(br);
            for(int q=m+1;q<x.length;q++)
            {
                if(var==x[q] && x[q]!=0)
                {
                    System.out.println(x[q]);
                    
                    rslt++;
                }
            }
            c=rotate(c);
        }
        }
        System.out.println(rslt);
        String st="";
        st+=rslt;
        out.write(st);
        out.newLine();
        }
        out.close();
    }
    public static char[] rotate(char[] x)
    {
        char[] y=new char[x.length];
        for(int i=0;i<x.length;i++)
        {
            if(i==x.length-1)
            {  
                y[0]=x[i];
            
            }
            else{
            
                y[i+1]=x[i];
            }
            
        }
        String str="";
        String str2="";
        for(int i=0;i<x.length;i++)
        {
            str+=y[i];
            str2+=x[i];
        }
        return str.toCharArray();
        
    }
    public static int chkdgt(int x)
    {
        int dgt=10;
        int rs=1;
        while(x>=dgt)
        {
            dgt*=10;
            rs++;
        }
        return rs;
    }
}

