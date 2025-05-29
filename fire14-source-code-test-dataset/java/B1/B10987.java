
import java.io.*;
import java.util.*;
public class trie
{
    public static void main(String[] args)throws IOException
    {
     int i,j,a,b,n,ans;
        String s1="",p1="";
        solver h1=new solver();
        Scanner fin=new Scanner(new File("A.txt"));
        s1=fin.nextLine();
        n=Integer.parseInt(s1);
        FileWriter fstream=new FileWriter("out.txt");
        BufferedWriter out=new BufferedWriter(fstream);
        for(i=0;i<n;i++)
        {
            s1="";
            j=0;
            s1=fin.nextLine();
            out.write("Case #");
            out.write(Integer.toString(i+1));
            out.write(": ");
            while(s1.charAt(j)!=' ')
            {
                p1=p1+s1.charAt(j);
                j++;
            }
            a=Integer.parseInt(p1);
            p1="";
            j++;
            while(j<s1.length())
            {
                p1=p1+s1.charAt(j);
                j++;
            }
            b=Integer.parseInt(p1);
            p1="";
            ans=h1.solve(a,b);
            out.write(Integer.toString(ans));
            out.write("\n");
        }
        out.close();
        
    }
    
}
