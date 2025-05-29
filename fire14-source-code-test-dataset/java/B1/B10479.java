import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import javax.security.auth.x500.X500Principal;


public class RecycledNumbers {

	static HashSet<Integer> set = new HashSet<Integer>();
	static ArrayList<Integer> rotate = new ArrayList<Integer>();
	int counter = 0;
	int count=1;
	public static void main(String[] args) {
		try {
			
			BufferedReader in = new BufferedReader(new FileReader("input.txt"));
			BufferedWriter out = new BufferedWriter(new FileWriter("A-small.out"));
			RecycledNumbers x = new RecycledNumbers();
			String str;
			in.readLine();
			while ((str = in.readLine()) != null) {
				x.recycle(str);
				out.write("Case #"+(x.count++)+": "+x.counter+"\n");
				x.counter = 0;
			}
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	void recycle(String in)
	{
		int a = Integer.parseInt(in.split(" ")[0]);
		int b = Integer.parseInt(in.split(" ")[1]);
		for (int n = a; n < b ; n++) {
			rotateNumber(n);
			if(rotate.size()>0){
				for (int i = 0; i < rotate.size(); i++) {
					int m = rotate.get(i);
					if(a <= n && n < m && m <= b)
						counter++;
				}
			}	
			
		}
		
	}
	
	static void rotateNumber(int number){
		rotate = new ArrayList<Integer>();
		int start = number;
		int numdigits = (int) Math.log10((double)number);
		int multiplier = (int) Math.pow(10.0, (double)numdigits);
		while(true){
               int q = number / 10;
               int r = number % 10;

               //1234 = 123;
               number = number / 10;
               number = number + multiplier * r;

               if(number == start)
                     return;
               rotate.add(number);
         }
	}
}
