package codejam2012Qualification;
import java.io.*;
import java.util.*;
public class B {
	public static void main(String[] args)throws IOException {
		boolean large = false;
		//large = true;
		String dir = "C://Users//Aayush//Desktop//";
		String InputFile = dir + (large ? "B-large.in" : "B-small-attempt0.in");
		String OutputFile = dir + (large ? "B-large.out" : "B-small.out");
		File file = new File(InputFile);
		Scanner st = new Scanner(file);
		FileWriter fw = new FileWriter(OutputFile);
		int T = st.nextInt();
		for(int cases = 1; cases <= T; cases++){
			int N = st.nextInt();
			int S = st.nextInt();
			int p = st.nextInt();
			int[] t = new int[N];
			for(int i = 0; i < N; i++){
				t[i] = st.nextInt();
			}
			int count = 0;
			for(int i = 0; i < N; i++){
				//a, b and are the scores allotted to googler a <= b <= c
				int a = t[i] / 3;
				int b = t[i] / 3;
				int c = t[i] / 3;
				if(t[i] % 3 == 0){
					if(c >= p)count++;
					else if(b > 0 && c == p - 1 && S > 0){
						S--;
						count++;
					}
				}else if(t[i] % 3 == 1){
					c += 1;
					if(c >= p)count++;
				}else if(t[i] % 3 == 2){
					c += 1;
					b += 1;
					if(c >= p)count++;
					else if(b > 0 && c == p - 1 && S > 0){
						S--;
						count++;
					}
				}
			}
			System.out.print("Case #" + cases + ": " + count);
			fw.write("Case #" + cases + ": " + count);

			System.out.println();
			fw.write("\n");

		}
		fw.flush();
		fw.close();

	}
}
