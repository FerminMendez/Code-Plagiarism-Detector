import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class B {

	public final String INPUT_FILE_NAME = "b_in";
	public final String OUTPUT_FILE_NAME = "b_out";
	
	int kase = 1;
	int N = 0;
	int T = 0;
	int P = 0;
	int SUR = 0;
	int ans = 0;
	ArrayList<Integer> sums = new ArrayList<Integer>();
	
	public ArrayList<ArrayList<Integer>> gen(int sum){
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= 10; j++) {
				if (Math.abs(j-i) > 2) continue;
				for (int k = 0; k <= 10; k++) {
					if (Math.abs(i-k) > 2) continue;
					if (Math.abs(j-k) > 2) continue;
					if (i+j+k != sum) continue;
					ArrayList<Integer> v = new ArrayList<Integer>();
					v.add(i); v.add(j); v.add(k);
					ans.add(v);
				}
			}
		}
		
		return ans;
	}
	
	public boolean isSur(ArrayList<Integer> v){
		int a = v.get(0); int b = v.get(1); int c = v.get(2);
		if (Math.abs(a-b) == 2) return true;
		if (Math.abs(a-c) == 2) return true;
		if (Math.abs(b-c) == 2) return true;
		return false;
	}
	
	public void solve(int count,int sur,int index){
		//if (N == 2)
		//	System.out.println(count + " " + sur + " " + index);
		if (index == N){
			if (sur == SUR)
				ans = Math.max(ans,count);
			return;
		}
		if (sur > SUR)
			return;
		ArrayList<ArrayList<Integer>> v = gen(sums.get(index));
		//System.out.println(v.size() + " " + sur);
		for (int i = 0; i < v.size(); i++) {
			//if (N==2)
			//System.out.println(index + " " + v.get(i));
			boolean surprize = isSur(v.get(i));
			if (v.get(i).get(0) >= P ||v.get(i).get(1) >= P ||v.get(i).get(2) >= P  )
				if (surprize)
					solve(count+1,sur+1,index+1);
				else
					solve(count+1,sur,index+1);
			else
				if (surprize)
					solve(count,sur+1,index+1);
				else
					solve(count,sur,index+1);
		}
	}
	
	public void run() throws IOException{
		Scanner s = new Scanner(new File(INPUT_FILE_NAME));
		//BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
		PrintWriter pw = new PrintWriter(new FileWriter(OUTPUT_FILE_NAME));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		T = s.nextInt();
		while  (T-- > 0){
			ans = 0;
			sums = new ArrayList<Integer>();
			N = s.nextInt();
			SUR = s.nextInt();
			P = s.nextInt();
			for (int i = 0; i < N; i++)
				sums.add(s.nextInt());
			solve(0,0,0);
			pw.println("Case #" + kase + ": " + ans);
			kase++;
		}
		
		pw.close();
		s.close();
		//br.close();
	}
	
	
	public static void main(String[] args) throws IOException {
		(new B()).run();
	}

}
