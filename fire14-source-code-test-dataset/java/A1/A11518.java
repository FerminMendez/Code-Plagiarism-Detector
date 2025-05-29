import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;

public class MainB {

	final static String FNAME = "B-small-attempt0";

	public BufferedReader in;

	public PrintWriter out;

	void open() throws IOException {
		in = new BufferedReader( new FileReader( new File( FNAME+".in"  ) ) );
		out = new PrintWriter( new File( FNAME + ".out" ) );
	}

	void close() throws IOException {
		out.close();
	}

	private boolean isBetterThanP(int num,int P)
	{
		int diff=num-P;
		int num1=diff/2;
		int num2=diff-num1;
		if(num1+1<P)return false;
		if(num1==num2||(num1+1==num2)) return true;
		return false;
	}
	private boolean isBetterThanPCaseSupersing(int num,int P)
	{
		int diff=num-P;
		if(diff<0) return false;
		int diff1=diff-P+2;
		if(diff1+2>=P) return true;
		return false;
	}
	
	void run() throws IOException {
		
		Integer T=Integer.parseInt(in.readLine()) ;
		for(int i=1;i<=T;i++)
		{
			StringBuffer res=new StringBuffer();
			res.append("Case #" + i + ": ");
			
			String line=in.readLine();
			String nums[]=line.split(" ");
			int N=Integer.parseInt(nums[0]);
			int S=Integer.parseInt(nums[1]);
			int P=Integer.parseInt(nums[2]);
			int c=0;
			int[] arr=new int[N];
			for(int k=0;k<N;k++)
			{
				arr[k]=Integer.parseInt(nums[3+k]);
				if(isBetterThanP(arr[k],P))
				{
					c++;
				}
				else if(S>0&&isBetterThanPCaseSupersing(arr[k],P))
				{
					S--;
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
					MainB solution = new MainB();
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
