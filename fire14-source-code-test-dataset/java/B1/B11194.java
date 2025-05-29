/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication18;

/**
 *
 * @author USER-1
 */
import java.io.*;
public class Main {

    /**
     * @param args the command line arguments
     */

    public static boolean check_recycled(int m,int n)
    {
    int rem=0,div=m;
    Integer k=new Integer(m);
    Integer k1=new Integer(n);
    String g=k.toString();
    String g1=k1.toString();
    int c=0,l=g.length(),l1=g1.length();
    while(c<l)
    {
        int w=0,ml=0;
        String temp="",temp1="";
    while(w<=c)
    {
      temp=String.valueOf(g.charAt(l-w-1))+temp;
      
      w++;
    }
     while(ml<=(l-w-1))
     {
     temp1=temp1+String.valueOf(g.charAt(ml));
     ml++;
     }
    //System.out.println(temp1);
    
    if((temp+temp1).equals(g1))
    {
return true;
    }
    c++;
    }
    return false;
    }


    public static void main(String[] args) {
        // TODO code application logic here
    
    try
    {
    BufferedReader br=new BufferedReader(new FileReader("a1.in.txt"));
    PrintWriter out=new PrintWriter(new FileWriter("out.txt"));
    int t=Integer.parseInt(br.readLine());
    int q=0;
    while(q<t)
    {
    String h[]= br.readLine().split(" ");
    int a=Integer.parseInt(h[0]);
    int b=Integer.parseInt(h[1]),n=0,m=0,p=0;
    //out.println(check_recycled(12345,34512));
    for(int i=a;i<b;i++)
    {
    n=i;
    for(int j=a+1;j<=b;j++)
    {
    m=j;
    if(m>n)
    {
     if(check_recycled(n,m))
     {
     p++;
     
     }

    }
    }
    }
    out.println("Case #"+(q+1)+":"+" "+p);
    q++;
    }
    out.flush();
    }
    catch(Exception e)
    {
    System.out.print(e.toString());


    }

    }

}
