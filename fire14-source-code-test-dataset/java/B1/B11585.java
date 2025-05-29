package br.com.codejam.qualification;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RecycledNumbers {
	public static void main(String[] args) throws IOException {
		String file = "C-small-attempt1";
		Scanner sc = new Scanner(new FileReader(file + ".in"));
		PrintWriter pw = new PrintWriter(new FileWriter(file + ".out"));
		int T = new Integer(sc.nextLine());
		Map<Map<String, String>, String> mapAll = new HashMap<Map<String, String>, String>();
		Map<String, String> map = new HashMap<String, String>();

		int h = 1;
		for (int t = 1; t <= T; t++) {
			String line = sc.nextLine();
			String[] numbers = line.split(" ");
			mapAll = new HashMap<Map<String, String>, String>();
			int A = new Integer(numbers[0]);
			int B = new Integer(numbers[1]);
			if ((String.valueOf(A)).length() > 1) {
				
				for (int i = B; i > A; i--) {
					for (int j = A; j < i; j++) {
						String auxA = String.valueOf(j);
						for (int m = 0; m < auxA.length(); m++) {
							if (auxA.charAt(0) != '0') {
								if (new Integer(auxA) == i) {
									map = new HashMap<String, String>();
									map.put(String.valueOf(j),
											String.valueOf(i));
									mapAll.put(map, "sucesso");
								}
							}
							StringBuilder sb = new StringBuilder();
							sb.append(auxA.charAt(auxA.length() - 1));
							sb.append(auxA.substring(0, auxA.length() - 1));
							auxA = sb.toString();
						}
					}
				}
			}			
			pw.print("Case #" + h + ": ");
			pw.println(mapAll.size());
			/*for(Map<String, String> m : mapAll.keySet()) {
				for(String s : m.keySet()) {
					pw.print(s + " - ");
					pw.println(m.get(s));
				}
			}
			pw.println("###########################");
			pw.println();*/
			h++;

		}
		pw.flush();
		pw.close();
		sc.close();
	}

}
