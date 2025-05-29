package tp;
import java.io.*;
public class Numbers
{
    String input[];
    int n,m,g;
    int no;
    int ans[];
    int count=0;
    int j,t_c;
    int a,b;   
    DataInputStream dis=new DataInputStream(System.in);
    FileReader fr;
    BufferedReader br;

    Numbers() throws IOException
    {
        fr= new FileReader("D://D//input2.txt");
        br= new BufferedReader(fr);
    }
    void get() throws IOException // this is input ka process
    {
        String ip=br.readLine();// it will take entire line
        t_c= Integer.parseInt(ip);// taste case

        for(int i=1; i<=t_c; i++)
        {
            ip=br.readLine();
            String ip1[]= ip.split(" ");// split
            a= Integer.parseInt(ip1[0]);
            b= Integer.parseInt(ip1[1]);
            
            count=0;
            
            for(int y=a;y<b;y++)
                for(int z=y+1;z<=b;z++)
                {
                        rotate(y,z); 
               }
           System.out.println("Case #"+i+": "+ count);
        }
    }
    void rotate(int x,int y)
    {   
       int tem=x,c=0;
       while(tem!=0)
       {
           tem=tem/10;
           c++;
       }
       int a1=x;
       for(int i=0;i<c-1;i++)
       {
           
           tem=a1%10;
           a1=a1/10;
           a1+=tem*Math.pow(10,c-1);
           if(a1==y)
           {
                count++;
                return;
           }
       }
        
    }
    
    public static void main(String args[])throws IOException
    {
        Numbers n1=new Numbers();
        n1.get();

    }
    
}
    