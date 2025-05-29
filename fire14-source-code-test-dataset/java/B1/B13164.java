import static java.lang.System.in;
import static java.lang.System.out;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Recycled {

	
	public static void main(String[] args) throws IOException {
		Scanner asdf = new Scanner(in);
		Scanner file = new Scanner(new File("C-small.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C-small.out")));
		int t = file.nextInt();
		
		for(int r=1; r<=t; r++){
			run(r, file, out, asdf);
		}
		
		out.close();
	}
	
	public static void run(int r, Scanner file, PrintWriter out, Scanner asdf){
		
		int a = file.nextInt();
		int b = file.nextInt();
		int count = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int s=1; s<=Integer.toString(b).length(); s++)
			for(int x=a; x<=b; x++)
				for(int y=b; y>=x; y--)
					if(x!=y && x==rotateDig(y, s) && !list.contains(x*y)){
						count++;
						list.add(x*y);
						//System.out.println(x+" "+y);
					}
		
		//System.out.println("Case #"+r+": "+count);
		out.println("Case #"+r+": "+count);
	}
	
	public static int rotateDig(int n, int shift){
		
		String s = Integer.toString(n);
		String t = "";
		
		t = s.substring(shift);
		t += s.substring(0,shift);
		
		return Integer.parseInt(t);
	}

}
