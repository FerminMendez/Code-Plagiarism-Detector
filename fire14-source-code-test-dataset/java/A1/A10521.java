import java.io.*;
public class dwtg
{
    public void dwtg()throws IOException
    {
        FileInputStream fstream = new FileInputStream("C:/Users/m.l/Desktop/B-small-attempt0.in"); 
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int T=Integer.parseInt(br.readLine());int i,j,k,h,g,l,p=0,N=0,S=0;String input;int temp1,temp2,r,s,n,m,ans=0;
        for(i=0;i<T;i++)
        {
            input=br.readLine()+" ";l=input.length();
            for(j=0;j<l;j++)
            {
                if(input.charAt(j)==' ')
                {N=Integer.parseInt(input.substring(0,j));break;}
            }
            for(k=j+1;k<l;k++)
            {
                if(input.charAt(k)==' ')
                {S=Integer.parseInt(input.substring(j+1,k));break;}
            }
            for(h=k+1;h<l;h++)
            {
                if(input.charAt(h)==' ')
                {p=Integer.parseInt(input.substring(k+1,h));break;}
            }
            int t[]=new int[N];
            temp1=0;temp2=h+1;
            for(g=h+1;g<l;g++)
            {
                if(input.charAt(g)==' ')
                {t[temp1]=Integer.parseInt(input.substring(temp2,g));temp1+=1;temp2=g+1;}
            }
            n=0;m=0;
            for(j=0;j<N;j++)
            {
                r=0;s=0;
                if(t[j]%3==0&&t[j]>=3)
                {r=t[j]/3;s=r+1;}
                if(t[j]%3==1)
                {
                    if(t[j]!=1)
                    {r=(t[j]+2)/3;s=r;}
                    if(t[j]==1)
                    r=(t[j]+2)/3;
                }
                if(t[j]%3==2)
                {r=(t[j]+1)/3;s=r+1;}
                if(r>=p)
                n+=1;
                if(r<p&&s>=p)
                m+=1;
            }
            if(S>=m)
            ans=n+m;
            if(S<m)
            ans=n+S;
            System.out.println("Case #"+(i+1)+": "+ans);
        }
    }
}
        