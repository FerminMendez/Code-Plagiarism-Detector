package codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Googler
{

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i =1;
        int n = Integer.parseInt(reader.readLine());
        for(; i<=n; i++)
        {
            String input = reader.readLine();
            System.out.print("Case #" + i + ": ");
            String[] sp = input.split(" ");
            int numData  = Integer.parseInt(sp[0]);
            int s = Integer.parseInt(sp[1]);
            int p = Integer.parseInt(sp[2]);
            
            int[] data = new int[numData];
            for(int j=0; j<numData; j++)
            {
                data[j] = Integer.parseInt(sp[j+3]);
            }
            System.out.println(count(data, s, p));
        }
    }
    
    public static int count(int[] data, int s, int p)
    {
        Arrays.sort(data);
        int count = 0;
        for(int i=data.length-1; i>=0 && s>=0; i--)
        {
            if(data[i] % 3 == 0)
            {
                if(data[i]/3 >= p)
                {
                    count++;
                    continue;
                }
                else if(data[i]/3 + 1 >=p && s>0 && data[i]/3 -1 >=0)
                {
                    count++;
                    s--;
                    continue;
                }
                else
                {
                    break;
                }
            }
            else if(data[i] % 3 == 2)
            {
                if((data[i]/3 >= p) || data[i]/3 + 1 >=p)
                {
                    count++;
                    continue;
                }
                else if(data[i]/3 + 2 >=p && s>0)
                {
                    count++;
                    s--;
                    continue;
                }
                else
                {
                    break;
                }
            }
            else
            {
                if((data[i]/3 >= p) || data[i]/3 + 1 >=p)
                {
                    count++;
                    continue;
                }
                else if(data[i]/3 - 1 >=p && s>0 && data[i]/3 - 1>=0)
                {
                    count++;
                    s--;
                    continue;
                }
                else
                {
                    break;
                }
            }
        }
        
        return count;
    }
    
}
