import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class CodeJam
{

    private Set<Integer> generateCombination(Integer i, Integer max)
    {
        final Set<Integer> output = new HashSet<Integer>();
        final Integer len = String.valueOf(i).length();

        Integer num = i;
        double pow = Math.pow(10, len - 1);

        for (int j = 0; j < len - 1; ++j)
        {
            num = (int) ((num % pow) * 10 + (num / pow));
            if (num > i && num <= max)
                output.add(num);
        }

        return output;
    }

    private List<HashMap<Integer, Integer>> getInputValue()
    {
        List<HashMap<Integer, Integer>> inpVal = new ArrayList<HashMap<Integer, Integer>>();

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            final String tc_ = stdin.readLine();
            Integer testCase = Integer.parseInt(tc_);

            while (testCase-- > 0)
            {
                // System.err.println("tc#" + testCase);
                final String[] input = stdin.readLine().split(" ");
                final int min = Integer.parseInt(input[0]);
                final int max = Integer.parseInt(input[1]);

                inpVal.add(new HashMap<Integer, Integer>() {
                    {
                        put(min, max);
                    }
                });
            }

            return inpVal;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args)
    {
        CodeJam cj = new CodeJam();
        List<HashMap<Integer, Integer>> inp = cj.getInputValue();
        int count = 1;

        for (HashMap<Integer, Integer> tc : inp)
        {

            // operating for tc
            int min = 0, max = 0;
            int answer = 0;
            for (Entry<Integer, Integer> e : tc.entrySet())
            {
                min = e.getKey();
                max = e.getValue();
            }
            for (int i = min; i <= max; ++i)
            {
                answer += cj.generateCombination(i, max).size();
            }
            System.out.println("Case #" + count++ + ": " + answer);

        }

        // System.err.println(cj.generateCombination(24, 40));
    }
}
