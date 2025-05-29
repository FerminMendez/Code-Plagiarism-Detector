package compete;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Recycle {
	private static void print(String sth) {
		System.out.println(sth);
	}

    private static int recycle(int A, int B) {
        
        int n=0;
        for (int i=A;i<B;i++) {
            String t = i+"";

            ArrayList<Integer> l = new ArrayList<Integer>();
            for (int k=0;k<t.length();k++) {
                char c = t.charAt(0);
                t = t.substring(1)+c;	
                if (t.charAt(0)=='0') continue;
                int ti = Integer.parseInt(t);
                if (ti>B||ti<=i) continue;
                if (!l.contains(ti)) {
                	l.add(ti);
                	n++;
                }
            }
        }

        return n;
    }

	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		
		int num = Integer.parseInt(in.readLine());
		
		for (int i=0;i<num;i++) {
			String sentence = in.readLine();
			Scanner s = new Scanner(sentence);
			
			int A = s.nextInt();
			int B = s.nextInt();
			
			print("Case #"+(1+i)+": "+recycle(A,B));
		}	
	}
}
