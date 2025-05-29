import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DancingWiththeGooglers {

	public static void main(String[] args) {
		List<String> lines = getline("C:\\Users\\Ami\\Downloads\\B-small-attempt16.in");
		System.out.println("number Of Test Cases-->" + lines.remove(0));
		ProcessTestCases(lines);
	}

	private static void ProcessTestCases(List<String> lines) {
		int k = 1;
		for (String line : lines) {
			String[] strings = line.split(" ");
			int S = Integer.valueOf(strings[1]);
			int p = Integer.valueOf(strings[2]);
			int j = 0;
			List<Integer> lst = new ArrayList<Integer>();
			for (int i = 3; i < strings.length; i++) {
				lst.add(Integer.valueOf(strings[i]));
			}
			Collections.sort(lst);
			for (int i : lst) {
				if (S > 0) {
					int eqCmp = i / 3;
					if (eqCmp >= p) {
						j++;
					} else {
						int remin = i % 3;
						if (remin > 0) {
							if (eqCmp > 0 && remin == 1 && eqCmp + 1 >= p) {
								j++;
							} else if (eqCmp > 0 && remin == 2) {
								if (eqCmp + 1 >= p) {
									j++;
								} else if (eqCmp + 2 >= p) {
									S--;
									j++;
								}

							}
						} else if (eqCmp > 0 && eqCmp + 1 >= p) {
							j++;
							S--;
						} else {
							if (eqCmp == 0) {
								if (remin == 2) {
									if (p == 2) {
										j++;
										S--;
									} else {
										j++;
									}
								} else if (remin == 1) {
									if (p == 1 || p == 0) {
										j++;
									}
								}
							}
						}
					}
				} else {
					int eqCmp = i / 3;
					int remin = i % 3;
					if (eqCmp >= p) {
						j++;
					} else {
						if (remin > 0 && eqCmp > 0
								&& (eqCmp + (remin == 1 ? 1 : 1)) >= p) {
							j++;
						} else if ((remin == 1 || remin == 2) && p == 1
								&& eqCmp == 0) {
							j++;
						}
					}
				}
			}
			System.out.println("Case #" + k + ": " + j);
			k++;
		}
	}

	private static List<String> getline(String path) {
		List<String> ls = new ArrayList<String>();
		try {
			FileInputStream fstream = new FileInputStream(path);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				ls.add(strLine);
			}
			in.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		return ls;
	}
}
