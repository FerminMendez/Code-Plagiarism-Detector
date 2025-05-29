package recycledNumbers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RecycledNumbers {
	
	public static String processaCaso(String linha, int i) {
		String[] nums = linha.split(" ");
		int a = Integer.parseInt(nums[0]);
		int b = Integer.parseInt(nums[1]);
		int numDistincPairs = 0;
		int lenNum = Integer.toString(a).length()-1;
		Set<Integer> ms = new HashSet<Integer>();
		for (; a < b; a++) {
			String n = Integer.toString(a);
			ms.clear();
			for (int j = 0; j < lenNum; j++) {
				int indice = lenNum-j;
				String strM = n.substring(indice)+n.substring(0,indice);
				int m = Integer.parseInt(strM);
				if (!(a < m && m <= b)) continue;
				ms.add(m);
			}
			numDistincPairs += ms.size();
		}
		return String.format("Case #%d: %d", i, numDistincPairs);
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File(args[0]));
        int numTestCases = scan.nextInt();
        scan.nextLine();
        Writer saida = new FileWriter(args[0]+".out");
		for (int i = 1 ; i <= numTestCases; i++) {
			saida.write(processaCaso(scan.nextLine(),i)+"\n");
		}
		saida.close();
	}

}
