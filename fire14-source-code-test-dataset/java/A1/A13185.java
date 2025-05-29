import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

public class Main2 {

	public static final String fileName = "A-small-attempt0.in";

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		PrintWriter pw = new PrintWriter(new File("out.txt"));
		int num = Integer.valueOf(br.readLine());
		for (int i = 0; i < num; i++) {
			String inline = br.readLine();
			int result = 0;
			String[] tmp = inline.split(" ");
			int[] params = new int[tmp.length];
			for (int j = 0; j < tmp.length; j++) {
				params[j] = Integer.valueOf(tmp[j]);
			}
			
			int n = params[0];
			int s = params[1];
			int p = params[2];
			int slot = 0;
			
			for(int j = 3; j < n + 3; j++){
				if(params[j] < p || params[j] < (3*p - 4)) continue;
				if(params[j] >= (3*p - 2)){
					result ++;
					continue;
				}
				else if(slot < s){
					slot ++;
					result ++;
				}
			}

			pw.println("Case #" + (i + 1) + ": " + result);
		}
		pw.close();
	}

}
