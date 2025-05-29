import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class DancingWithTheGooglers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"C:\\bInput.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter(
					"C:\\bOutput.txt"));
			String strLine;
			strLine = br.readLine();
			int size = Integer.parseInt(strLine);
			for (int i = 1; i <= size; i++) {
				String[] s = br.readLine().split(" ");
				int N = Integer.parseInt(s[0]);
				int S = Integer.parseInt(s[1]);
				int p = Integer.parseInt(s[2]);
				int[] totals = new int[N];
				for(int j=0;j<N;j++){
					totals[j] = Integer.parseInt(s[3+j]);
				}
				int res = FindMaximumBests(totals,N,S,p);
				bw.write("Case #" + i + ": " + res);
				bw.newLine();
			}
			bw.close();
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static int FindMaximumBests(int[] totals, int N, int S, int p) {
		int aboveP = 0;
		int potentialAboveP = 0;
		for (int i = 0; i<N; i++){
			if (totals[i]%3==0){
				if(totals[i]/3>=p)
					aboveP++;
				else if (totals[i]/3==(p-1)){
					if (totals[i]/3==0)//special exception when 0 can't get lower...
						continue;
					potentialAboveP++;
				}
			}
			else if (totals[i]%3==2){
				if((totals[i]/3+1)>=p)
					aboveP++;
				else if ((totals[i]/3+1)==(p-1))
					potentialAboveP++;
			}
			else{
				if((totals[i]/3+1)>=p)
					aboveP++;
			}
		}
		return aboveP + Math.min(S, potentialAboveP);
	}
	
	

}
