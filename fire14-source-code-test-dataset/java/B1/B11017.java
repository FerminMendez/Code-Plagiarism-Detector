
import java.io.File;

public class RecycledNumbers {
    
    public static void main(String[] args)
    {
        try
        {
            FileReader fr = new FileReader(new File(args[0]));
            PrintResult pr = new PrintResult(args[1]);
            process(fr, pr);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    public static void process(FileReader fr, PrintResult pr)
    {
        int numCases;
        int[] in;
        try
        {
            numCases = fr.nextInt();
            for (int i = 0; i < numCases; i++)
            {
                in = fr.nextIntArray();
                pr.printLine(i, solve(in[0],in[1]));
            }
            pr.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static String solve(int a, int b)
    {
        int count = 0;
        char[] achar = Integer.toString(a).toCharArray();
        int m = 0;
        if(achar.length > 1)
        {
            for(int n = a; n < b+1; n++)
            {
                for(int j = 1; j < Integer.toString(n).length(); j++)
                {
                    m = rearrange(n,j);
                    if(m > n && m < b + 1)
                    {
                        int mlength = Integer.toString(m).toCharArray().length;
                        int nlength = Integer.toString(n).toCharArray().length;
                        if(mlength == nlength)
                        {
                            count++;
                        }
                        if(b == 2222)
                        {
                            System.out.println(n + " " + m + " " + j);
                        }
                    }
                }
            }
        }
        return Integer.toString(count);
    }
    
    public static int rearrange(int in, int amount)
    {
        char[] temp = Integer.toString(in).toCharArray();
        char[] result = new char[temp.length];
        for(int i = 0; i < temp.length; i++)
        {
            result[i] = temp[(temp.length-amount+i)%temp.length];
        }
        return Integer.parseInt(new String(result));
    }
}
