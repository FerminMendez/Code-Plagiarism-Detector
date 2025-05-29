import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Dancing {
	private static int[] data;
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("A-small-practice.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("A-small-practice.out")));
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    
	    int tests = Integer.parseInt(st.nextToken());
	    
	    for (int t = 1; t <= tests; t++){
	    	out.printf("Case #%d:", t);
	    	st = new StringTokenizer(f.readLine());
		    int n = Integer.parseInt(st.nextToken());
		    int s = Integer.parseInt(st.nextToken());
		    int p = Integer.parseInt(st.nextToken());
		    data = new int[n];
		    for (int i = 0; i < n; i++){
		    	data[i] = Integer.parseInt(st.nextToken());
		    }
		    
		    out.printf(" %d\n", fun1(n, s, p));
	    }
	   
	    out.close();
	    System.exit(0);
	}
	
	private static int fun1(int n, int s, int p){
		int count = 0;
		int s_ = s;
		for (int i = 0; i < n; i++){
			int avg = data[i] / 3;
			
			if (data[i] % 3 == 0){				
				if(avg >= p) {
					count ++;
				} else{
					if((s_ > 0) && (avg + 1 >= p) && (avg - 1 >=0)){
						count ++;
						s_--;
					}
				}	
			} else if(data[i] % 3 == 1){
				if(avg + 1 >= p){
					count++;
				} 
			} else if(data[i] % 3 == 2){
				if(avg + 1 >= p){
					count ++;
				} else if((s_ > 0) && (avg + 2 >= p)){
					count++;
					s_--;
				}
			}
		}
		return count;
	}
}
