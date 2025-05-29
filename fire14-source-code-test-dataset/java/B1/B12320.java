import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;


public class C {

	PrintWriter out;

	public void read() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.in"));
		out = new PrintWriter(new FileWriter("output.in"));
		int n = Integer.parseInt(br.readLine());
		int i = 0;
		String line;
		while (i < n) {
			line = br.readLine();
			solve(i + 1, line);

			i++;
		}

		out.close();
		out.flush();
	}

	private void solve(int c, String line) {
		
		int max = 0;
		Set numbers = new HashSet();
		out.print("Case #" + c + ": ");
		String[] tokens = line.split(" ");
		Integer A = Integer.parseInt(tokens[0]);
		Integer B = Integer.parseInt(tokens[1]);
		
		for (Integer i=A; i<=B; i++){
			int length = i.toString().length();
			for (int j=length -1 ; j>0; j--){
				Integer x = Integer.parseInt(C.recycledNumber(i.toString(),j));
				if ((A <= i) && (i < x) && (x <= B)){
					numbers.add(Integer.parseInt(i.toString().concat(x.toString())));
				}
			}	
		}
		max = numbers.size();
		out.print(max);
		out.println();
	}
	
	public static void main(String[] args) throws IOException {
		new C().read();
	}
	
	public static String recycledNumber(String a, int index) {
		
		int length = a.length();
		StringBuilder recycledNumber = new StringBuilder();
		for (int i=index ; i<length; i++){
			recycledNumber.append(a.charAt(i));
		}
		for (int j=0 ; j<index; j++){
			recycledNumber.append(a.charAt(j));
		}
		
		return recycledNumber.toString();
	}
}
