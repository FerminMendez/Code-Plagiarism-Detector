/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;
import java.util.*;
import java.io.*;
public class RecycledNumbers{
    public static void main(String[] args) throws Exception
    {
        Scanner input = new Scanner(new File("C:\\temp\\C-small.in"));
        int T = input.nextInt();
        for (int t = 1; t <= T; t++)
        {
        int A = input.nextInt();
        int B = input.nextInt();
        double answer = 0;
        for (int a = A; a <= B; a++)
        {
            String aS = a + "";
            for (int i = aS.length(); i > 1; i--)
            {
                int max = Integer.parseInt(aS.substring(i-1) + aS.substring(0, i-1));
                if (max <= B && max >= A && max != a)
                {
                   answer++;
                }
            }
        }
        System.out.println("Case #" + t + ": " + (int)(answer/2));
    }
    }
    public static String reverse(String s, int i)
    {
        return (i < s.length()) ? s.charAt(s.length()-1-i) + reverse(s, i+1) : "";
    }
}
