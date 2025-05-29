package practice.GC2012;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class recycle {
	
	public static void main(String args[]) throws IOException {
		Scanner s = new Scanner(new File("Z:\\junkyard\\practice\\resources\\input3.txt"));
		FileWriter fo = new FileWriter(new File("Z:\\junkyard\\practice\\resources\\output3.txt"));
		int num = s.nextInt();
		for(int i = 1; i<= num; i++) {
			fo.write("Case #" + i + ": ");
			int a = s.nextInt();
			int b = s.nextInt();

			Set<String> alreadyCounted = new HashSet<String>();
			for (int j = a;j<=b;j++) {

				StringBuffer n = new StringBuffer(String.valueOf(j));
				for (int p = 0; p < n.length(); p++) {
					n.append(n.charAt(0));
					n.deleteCharAt(0);
					
					if (j < Integer.parseInt(n.toString()) && Integer.parseInt(n.toString()) <= b) {
						alreadyCounted.add(String.valueOf(j) + n.toString());

					}
				
				}

			}

				fo.write(alreadyCounted.size() + "\n");

		}
			fo.close();
			s.close();
	}
}
