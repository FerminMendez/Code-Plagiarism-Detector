import java.io.*;
public class Palindrome
 {
     public static void main(String args[]) throws IOException
     {
         int N;
         int a,b,i;
         String s[];
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         N=Integer.parseInt(br.readLine());
         for(i=1;i<=N;i++)
         {
             s=br.readLine().split(" ");
             a=Integer.parseInt(s[0]);
             b=Integer.parseInt(s[1]);
             System.out.println("Case #"+i+": "+calc(a,b));
            }
        }
        
     public static int calc(int a,int b)
     {
         int i,j,k,p1,p2,cnt=0;
         int tmp[];
         p1=-1;
         p2=-1;
         for(i=a;i<b;i++)
         {            
            tmp=permute(i);
            for(k=0;k<tmp.length;k++)
            {
                j=tmp[k];
                //
                if(i<j&&j<=b)
                {
                    if(p1==i&&p2==j)
                    {
                    }
                    else
                    {
                        p1=i;p2=j;
                     //System.out.println(i+" "+j);
                     cnt++;
                    }
                }
            }
        }
         return cnt;
       }
       
       public static int[] permute(int tmp)
       {
           int digits=0;
           int cnt,k,i;
           int vals[];
           k=tmp;
           
           String s="";          
           while(k!=0)
           {
               s=(k%10)+s;
               k=k/10;
               digits++;
            }
            cnt=0;
            vals=new int[digits];
           for(i=digits-1;i>=0;i--)
           {
               vals[cnt++]=Integer.parseInt(s.substring(i,digits)+s.substring(0,i));
            }
            return vals;
        }
    }
        
      