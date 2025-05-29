import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;


public class C {
	
	public ArrayList<Integer> hash = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			C c = new C();
			int y = 0;
			int A = scanner.nextInt();
			int B = scanner.nextInt();
			for (int j = A; j <= B; j++) {
//				if(!c.hash.contains(j)) {
//					System.out.println("j="+j);
					y += c.permut(j, A, B);
//				}
			}
			System.out.println("Case #"+(i+1)+": "+y);
		}
	}
	
	public int permut(int j, int A, int B) {
		int y = 0;
		String sj = ""+j;
		int newJ = 0;
		while(newJ != j) {
			char lastDigit = sj.charAt(sj.length()-1);
			String frontNumber = sj.substring(0, sj.length()-1);
			sj = lastDigit + frontNumber;
			newJ = Integer.parseInt(sj);
//			System.out.print(newJ);
			if(newJ >= A && newJ <= B  && newJ > j) {
				y++;
//				if(!hash.contains(newJ)) {
//					hash.add(newJ);
//					System.out.print(" p");
//				}
			}			
//			System.out.println();
		}
//		System.out.println();
		return y;
	}

}
