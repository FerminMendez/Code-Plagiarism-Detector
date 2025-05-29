/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joel
 */
import java.io.*;
public class RecycledNumbers
{
    public static void main(String[] args)
    {
        try
        {
            FileWriter output = new FileWriter("C:\\Users\\Joel\\Documents\\CSCI 221\\Netbeans Projects\\Google CodeJam\\src\\C-small-attempt2.out");
            BufferedWriter out = new BufferedWriter(output);
            FileReader reader = new FileReader("C:\\Users\\Joel\\Documents\\CSCI 221\\Netbeans Projects\\Google CodeJam\\src\\C-small-attempt2.in");
            BufferedReader in = new BufferedReader(reader);
            int p = Integer.parseInt(in.readLine());
            StringBuilder test;
            int count = 0;
            for (int i = 0; i < p; i++)
            {
                String nums = in.readLine();
                int m = Integer.parseInt(nums.substring((nums.indexOf(" ")) + 1));
                int n = Integer.parseInt(nums.substring(0, nums.indexOf(" ")));
                for (int j = n; j < (m+1); j++)
                {
                    test = new StringBuilder(Integer.toString(j));
                    int k;
                    do
                    {
                        char move = test.charAt(test.length() - 1);
                        test.insert(0, move);
                        test.deleteCharAt(test.length() - 1);
                        k = Integer.parseInt(test.toString());
                        if (k > j && k < (m + 1) && k != j)
                            count++;
                    }
                    while(k != j);
                }
                out.write("Case #" + (i + 1) + ": " + count + "\n");
                count = 0;
            }
            out.close();
        }
        catch (IOException e)
        {
            
        }
    }
}
