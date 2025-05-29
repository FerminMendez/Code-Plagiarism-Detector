import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;


public class Recycled {
	
	public static Integer reorder(int n) {
		int newn = n, digits = 0, greatest = 0, scale = 1;
		while (newn > 0) {
			newn /= 10;
			digits++;
			scale *= 10;
		}
		scale /= 10;
		int temp = 0;
		for (int i = 0; i < digits; i++) {
			temp = n;
			temp /= 10;
			temp += scale * (n-(10*temp));
			n = temp;
			greatest = Math.max(n,greatest);
		}
		
		return greatest;
	}
	
	public static void main(String[] args) {
		
		String fileName;
		String line;
		fileName = "C-small-attempt0.in";
		
		Scanner fromFile = null;
		try {
			fromFile = new Scanner(new File(fileName));
		} catch (Exception e) {}
		
		int iterations = Integer.parseInt(fromFile.nextLine());
		int count, lower, upper;
		int[] answers = new int[iterations];
		HashMap<Integer,Integer> map = null;
		Integer ordered = null;
		
		for (int i = 0; i < iterations; i++) {
			
			line = fromFile.nextLine();
			String[] arguments = line.split(" ");
			lower = Integer.parseInt(arguments[0]);
			upper = Integer.parseInt(arguments[1]);
			count = 0;
			map = new HashMap<Integer,Integer>();
			
			for (int j = lower; j <= upper; j++) {
				ordered = reorder(j);
				if (map.containsKey(ordered)) {
					int number = map.get(ordered);
					count += number;
					map.put(ordered, number+1);
				} else {
					map.put(ordered, 1);
				}
			}
			
			answers[i] = count;
		}
		
		try {
			fromFile.close();
		} catch (Exception e){}
		
		PrintWriter toFile = null;
		try {
			File f = new File("output.txt");
			if (!f.exists())
				f.createNewFile();
			toFile = new PrintWriter(f);
		
			for (int i = 0; i < iterations; i++) {
				if (i == iterations - 1) {
					toFile.print("Case #" + (i + 1) + ": " + answers[i]);
				} else {
					toFile.println("Case #" + (i + 1) + ": " + answers[i]);
				}
			}
			
			toFile.close();
		
		} catch (Exception e) {}
	}
}
