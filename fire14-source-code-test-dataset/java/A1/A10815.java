import java.io.*;
/**
 *
 * @author ankush
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        //System.out.println(Math.floor(Math.log10(11)));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int ans[]=new int[t];
        for(int i=0;i<t;i++)
        {
            String x=br.readLine();
            String r[]=new String[250];
            r=x.split(" ");
            int n=Integer.parseInt(r[0]);
            int s=Integer.parseInt(r[1]);
             int p=Integer.parseInt(r[2]);
            int count=0;
            int arr[]=new int[n];
            for(int j=0;j<n;j++)
            {
                arr[j]=Integer.parseInt(r[j+3]);
            }
            int pos[]=new int[n];
            for(int j=0;j<n;j++)
            {
                int max=0,a=0,b=0,c=0;
                for(a=p;a<11;a++)
                {
                     for(b=0;b<11;b++)
                    {
                        c=(arr[j]-a-b);
                        if(c>=0 && Math.abs(a-b)<2 && Math.abs(a-c)<2 && Math.abs(c-b)<2)
                        {
                           max=Math.max(a, b);
                           max=Math.max(max,c);
                           if(max >= p && pos[j]!=1)
                           {
                               count++;
                               pos[j]=1;
                           //  System.out.println(arr[j]+" "+a+" "+b+" "+c);
                             a=100;b=100;
                            break;
                           }
                        }
                     }
                }
                if(a==11)
                {
                for(a=p;a<11;a++)
                {
                     for(b=0;b<11;b++)
                    {
                        c=(arr[j]-a-b);
                        if(c>=0 && Math.abs(a-b)<3 && Math.abs(a-c)<3 && Math.abs(c-b)<3)
                        {
                           max=Math.max(a, b);
                           max=Math.max(max,c);
                           if(max >= p && s>0 && pos[j]!=1)
                           {
                               s--;
                               count++;
                               pos[j]=1;
                             // System.out.println(arr[j]+" "+a+" "+b+" "+c+" "+s);
                             a=11;b=11;
                             break;
                           }
                        }
                    }
                }
                }

            }/*
              if(s>0)
                {
              for(int j=0;j<n;j++)
                {
                  if(pos[j]==1)
                  {
                 int max=0,a=0,b=0,c=0;
                for(a=0;a<11;a++)
                {
                     for(b=0;b<11;b++)
                    {
                        c=(arr[j]-a-b);
                        if(c>=0 && Math.abs(a-b)==2 || Math.abs(a-c)==2 || Math.abs(c-b)==2)
                        {
                           max=Math.max(a, b);
                           max=Math.max(max,c);
                           if(max >= p && pos[j]==1)
                           {
                               s--;
                            //  System.out.println(arr[j]+" "+a+" "+b+" "+c);
                             a=100;b=100;
                             break;
                           }
                        }
                     }
                }
                    }
                }
              }*/
            ans[i]=count;
           //System.out.println(x+" "+ans[i]+" "+s);
            
    }
 for(int i=0;i<t;i++)
        {
            System.out.println("Case #"+(i+1)+": "+ans[i]);
        }
}
}