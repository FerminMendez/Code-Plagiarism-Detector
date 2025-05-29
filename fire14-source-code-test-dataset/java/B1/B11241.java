import java.util.List;
import java.util.Vector;

public class DataModel extends Thread {

	class Data {
		private int no;
		private List<Integer> pairs;

		public Data(int no) {
			this.no = no;
			pairs = new Vector<Integer>();
		}

		public void addToList(int no) {
			pairs.add(no);
		}

		public int getPairs() {
			int p = 0;
			for (Integer i : pairs) {
				if (i != no)
					p++;
			}
			return p;
		}

		public boolean isInList(int i) {
			return pairs.contains(i);
		}

	}

	private int lowBound;
	private int highBound;
	private int caseNo;
	private Data[] range;
	private int output;
	private boolean stateCalc;

	public DataModel(String input, int caseNo) {
		this.caseNo = caseNo;
		String[] temp = input.split(" ");
		stateCalc = false;
		try {
			lowBound = Integer.parseInt(temp[0]);
			highBound = Integer.parseInt(temp[1]);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		range = new Data[highBound - lowBound + 1];
		for (int i = lowBound; i <= highBound; i++) {
			range[i - lowBound] = new Data(i);
		}
	}

	@Override
	public void run() {
		char[] split;
		int splitOn;
		for (int i = lowBound; i <= highBound; i++) {
			split = (i + "").toCharArray();
			if (split.length == 1) {
				output = 0;
				break;
			}
			for (int j = 0; j < split.length; j++) {

				splitOn = splitOnPos(split, j);
				if (splitOn <= highBound && splitOn >= lowBound && splitOn != i) {
					if (!range[i - lowBound].isInList(splitOn)) {
						range[i - lowBound].addToList(splitOn);
					}
				}
			}
		}
		calcOut();

		stateCalc = true;
	}

	private void calcOut() {
		for (int i = 0; i < range.length; i++) {
			for (int j = 0; j < range[i].getPairs(); j++)
				output++;
		}
		output /= 2;
	}

	private int splitOnPos(char[] arr, int splitpos) {
		StringBuilder sb = new StringBuilder();
		for (int i = splitpos; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		for (int i = 0; i < splitpos; i++) {
			sb.append(arr[i]);
		}
		return Integer.parseInt(sb.toString());
	}

	public boolean isDone() {
		return stateCalc;
	}

	public void getOutput() {
		System.out.println("Case #" + caseNo + ": " + output);
	}
}