import java.io.*;
import java.util.*;
class DancingGooglers
{
    public static void main(String args[]) throws Exception
    {
        Scanner in = new Scanner(new File("B-small-attempt6.in"));
        FileWriter out = new FileWriter(new File("B-small-attempt6.out.txt"));
        int t = Integer.parseInt(in.nextLine());
        for(int x = 1; x <= t; x++)
        {
            String str = in.nextLine();
            Scanner sn = new Scanner(str);
            int n, s, p, y;
            n = sn.nextInt();
            s = sn.nextInt();
            p = sn.nextInt();
            y = 0;
            int scores[] = new int[n];
            for(int a = 0; a < n; a++)
            {
                scores[a] = sn.nextInt();
            }
            for(int score : scores)
            {
                int base = score/3;
                switch(score % 3)
                {
                    case 0 : 
                    {
                        if(base >= p)
                        {
                            y++;
                        }
                        else if(s > 0 && base > 0 && base + 1 >= p)
                        {
                            y++;
                            s--;
                        }
                    }
                    break;
                    case 1 : 
                    {
                        if(base >= p || base + 1 >= p)
                        {
                            y++;
                        }
                        else if(s > 0 && base + 1 >= p)
                        {
                            y++;
                            s--;
                        }
                    }
                    break;
                    case 2 : 
                    {
                        if(base + 1 >= p || base >= p)
                        {
                            y++;
                        }
                        else if(s > 0 && base + 2 >= p)
                        {
                            y++;
                            s--;
                        }
                    }
                }
            }
            System.out.println("Case #" + x + ": " + y);
            out.write("Case #" + x + ": " + y + "\n");
        }
        out.flush();
        out.close();
    }
}