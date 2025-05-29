import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Recycled {
	
	private static boolean contains(List<Integer> results, int result){
		for(int i = 0; i < results.size(); i++){
			if(results.get(i) == result){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("A-small-practice.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("A-small-practice.out")));
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    
	    int tests = Integer.parseInt(st.nextToken());
	    
	    for (int t = 1; t <= tests; t++){
	    	out.printf("Case #%d:", t);
	    	st = new StringTokenizer(f.readLine());
	    	int count = 0;
	    	String a = st.nextToken();
	    	String b = st.nextToken();
	    	
	    	for(int i = Integer.parseInt(a); i < Integer.parseInt(b); i++){	
	    		String m = Integer.toString(i);
	    		for(int j = 1; j < m.length(); j++){
	    			int n = 0;
	    			List<Integer> results = new ArrayList<Integer>();
	    			if(m.length() - j - 1 > 0){ 
	    				n = Integer.parseInt(m.substring(m.length() - j) + m.substring(0, m.length() - j));
	    			} else {
	    				n = Integer.parseInt(m.substring(m.length() - j) + m.charAt(0));
	    			}
	    			
		    		if (n > Integer.parseInt(m) && Integer.parseInt(b) >= n && !contains(results, n)){
		    			results.add(n);
		    			count++;
		    		}
	    		}
	    	}
	    	
	    	out.printf(" %d\n", count);
	    }
	   
	    out.close();
	    System.exit(0);
	}
}
