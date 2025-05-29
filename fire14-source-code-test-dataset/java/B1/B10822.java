import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class Fattom2012C {
	private final String _PROBLEM_NO = "201201C";
	private final String _FILE_DIRECTORY = "K:/Dropbox/workspace/codejam/" + _PROBLEM_NO + "/";
	private final String _FILE_PATH = _FILE_DIRECTORY + "C-small-attempt4";
	
	public static void main(String[] args) throws IOException {
		Locale.setDefault(Locale.US);
		new Fattom2012C().execute();
	}

	public void execute() {
		BufferedReader br = null;
		PrintWriter pw = null;

		try {
			br = new BufferedReader(new FileReader(_FILE_PATH + ".in"));
			pw = new PrintWriter(_FILE_PATH + ".out");
			 
			//main
			int caseno = Integer.parseInt(br.readLine());
			Map<Integer,List> m = new HashMap<Integer,List>();
			
			for(int i=10;i<=1000000;i++) {
				check(i,m);	
			}
//			System.out.println(m.get(2));
			for (int count = 1; count <= caseno; count++) {
//				if(count>4)break;
				pw.print("Case #" + count + ": ");
				System.out.print("Case #" + count + ": ");
				
				String line = br.readLine();
				
				String[] splits = line.split(" ");
				int A = Integer.parseInt(splits[0]); 
				int B = Integer.parseInt(splits[1]); 
					 
				int r = 0;
				
				if(A < 10 || A >= 1000000 || A==B) {
					pw.print("0");
					System.out.print("0"); 
				}
				else {
					List<Integer> tt = m.get((""+A).length());
					for(int t:tt) {

//						if(t >= A && t <= B) {
							r += check(A,B,t);
//						}
					}
					pw.print(r);
					System.out.print(r);
				}
				
				pw.print("\n");
				System.out.print("\n");
			}
			
			//end
	
	
			br.close();
			pw.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pw != null) pw.close();
			} catch(Exception e) {}
			try {
				if(br != null) br.close();
			} catch(Exception e) {}
		}
	}

	private int check(int a, int b, int t) {
		String tt = ""+t;
//		System.out.println(tt);
		int r =0;
		Set<Integer> rr = new HashSet<Integer>();  
		for(int i=0;i<tt.length();i++) {
			if(i!=0) {
				tt = tt.substring(1) + tt.charAt(0);
				if(tt.startsWith("0")) continue;

				t = Integer.parseInt(tt);
				
				
			}
			if(t>=a&&t<=b) {
//				System.out.print(tt + "!");
				rr.add(t);
				
			}
		}
		r=rr.size();
//		System.out.println(r);
		if(r==1) return 0;
		
		
		
		if(r!=0) r = (r*(r-1))/2;
		
		return r;
	}

	private void check(int i, Map<Integer, List> m) {
 
		String in = "" + i;
		int b = in.length(); 
		
		if(!dedup(i)) return;
		
		dedup.put(i, true);
		
		List target = m.get(b);
		if(target == null) {
			target = new ArrayList<Integer>();
			m.put(b, target);
		}
		target.add(i);
	}
	 
	public static Map<Integer,Boolean> dedup = new HashMap<Integer,Boolean>();
 

	private boolean dedup(int t) {
		String tt = ""+t;


		for(int i=0;i<tt.length();i++) {
			if(i!=0) {
				tt = tt.substring(1) + tt.charAt(0);
				if(tt.startsWith("0")) continue;
				 
				t = Integer.parseInt(tt);
				 
			}
			 
			if(dedup.get(t) != null)
				return false;
		}
 
		return true;
	}
	
}
