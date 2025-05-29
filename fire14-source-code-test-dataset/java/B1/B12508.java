import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class RecycledNumbers {
	
	public static File input;
	public static FileReader inputReader;
	public static BufferedReader in;
	
	public static File output;
	public static FileWriter outputWriter;
	public static BufferedWriter out;
	
	private static void init(String problemName) throws IOException {
		input = new File(problemName+".in");
		inputReader = new FileReader(input);
		in = new BufferedReader(inputReader);
		
		output = new File(problemName+".out");
		outputWriter = new FileWriter(output);
		out = new BufferedWriter(outputWriter);
	}
	
	public static int INT() throws IOException {
		return Integer.parseInt(in.readLine());
	}
	
	public static String LINE() throws IOException {
		return in.readLine();
	}
	
	public static void main(String[] args) throws IOException {
		init("recycled-numbers");
		
		int cases = INT();
		for(int i = 1; i <= cases; i++) {
			String[] bounds = LINE().split("\\s");
			int A = Integer.parseInt(bounds[0]);
			int B = Integer.parseInt(bounds[1]);
			
			Set<String> pairs = new HashSet<String>();
			
			for(int x = A; x<=B; x++) {
				String n = String.valueOf(x);
				int digits = n.length();
				if(digits > 1) {
					for(int p = 1; p < digits; p++) {
						String m = n.substring(n.length()-p)+n.substring(0,n.length()-p);
						int mN = Integer.parseInt(m);
						if(m.startsWith("0") || !(mN >= A && mN <=B)){
							continue;
						} else {
							if(x < mN){
								pairs.add("("+n+","+m+")");
							}
						}
					}
				}
			}
			
			System.out.println("Case #"+i+": "+pairs.size());
			out.write("Case #"+i+": "+pairs.size());
			out.newLine();
		}
		
		out.flush();
		out.close();
		in.close();
	}
}
