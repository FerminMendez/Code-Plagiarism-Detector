import java.io.*;
import java.util.*;
/**
 * Write a description of class Googlerese here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RecycledNumbers
{
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    
    private int x;
    private int max;
    public RecycledNumbers(int n)
    {
        x=0;
        max=n;
    }
    
        public int countdigit(int b)
        {
            int ctr=0;
            while(b>0)
            {
                b/=10;
                ctr++;
            }
            return ctr;
        }
        
        public int fact(int a)
        {
            int fact=1;
            int b=countdigit(a)-1;
                while(b>0)
                {
                    fact*=10;
                    b--;
                }
                return fact;
        }
                    
   public void input(int n,int m)
   {
       int success=0;
       for(int i=n;i<=m;i++)
       {
           for(int j=n;j<=m;j++)
           {
               if(j>i)
               {
                    if(calculate(i,j))
                        success++;
                }
           }
       }
        //System.out.println("Success="+success);
        
        System.out.print("Case #"+(x+1)+": ");
        System.out.println(success);
        x+=1;
        if(x==max)
            return;
       
    }
   
 
            
   public boolean calculate(int n,int m )
   {
     
     int cpy=countdigit(n);
     int aux=0;
     int success=0;
     
     int test=n;
    while(aux<cpy)
     //while(rd<cpy)
     {
         int x=fact(n);
         
         int y=n/x;
         n=n%(y*x);
         //System.out.println(n);
         n=n*10;
         n=n+y;
         while(cpy>countdigit(n))
            n*=10;
         
         //System.out.println(n);
         if(m==n)
         {
             //System.out.println(test+"="+m);
             //success++;
             return true;
         }
         aux++;
         
         
     }
         
     return false;
     
   }
    
    
    
    
    
    public void start()throws IOException
    {
        // put your code here
       int i=1; 
        File file = new File("C-small-attempt.txt");
    FileInputStream fis = null;
    BufferedInputStream bis = null;
    DataInputStream dis = null;

    try {
      fis = new FileInputStream(file);

      // Here BufferedInputStream is added for fast reading.
      bis = new BufferedInputStream(fis);
      dis = new DataInputStream(bis);

      // dis.available() returns 0 if the file does not have more lines.
      while (dis.available() != 0) {

          if(x==max)
            return;
      // this statement reads the line from the file and print it to
        // the console.
       // System.out.println(dis.readLine());
       String s=dis.readLine();
       StringTokenizer st=new StringTokenizer(s," ");
       while(st.hasMoreElements())
       {
          
            int x=Integer.parseInt(st.nextElement().toString());
           //System.out.println(x);
           
           int y=Integer.parseInt(st.nextElement().toString());
           //System.out.println(y);
           input(x,y);
           
      }
    }

      // dispose all the resources after using them.
      fis.close();
      bis.close();
      dis.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  //Read File Line By Line
  
  //Close the input stream
  
  }
   
     
        
    public static void main(String[]args)throws IOException     
    {
        
        int n;
        do{
         n=Integer.parseInt(br.readLine());
        }while(n<1||n>50);
        RecycledNumbers obj=new RecycledNumbers(n);
        for(int i=0;i<n;i++)
        {
            
        obj.start();
        //System.out.println("Output");
        
    }}}
