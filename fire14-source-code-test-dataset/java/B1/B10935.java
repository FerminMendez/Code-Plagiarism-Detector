import java.io.*;
import java.util.HashSet;

public class B {
	int a, b;
	
	int countRec(int num){
		char[] digits = String.valueOf(num).toCharArray();
		int n = digits.length;
		char[] rec = new char[n];
		HashSet<Integer> set = new HashSet<Integer>();
		int cnt=0;
		
		for(int i=1; i<n; i++){
			int index = i;
			for(int j=0; j<n; j++, index++){
				if(index>=n) index%=n;				
				rec[j] = digits[index];
			}
			
			int out = Integer.parseInt(String.valueOf(rec));
			if(out > num && out <= b && !set.contains(out)){
				cnt++;
				set.add(out);
			}
		}
		
		return cnt;
	}
	
	public void run() throws IOException{
		BufferedReader bf = new BufferedReader(new FileReader("b.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("b.out"));
		
		int kases = Integer.parseInt(bf.readLine());
		for(int kase=1; kase<=kases; kase++){
			String[] in = bf.readLine().trim().split("[ ]+");
			a = Integer.parseInt(in[0]);
			b = Integer.parseInt(in[1]);
			
			long ret = 0;
			for(int i=a; i<=b; i++) ret+= countRec(i);
			
			pw.println("Case #" + kase + ": " + ret);
		}
		
		pw.close();
	}
	
	public static void main(String[] args) throws IOException {
		new B().run();
	}
}
