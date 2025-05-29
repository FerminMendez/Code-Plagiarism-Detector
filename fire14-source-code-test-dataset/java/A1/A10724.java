package home.lviv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void proA(BufferedReader reader, BufferedWriter writer)
			throws NumberFormatException, IOException {
		Map<Character, Character> map = new HashMap<Character, Character>(32);
		String text = "zejp mysljylc kd kxveddknmc re jsicpdrysi"
				+ "rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd"
				+ "de kr kd eoya kw aej tysr re ujdr lkgc jvq", mapping = "qour language is impossible to understand"
				+ "there are twenty six factorial possibilities"
				+ "so it is okay if you want to just give upz";
		for (int i = 0; i < text.length(); i++) {
			map.put(Character.valueOf(text.charAt(i)),
					Character.valueOf(mapping.charAt(i)));
		}
		int T;
		T = Integer.parseInt(reader.readLine());
		for (int t = 0; t < T; t++) {
			String in, out = "";
			in = reader.readLine();
			for (int i = 0; i < in.length(); i++) {
				if (map.get(in.charAt(i)) == null) {
					System.out.println("null is " + in.charAt(i));
				}
				out += map.get(in.charAt(i));
			}
			writer.write("Case #" + (t + 1) + ": " + out + "\n");
		}
	}

	public static void proB(BufferedReader reader, BufferedWriter writer)
			throws NumberFormatException, IOException {
		int T = Integer.parseInt(reader.readLine());
		for (int t = 0; t < T; t++) {
			String[] temp = reader.readLine().split(" ");
			int N = Integer.parseInt(temp[0]), S = Integer.parseInt(temp[1]), p = Integer
					.parseInt(temp[2]), G = 0;
			int[] n = new int[N];
			ArrayList<Integer> integers = new ArrayList<Integer>(N);
			for (int i = 0; i < N; i++) {
				n[i] = Integer.parseInt(temp[3 + i]);
				if (((n[i] / 3) >= p)) {
					G++;
					continue;
				} else {
					if (((n[i] / 3) >= p - 1) && (n[i] > 0) && (n[i] % 3 > 0)) {
						G++;
						continue;
					}
					if (((n[i] / 3) >= p - 1) && (n[i] > 0) && (S > 0)) {
						G++;
						S--;
						continue;
					}
					if (((n[i] / 3) >= p - 2) && (n[i] > 0) && (n[i] % 3 > 1)
							&& (S > 0)) {
						G++;
						S--;
						continue;
					}
				}
			}
			writer.write("Case #" + (t + 1) + ": " + (G) + "\n");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(
				new FileInputStream("/home/taras/codejam/data.in")));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("/home/taras/codejam/data.out")));
		proB(input, output);
		input.close();
		output.close();
	}
}
