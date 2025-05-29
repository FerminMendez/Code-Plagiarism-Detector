import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: james
 * Date: 4/14/12
 * Time: 3:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Recycled
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("inputs/recycled.in"));
        
        int cases = sc.nextInt();
        
        for (int i = 1; i <= cases; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int num = 0;
            
            for (int j = a; j <= b; j++)
            {
                String s = j + "";
                HashSet<Integer> set = new HashSet<Integer>();

                for (int k = 1; k < s.length(); k++)
                {
                    String rotated = rotate(s, k);
                    if (!rotated.startsWith("0"))
                    {
                        int paired = Integer.parseInt(rotated);

                        if (paired > j && paired <= b)
                        {
                            set.add(paired);
                        }
                    }
                }

                num += set.size();
            }
            
            System.out.printf("Case #%s: %s\n", i, num);
        }
    }
    
    private static String rotate(String s, int i)
    {
        String rotated = s.substring(s.length() - i) + s.substring(0, s.length() - i);

        return rotated;
    }
}
