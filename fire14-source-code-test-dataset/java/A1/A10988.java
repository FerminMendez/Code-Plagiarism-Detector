import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tc=Integer.parseInt(br.readLine());
        for(int j=0;j<tc;j++)
        {
            String str=br.readLine();
            StringTokenizer st=new StringTokenizer(str);
            int n=Integer.parseInt(st.nextToken());
            int s=Integer.parseInt(st.nextToken());
            int p=Integer.parseInt(st.nextToken());
            int GS[]=new int[n];
            int GT[]=new int[n];
            int cnt=0;
            for(int i=0;i<n;i++)
            {
                GS[i]=Integer.parseInt(st.nextToken());
                GT[i]=GS[i]/3;

            }

            for(int i=0;i<n;i++)
            {
                if (GS[i]==0&&p!=0)
                    continue;
                
                if(GS[i]-(GT[i]*3)==2)
                {
                    
                    GT[i]=GT[i]+1;
                    if(GT[i]>=p)
                    {
                        cnt++;
                        continue;
                    }
                    if(s>0)
                    {
                        if((GT[i]+1)==p)
                        {
                            GT[i]=GT[i]+1;
                            cnt++;
                            s--;
                            
                        }
                    }




                }


            }

            for(int i=0;i<n;i++)
            {
                if (GS[i]==0&&p!=0)
                    continue;
                if(GS[i]-(GT[i]*3)==1)
                {
                    GT[i]=GT[i]+1;
                    if(GT[i]>=p)
                    cnt++;


                }


            }

            for(int i=0;i<n;i++)
            {
                if (GS[i]==0&&p!=0)
                    continue;
                if(GS[i]-(GT[i]*3)==0)
                {
                    if(GT[i]>=p)
                    {
                        cnt++;
                        continue;
                    }
                    else if(s>0)
                    {
                    GT[i] = GT[i] + 1;
                    if(GT[i]>=p)
                        {
                        s--;
                        cnt++;
                        }

                    }

                }


            }

       int x=j+1;
       System.out.println("Case #"+x+": "+cnt);

        }
    }
    

}

