public class DancingWithGooglers {
	public static int[] numbers(int given, boolean check, int p) {
		int[] solution = new int[3];
		int []answer= new int[2];
		int num = given / 3;
		int mod = given % 3;

		solution[0] = num;
		int remain = given - num;
		int newN = remain / 2;
		solution[1] = newN;
		solution[2] = remain - newN;

		if (solution[0] >= p || solution[1] >= p || solution[2] >= p) {
			answer[0]=1;
			answer[1]=0;
			return answer;
		}
		
		if (check) {
			answer[1]=1;
			if ((mod == 0)&&num!=0) {
				solution[0] = num - 1;
				solution[1] = num;
				solution[2] = num + 1;

			} else if ((mod == 1)&&num!=0) {
				solution[0] = num - 1;
				solution[1] = num + 1;
				solution[2] = num + 1;
			} else if (mod == 2) {
				solution[0] = num;
				solution[1] = num;
				solution[2] = num + 2;
			}
		}
		
		if (solution[0] >= p || solution[1] >= p || solution[2] >= p) {
			answer[0]=1;
			
			return answer;
		}
		// System.out.println(solution[0]);
		// System.out.println(solution[1]);
		// System.out.println(solution[2]);
		answer[0]=0;
		answer[1]=0;
		return answer;
		
	}

	public static void solve(String fname) {
		Read r = new Read();
		r.Read(fname);
		String fAnswer="";
		int numOfTest = r.noOfTestCases;
		int[] numOfPlayers = r.N;
		int[] numOfSurprising = r.S;
		int[] ps = r.p;
		int[][] nums = r.all;
		
		for (int i = 0; i < numOfTest; i++) {
			int numOfP = numOfPlayers[i];
			int numOfS = numOfSurprising[i];
			int p = ps[i];
			int[] numsCurr = nums[i];
			int surprised = 0;
			
			int maxNumber = 0;
			for (int j = 0; j < numsCurr.length; j++) {
				if (surprised < numOfS) {
					int []num ;
					num = numbers(numsCurr[j], true, p);
					maxNumber = maxNumber + num[0];
					surprised = surprised + num[1];
				} else {
					int []num ;
					num= numbers(numsCurr[j], false, p);
					maxNumber = maxNumber + num[0];
					surprised = surprised + num[1];
				}
			}
			String ans = "Case #" + (i + 1) + ": " +maxNumber;
			
			fAnswer=fAnswer+ans+"\n";
		}
		System.out.println(fAnswer);
		r.write("out", fAnswer);
	}

	public static void main(String[] args) {
		solve("test");
	}
}
