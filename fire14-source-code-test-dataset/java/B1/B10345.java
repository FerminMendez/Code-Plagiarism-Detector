import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;


public class C {

	public final String INPUT_FILE_NAME = "c_in";
	public final String OUTPUT_FILE_NAME = "c_out";
	
	int kase = 1;
	int T = 0;
	int a,b;
	public void run() throws IOException{
		Scanner s = new Scanner(new File(INPUT_FILE_NAME));
		PrintWriter pw = new PrintWriter(new FileWriter(OUTPUT_FILE_NAME));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		T = s.nextInt();
		while (T-- > 0){
			a = s.nextInt();
			b = s.nextInt();
			
			int ans = 0;
			for (int i = a; i <=b ; i++) {
				for (int j = i+1;j <=b ; j++) {
					String s1 = i + "";
					//String s2 = j + "";
					String temp = "";
					for (int k = 1; k < s1.length() ; k++) {
						temp = s1.substring(s1.length() - k) + s1.substring(0,s1.length()-k);
						int r1 = Integer.parseInt(temp); 
						if (r1 == j){
							ans++;
							break;
						}
					}
				}
			}
			
			pw.println("Case #" + kase + ": " + ans);
			kase++;
		}
		
		pw.close();
		s.close();
	}
	
	
	public static void main(String[] args) throws IOException {
		(new C()).run();
	}

}
