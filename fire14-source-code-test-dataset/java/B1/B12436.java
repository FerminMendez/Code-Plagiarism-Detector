import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * 
 */

/**
 * @author Daniel
 *
 */
public class Recycled {

	
	public static ArrayList<Integer> generateRecycled(int seed){
		String seeds = Integer.toString(seed);
		ArrayList<Integer> recycled = new ArrayList<Integer>();
		Integer temp;
		for (int i = 1; i < seeds.length(); i++){
			temp = Integer.parseInt(seeds.substring(i) + seeds.substring(0, i));
			if (temp.intValue()!=seed && !recycled.contains(temp))
				recycled.add(temp);
		}
		return recycled;
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		if (args.length!=2){
			System.err.println("Error with arguments");
			System.exit(-1);
		}
			
		// Configuring input and output
		Scanner input = new Scanner(new FileReader(new File(args[0])));
		Writer output = new BufferedWriter(new FileWriter(new File(args[1])));
		
		int T = input.nextInt();
		int A, B, count, temp;		
		for (int i = 1; i <= T; i++){
			System.out.print("Case #" + i + ": ");
			output.write("Case #" + Integer.toString(i) + ": ");
			
			A = input.nextInt();
			B = input.nextInt();
			count = 0; temp = 0;
			ArrayList<Integer> found = new ArrayList<Integer>();
			
			for (int j = A; j <= B; j++){
				if (found.contains(Integer.valueOf(j)))
					continue;
				ArrayList<Integer> recycled = new ArrayList<Integer>(generateRecycled(j));
				temp = 0;
				for (Integer e :recycled){
					if ((e.intValue() >= A) && (e.intValue() <= B)){
						found.add(e);
						temp ++;
					}
				}
				if (temp > 0){
					count += temp * (temp+1) / 2;
				}
				
			}
			System.out.print(count);
			output.write(Integer.toString(count));
			
			System.out.println();
			output.write("\n");
		}
		output.close();

	}

}
