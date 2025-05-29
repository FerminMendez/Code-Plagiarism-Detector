import java.util.*;
import java.io.*;

public class recycle {
	public static String cycle(String n){
		String[] t = new String[n.length()];
		for(int i = 0; i < n.length(); i++){
			t[i] = n.substring(i, i+1);
		}
		
		String q = t[n.length() - 1];
		for(int i = n.length() - 2; i >= 0; i--){
			t[i+1] = t[i];
		}
		t[0] = q;
		
		String res = "";
		for(int i = 0; i < n.length(); i++){
			res += t[i];
		}
		return res;
	}
	public static boolean cycletest(String n, String m){
		boolean con = false;
		for(int i = 0; i < m.length(); i++){
			m = cycle(m);
			if(n.equals(m)){
				con = true;
			} 
		}
		return con;
	}
	public static void main(String[] args) throws IOException{
		Scanner reader = new Scanner(new File("recycle.in"));
		PrintWriter out = new PrintWriter(new File("recycle.out"));
		
		int n = reader.nextInt();
		int[][] set = new int[n][2];
		
		for(int i = 0; i < n; i++){
			set[i][0] = reader.nextInt();
			set[i][1] = reader.nextInt();
		}
		
		int counter = 0;
		int[] res = new int[n];
		for(int i = 0; i < n; i++){
			for(int j = set[i][0]; j <= set[i][1]; j++){
				for(int q = j+1; q <= set[i][1]; q++){
					if(cycletest(Integer.toString(q), Integer.toString(j))){
						counter++;
					}
				}
			}
			res[i] = counter;
			counter = 0;
		}
		
		for(int i = 0; i < n; i++){
			out.println("Case #" + (i+1) + ": " + res[i]);
		}
		
		out.close();
		System.exit(0);
	}
}
