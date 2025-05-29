/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package google.code.jam.qualification.round;

import java.io.*;
import java.util.*;
/**
 *
 * @author ahmad
 */
public class GoogleCodeJamQualificationRound {

    /**
     * @param args the command line arguments
     */
    public static String[] input=new String[0];
    public static String[] output=new String[0];
    static String a="";
    static String b="";
    static int counter=0;
    public static String[] addarray(String[] a,String val)
    {
        String[] b=new String[a.length+1];
        for(int i=0;i<a.length;i++)
        {
            b[i]=a[i];
        }
        b[a.length]=val;
        return b;
    }
    
    public static void getdata() throws FileNotFoundException, IOException
    {
          FileInputStream fstream = new FileInputStream("C-small-attempt0.in");
          DataInputStream in = new DataInputStream(fstream);
          BufferedReader br = new BufferedReader(new InputStreamReader(in));
          String strLine;
          while ((strLine = br.readLine()) != null)   {
          input=addarray(input,strLine);
          }
    }
    
    public static void setdata(String []s) throws IOException
    {
        
        
          FileWriter fstream = new FileWriter("out.txt");
          BufferedWriter out = new BufferedWriter(fstream);
          for(int i=0;i<s.length;i++)
          {
              out.write(s[i]+"\n");
              
          }
          out.close();
          
        
        
    }
    
public static boolean samenum(int n)
{
    String s=String.valueOf(n);
    int bad=0;
    char a=s.charAt(0);
    for(int i=0;i<s.length();i++)
    {
        if(s.charAt(i)!= a)
        {
            bad =1;
        }
    }
    if(bad==1)
    {
        return false;
    }
    else
        return true;
}
    
    
    public static void solveproblem()
    {
        
        int n=Integer.parseInt(input[0]);
        for(int i=1;i<=n;i++)
        {
            ArrayList aaa=new ArrayList();
            counter=0;
            String[] nums=input[i].split(" ");
             a=nums[0];
             b=nums[1];
             int n1=Integer.parseInt(a);
             int n2=Integer.parseInt(b);
           //  System.out.println(".......... "+i+" ................");
             for(int j=n1;j<=n2;j++)
             {
                 
                 
                 if(samenum(j)==true)
                 {}
                 else
                 {
                 String s=String.valueOf(j);
                
                 for(int k=0;k<s.length()-1;k++)
                 {
                     String s1=s.substring(0, k+1);
                     String s2=s.substring(k+1);
                     int nn=Integer.parseInt(s2+s1);
                     
                     solve(nn,j);
                     
                 }
                 }
             }
             if(a.length()>3)
             {
                 counter--;
             }
               output=addarray(output,"Case #"+i+": "+counter+"");
             
        }
        
    }
    
    public static void solve(int n1,int n2)
    {
      // System.out.println(n1+"    "+n2);
       // int i=Integer.parseInt(a);
        for(int i=Integer.parseInt(a);i<n2;i++)
        {
            
            if(i==n1)
            {
                
                counter++;
                System.out.println(i+"    "+n1+"  "+counter);
                break;
            }
        }
      
        
        
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
    getdata();
    solveproblem();
    setdata(output);
     // TODO code application logic here
    }
}
