

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class Recycle {
	public static void main(String...args) throws IOException  {
		//the result file
		PrintWriter writer = new PrintWriter(new FileWriter("c:\\jam\\C-small-attempt0.out"));
		//reading input file the file
		BufferedReader reader = new BufferedReader(new FileReader("c:\\jam\\C-small-attempt0.in"));
		//Reading cases number
		int count = Integer.parseInt(reader.readLine());
		
		//Iterating over the cases
		for(int k=1;k<count+1;k++){
			String g = reader.readLine();
			String[] tab = g.split("\\s");
			int A = Integer.parseInt(tab[0]);
			int B = Integer.parseInt(tab[1]);
			int res = 0;
			
			for(int n=A;n<B;n++){
				String str = "" + n;
				String origin = str;
				int size = str.length();
				String old = null;
				int c = 0;
				List<String> list = new ArrayList<String>();
				for(int i=0;i<size;i++){
					char first = str.charAt(0);
					str = str.substring(1).concat(first + "");
					boolean test = false;
					for(String s:list){
						if(s.equals(str)) test = true;
					}
					if(test) continue;
					list.add(str);
					c = Integer.parseInt(str);
					int size2 = String.valueOf(c).length();
					if(c>n && c<=B && size==size2){
						res++;
					}
					old = str;
				}
			}
			
			writer.println("Case #" + k + ": " + res);
		}
		
			reader.close();
			writer.close();
	}
}
