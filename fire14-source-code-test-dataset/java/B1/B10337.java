
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author megaterik
 */
public class C {

    public static void main(String[] args) throws FileNotFoundException {
        new C().solve();
    }
    
    int[] lastAchivement;
    int calculate(int x, int a, int b)
    {
        String s = Integer.toString(x);
        int res = 0;
        for (int i = 0; i < s.length(); i++)
        {
            int val = Integer.parseInt(s.substring(i).concat(s.substring(0, i)));
            if (val >= a && val <= b && !s.substring(i).concat(s.substring(0, i)).startsWith("0") && val > x && lastAchivement[val] != x)
            {
                res++;
                lastAchivement[val] = x;
              //  out.println(x + " and " + val);
            }
        }
        return res;
    }
    
    PrintWriter out;

    void solve() throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("src/input.txt"));
        out = new PrintWriter(new FileOutputStream("src/output.txt"));;
        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int a = in.nextInt();
            int b = in.nextInt();
            lastAchivement = new int[b + 1];
            int res = 0;
            for (int i = a; i <= b; i++)
                res += calculate(i, a, b);
            out.println("Case #" + t + ": " + res);
        }
        in.close();
        out.close();
    }
}
