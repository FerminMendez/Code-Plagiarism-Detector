import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		scan.nextLine();
		String phrase;
		int i = 1;
		while (scan.hasNextLine()) {
			int n1 = scan.nextInt();
			int n2 = scan.nextInt();
			System.out.println("Case #"+i+++": "+recycle(n1,n2));
		}	
	}

	public static int recycle(int n1, int n2){
		int count = 0;
		for(int i = n1; i<n2; i++){
			for(int j = i+1; j<=n2; j++){
				if(moveComp(i, j))
					count++;
			}
		}
		return count;
	}

	public static boolean moveComp(int n1, int n2){
		String num1 = Integer.toString(n1);
		String num2 = Integer.toString(n2);
		if(num1.length() != num2.length()) return false;
		for(int i = 0; i <num2.length(); i++){
			if(num2.equals(num1))
				return true;
			num2 = num2.charAt(num2.length()-1)+num2.substring(0, num2.length()-1);

		}
		return false;
	}
}
