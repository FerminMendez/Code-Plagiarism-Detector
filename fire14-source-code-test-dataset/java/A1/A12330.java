/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;
/**
 *
 * @author Alex
 */
public class GooglePartay
{
    
    public static void main(String sArgs[]) throws IOException
    {
        
        Scanner oScan = new Scanner(new File("B-small-attempt2.in"));
        //Scanner oScan = new Scanner(new File("sompin.txt"));
        int sets = Integer.parseInt(oScan.nextLine().trim());
        int count = 0;
        while(sets-->0)
        {
            count++;
            int googlers = oScan.nextInt();
            int sp = oScan.nextInt();
            int lim = oScan.nextInt();
            int[] scores = new int[googlers];
            for (int i = 0; i <googlers; i++)
            {
                scores[i]=oScan.nextInt();
            }
            int above = 0;
            ArrayList<Googler> list = new ArrayList<Googler>();
            for (int i = 0; i <scores.length; i++)
            {
                list.add(new Googler(scores[i],lim));
            }
            for(Googler g:list)
            {
                //System.out.println(g);
                if(g.above&&!g.surpr)above++;//System.out.println(g);
                else if(g.above&&g.surpr&&sp>0)
                {
                    sp--;
                    above++;
                }
            }
            System.out.println("Case #"+count+": "+above);
        }
    }
}
class Googler
{
    ArrayList<Score> list = new ArrayList<Score>();
    int n, p;boolean above, surpr;
    class Score implements Comparable<Score>
    {
        int A, B, C, best;boolean surp;
        public Score(){}
        public Score(int a, int b, int c)
        {
            A=a;
            B=b;
            C=c;
           // tot=a+b+c;
            if(Math.max(Math.max(Math.abs(a-b),Math.abs(a-c)),Math.abs(b-c))>1)surp = true;
            best = (int)Math.max(Math.max(a,b),c);
        }
        
        public int compareTo(Score o)
        {
            return surp^o.surp?best-o.best:surp?1:-1;
        }
        
        public String toString()
        {
            return "("+A+","+B+","+C+")"+(surp?"*":"");
        }
    }
    public Googler(){}
    public Googler(int n, int p)
    {
        this.n=n;
        this.p=p;
        createScores();
        Collections.sort(list);
        for(Score s:list)
        {
            if(!s.surp)
            {
                if(s.best>=p)above = true;
            }
        }
        if(above!=true)
        {
            for(Score s: list)
            {
                if(!above)
                {
                    if(s.best>=p)
                    {
                        above = true;
                        surpr = true;
                    }
                }
            }
        }
    }
    public boolean valid(int a, int b, int c)
    {
        return Math.max(Math.max(Math.abs(a-b),Math.abs(a-c)),Math.abs(b-c))<=2;
    }
    public void createScores()
    {
        for(int i = 0; i<=n; i++)
        {
            for(int j = i; j<=n;j++)
            {
                for(int k = j; k<=n; k++)
                {
                    if(valid(i,j,k)&&i+j+k==n)list.add(new Score(i,j,k));
                }
            }
        }
    }
    public String toString()
    {
        return n+"  "+list.toString()+above+surpr;
    }
}