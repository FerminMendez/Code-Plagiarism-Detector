import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class CodeJam {
	public static void main(String args[]){
		try {
			FileReader f = new FileReader("C-small-attempt0.in");
			BufferedReader in = new BufferedReader(f);
			FileWriter fwrite = new FileWriter("output");
			BufferedWriter out = new BufferedWriter(fwrite);
			int n = Integer.parseInt(in.readLine().toString());
			int i =0;
			int count = 0;
			int a;
			int b;
			String line;
			while(i<n){
				out.write("Case #"+(i+1)+": ");
				line = in.readLine();
				a = Integer.parseInt(line.substring(0,line.indexOf(" ")));
				line = line.substring(line.indexOf(" ")+1);
				b= Integer.parseInt(line.substring(0,line.length()));
				count = 0;
//				System.out.println(a+" "+b);
				count = answer(a,b);
				out.write(String.valueOf(count));
				out.newLine();
				i++;
			}
			in.close();
			out.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	private static int shift(int a, int n){
		String temp = String.valueOf(a);
		char c[]= new char[temp.length()];
		int j=0;
		while(j<n){
			for (int i = 0 ; i< temp.length();i++){
				c[i]= temp.charAt((temp.length()+i-1)%temp.length());
			}
			temp = String.valueOf(c);
			j++;
		}
		return Integer.parseInt(temp);
	}
	private static int answer(int a, int b) {
		int n =a;
		int count = 0;
		shift(a,3);
		while(n<=b){
			count += check(n,a,b);
			n++;
		}
		return count;
	}
	private static int check(int n, int a, int b) {
		int digit = String.valueOf(a).length();
		int temp = 0;
		int res = 0;
		int flag = 0;
		int ar[] = new int[digit];
		for(int i = 0; i<digit ; i++){
			temp = shift(n,i);
			ar[i]=temp;

			if(temp>= a && temp>n && temp <= b ){
				for(int z=0;z<i;z++){
					if(temp == ar[z]){
						flag = 1;
					}
				}
				if(flag == 0)
					res ++;
			}
		}
		return res;
	}
}