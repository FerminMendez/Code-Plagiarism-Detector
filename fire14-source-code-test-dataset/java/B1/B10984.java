import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class RecycledPair {
	public static void main(String[] args) {

		try {

			BufferedReader br = new BufferedReader(new FileReader("input.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
			int N;
			N = Integer.parseInt(br.readLine());
			int k,i,j;
			HashSet<Integer> set;
			for (k = 0; k < N; k++) {
				
				String[] line = br.readLine().split(" ");
				int A = Integer.parseInt(line[0]);
				int B = Integer.parseInt(line[1]);
				
				
				int counter = 0;
				

				for (i = A; i < B; i++) {
					set = new HashSet<Integer>();
					updateSet(set, i);
					for (j = i + 1; j <= B; j++) {
						if (set.contains(j)) {
							counter++;
						}
					}
				}
				bw.write("Case #" + (k+1) + ": " + counter);
				bw.newLine();
				// showSet(set);
			}

			br.close();
			bw.close();

		} catch (IOException io) {
		}

	}

	private static void updateSet(HashSet<Integer> set, int num) {

		String numStr = num + "";
		char[] numChar = numStr.toCharArray();

		int i, j;

		for (i = numChar.length - 1; i >= 1; i--) {

			if (numChar[i] != '0') {

				char[] newNum = new char[numChar.length];
				j = i;
				int counter = 0;
				newNum[counter] = numChar[j];
				counter++;
				while (counter < numChar.length) {
					if (j < numChar.length - 1) {
						j++;
					} else {
						j = 0;
					}
					newNum[counter] = numChar[j];
					counter++;
				}
				set.add(Integer.parseInt(new String(newNum)));
			}
			//set.add(num);
		}
		set.add(num);
	}
/*
	private static void showSet(HashSet<Integer> set) {

		for (Integer s : set) {
			System.out.println(s);
		}
	}
*/
}
