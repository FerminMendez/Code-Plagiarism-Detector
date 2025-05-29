import java.io.*;

public class ProCOpt
{
    public static void main(String args[])
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("E:\\test.txt"));
            int n;
            n= Integer.parseInt(br.readLine());
            
            int casen=0,i,j;
            int a,b,count;
            
            String temp,t,u;
            String outp;
            outp="";
            
            String spl[];
            String memory,fp,lp;
            while( casen < n )
            {
                temp = br.readLine();
                outp += "Case #"+(casen+1)+": ";
                
                spl = temp.split(" ");
                a = Integer.parseInt(spl[0]);
                b = Integer.parseInt(spl[1]);
                
                count = 0;
                memory = "";
                
                for(i=a;i<=b; i++)
                {
                	t = i+"";
                	                	
                	for(j=1;j<t.length();j++)
                	{
                		u= t.substring(j);
                		u+= t.substring(0,j);
                		//System.out.println(u);
                		if( !u.startsWith("0") && Integer.parseInt(u) < i && Integer.parseInt(u)<= b && Integer.parseInt(u) >= a)
                		{
                			if( t.length() % 2 == 0 )
                			{
                				fp= t.substring(0,t.length()/2);
                				lp = t.substring(t.length()/2);
                				if( fp.equals(lp) )
                				{
                					if(!memory.contains(Integer.parseInt(u)+" "+i))
                					{
                						count++;
                						memory += Integer.parseInt(u) + " " + i+"\n";
                					}
                				}
                				else
                				{
                					count++;
                				}
                			}
                			else
                			{
                				count++;
                			}
                			/*if( memory.contains(Integer.parseInt(u)+" "+i) )
                				System.out.println(Integer.parseInt(u)+"  "+i);
                			else
                			{
                				count++;
                				memory += Integer.parseInt(u) + " " + i+"\n";
                			}*/
                		}
                	}                	
                }
                outp += count;                
                if( casen != n-1 )
                    outp += "\n";
                casen++;
            }
            System.out.println(outp);

            BufferedWriter bw = new BufferedWriter( new FileWriter("E:\\result.txt"));
            bw.write(outp);
            bw.close();
            
            br.close();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}
