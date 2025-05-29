import java.util.*;
import java.io.*;
public class SOURCE041312_CJ_Qual_DancingWithGooglers {

    public static void main(String sargs[])throws IOException
    {
    	System.setOut(new PrintStream(new File("OUTPUT041312_CJ_Qual_DancingWithGooglers.dat")));
    	Scanner oScan=new Scanner(new File("C-small-attempt0.in"));
    	int T=Integer.parseInt(oScan.nextLine().trim());
    	int Case=0;
    	while(T-->0)
    	{
    		Set<String> l=new HashSet<String>();


    		int A=oScan.nextInt();int B=oScan.nextInt();
    		for(int i=A;i<=B;++i)
    		{

    			String n=i+"";
    			for(int ind=1;ind<n.length();++ind)
    			{
    				String m=n.substring(ind)+n.substring(0,ind);
    				if(Integer.parseInt(m)<=B&&Integer.parseInt(m)>Integer.parseInt(n))
    					l.add(""+n+" "+m);
    			}
    		}
    		System.out.println("Case #"+ ++Case+": "+l.size());
    	}
    }


}