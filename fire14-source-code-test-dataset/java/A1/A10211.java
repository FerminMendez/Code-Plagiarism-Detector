/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;
import java.util.*;
import java.io.*;
public class DancingWithGooglers {
    public static void main(String[] args) throws Exception
    {
        Scanner input = new Scanner(new File("C:\\temp\\B-small.in"));
        int A = input.nextInt();
        for (int c = 1; c <= A; c++)
        {
        int N = input.nextInt();
        int S = input.nextInt();
        int p = input.nextInt();
        double[] t = new double[N];
        for (int n = 0; n < N; n++)
        {
            t[n] = input.nextInt();
        }
        int a = 0;
        for (int i = 0; i < t.length; i++)
        {
            for (int j = p; j <= 10; j++)
            {
                if (p == 0 && t[i] == 0)
                {
                    a++;
                    break;
                }
                else if (j >= p && j*3-t[i] <= 2 && t[i] > j)
                    {
                        a++;
                        break;
                    }
                    else if (j >= p && j*3-t[i] <=4 && t[i] > j && S>0)
                    {
                        S--;
                        a++;
                        break;
                    }
            }
        }
        System.out.println("Case #" + c + ": " + a);
        }
        
    }
}
