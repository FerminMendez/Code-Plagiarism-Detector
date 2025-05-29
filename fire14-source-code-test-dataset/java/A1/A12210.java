import java.io.*;
public class codejam2 
{
    public static void main(String args[]) throws FileNotFoundException, IOException
    {
        String address="g:\\cj2.txt";
        BufferedReader br = new BufferedReader(new FileReader(address));
        int test_case=Integer.parseInt(br.readLine());
        int iindex,jindex,N,S,p;
        int ul,ll;
        int select;
        String str,temp[];
        for(iindex=0;iindex<test_case;iindex++)
        {
            select=0;
            str=br.readLine();
            temp=str.split(" ");
            N=Integer.parseInt(temp[0]);
            S=Integer.parseInt(temp[1]);
            p=Integer.parseInt(temp[2]);
            ul=(p*3)-2;
            ll=ul-2;
            for(jindex=3;jindex<N+3;jindex++)
            {
                if(Integer.parseInt(temp[jindex])==0)
                    continue;
                if(Integer.parseInt(temp[jindex])>=ul)
                    select++;
                else if(Integer.parseInt(temp[jindex])>=ll)
                {
                    if(S>0)
                    {
                        S--;
                        select++;
                    }
                }
                
            }
            System.out.print("Case #"+(iindex+1)+": ");
            System.out.println(select);
        }
        
    }
    
}
