import java.io.*;

public class Test2 {

	final static String INPUT_FILE_NAME = "input2";

	int T = 0;
	int q = 0;

	public static void main(String args[]) {
		try {
			Test2 tst = new Test2();
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
			String[] strHairetsu = strHead.split(" ");
			int N = getInt(strHairetsu[0]);
			int S = getInt(strHairetsu[1]);
			int P = getInt(strHairetsu[2]);
			int[] t = new int[N];
			for (int j=0; j<N; j++) {
				t[j] = getInt(strHairetsu[3+j]);
			}

			//list kakunou
			execuse(i, N, S, P, t);
		}
	}

	private void execuse(int num, int N, int S, int P,int[] t) {

		int count =0;
		for (int i=0; i<N; i++) {
			int mod3 =t[i] % 3;
			if (mod3==0) {
				if (t[i] == 0) {
					if (P==0) {
						count++;
					}
				} else if (t[i]/3 >= P) {
					count++;
				} else if ((t[i]/3 >= (P-1)) && S>0) {
					S--;
					count++;
				} 
			} else if (mod3 ==2) {
				if (t[i]/3 >= P-1) {
					count++;
				} else if ((t[i]/3 >= (P-2)) && S>0) {
					S--;
					count++;
				} 
			} else {
				if (t[i]/3 >= P-1) {
					count++;
				}
			}
		}


		System.out.println("Case #"+(num+1)+": "+count);
		//System.out.println("Hello WorldÅI");
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
