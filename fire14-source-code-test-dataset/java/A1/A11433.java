import java.util.*;
import java.io.*;

public class Dance
{
    public static void main(String zaga[]) throws FileNotFoundException
    {
        Scanner input = new Scanner(System.in);
        File file = new File("out.txt");
        PrintStream writer = new PrintStream(file);
        
        int T = input.nextInt();
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        for(int t = 0; t < T; t++)
        {
            int N = input.nextInt();
            
            int S = input.nextInt();
            
            int P = input.nextInt();
            
            ArrayList<Integer> scores = new ArrayList<Integer>();
            
            for(int i = 0; i < N; i++)
            {
                scores.add(input.nextInt());
            }
            
            int s = 1;
            
            for(int i = 0; i < scores.size(); i++)
            {   
                int num = scores.get(i);
                
                int first = P;
                
                if((scores.get(i) - P) >= P * 2 )
                {
                    continue;
                }
                
                if(scores.get(i) - P < 0)
                {
                    scores.remove(i);
                    --i;
                    continue;
                }
                
                if(((scores.get(i) - P) / 2) + 1 == P)
                {
                    continue;
                }
                
                if(num - P >= 0)
                {
                    int second = (num - P) / 2;
                    int third = second;
                    
                    if((num - P) % 2 == 1)
                    {
                        ++third;
                    }
                
                    if(second + 2 >= P && third + 2 >= P)
                    {
                        if(s <= S)
                        {
                            ++s;
                           continue;
                        }
                        else
                        {
                            scores.remove(i);
                            --i;
                            continue;
                        }
                    }
                    else
                    {
                        scores.remove(i);
                        --i;
                        continue;
                    }
                    
                }
                else
                {
                    scores.remove(i);
                    --i;
                    continue;
                }
            }
            
            ans.add(scores.size());
        }
        
        for(int i = 0; i < ans.size(); i++)
        {
            writer.print("Case #"+(i+1)+": "+ans.get(i));
            
            if(!(i + 1 == ans.size()))
            {
                writer.print("\n");
            }
        }
        
    }
}