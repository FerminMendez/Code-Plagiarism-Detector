import java.util.Scanner;

public class Dancing_With_the_Googlers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = 0;
		while (scanner.hasNextInt()) {
			T = scanner.nextInt();
			break;
		}

		for (int t = 0; t <= T; t++) {
			if (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (!line.isEmpty()) {
					String[] g = line.split(" ");
					int N = Integer.parseInt(g[0]);
					int s = Integer.parseInt(g[1]);
					int p = Integer.parseInt(g[2]);

					int minS = p + (p - 2) + (p - 2);
					int noS = p + (p - 2) + (p - 2) + 2;

					int output = 0;
					int total = 0;

					for (int i = 3; i <= N + 2; i++) {
						if (Integer.parseInt(g[i]) >= noS) {
							output++;
						} else if (Integer.parseInt(g[i]) < noS && Integer.parseInt(g[i]) >= minS) {
							if(Integer.parseInt(g[i])==0){
								continue;
							}
							total++;
						}
					}
					if (total == s) {
						output += total;
					} 
					else if(s==0){
						
					}else if (total >=s) {
						if(output==0)
							output=s;
						else
							output += (total - s);
					}else if (total <s) {
						output += total;
					}
					System.out.println("Case #" + (t) + ": " + output);
				}
			}
		}

	}

}
