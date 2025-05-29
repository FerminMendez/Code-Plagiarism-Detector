package question;

import java.util.HashMap;

import utils.FileTools;

public class Qualification2 {
	public static void main(String[] args) {
		try {
			FileTools ft = new FileTools("B-small-attempt1.in");
			int T = Integer.parseInt(ft.in.readLine());
			String line;
			int l = 0;
			while ((line = ft.in.readLine()) != null) {
				ft.out.write("Case #" + (++l) + ": ");
				String[] a = line.split(" ");
				int total = 0;
				int size = Integer.parseInt(a[0]);
				int sur = Integer.parseInt(a[1]);
				int avr = Integer.parseInt(a[2]);
				for (int i = 0; i < size; i++) {
					int v = Integer.parseInt(a[i + 3]);
					if (v >= avr && v >= 3 * avr - 2) {
						total++;
					} else if (sur > 0 && v >= avr && v >= avr * 3 - 4) {
						sur--;
						total++;
					}
				}
				ft.out.write(Integer.valueOf(total).toString());
				System.out.println("Case #" + l + ": " + total);
				ft.out.newLine();
			}
			ft.out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
