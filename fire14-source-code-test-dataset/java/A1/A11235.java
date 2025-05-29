import java.io.*;
import java.util.*;
import java.math.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        new Solution().run();
    }
    StreamTokenizer in; 
    Scanner ins;
    PrintWriter out;
    
    int nextInt() throws IOException
    {
        in.nextToken();      
        return (int)in.nval;
    }
   

    void run() throws IOException
    {

        if(System.getProperty("ONLINE_JUDGE")!=null)
        {
            in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
            ins = new Scanner(System.in);
            out = new PrintWriter(System.out);
        }
        else
        {           
            in = new StreamTokenizer(new BufferedReader(new FileReader("input.txt")));             
            ins = new Scanner(new FileReader("input.txt"));
            out = new PrintWriter(new FileWriter("output.txt"));
        }
        int n = nextInt();
        for(int k =0; k<n; k++)
        {
            out.print("Case #"+(k+1)+": ");
            int m = nextInt(),t = nextInt(), p = nextInt();
            p*=3;
            int answ = 0;
            for(int i = 0; i<m; i++)
            {
                int a = nextInt();
                
                if(a>=p || (a+2>=p && p>=1 && a-1>=0))
                    answ++;
                else
                {
                    if(a+4>=p && p>=2  && t>0 && a-2>=0)
                    {
                        answ++;
                        t--;
                    }
                }

            }
            out.print(answ);
            out.println();
        }
        
        out.close();
    }
    
    interface Ololo
    {
        public int Calc();
    }
    enum Trololo{ZOMBI, Ololosha, kukuru}
    class Team implements Comparable
    {
        public int p,t;
        public int compareTo(Object obj)
        {
            Team a = (Team) obj;
            if(p>a.p || p==a.p && t<a.t)                          
                return -1;
            else                
                if(p==a.p && t==a.t)
                    return 0;
                else
                    return 1;
        }
        
    }
}