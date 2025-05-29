import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MainC {

	final static String FNAME = "C-small-attempt0";

	public BufferedReader in;

	public PrintWriter out;

	void open() throws IOException {
		in = new BufferedReader( new FileReader( new File( FNAME+".in"  ) ) );
		out = new PrintWriter( new File( FNAME + ".out" ) );
	}

	void close() throws IOException {
		out.close();
	}
	
	private Boolean isRecycled(int a,int b)
	{
		String A=String.valueOf(a);
		String B=String.valueOf(b);
		
		
		if(A.length()!=B.length()) return false;
		for(int i=0;i<A.length();i++)
		{
			StringBuilder Anew=new StringBuilder();
			Anew.append(A.substring(i, A.length()));
			Anew.append(A.substring(0, i));
			if(B.contains(Anew.toString())) return true;
		}
		
		return false;
	}
	

	void run() throws IOException {
		
		Integer N=Integer.parseInt(in.readLine()) ;
		
		for(int i=1;i<=N;i++)
		{
			StringBuffer res=new StringBuffer();
			res.append("Case #" + i + ": ");
			String line=in.readLine();
			String nubers[]=line.split(" ");
		    int a=Integer.parseInt(nubers[0]);
		    int b=Integer.parseInt(nubers[1]);
			int c=0;
		    
			for(int j=a;j<=b;j++)
				for(int k=j+1;k<=b;k++)
			{
			
				if(isRecycled(j,k))
				{
					c++;
				}
				
			}
			res.append(c);
			out.println(res.toString());
		}
	}

	public static void main( String[] args ) throws IOException {
		new Thread() {

			public void run() {
				try {
					MainC solution = new MainC();
					solution.open();
					solution.run();
					solution.close();
				} catch ( Exception e ) {
					throw new RuntimeException( e );
				}
			}
		}.start();
	}
}
