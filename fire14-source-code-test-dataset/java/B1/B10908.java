
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Main
{

    static int p[] =
    {
        1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000
    };

    static int length(int n)
    {
        int ans = 0;
        while (n > 0)
        {
            ++ans;
            n /= 10;
        }
        return ans;
    }

    static int rotate(int n, int len)
    {
        int d = n % 10;
        n /= 10;
        n = p[len - 1] * d + n;
        return n;
    }

    static void redirect() throws FileNotFoundException
    {
        System.setIn(new FileInputStream("c.in"));
        System.setOut(new PrintStream("c.out"));
    }

    public static void main(String[] args) throws FileNotFoundException
    {

        redirect();

        Scanner in = new Scanner(System.in);
        int tc;
        tc = in.nextInt();
        for (int t = 1; t <= tc; t++)
        {
            int a, b, n, x, y;
            a = in.nextInt();
            b = in.nextInt();
            Set<Pair> s = new TreeSet<Pair>();

            int ans ;
            int len = length(a);
            for (int i = a; i <= b; i++)
            {
                n = i;
                if (i == p[len])
                    len++;

                while (true)
                {
                    n = rotate(n, len);
                    if (n == i)
                        break;
                    if (a <= n && n <= b)
                    {
                        x = i;
                        y = n;
                        if (x > y)
                        {
                            int tmp = x;
                            x = y;
                            y = tmp;
                        }


                        s.add(new Pair(x, y));
                    }
                }
            }

            ans = s.size();

            System.out.printf("Case #%d: %d\n", t, ans);
        }
    }
}

class Pair implements Comparable<Pair>
{
    int x,y;

    public Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p)
    {
        if (x != p.x) return x - p.x;
        else return y - p.y;
    }


}
