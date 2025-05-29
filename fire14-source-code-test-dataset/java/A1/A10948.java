import java.io.*;
import java.util.Scanner;
import java.util.*;

public class trie
{
    public static void main(String[] args) throws IOException
    {
        int i,j,nog,nos,p,n,count;
        int[] t=new int[10];
        String s1="",p1="",m1="";
        solver h1=new solver();
        Scanner fin=new Scanner(new File("A.txt"));
        s1=fin.nextLine();
        n=Integer.parseInt(s1);
        FileWriter fstream=new FileWriter("out.txt");
        BufferedWriter out=new BufferedWriter(fstream);
        for(i=0;i<n;i++)
        {
            j=0;
            s1="";
            s1=fin.nextLine();
            out.write("Case #");
            out.write(Integer.toString(i+1));
            out.write(": ");
            while(s1.charAt(j)!=' ')
            {
                p1=p1+s1.charAt(j);
                j++;
            }
                         System.out.println(p1);
            nog=Integer.parseInt(p1);
            j++;
            p1="";
            while(s1.charAt(j)!=' ')
            {
                p1=p1+s1.charAt(j);
                j++;
            }
                      //   System.out.println(p1);
            nos=Integer.parseInt(p1);
            j++;
            p1="";
            while(s1.charAt(j)!=' ')
            {
                p1=p1+s1.charAt(j);
                j++;
            }
                        // System.out.println(p1);
            p=Integer.parseInt(p1);
            j++;
            p1="";
            count=0;
            while(j<s1.length())
            {   
                if(s1.charAt(j)==' ')
                {
                    t[count++]=Integer.parseInt(p1);
                      //           System.out.println(p1);
                    p1="";
                }
                else
                p1=p1+s1.charAt(j);
                j++;
            }
             t[count++]=Integer.parseInt(p1);
            // System.out.println(p1);
             p1="";
             m1=Integer.toString(h1.solve(nog,nos,p,t));
             out.write(m1);
             m1="";
             out.write("\n");
             
    } 
    out.close();
}
}
