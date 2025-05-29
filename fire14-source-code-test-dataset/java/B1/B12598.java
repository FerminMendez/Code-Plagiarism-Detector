import java.io.*;
import java.util.*;
import java.lang.Math.*;
public class gcj3
{
     public static void main(String args[])throws Exception
     {
         //Scanner in=new Scanner(System.in);
         //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         //BufferedReader br = new BufferedReader(new FileReader("gcj3.in"));
         //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gcj3.out")));
         //PrintWriter pw = new PrintWriter(System.out);
         StringTokenizer st;
         BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\rahul\\Desktop\\gcj3.in"));
         PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\rahul\\Desktop\\gcj3.out")));
         int t=Integer.parseInt(br.readLine());
         int ctr=0;
         while(t>0)
         {
             int total=0;
             t--;ctr++;
             st=new StringTokenizer(br.readLine());
             int A=Integer.parseInt(st.nextToken());
             int B=Integer.parseInt(st.nextToken());
             int i,j,k,l;
             int ctr1=0,ctr2=0;
             for(i=A;i<=B;i++)
             {
                 String s=Integer.toString(i);
                 l=s.length();
                 String s1=s;
                 int a[]=new int[l+1];
                 a[0]=-1;
                 for(j=0;j<l;j++)
                 {
                     s1=s1.substring(l-1)+s1.substring(0,l-1);
                     int val=Integer.parseInt(s1);
                     a[j+1]=val;
                 }
                 Arrays.sort(a);
                 for(j=1;j<=l;j++)
                 if(a[j]<=B && a[j]>i && a[j]!=a[j-1])
                     {
                         ctr1++;
                     }
                }
             pw.println("Case #"+ctr+": "+ctr1);   
            }
            pw.flush();
     }
     
}