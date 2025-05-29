import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class C implements Runnable{

	BufferedReader in;
	BufferedWriter out;
	static String inputFile="";
	static String outputFile="";
	static {
		inputFile=C.class.getName()+".in";
		outputFile=C.class.getName()+".out";
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
			String A_temp = readword();
			int l = A_temp.length();
			int A = Integer.parseInt(A_temp);
			int B = iread();
			int result = 0;
			ArrayList<String> done = new ArrayList<String>(B-A);
			
			for(int i=A; i<B; i++) {
				StringBuilder tp = new StringBuilder(String.valueOf(i));
				int r_count = 0;
				int count = 0;
				if(done.contains(tp.toString())) continue;
				else {done.add(tp.toString()); ++r_count;}
				
				while(++count < l) {
					char c = tp.charAt(l-1);
					tp = tp.delete(l-1,l).insert(0,c);
					String tp2 = tp.toString();
					if((int)Integer.parseInt(tp2)>=A && (int)Integer.parseInt(tp2)<=B && !done.contains(tp2)){
						++r_count;
						done.add(tp2);
					}
				}
				result += r_count*(r_count-1)/2;
				
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
		new Thread(new C()).start();
	}
	
}
