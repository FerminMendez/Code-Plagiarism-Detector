/**
 * @(#)Main.java
 *
 *
 * @author 
 * @version 1.00 2012/4/14
 */
import java.io.*;

public class Main {
	
	public static void main(String...args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C-small-attempt0.in"));
        FileWriter fstream = new FileWriter("C-small-attempt0.out");
        BufferedWriter out = new BufferedWriter(fstream);
        String in = br.readLine();
        int testCases = Integer.parseInt(in);
        int i = 1;
        
        while(testCases > 0) {
        	in = br.readLine();
        	out.write("Case #" + i + ": " + solve(in) + "\n");
        	testCases--;
        	i++;
        }
        out.close();
	}
	
	public static int solve(String in) {
		String[] data = in.split(" ");
		int a = Integer.parseInt(data[0]);
		int b = Integer.parseInt(data[1]);
		
		int solution = 0;
		
		for(int i = a; i < b; i++) {
			int tmp = i;
			
			do{
				tmp = shift(tmp);
				while (Math.floor(Math.log10(i)) != Math.floor(Math.log10(tmp))){
					tmp *= 10;
				}
				if(tmp > i && tmp <= b){
					solution++;
				}
			}while(tmp != i);
		}
		return solution;
	}
	
	public static int shift(int a){
		int E = firstDigit(a);
		int T = 10 * trailing(a);
		return E + T;
	}
	
	public static int trailing(int x) {
		if (x == 0) return 0;
		return (int) Math.floor(x % Math.pow(10, Math.floor(Math.log10(x))));
	}
	
	public static int firstDigit(int x) {
  		if (x == 0) return 0;
  		return (int) Math.floor(x / Math.pow(10, Math.floor(Math.log10(x))));
	}
    
}