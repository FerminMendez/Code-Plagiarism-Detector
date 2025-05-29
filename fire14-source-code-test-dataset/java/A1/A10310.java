import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class CodeJam2
{

    private class Data
    {
        private int num;
        private int surprise;
        private int threshold;
        private Integer[] values;

        public Data(int num, int surprise, int threshold, Integer[] values)
        {
            this.num = num;
            this.surprise = surprise;
            this.threshold = threshold;
            this.values = values;
        }

        public int getNum()
        {
            return num;
        }

        public int getSurprise()
        {
            return surprise;
        }

        public int getThreshold()
        {
            return threshold;
        }

        public Integer[] getValues()
        {
            return values;
        }

        public String toString()
        {
            return num + " " + surprise + " " + threshold + " " + values.length;
        }
    }

    private List<Data> getInputValue()
    {
        List<Data> inpVal = new ArrayList<Data>();

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            final String tc_ = stdin.readLine();
            Integer testCase = Integer.parseInt(tc_);

            while (testCase-- > 0)
            {
                // System.err.println("tc#" + testCase);
                final String[] input = stdin.readLine().split(" ");
                int num = Integer.parseInt(input[0]);
                Integer[] values = new Integer[num];

                for (int i = 3; i < input.length; ++i)
                    values[i - 3] = Integer.parseInt(input[i]);

                Data data = new Data(num, Integer.parseInt(input[1]), Integer.parseInt(input[2]), values);

                inpVal.add(data);

            }

            return inpVal;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    private static int getMaxWOSurprise(int a)
    {
        if (a % 3 == 0)
            return a / 3;
        else
            return (a / 3) + 1;
    }

    private static int getMaxWithSurprise(int a)
    {
        if (a == 0)
            return -1;
        else if ((a % 3) == 0)
            return (a / 3) + 1;
        else if (a % 3 == 1)
            return -1;
        else
            return (a / 3) + 2;
    }

    private static Integer[] sort(Integer[] arr)
    {
        for (int i = 0; i < arr.length - 1; ++i)
            for (int j = i + 1; j < arr.length; ++j)
                if (arr[i] < arr[j])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
        return arr;
    }

    public static void main(String[] args)
    {
        CodeJam2 cj = new CodeJam2();
        List<Data> inp = cj.getInputValue();
        // System.err.println(inp);

        // System.err.println(getMaxWithSurprise(15));

        int count = 1;

        // operating for each tc
        for (Data data : inp)
        {
            int surprise = data.getSurprise();
            int threshold = data.getThreshold();
            int answer = 0;

            Integer[] scores = sort(data.getValues());

            for (Integer score : scores)
            {
                // System.err.println(score + " " + getMaxWithSurprise(score) +
                // " " + getMaxWOSurprise(score));

                if (getMaxWOSurprise(score) >= threshold)
                    answer++;
                else if (surprise > 0 && getMaxWithSurprise(score) >= threshold)
                {
                    answer++;
                    surprise--;
                }
            }

            System.out.println("Case #" + count++ + ": " + answer);
        }

        // System.err.println(cj.generateCombination(24, 40));
    }
}
