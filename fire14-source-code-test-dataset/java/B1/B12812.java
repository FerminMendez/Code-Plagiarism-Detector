import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Solution {
	
	public void output(BufferedWriter out, int caseNum, 
			int time) throws IOException
	{
		out.write("Case #" + caseNum + ": " + time + "\n");		
	}
	
	public void solve() throws IOException
	{

		Scanner scan = new Scanner(new File("src/C-small-attempt0.in"));
		BufferedWriter out = new BufferedWriter(new FileWriter
				("C-small-attempt0.out"));

		int cases = scan.nextInt();
		
			for(int i = 1; i <= cases;i++){
					int A = scan.nextInt();
					int B = scan.nextInt();
					int count = 0;
					int j = 0;
					String [] arr = new String[B-A+1];
					
					for(int n = A; n <= B; n++){
						arr[j] = Integer.toString(n);
						j++;
					}
					
					for(int k = 0; k < arr.length; k++){
						for(int l = k+1; l < arr.length; l++){
							int zz = 1;
							int len = arr[k].length();
							while(zz < len){
								if(arr[k].endsWith(arr[l].substring(0, len-zz))){
									if(arr[k].startsWith(arr[l].substring(len-zz))){
										count++;
										break;
									}
								}
								zz++;
							}
						}
					}
					System.out.format("Case #%d: %d\n", i, count);
					output(out, i, count);
			}
		
		out.close();	
	}
	
	public static void main(String[] args) throws IOException
	{
		Solution sol = new Solution();
		sol.solve();
		
	}

}

