import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;


public class Recycled {

	
	public static void main(String args[]) {
		try {
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("c:\\gcj\\C\\C-small-attempt0.in")));
		String line=br.readLine();
		PrintStream ps=new PrintStream("c:\\gcj\\C\\C-Small.out");
		
		int n=Integer.parseInt(line);
			for(int i=1;i<=n;i++) {
				
				line=br.readLine();
				String[] nums=line.split(" ");
				long A=Long.parseLong(nums[0]);
				long B=Long.parseLong(nums[1]);
				ps.println("Case #"+i+": "+getCount(A,B));
										
			}
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
