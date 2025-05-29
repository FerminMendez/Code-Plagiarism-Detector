import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public class DancingWithTheGooglers {

	public class TestItem {
		
		int n;
		int s;
		int p;
		Vector t;
		int count;
		
		TestItem () {
			t = new Vector();
			count = 0;
		}

		public int getN() {
			return n;
		}

		public void setN(int n) {
			this.n = n;
			this.t.ensureCapacity(n);
		}

		public int getS() {
			return s;
		}

		public void setS(int s) {
			this.s = s;
		}

		public int getP() {
			return p;
		}

		public void setP(int p) {
			this.p = p;
		}
		
		public Vector getT() {
			return t;
		}
		
		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}
		
		public void calculate() {
			int tripleP = 3*p;
			for (int i = 0; i < n; i++) {
				int ti = (Integer) t.get(i);
				if (ti - p >= 0) {
					int delta = tripleP - ti;
					if (delta <= 4) {
						if (delta < 3) {
							count++;
						}
						else {
							if (s > 0) {
								s--;
								count++;
							}
						}
					}
				}
			}
		}

	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length > 0) {
			String inputFileName = args[0];
			try {
				DancingWithTheGooglers dwtg = new DancingWithTheGooglers();
				FileInputStream fstream = new FileInputStream(inputFileName);
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String strLine = br.readLine();
				String stringArray[] = strLine.split("\\s+");
				int T = (new Integer(stringArray[0])).intValue();
				;
				;
				;
				;
				for (int i = 1; i <= T; i++) {
					String stringTestData = br.readLine();
//					System.out.println(stringTestData);
					String stringTestDataArray[] = stringTestData.split("\\s+");
					
/*				for (int k = 0; k < stringTestDataArray.length; k++) {
					System.out.println(stringTestDataArray[k]);
				}
*/
					TestItem testItem = dwtg.new TestItem();
					testItem.setN((new Integer(stringTestDataArray[0])).intValue());
					testItem.setS((new Integer(stringTestDataArray[1])).intValue());
					testItem.setP((new Integer(stringTestDataArray[2])).intValue());
					int limit = testItem.getN() + 3;
					for (int j = 3; j < limit; j++) {
						testItem.getT().add((new Integer(stringTestDataArray[j])).intValue());
					}
					testItem.calculate();
					System.out.println("Case #" + i + ": " + testItem.getCount());
				}
/*				for (String s : stringArray) {
					System.out.println (s);
				}*/
/*				while ((strLine = br.readLine()) != null) {
					System.out.println (strLine);
				}*/
				in.close();
			}
			catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
			}		
		}
	}
	
	void test() {
		TestItem testItem = new TestItem();
		System.out.println("Test size: " + testItem.getT().size());
		testItem.setN(5);
		System.out.println("Test size: " + testItem.getT().size());
		testItem.t.add(1);
		System.out.println("Test size: " + testItem.getT().size());
	}

}
