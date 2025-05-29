import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class G2012B {

	public static void main(String[] args) throws IOException {
		G2012B trans = new G2012B();
		trans.doMe();
	}

	private static final String ID = "practice";
	private static final String SIZE = "small";
	private static final String CODE = "A";

	private static final String NAME = CODE + "-" + SIZE + "-" + ID;

	public void doMe() throws IOException {
		//File file = new Fil("test.txt");
		File file = new File("B-small-attempt0.in");
		BufferedWriter out = new BufferedWriter(new FileWriter("output.out"));
		try {
			//use buffering, reading one line at a time
			//FileReader always assumes default encoding is OK!
			BufferedReader input = new BufferedReader(new FileReader(file));
			try {
				String line = input.readLine();
				int count = Integer.parseInt(line);

				for (int i = 0; i < count; i++) {
					line = input.readLine();
					//System.out.println(line);
					int str = this.proccessLine(line.trim());
					out.write("Case #" + (i + 1) + ": " + str);
					if (i < count - 1)
						out.write(System.getProperty("line.separator"));
					System.out.println(str);
				}
			} finally {
				input.close();
				out.flush();
				out.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	int proccessLine(String line) {
		String st[] = line.split(" ");
		int n = Integer.parseInt(st[0]);
		int s = Integer.parseInt(st[1]);
		int p = Integer.parseInt(st[2]);
		int sol = 0;
		for (int i = 3	; i < st.length; i++) {
			int u = calc(Integer.parseInt(st[i]), p);
			if (u==1) sol++;
			if (u==2 && s>0) {
				sol++;
				s--;
			}
		}
		return sol;
	}
	
	public int calc(int n, int t) {
		if(n==0) {
			if (t==0) return 1;
			else return 0;
		}
		if(n==1) {
			if (t<=1) return 1;
			else return 0;
		}
		if (n==2) {
			if (t==2) return 2;
			if (t<=1) return 1;
			return 0;
		}
		
		if (t<=1) return 1;
		n -= t;
		if ((t-1)*2<=n) {
			return 1;
		} 
		if ((t-2)*2<=n) {
			return 2;
		}
		return 0;
	}
}
