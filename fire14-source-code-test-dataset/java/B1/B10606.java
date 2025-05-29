import java.io.*;
import java.util.*;
public class Prob3
{
    public static void main (String[] args) throws IOException
    {
	BufferedReader in = new BufferedReader (new FileReader ("C-small-attempt0.in"));
	PrintWriter out = new PrintWriter (new FileWriter ("OUT3.txt"));
	int T = Integer.parseInt (in.readLine ().trim ()), c, a, b;
	StringTokenizer st;
	String temp, hold;
	ArrayList p;
	for (int x = 0 ; x < T ; x += 1)
	{
	    c = 0;
	    st = new StringTokenizer (in.readLine ());
	    a = Integer.parseInt (st.nextToken ());
	    b = Integer.parseInt (st.nextToken ());

	    for (int y = a ; y < b ; y += 1)
	    {
		if (y > 10)
		{
		    temp = Integer.toString (y);
		    p = new ArrayList ();
		    for (int z = 0 ; z < temp.length () - 1 ; z += 1)
		    {
			hold = temp.substring (z + 1) + temp.substring (0, z + 1);
			if (hold.charAt (0) != '0' && Integer.parseInt (hold) > Integer.parseInt (temp) && Integer.parseInt (hold) <= b && p.contains (hold) == false)
			{
			    c += 1;
			    p.add (hold);
			}
		    }
		}
	    }
	    out.println ("Case #" + (x + 1) + ": " + c);
	}
	out.close ();
    }
}


