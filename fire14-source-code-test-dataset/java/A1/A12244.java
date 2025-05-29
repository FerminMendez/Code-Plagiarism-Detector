import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		int cases, num, sur, p;
		int[] googlers;
		Scanner sin = new Scanner(System.in);
		int[] ans;

		cases = sin.nextInt();
		ans = new int[cases];
		for (int i = 0; i < cases; i++) {
			int count = 0;
			int couSur = 0;
			int center, notSurLeast, least;

			num = sin.nextInt();
			googlers = new int[num];
			sur = sin.nextInt();
			p = sin.nextInt();
			for (int j = 0; j < num; j++)
				googlers[j] = sin.nextInt();

			center = 3 * p;
			notSurLeast = center - 2;
			least = center - 4;
			if (least < p)
				least = p;
			for (int j = 0; j < num; j++)
				if (googlers[j] >= least) {
					count++;
					if (googlers[j] < notSurLeast)
						couSur++;
				}
			
			if (couSur > sur)
				count -= (couSur - sur);
			ans[i] = count;
		}

		for (int i = 0; i < cases; i++)
			System.out.println("Case #" + (i + 1) + ": " + ans[i]);
	}
}