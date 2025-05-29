import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dancing
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("inputs/dancing.in"));
        
        int cases = sc.nextInt();
        
        for (int i = 1; i <= cases; i++)
        {
            int googs = sc.nextInt();
            int surprises = sc.nextInt();
            int min = sc.nextInt();

            int num = 0;
            
            for (int j = 0; j < googs; j++)
            {
                int curr = sc.nextInt();

                int remain = curr - min;

                if (remain < 0)
                {
                    continue;
                }
                else if (remain / 2 >= (min - 1))
                {
                    num++;
                }
                else if (surprises > 0 && (remain / 2 == (min - 2)))
                {
                    num++;
                    surprises--;
                }
            }
            
            System.out.printf("Case #%s: %s\n", i, num);
        }
    }
}
