import static java.lang.System.*;import static java.lang.Math.*;import static java.lang.Character.*;import java.io.*;import java.text.*;import java.util.*;import java.util.regex.*;
public class Recycled
{
    public static Scanner in;
    public static PrintWriter out;

    public static String nl(){return in.nextLine();}
    public static int ni(){return in.nextInt();}
    public static double nd(){return in.nextDouble();}
    public static int pi(String a){return Integer.parseInt(a);}
    public static double pd(String a){return Double.parseDouble(a);}
    public static void pl(Object o) { out.println(o); }
    public static void plf(String f, Object... o) { out.printf(f, o); out.println(); }
    public static String nt(){return in.next();}
	public static void pt(Object o) {out.print(o);}

    public static void main(String[]args) throws IOException
    {
        in=new Scanner(new File("C-small-attempt0.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("C-small-attempt0.out")));
    //    in=new Scanner(System.in);
        int xxxxxx=pi(nt());nl();
        for (int xxxxx=1;xxxxx<=xxxxxx;xxxxx++)
        {
        	pt("Case #"+xxxxx+": ");
        	int min = ni();
        	int max = ni();
        	int count = 0;
        	for(int i=min;i<=max;i++){
        		for(int j=max;j>i;j--){
        			String si = Integer.toString(i);
        			String sj = Integer.toString(j);
        			if(si.length()!=sj.length())
        				continue;
        			if(recycled(si,sj)) count++;
        		}
        	}
        	pl(count);

        }

        out.close();
		System.exit(0);
    }

    static boolean recycled(String a, String b){
    	for(int x=0;x<a.length();x++){
        	b = b.substring(1)+b.charAt(0);
        	if(a.equals(b)) return true;
        }
        return false;
    }
}