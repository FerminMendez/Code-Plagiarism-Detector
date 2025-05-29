import java.io.*;

public class Test3 {

	final static String INPUT_FILE_NAME = "input3";

	int T = 0;
	int q = 0;

	public static void main(String args[]) {
		try {
			Test3 tst = new Test3();
			tst.getInput();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getInput() throws Exception {
		File file = new File(INPUT_FILE_NAME);
		FileReader fis = new FileReader(file);
		BufferedReader br = new BufferedReader(fis);
		String strT = br.readLine();
		T = getInt(strT);

		for (int i=0; i<T; i++) {
			String strHead = br.readLine();
			String[] AandB = strHead.split(" ");
			int A = getInt(AandB[0]);
			int B = getInt(AandB[1]);

			//list kakunou
			execuse(i, A, B);
		}
	}

	private void execuse(int t, int A, int B) {
		int rtn = 0;
		int[] counts = new int[B+1];
		for (int i=0; i<=B;i++) {
			counts[i] = 0;
		}

		for (int i=A; i<=B;i++) {
			if (sortNumber(i)>0) {
				counts[sortNumber(i)]++;
			}
		}

		for (int i=0; i<=B;i++) {
//System.out.println("i="+i+" counts="+counts[i]);
			rtn += counts[i] * (counts[i]-1) / 2;
		}

		System.out.println("Case #"+(t+1)+": "+rtn);
		//System.out.println("Hello WorldI");
	}

	private int sortNumber(int i) {
		String str = String.valueOf(i);
		int keta = str.length();

		int min = i;
		String slideStr = str;
		for (int k=0; k<keta; k++) {
			slideStr = slideStr.substring(1)+slideStr.substring(0,1);
			if (min > getInt(slideStr)) {
				min = getInt(slideStr);
			}
		}

		return min;
	}

	private int getInt(String a) {
		return Integer.parseInt(a, 10);
	}

	private int getIntx(String a) {
		if (a.equals(".")) {
			return 0;
		}
		return 1;
	}

}
