
/**
 * Shashank Gupta
 * 
 * ****SinnerShanky****
 */
import java.io.*;
public class problem_C
{
    void main()
    {
        try
        {
           FileReader fr=new FileReader("C:\\USERS\\SHASHANK GUPTA\\DOWNLOADS\\C-small-attempt0.in");
           BufferedReader br=new BufferedReader(fr);
           int n=Integer.parseInt(br.readLine());
           for(int i=1;i<=n;i++)
           {
               int count=0;
               String s=br.readLine();
               int b=0;
               int a=0;
               for(int j=0;j<s.length();j++)
                 {
                   if(s.charAt(j)==' ')
                   {
                     a=Integer.parseInt(s.substring(0,j));
                     b=Integer.parseInt(s.substring(j+1,s.length()));
                     j=s.length();
                   }
                  }
                  for(int j=a;j<b;j++)
                  {
                      for(int k=j+1;k<=b;k++)
                      {
                          String temp=Integer.toString(j);
                          if(check(temp,k)==true)
                          count++;
                        }
                  }
                  System.out.println("Case #"+i+": "+count);
           }
            fr.close();
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
    boolean check(String s, int b)
    {
        String s1="";
        for(int i=s.length()-1;i>=0;i--)
        {
            s1=s.substring(0,i);
            s1=s.substring(i)+s1;
            int a=Integer.parseInt(s1);
            if(a==b)
            return true;
        }
        return false;
    }
        
}
