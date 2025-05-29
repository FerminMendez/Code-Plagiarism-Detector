import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;


public class RecycledNumbers {

	static HashSet<String> set = new HashSet<String>();
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader("small-C.in"));
		BufferedWriter out = new BufferedWriter(new FileWriter("small-C.out"));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= n; i++){
			set.clear();
			int total = 0;
			String [] temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			
			for(int j = a; j < b; j++)
				total += check(j, a, b, temp[0], temp[1]); 
			
			out.write("Case #" + i + ": " + set.size());
			if(i < n)
				out.write("\n");
		}
		System.out.println(set.size());
		br.close();
		out.close();
	}

	private static int check(int n, int a, int b, String astr, String bstr) {
		
		int num = 0;
		String temp = n + "";
		
		for(int len = 1; len < astr.length(); len++){
			String one = temp.substring(0, len);
			String two = temp.substring(len);
			
			int temp2 = Integer.parseInt(two + one);
			if(temp2 > n && temp2 <= b){
				num++;
				if(set.contains(n + " " + temp2))
					System.out.println("Contained *********************************************************\n*****\n***");
				else{
					set.add(n + " " + temp2);
				}
				//System.out.println(one + " " + two + " --> " + two + " " + one + " len = " + len);
			}
		}
		if(num > 0)
			System.out.println();
		return num;
	}

}
