import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;



public class B implements Runnable{
	BufferedReader in;
	BufferedWriter out;
	static String inputFile="";
	static String outputFile="";
	static {
		inputFile=B.class.getName()+".in";
		outputFile=B.class.getName()+".out";
		}
	public int iread() throws Exception {
		return Integer.parseInt(readword());
	}
	public long lread() throws Exception {
		return Long.parseLong(readword());
	}
	public double dread() throws Exception {
		return Double.parseDouble(readword());
	}
	public String readword() throws Exception {
		int k = in.read();
		if(k < 0) return "";
		while(k>=0 && k<=' ') k=in.read();
		StringBuilder bld = new StringBuilder();
		while(k>' ') {
			bld.append((char)k);
			k=in.read();
			}
		return bld.toString();
	}

	public void solve() throws Exception {
		int T = iread();
		for(int t=1; t<=T; t++) {
			int N = iread();
			int S = iread();
			int P = iread();
			int[] score = new int[N];
			int result = 0;
			for(int n=0; n<N; n++) {
				score[n]=iread();
				if(P > 1){
					if(score[n]<3*P-4) continue;
					else if(score[n]==3*P-3||score[n]==3*P-4){
						if(S > 0) {
						result++;
						S--;						
						}
						else continue;
					}
					else result++;
				}
				else {
					if(P == 1) {
						if(score[n]==0) continue;
						else result++;
					}
					else {
						result++;
					}
				}
			}
			out.write("Case #"+t+": "+result+"\n");
		}		
	}
	
	public void run() {
		try{
			in = new BufferedReader(new FileReader(inputFile));
			out = new BufferedWriter(new FileWriter(outputFile));
			solve();
			out.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Thread(new B()).start();
	}
	
}
