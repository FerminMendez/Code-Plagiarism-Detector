import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class recycled {
	private static File f = new File("C:/Users/Cybermask/Desktop/myfile.txt");
	private static File outfile = new File("C:/Users/Cybermask/Desktop/out.txt");
	private static BufferedReader reader;

	private static String read() throws Exception{
		return reader.readLine();
	}
	private static int toint(String s){
		return Integer.parseInt(s);
	}
	private static ArrayList<Object> reverse(ArrayList<Object>list){
		ArrayList<Object> result = new ArrayList<Object>();
		for(int i=0;i<list.size();i++)
			result.add(list.get(list.size()-i-1));
		return result;
		
	}
public static void main(String args[])throws Exception{
	reader = new BufferedReader(new FileReader(f));
	PrintWriter pw = new PrintWriter(outfile);
	int n = toint(read());
	for(int i = 0 ; i<n;i++){
		String string = read();
		Scanner s = new Scanner(string);
		s.useDelimiter(" ");
		int f = s.nextInt();
		int l = s.nextInt();
		int count = 0 ;
		pw.print("Case #"+(i+1)+": ");
	
		for(int k=f;k<=l;k++){
			String number = k+"";
			int first = toint(number);
			HashSet<Integer> hs = new HashSet<Integer>();
			for(int o=1;o<number.length();o++){
				
				String 	number2=number.substring(number.length()-o,number.length())+""+number.substring(0,number.length()-o);
				
		
				
				int result = toint(number2);
				if(number.length()==number2.length() &&result>=f && result<=l && result > first){
					hs.add(result);
				}
				
			}
			count+=hs.size();
		}
		pw.println(count);
		
		
	}
	pw.flush();
}
}