import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class C
{
    Scanner in;
    PrintWriter out;
    PrintStream err;
    
    private boolean recycled(int x, int y) {
    	String s1 = Integer.toString(x);
    	String s2 = Integer.toString(y);
    	if (s1.length() != s2.length())
    		return false;
    	for (int i = 0; i < s1.length(); ++i)
    		if (s1.equals(s2.substring(i) + s2.substring(0, i)))
    			return true;
    	return false;
    }
 
    private void run() throws Exception
    {
    	//in  = new Scanner(System.in);
    	//out = new PrintWriter(System.out);
        //in = new Scanner(new FileInputStream(		new File("input")));
        in = new Scanner(new FileInputStream(		new File("C-small-attempt0.in")));
        //in = new Scanner(new FileInputStream(		new File("X-large.in")));
        out = new PrintWriter(new FileOutputStream(	new File("output")));
        err = System.out;

        int testCases = in.nextInt();

        for (int test = 1; test <= testCases; ++test) {
        	int a = in.nextInt();
        	int b = in.nextInt();
        	int result = 0;
        	for (int i = a; i <= b; ++i)
        		for (int j = i+1; j <= b; ++j)
        			if (recycled(i, j))
        				result++;
        	out.println("Case #" + test + ": " + result);
        }
        out.close();
    }

    public static void main(String[] args) throws Exception
    {
        new C().run();
    }
}