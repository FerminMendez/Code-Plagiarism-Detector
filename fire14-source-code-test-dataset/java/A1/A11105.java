import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GoogleDancers {

	public Triplet findAddFactors(int n) {
		int m = n / 3;
		if (m==0)
			return new Triplet(m,m,m);
		int add = n % m;
		int nums[] = { m, m, m };
		while (add != 0) {
			nums[add]++;
			add--;
		}
		return new Triplet(nums);
	}

	public Triplet findSurprisingFactors(int n) {
		int m = n / 3;
		if (m==0)
			return new Triplet(m,m,m);
		int mod = n % m;
		if (mod == 2)
			return new Triplet(m, m, m + 2);
		else if (mod == 1)
			return new Triplet(m + 1, m + 1, m - 1);
		else
			return new Triplet(m - 1, m, m + 1);
	}

	public int findMaxAboveP(ArrayList<Triplet> scores, ArrayList<Triplet> surps, int surprises, int p) {
		int total = 0;
		int size = scores.size();
		for (int i=0; i<size; i++) {
			Triplet curr = scores.get(i);
			if (curr.getHighest() >= p) {
				total++;
			}else if (surps.get(i).getHighest() >= p && surprises!=0 && surps.get(i).getHighest() <= 10) {
				total++;
				surprises--;
			}
		}
		return total;
	}
	public static void main(String[] args) {
		GoogleDancers driver = new GoogleDancers();
		File input = new File("B-small-attempt1.in");
		if (!input.canRead()) {
			System.out.println("Cannot read from file!");
			System.exit(1);
		}
		ArrayList<Triplet> scores = new ArrayList<Triplet>();
		ArrayList<Triplet> surprising = new ArrayList<Triplet>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(input));
			int count = 1;
			String line;
			reader.readLine();		//get rid of first line
			while ((line = reader.readLine()) != null && !line.isEmpty()) {
				scores.clear();
				surprising.clear();
				StringTokenizer tokenizer = new StringTokenizer(line, " ");
				int numGooglers = Integer.parseInt(tokenizer.nextToken());
				int surprises = Integer.parseInt(tokenizer.nextToken());
				int p = Integer.parseInt(tokenizer.nextToken());
				while (tokenizer.hasMoreTokens()) {
					String token = tokenizer.nextToken();
					//System.out.println("parsed " + token);
					scores.add(driver.findAddFactors(Integer.parseInt(token)));
					surprising.add(driver.findSurprisingFactors(Integer.parseInt(token)));
				}
				System.out.println("Case #" + count+": " + driver.findMaxAboveP(scores, surprising, surprises, p));
				count++;
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	private class Triplet {
		int one, two, three, highest; // Three scores

		public Triplet(int[] nums) {
			this.one = nums[0];
			this.two = nums[1];
			this.three = nums[2];

			if (one >= two)
				highest = one;
			else
				highest = two;

			if (highest < three)
				highest = three;
		}

		public Triplet(int one, int two, int three) {
			this.one = one;
			this.two = two;
			this.three = three;

			if (one >= two)
				highest = one;
			else
				highest = two;

			if (highest < three)
				highest = three;
		}

		public String toString() {
			return one + ", " + two + ", " + three + "\n";
		}

		public int getHighest() {
			return highest;
		}
	}
}
