import java.io.*;
import java.util.*;
import java.lang.Math.*;
public class gcj2
{
     public static void main(String args[])throws Exception
     {
         //Scanner in=new Scanner(System.in);
         //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         //BufferedReader br = new BufferedReader(new FileReader("gcj2.in"));
         //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gcj2.out")));
         //PrintWriter pw = new PrintWriter(System.out);
         BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\rahul\\Desktop\\gcj2.in"));
         PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\rahul\\Desktop\\gcj2.out")));
         StringTokenizer st;
         int a[]={0,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,9,9,9,10,10,10,10,10};
         int c[]={-1,-1,2,5,8,11,14,17,20,23,26};
         int t=Integer.parseInt(br.readLine());
         int ctr=0;
         while(t>0)
         {
             t--;
             ctr++;
             int need=0,best=0;
             st=new StringTokenizer(br.readLine());
             int n=Integer.parseInt(st.nextToken());
             int s=Integer.parseInt(st.nextToken());
             int p=Integer.parseInt(st.nextToken());
             
             for(int i=0;i<n;i++)
             {
                 int val=Integer.parseInt(st.nextToken());
                 if(a[val]>=p)
                 {
                     if(p>=2 && (val==c[p] || val==c[p]+1))
                     {
                        need++;
                      }
                      
                      else best++;
                  }
             }
             best=best + Math.min(s,need);
             pw.println("Case #" + ctr + ": " +best);
         }

        pw.flush();
        pw.close();
     }
}