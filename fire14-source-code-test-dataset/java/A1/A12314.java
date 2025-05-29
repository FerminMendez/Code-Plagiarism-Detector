import java.io.*;
import java.util.*;
public class dancing {
	private void go() throws Exception{
		File infile = new File("B-small-attempt0.in");
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(infile)));
		int num_of_cases = Integer.parseInt(br.readLine());
		for(int i=1;i<=num_of_cases;i++){
			String cur_str = br.readLine();
			StringTokenizer stk = new StringTokenizer(cur_str);
			int num_of_emp = Integer.parseInt(stk.nextToken());
			int num_of_surprise = Integer.parseInt(stk.nextToken());
			int req_num = Integer.parseInt(stk.nextToken());
			int surprise_not_needed = req_num*3 - 2;
			int surprise_needed = Math.max(req_num*3 -2 -2,1);
			int satisifed = 0;
			int scores[] = new int[num_of_emp];
			for(int k=0;k<num_of_emp;k++)
				scores[k] = Integer.parseInt(stk.nextToken());
			for(int k=0;k<num_of_emp;k++){
				if(scores[k] >= surprise_not_needed){
					satisifed++;
					continue;
				}
				else{
					if(scores[k] >= surprise_needed && num_of_surprise>0){
						satisifed++;
						num_of_surprise--;
						continue;
					}
					else continue;
				}
			}
			System.out.println("Case #"+i+": "+satisifed);
		}
	}
	public static void main(String[] args){
		try {
			new dancing().go();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
