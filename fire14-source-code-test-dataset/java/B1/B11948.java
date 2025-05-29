import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class RecycledNumbers {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("recycle.in"));
		PrintWriter out = new PrintWriter(new FileWriter("recycle.out"));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int count = 1; count <= n; count++){
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			boolean[] hasBeen = new boolean[B+1];
			int numPairs = 0;
			for(int i = A; i <= B; i++){
				if(hasBeen[i] == true) continue;
				hasBeen[i] = true;
				ArrayList<Integer> cycle = rotate(i);
				int numCycles = 1;
				for(int num: cycle){
					if(num > B || num < A) continue;
					if(hasBeen[num]) continue;
					hasBeen[num] = true;
					numCycles++;
				}
				numPairs += (numCycles*(numCycles-1))/2;
			}
			out.println("Case #" + count + ": " + numPairs);
		}
		out.close();
	}
	
	static ArrayList<Integer> rotate(int num){
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int length = String.valueOf(num).length();
		for(int i = 1; i < length; i++){
			if(num%10 == 0){
				num = (int)((num%10)*Math.pow(10, length-1)) + num/10;
			} else {
				num = (int)((num%10)*Math.pow(10, length-1)) + num/10;
				ans.add(num);
			}
		}
		return ans;
	}
}
