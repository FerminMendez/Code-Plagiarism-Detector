import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DancingSolution {

	public static void main(String[] args) {
		String inFilename = "B-small-attempt0.in";
		String outFilename = inFilename.substring(0, inFilename.length() - 3)
				+ ".out";
		try {
			Scanner sc = new Scanner(new File(inFilename));
			PrintStream ps = new PrintStream(new FileOutputStream(outFilename));
			int testCases = Integer.parseInt(sc.nextLine());
			for (int i = 1; i <= testCases; i++) {
				if (i > 1) {
					ps.println();
				}
				String data = sc.nextLine();
				String[] dataParts = data.split(" ");
				int googlers = Integer.parseInt(dataParts[0]);
				int surprising = Integer.parseInt(dataParts[1]);
				int minScore = Integer.parseInt(dataParts[2]);
				int found = 0;
				for (int person = 0; person < googlers; person++) {
					int theirScore = Integer.parseInt(dataParts[person + 3]);
					if (findUnsurprisingFor(theirScore).containsAtLeast(
							minScore)) {
						found++;
						continue;
					} else if (surprising > 0) {
						Set<Triplet> surprisingScores = findSurprisingFor(theirScore);
						for (Triplet score : surprisingScores) {
							if (score.containsAtLeast(minScore)) {
								found++;
								surprising--;
								break;
							}
						}
					}
				}
				System.out.println("Case #" + i + ": " + found);
				ps.print("Case #" + i + ": " + found);
			}
			sc.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Triplet findUnsurprisingFor(int number) {
		int biggestBit = (int) Math.ceil(number / 3.0);
		int smallerBit = biggestBit - 1;
		Triplet answer = new Triplet();
		for (int i = 0; i < 3; i++) {
			if ((3 - i) * biggestBit + i * smallerBit == number) {
				for (int j = 0; j < 3 - i; j++) {
					answer.addComponent(biggestBit);
				}
				for (int j = 0; j < i; j++) {
					answer.addComponent(smallerBit);
				}
				break;
			}
		}
		return answer;
	}

	public static Set<Triplet> findSurprisingFor(int number) {
		Set<Triplet> solutions = new HashSet<Triplet>();
		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= 10; j++) {
				for (int k = 0; k <= 10; k++) {
					if (i + j + k == number) {
						if (Math.abs(k - i) <= 2 && Math.abs(k - j) <= 2
								&& Math.abs(j - i) <= 2) {
							if (Math.abs(k - i) == 2 || Math.abs(k - j) == 2
									|| Math.abs(j - i) == 2) {
								solutions.add(new Triplet(i, j, k));
							}
						}
					}
				}
			}
		}
		return solutions;
	}

	public static class Triplet {
		public int x, y, z;
		private int idx = 0;
		boolean isOrdered = false;

		public Triplet() {
		}

		private Triplet(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.idx = 3;
			this.isOrdered = true;
		}

		public void addComponent(int component) {
			if (idx == 0) {
				x = component;
			} else if (idx == 1) {
				y = component;
			} else {
				z = component;
			}
			idx++;
		}

		public boolean containsAtLeast(int num) {
			return (x >= num || y >= num || z >= num);
		}

		public Triplet orderedSet() {
			List<Integer> t = Arrays.asList(new Integer[] { x, y, z });
			Collections.sort(t);
			return new Triplet(t.get(0), t.get(1), t.get(2));

		}

		@Override
		public int hashCode() {
			if (isOrdered) {
				final int prime = 31;
				int result = 1;
				result = result * prime + x;
				result = result * prime + y;
				result = result * prime + z;
				return result;
			} else {
				return orderedSet().hashCode();
			}
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Triplet other = ((Triplet) obj).orderedSet();
			if (isOrdered) {
				if (x != other.x)
					return false;
				if (y != other.y)
					return false;
				if (z != other.z)
					return false;
				return true;
			} else {
				Triplet myOrder = orderedSet();
				if (myOrder.x != other.x)
					return false;
				if (myOrder.y != other.y)
					return false;
				if (myOrder.z != other.z)
					return false;
				return true;
			}
		}
	}

}
