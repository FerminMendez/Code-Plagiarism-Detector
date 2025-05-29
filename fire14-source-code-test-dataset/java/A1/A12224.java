import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class DWiGoogler {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("B-small-attempt0.in"));
		BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"));
		int T = Integer.parseInt(in.readLine());
		int cnt = 0;
		while(T > 0){
			 T--;
			 cnt++;
			int result = 0;
			String str1 = in.readLine();
			String[] str2= str1.split(" ");
			int n = Integer.parseInt(str2[0]);
			int s = Integer.parseInt(str2[1]);
			int p = Integer.parseInt(str2[2]);
			int [] x = new int[n];
			for(int i=0; i<n; i++){
				int score = Integer.parseInt(str2[i+3]);
				int min = score / 3;
				int rest = score%3;
				if(min>=p){
					result++;
				}else if(p-min==1 && rest>0){
					result++;
				}else if((s>0 && rest==0 && p-min==1 && min != 0) || (s>0 && rest==2 && p-min==2 && min !=0)){
					result++;
					s--;
				}
			}
			out.write("Case #"+ cnt +": " + result+"\n");
		}
		in.close();
		out.close();
	}

}
