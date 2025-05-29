import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class RecycleNumbers {
	public static void main(String[] args) {
		try{
			BufferedReader fileIn = new BufferedReader(new FileReader("C-small-attempt0.in"));
			int cases = Integer.valueOf(fileIn.readLine());
			Scanner numReader = new Scanner(fileIn);
			for(int i = 0; i < cases; i++) {
				int start = numReader.nextInt();
				int end = numReader.nextInt();
				List<NumberQueue.Pair> p = new ArrayList<NumberQueue.Pair>();
				for(int n = start; n <= end; n++) {
					NumberQueue q = new NumberQueue(n);
					List<NumberQueue.Pair> returned = q.distinctRoations(start, end);
					for(NumberQueue.Pair ap : returned) {
						if(!p.contains(ap)) {
							p.add(ap);
						}
					}
				}
				System.out.println("Case #"+(i+1)+": "+p.size());
			}
		} catch(Exception err) {
			System.out.println("ERRORRRRRRRRRRRRRRRRRRRRR: "+ err.getMessage());
			err.printStackTrace();
		}
	}
}
