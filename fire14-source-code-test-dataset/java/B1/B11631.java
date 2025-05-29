import static java.lang.System.*;
import static java.lang.Math.*;
import static java.lang.Character.*;
import java.io.*;
import java.util.*;
public class recycled
{
    public static Scanner in;
    public static String nl(){return in.nextLine();}
    public static int ni(){return in.nextInt();}
    public static double nd(){return in.nextDouble();}
    public static int pi(String a){return Integer.parseInt(a);}
    public static double pd(String a){return Double.parseDouble(a);}
    public static void pl(Object o) { out.println(o); }
    public static void pl() { out.println(); }
    public static void pt(Object o) { out.print(o); }
    public static void plf(String f, Object... o) { out.printf(f, o); out.println(); }
    public static String nt(){return in.next();}
    public static void main(String[]args) throws IOException
    {
    	in=new Scanner(new File("recycled.dat"));
        in=new Scanner(new File("C-small-attempt2.in"));
    //    in=new Scanner(System.in);
	    int count  = ni();
	    for (int da = 1; da <= count; da++)
	    {
	    	int s = ni(), e = ni();
	    	//pl (s + ", " + e);
	        TreeSet<String> gused = new TreeSet<String>();
	        for (int xx = s; xx < e; xx++)
	        {
	        	String n = "" + xx;


        		ArrayList<Character> alt = new ArrayList<Character>();
        		for (char c : n.toCharArray())
        			alt.add(c);
	        	for (int i = 0; i < n.length(); i++)
	        	{
	        		Collections.rotate(alt, 1);

	        		String t = "";
	        		for (Character c : alt)
	        			t += "" + c;
	        		//pl(t);
	        		//pl(n);
	        		if (!gused.contains(t+"|"+n) && pi(n) >= s && pi(t) <= e && pi(n) < pi(t))
	        		{
	        			gused.add(t+"|"+n);

	        		}
	        	}

	        }
	        pl("Case #" + da + ": " + gused.size());
	    }
    }
}