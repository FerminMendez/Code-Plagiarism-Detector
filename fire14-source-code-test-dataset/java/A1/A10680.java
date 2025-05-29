import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class DancingWithGooglers {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
	//	BufferedInputStream in = new BufferedInputStream(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new FileReader("B-small-attempt0.in"));
		BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));
		int t = Integer.parseInt(in.readLine());
		int cnt = 0;
		while(t>0){
			t--; cnt++;
			int ans = 0;
			String s1 = in.readLine();
			String[] ss = s1.split(" ");
			int n = Integer.parseInt(ss[0]);
			int s = Integer.parseInt(ss[1]);
			int p = Integer.parseInt(ss[2]);
			int [] x = new int[n];
			for(int i=0; i<n; i++){
				int score = Integer.parseInt(ss[i+3]);
				int min = score / 3;
				int extra = score%3;
				if(min>=p){
					ans++;
					continue;
				}else if(p-min==1 && extra>0){
					ans++;
					continue;
				}else if((s>0 && extra==0 && p-min==1 && min != 0) || (s>0 && extra==2 && p-min==2 && min !=0)){
					ans++;
					s--;
					continue;
				}
			}
			out.write("Case #"+ cnt +": " + ans+"\n");
		}
		in.close();
		out.close();
	}

}
