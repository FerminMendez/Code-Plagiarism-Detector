import java.util.Scanner;
import java.util.LinkedList;
public class ProblemC {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt(); //number of cases
		scan.nextLine();
		
		for (int k = 1; k <= T; k++) {
			int A = scan.nextInt();
			int B = scan.nextInt();

			int count = 0;
			for (int i = A; i <= B; i++) {
				String original = ""+i;
				LinkedList<Integer> recycleList = new LinkedList<Integer>();
				for (int j = 1; j< original.length(); j++) { //where to rotate from
					if (original.charAt(j) < original.charAt(0)) //eliminate some obvious "decreasing" cases
						continue;								 //since they'll be duplicated anyway.
					String newstr = original.substring(j) + original.substring(0,j);
					int newint = Integer.parseInt(newstr);

					if (newint > i && newint <= B) {//don't count duplicates or pairs out of range
						if (!recycleList.contains(newint)) {//no duplicate recycles
							count++;
							recycleList.add(newint);
						}
					}
				}
			}
			//System.err.println("count: " + count);
			int solution = count;

			System.out.println("Case #" + k + ": " + solution);
		}
	}

}
