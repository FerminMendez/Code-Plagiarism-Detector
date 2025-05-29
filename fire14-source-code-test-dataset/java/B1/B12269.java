import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);
		int cases, a, b;
		int[] ans;

		cases = sin.nextInt();
		ans = new int[cases];
		for (int i = 0; i < cases; i++) {
			int count = 0;

			a = sin.nextInt();
			b = sin.nextInt();

			for (int j = a; j <= b; j++) {
				String ori = String.valueOf(j);
				int[] temp = new int[ori.length() - 1];
				int tempIndex = 0;

				for (int k = 1; k < ori.length(); k++) {
					String newStr = ori.substring(k, ori.length())
							+ ori.substring(0, k);
					int newInt;
					boolean skip = false;

					if (newStr.charAt(0) == '0')
						continue;

					newInt = Integer.parseInt(newStr);

					for (int m = 0; m < tempIndex; m++)
						if (temp[m] == newInt) {
							skip = true;
							break;
						}

					if (skip == false)
						temp[tempIndex++] = newInt;
					else
						continue;

					if (j < newInt && newInt >= a && newInt <= b)
						count++;
				}
			}
			ans[i] = count;
		}

		for (int i = 0; i < cases; i++)
			System.out.println("Case #" + (i + 1) + ": " + ans[i]);
	}
}