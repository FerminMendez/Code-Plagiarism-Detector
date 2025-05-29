import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int casenum = 1;
		
		while (T-- > 0) {
			 int num = solve(sc);
			 System.out.println("Case #" + casenum++ + ": " + num);
		}

	}

	private static int solve(Scanner sc) {
		int A = Integer.parseInt(sc.next());
		int B = Integer.parseInt(sc.next());
		long ts = System.currentTimeMillis();
		int num = 0;
		for (int a = A; a < B; a++) {
			for (int b = a+1; b <= B; b++) {
				
					if(isrec(a,b)) {
						//if(num < 10)
						//System.out.println("rec: " + a + " and " + b);
						num++;
					}
			}
		}
		ts = System.currentTimeMillis() - ts;
		//System.out.println("time: " + ts);
		return num;
	}

	private static boolean isrec(int a, int b) {
		int hi = a;
		int lo = 0;
		int[] base = {
				1,
				10,
				100,
				1000,
				10000,
				100000,
				1000000,
				10000000,
				100000000,
				1000000000};
		int i = 0;
		int len = 0;
		while(base[len] < a) len++;
		if(b >= base[len] || b <= base[len]/10) return false;
		while (hi > 0){
			int num = lo*base[len-i]+hi;
			
			if(num == b) {
				//System.out.println(a + " " + b + ": " + hi + "|" + lo);
				return true;
			}
			hi /=  10;
			lo = a - hi*base[i+1];
			i++;
		}
		return false;
	}
}
