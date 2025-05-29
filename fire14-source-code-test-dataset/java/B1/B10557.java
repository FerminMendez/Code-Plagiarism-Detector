import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class B {
	public static void main(String args[]) throws FileNotFoundException{
		//Scanner scanner = new Scanner(new FileInputStream("input.in"));
		Scanner scanner = new Scanner(System.in);
		int nt = scanner.nextInt();
		scanner.nextLine();
		//PrintWriter printWriter = new PrintWriter(new FileOutputStream("output.out"));
		PrintWriter printWriter = new PrintWriter(System.out);

		for (int i = 0; i < nt; i++) {
			printWriter.print("Case #"+(i+1)+": ");
			printWriter.println(solveIt(scanner.nextLine()));
		}
		printWriter.close();
		
	}

	private static String solveIt(String nextLine) {
		List<String> list= new ArrayList<String>(); 
		int A = Integer.parseInt(nextLine.split(" ")[0]);
		int B = Integer.parseInt(nextLine.split(" ")[1]);
		int result = 0;
		for (int i = A; i < B; i++) {
			String k = ""+i;
			for (int j = 0; j < k.length()-1; j++) {
				String k1 = k.substring(k.length()-(j+1), k.length()) + k.substring(0,k.length()-(j+1));
				if(Integer.parseInt(k1) > i && Integer.parseInt(k1) <= B){
					if(!list.contains(i+"--"+k1)){
						list.add(i+"--"+k1);
						result++;	
					}
				}	
			}
		}
		return result+"";
	}
}
