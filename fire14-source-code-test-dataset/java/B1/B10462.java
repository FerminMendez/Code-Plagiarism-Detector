
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ikhwan
 */
public class C
{
    public static void main(String []args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int test = Integer.parseInt(input);
        StringTokenizer token;
        for(int i=1;i<=test;i++)
        {
            String temp = br.readLine();
            token = new StringTokenizer(temp," ");
            String n1 = token.nextToken();
            String m1 = token.nextToken();
            int a=Integer.parseInt(n1),b=Integer.parseInt(m1);
            System.out.println("Case #"+i+": "+run(a,b));
            pool.clear();
        }

        //String k = "102";
        //System.out.println(run(Integer.parseInt(k),988));
    }
    static TreeSet<pair> pool = new TreeSet<pair>();
    public static int run(int A,int B)
    {
        int counter=0;
        int k = B-1;
        for(int i=A;i<k;i++)
        {
            String n = String.valueOf(i);
            for(int j=1;j<n.length();j++)
            {
                String m = leftshift(n,j);
                
                
                if(isRecycled(i,m,B))
                {
                    //System.out.println(n+" "+m);
                    counter++;
                    pool.add(new pair(n,m));
                }
            }
        }

        return counter;
    }

    static boolean isRecycled(int n,String m, int B)
    {
        boolean isRecycled=false;
        
        int mNum = Integer.parseInt(m);
        
        if(n<mNum && mNum<= B)
        {
            pair p=new pair(n+"",m);
            if(!pool.contains(p))
            isRecycled = true;
            //else
            //System.out.println(p.n+" "+p.m);
        }

        return isRecycled;

    }

    public static String leftshift(String number, int times)
    {
        String temp =number;
        for(int i=0;i<times;i++)
        {
            temp = leftshift(temp);
        }

        return temp;


    }

    public static String leftshift(String number)
    {
        StringBuffer hasil=new StringBuffer("");
        hasil.append(number.charAt(number.length()-1));
        hasil.append(number.substring(0,number.length()-1));
        return hasil.toString();
    }


    static class pair implements Comparable<pair>
    {
        String n,m;

        pair(String nn,String mm)
        {
            n=nn;
            m=mm;
        }

        public int compareTo(pair t)
        {
            return (n+m).compareTo((t.n+t.m));
        }
    }
    

}
