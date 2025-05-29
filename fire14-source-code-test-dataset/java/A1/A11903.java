import java.util.Scanner;


public class P2 {
	public static void main(String[] args) { 
		Scanner scan = new Scanner(System.in); 
		int t = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < t; i++) { 
			String[] a = scan.nextLine().split(" ");
			int n = Integer.parseInt(a[0]); 
			int s = Integer.parseInt(a[1]); 
			int p = Integer.parseInt(a[2]);
			int count = 0;
			
			int[] scores = new int[a.length-3];
			for (int j = 0; j < scores.length; j++) { 
				scores[j] = Integer.parseInt(a[j + 3]);
			}
			
			for (int j = 0; j < scores.length; j++) { 
				int result = oneApart(scores[j]);
				if (result >= p) { 
					count += 1;
				} else if (scores[j] != 0 && scores[j] % 3 != 1 && result == p - 1 && s > 0) { 
					count += 1;
					s -= 1;
				}
			}
			System.out.println("Case #" + (i+1) + ": " + count);
		}
	}
	
	public static int oneApart(int a) { 
		if (a % 3 == 0) { 
			return a / 3;
		} else if (a % 3 == 1) { 
			return (a-1)/3 + 1; 
		} else if (a % 3  == 2) { 
			return (a-2)/3 + 1;
		}
		return -1;
	}
}
