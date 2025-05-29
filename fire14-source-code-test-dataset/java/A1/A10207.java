import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Dance {

	/**
	 * @param args
	 */
	
	static int test(int n, int p, int surp, int [] ds){
		int res=0;
		int mean,mod;
		
		if (p==0) return n;
		for(int i=0; i<n; i++){
			if (ds[i] == 0) continue;
			mean = ds[i]/3;
			mod = ds[i]%3;
			if (mean >= p
				|| (mean + 1 >= p && mod >= 1)) {res ++; continue;}
		    if (((mod==2 && mean +2 >= p) || (mean+1>=p))&& surp > 0) {res ++; surp --; continue;}
		}
		return res;
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nbtests;
		try {
			nbtests = new Integer(br.readLine());
			for (int i=0; i<nbtests; i++){
				String s = br.readLine();
				String []tmp = s.split(" ",4);
				int n = new Integer(tmp[0]);
				int surp = new Integer(tmp[1]);
				int p = new Integer(tmp[2]);
				String[] dss = tmp[3].split(" ",n);
				int []ds = new int[n];
				for (int j=0; j<n; j++) ds[j]=new Integer(dss[j]);
				
				System.out.println("Case #"+(i+1)+": " + test(n,p,surp,ds));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
