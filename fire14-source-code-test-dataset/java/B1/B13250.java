import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.HashSet;


public class Number {
	public static int instinct(int a ){
		int b = a%10;
		int m = 0;
		while(a!=0){
			b = a%10;
			a = a/10;
			m++;
		}
		return m;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("C-small-attempt0.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

		String line = "";
		line = br.readLine();
		int number = Integer.valueOf(line);
		for(int i = 1; i<= number; i++){
			line = br.readLine();
			String[] tokens = line.split(" ");
			int a = Integer.valueOf(tokens[0]);
			int b = Integer.valueOf(tokens[1]);
			int result = 0;
			for(int n = a; n<= b; n++){
				int m = instinct(n);

				HashSet<Integer> in = new HashSet<Integer>();
					for(int c = 1; c< m; c++){
						int po =(int) Math.pow(10,c);
						
						int tmp = (int) (Math.pow(10, m-c)*(n%po)+n/po);

						if(tmp >= a && tmp <=b){
							if(tmp > n){
			                    if(!in.contains(tmp)){
			                    	result++;
			                    	in.add(tmp);
			                    }
							}
						}
					}
			}
			bw.append("Case #"+i+": "+result);
			bw.newLine();
		}
		br.close();
		bw.close();
	}
}
