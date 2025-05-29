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
public class Codejam2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        
       
         Scanner scanner = new Scanner(new File("C:\\Documents and Settings\\ZIYAN\\Desktop\\B-small-attempt2.IN"));
       
       
        FileWriter fstream = new FileWriter("C:\\Documents and Settings\\ZIYAN\\Desktop\\out.txt");
        BufferedWriter out = new BufferedWriter(fstream);
        
        int cases=scanner.nextInt();
        for(int l=0;l<cases;l++)
        {
            out.write("Case #"+(l+1)+": ");
        int a,b,c;
        a =scanner.nextInt();
        b=scanner.nextInt();
        c=scanner.nextInt();
        
        
        int[] x=new int[a];
        for(int m=0;m<a;m++)
        {
            x[m]=scanner.nextInt();
        }
        if(c==0)
        {
            int reslt=a;
            String rs="";
            rs+=reslt;
            System.out.println(rs);
            out.write(rs);
            out.newLine();
            //continue;
        }
        else{
        int [][] arr=arrngaryy(x);
      
        int reslt=0;
        for(int i=0;i<a;i++)
        {
            
            int add=arr[i][0]+arr[i][1]+arr[i][2];
            if(add==0)
            {
                continue;
            }
            if(add>=(3*c-2))
            {
                reslt++;
            }
            else if(add<=(3*(c-1))&& add>=(3*c-4) && b!=0 )
            {
                reslt++;
                b--;
            }
        }
        String rs="";
        rs+=reslt;
        System.out.println(rs);
        out.write(rs);
         out.newLine();
        
        }
        }
        out.close();
        
        
        
        
        
      
        
        
        
    }
    
    public static int[][] arrngaryy(int[] x)
    {
        int a=x.length;
        int[][] arr=new int[a][3];
        for(int i=0;i<a;i++)
        {
            
            if(x[i]%3==2)
            {
                arr[i][0]=x[i]/3;
                arr[i][1]=x[i]/3+1;
                arr[i][2]=x[i]/3+1;
                
            }
            else if(x[i]%3==1)
            {
                arr[i][0]=x[i]/3;
                arr[i][1]=x[i]/3;
                arr[i][2]=x[i]/3+1;
            }
            else
            {
                arr[i][0]=x[i]/3;
                arr[i][1]=x[i]/3;
                arr[i][2]=x[i]/3;
            }
        }
        return arr;
    }
}
