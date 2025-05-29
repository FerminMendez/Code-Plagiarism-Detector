/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joel
 */
import java.io.*;
import java.util.*;
public class GoogleDance
{
    public static void main(String[] args)
    {
        try
        {
            FileWriter output = new FileWriter("C:\\Users\\Joel\\Documents\\CSCI 221\\Netbeans Projects\\Google CodeJam\\src\\B-small-attempt1.out");
            BufferedWriter out = new BufferedWriter(output);
            FileReader reader = new FileReader("C:\\Users\\Joel\\Documents\\CSCI 221\\Netbeans Projects\\Google CodeJam\\src\\B-small-attempt1.in");
            BufferedReader in = new BufferedReader(reader);
            ArrayList<Integer> scores = new ArrayList<Integer>();
            int count = 0;
            int t = Integer.parseInt(in.readLine());
            for (int i = 0; i < t; i++)
            {
                StringBuilder nums = new StringBuilder(in.readLine());
                int n = Integer.parseInt(nums.substring(0, nums.indexOf(" ")));
                nums.delete(0, (nums.indexOf(" ") + 1));
                int s = Integer.parseInt(nums.substring(0, nums.indexOf(" ")));
                nums.delete(0, (nums.indexOf(" ") + 1));
                int p = Integer.parseInt(nums.substring(0, nums.indexOf(" ")));
                nums.delete(0, (nums.indexOf(" ") + 1));
                for (int j = 0; j < (n - 1); j++)
                {
                    scores.add(Integer.parseInt(nums.substring(0, nums.indexOf(" "))));
                    nums.delete(0, (nums.indexOf(" ") + 1));
                }
                scores.add(Integer.parseInt(nums.substring(0)));
                Collections.sort(scores);
                int next = 0;
                if (p == 0)
                    count = scores.size();
                else if (p == 1)
                {
                    for (int k : scores)
                        if (k != 0)
                            count++;
                }
                else
                {
                    while (s > 0 && (next != scores.size()))
                    {
                        if (scores.get(next) >= (p + (2 * (p - 2))))
                        {
                            count++;
                            next++;
                            s--;
                        }
                        else
                           next++;
                    }
                    while (next != (scores.size()))
                    {
                        if (scores.get(next) >= (p + (2 * (p - 1))) && next != scores.size())
                        {
                            count++;
                            next++;
                        }
                        else
                            next++;
                    }
                }
                out.write("Case #" + (i + 1) + ": " + count + "\n");
                count = 0;
                next = 0;
                scores.clear();
            }
            out.close();
        }
        catch (IOException e)
        {
            
        }
    }
}
