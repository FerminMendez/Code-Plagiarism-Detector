import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {

	public static void readFile() throws FileNotFoundException {
		File f = new File("C-small.in");
		Scanner in = new Scanner(f);
		PrintWriter out = new PrintWriter(new File("C-small"));

		Set<Pair> setOfFound = new HashSet<C.Pair>();
		// List<Pair> setOfFound = new ArrayList<C.Pair>();
		// Set<Pair> setOfNotFound;
		C c = new C();

		// System.out.println(c.new Pair(1, 2).compareTo(c.new Pair(2, 1)));
		// setOfFound.add(c.new Pair(1, 2));
		// setOfFound.add(c.new Pair(2, 1));
		// setOfFound.add(c.new Pair(1, 2));
		// for (Pair p : setOfFound)
		// System.out.println(p);

		int T = in.nextInt();
		// System.out.println("T: " + T);
		int A, B, strLength, newNbInt;
		String nbStr, newNbStr;

		for (int i = 0; i < T; i++) {
			setOfFound = new HashSet<C.Pair>();
			// setOfFound = new ArrayList<C.Pair>();
			// setOfNotFound = new HashSet<C.Pair>();

			A = in.nextInt();
			B = in.nextInt();
			// System.out.println("A: " + A + "--B: " + B);

			if (B > 9) {
				for (int j = A; j <= B; j++) {
					// if (i == 3)
					// System.out.println("j: " + j);
					nbStr = newNbStr = "" + j;

					strLength = nbStr.length();
					for (int k = 0; k < strLength - 1; k++) {
						// if (i == 3)
						// System.out.println("newNbStr1: " + newNbStr);
						newNbStr = newNbStr.charAt(strLength - 1)
								+ newNbStr.substring(0, strLength - 1);

						if (newNbStr.indexOf("0") == 0) {
							continue;
						}
						// if (i == 3)
						// System.out.println("newNbStr: " + newNbStr);
						if (!nbStr.equals(newNbStr)) {
							newNbInt = Integer.parseInt(newNbStr);
							if (newNbInt >= A && newNbInt <= B) {
								setOfFound.add(c.new Pair(j, newNbInt));
								// if (i == 3)
								// System.out.println("added: " + newNbInt);
							}
							// else {
							// setOfNotFound.add(c.new Pair(j, newNbInt));
							// }
						}

					}
				}
			} else {
				// System.out.println("1 digit => finish: 0");
			}

			// System.out.println("Founnnnnnnnnnnnnnnnd / 2: " +
			// setOfFound.size() / 2);
			if (i < T - 1)
				out.println("Case #" + (i + 1) + ": " + setOfFound.size() / 2);
			else
				out.print("Case #" + (i + 1) + ": " + setOfFound.size() / 2);
			// if (i == 3) {
			// for (Pair p : setOfFound)
			// System.out.println(p);
			// }
		}

		out.close();
	}

	public static void main(String[] args) throws FileNotFoundException {
		readFile();

	}

	public class Pair implements Comparable<Pair> {
		int A;
		int B;

		public Pair(int A, int B) {
			this.A = A;
			this.B = B;
		}

		public Pair() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final Pair other = (Pair) obj;
			if (this.A == other.A && this.B == other.B || this.A == other.B
					&& this.B == other.A) {
				return true;
			}
			return false;
		}

		@Override
		public int hashCode() {
			int hash = 7;
			hash = 79 * hash + this.A;
			hash = 79 * hash + this.B;
			return hash;
		}

		@Override
		public String toString() {
			return "A = " + A + " || B = " + B;
		}

		@Override
		public int compareTo(Pair other) {
			if (this.A == other.A && this.B == other.B || this.A == other.B
					&& this.B == other.A) {
				return 0;
			}
			return 1;
		}

	}

}
