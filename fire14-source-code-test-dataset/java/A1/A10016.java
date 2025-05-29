import java.util.*;
import java.io.*;
public class B {
  public static void main (String[] args)throws Exception
  {
    String inputfilename = args[0];
    String outputfilename = args[1];
    BufferedReader br = new BufferedReader(new FileReader(inputfilename));
    BufferedWriter bw = new BufferedWriter(new FileWriter(outputfilename));
    int cases = Integer.valueOf(br.readLine());
    for(int i = 0; i < cases; i++) {
		String[] ele = br.readLine().split(" ");
		int n = Integer.valueOf(ele[0]);
		int s = Integer.valueOf(ele[1]);
		int p = Integer.valueOf(ele[2]);
		List<Integer> total = new ArrayList<Integer>();
		for(int j = 0; j < n; j++) {
			total.add(Integer.valueOf(ele[3 + j]));
		}
		int result = B.solve(n,s,p,total);
		bw.write("Case #" + (i + 1) + ": " + result + "\n");
    }

    
    br.close();
    bw.close();
  }
  public static int solve(int n,int s,int p,List<Integer> total)
  {
    int cnt = 0;
    for(Integer t : total) {
      int divide = t / 3;
      int left = t - divide * 3;
      if(divide >= p) {
		cnt++;
		continue;
      }
      if(left == 1) {
		if(divide + 1 >= p) cnt++;
      } else if(left == 2) {
		if(divide + 1 >= p) cnt++;
		else if(divide + 2 >= p && s > 0) {cnt++;s--;}
      } else if(divide > 0){
		if(divide + 1 >= p && s > 0) {cnt++;s--;}
      }
      
    }
    return cnt;
  }
}
