import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;


public class ProbB {

	/**
	 * @param args
	 * @throws IOException 
	 */
	
	public static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader inputStream;
		PrintWriter outputStream;
		try {
			inputStream = new BufferedReader(new FileReader("X:\\GCJ\\input.txt"));
			outputStream = new PrintWriter(new BufferedWriter(new FileWriter("X:\\GCJ\\output.txt")));


			int n=Integer.parseInt(inputStream.readLine()),z=0;
			
			while(n>0)
			{
				n--;z++;c=0;
				String s=inputStream.readLine();
				int spc= s.indexOf(' ');
				int r=0,A=Integer.parseInt(s.substring(0,spc)),B=Integer.parseInt(s.substring(spc+1));
				
				for (int i = A; i < B; i++) {
					func(i,A,B,digits(A));
					
				}
				
				
				outputStream.println("Case #"+z+": "+c);
				System.out.println("Case #"+z+": "+c);
			}
			
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found.");
			e.printStackTrace();
		}
	}

	public static int digits(int a) {
		int z=0;
		while(a!=0){
			a/=10;z++;
		}
		return z;
	}
	
	public static int c=0;
	
	public static void func(int a,int A,int B, int n){
		int a2=0;
		int o=a;
		
		for (int j = 1; j < n; j++) {
			
			int k=a%10;
			for (int i = 0; i < n-1; i++) {
				k*=10;
			}
			a2= k+a/10;
								
			if(a2>o && a2<=B){
				map.put(o,a2);c++;
				System.out.println(c+":"+o+","+a2);
			}
			
			
			a=a2;
		}
		
	}
	
}
