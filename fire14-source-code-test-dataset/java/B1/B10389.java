import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class C {
	
	public static void main(String[] args) {
		
		Vector<Integer> num = new Vector<Integer>();
		Vector<Integer> counts = new Vector<Integer>();
		int count = 0;
		int cases = 0;
		int n = 0;
		boolean seen = false;
		int start, end;
		String num1, num3 = null;
		char num2[];
		
		try {
			Scanner in = new Scanner(new FileReader("C-small-attempt0.in"));
			
			cases = in.nextInt();
			
			for (int i = 0; i < cases; i++) {
				
				count = 0;
				start = in.nextInt();
				end = in.nextInt();
				num1 = Integer.toString(start);
				
				for (int j = start; j < end; j++) {
					num1 = Integer.toString(j);
					if (num.contains(j) == false) {
						num.add(Integer.parseInt(num1));
						num2 = num1.toCharArray();
						//System.out.print(num1);
						n = 0;
						for (int k = 0; k < num2.length - 1; k++) {
							seen = false;
							char temp = num2[num2.length - 1];
							for (int l = num2.length - 1; l >= 1; l--) {
								num2[l] = num2[l - 1];
							}
							num2[0] = temp;
							num3 = new String(num2);
							//System.out.println("2 " + num3);
							seen = num.contains(Integer.parseInt(num3));
							if (seen == false && num2[0] != '0' && 
									Integer.parseInt(num3) <= end &&
									Integer.parseInt(num3) >= start &&
									num3.equals(num1) == false) {
								//System.out.println("Original " + num1);
								//System.out.print(", " + num3);
								num.add(Integer.parseInt(num3));
								n++;
								//System.out.println("n: " + n);
							}
						}
						//System.out.println();
						count += (n * (n + 1) / 2);
					}
				}
				num = new Vector<Integer>();
				counts.add(count);
				System.out.println(count);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileWriter out = new FileWriter("C.out");
			BufferedWriter writer = new BufferedWriter(out);
			
			for (int i = 0; i < cases; i++) {
				writer.write(String.format("Case #%d: %d\n", i + 1, counts.get(i)));
			}
			
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
