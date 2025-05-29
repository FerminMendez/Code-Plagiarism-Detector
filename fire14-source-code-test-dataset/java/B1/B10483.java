import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;

public class RN {

    public static void main (String[] args) throws Exception
    {

		BufferedReader sr = new BufferedReader(new FileReader("c:\\Projects\\RN.txt"));

		int total = Integer.parseInt(sr.readLine());

        for (int i=0; i<total; i++)
        {
            String[] tokens = sr.readLine().split(" ");
            int A = Integer.parseInt (tokens[0]);
            int B = Integer.parseInt (tokens[1]);


            int res = solve (A, B);
            System.out.printf("Case #%d: %d\n", i+1, res);

        }
    }

    private static int[] decimals (int A)
    {
        int rest = A;
        int num = 0;

        while (rest > 0)
        {
            rest = rest / 10;
            num++;
        }

        int[] result = new int[num];
        for (int i=0; i<num; i++)
        {
            result[num-i-1] = A % 10;
            A = A / 10;
        }

        return result;
    }

    private static int toNumber (int[] dec, int offset)
    {

        int total1 = 0;
        for (int i=0; i<offset; i++)
        {
            total1 = total1 * 10 + dec[i];
        }

        int total2 = 0;
        for (int i=offset; i<dec.length; i++)
        {
            total2 = total2 *10 + dec[i];
        }

        return total1 + total2 * (int)Math.pow(10, offset);
    }


    public static int solve (int A, int B)
    {
        if (B <= A) return 0;

        int[] decA = decimals(A);
        int[] decB = decimals(B);

        if (decA.length < decB.length)
        {
            int border = (int) Math.pow(10, decA.length) - 1;
            return solve(A, border) + solve(border+1, B);
        }

        int total = 0;
        for (int Curr = A; Curr < B; Curr++)
        {
            int[] dec = decimals(Curr);

            //int[] variants = new int[dec.length];
            ArrayList<Integer> variants = new ArrayList<Integer>();
            int first = dec[0];
            for (int i=1; i<dec.length; i++)
            {
                if (dec[i] >= first)
                {
                    int candidate = toNumber(dec, i);
                    if (candidate > Curr &&
                        candidate <= B)
                    {
                        if (!variants.contains(candidate))
                        {
                            variants.add(candidate);
                            total++;
                        }
                    }
                }
            }
        }
        return total;
    }
}
