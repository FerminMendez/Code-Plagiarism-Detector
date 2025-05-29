import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class DancingWithTheGooglers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int T = -1;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Input");
		try {
			T = Integer.valueOf(br.readLine()).intValue();
		} catch (NumberFormatException e) {
			System.out.println("Plz input the Numbers.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Application will be terminated.");
			e.printStackTrace();
		}
		
		if (T < 1 || T > 100) {
			System.out.println("Input value should be larger than 0, also smaller than 100.");
			return ;
		}
		
		ArrayList<Info> info = new ArrayList<Info>();
		
		String s = null;
		
		int fromIndex = 0, toIndex = -1;
		
		for (int i = 0; i < T; i++) {
			Info temp = new Info();
			try {
				s = br.readLine();
//				System.out.println("s : " + s);
				toIndex = s.indexOf(" ", fromIndex);

				temp.N = Integer.parseInt(s.substring(fromIndex, toIndex));
				if (temp.N < 1 || temp.N > 101) {
					System.out.println("N value should be larger than 0, also smaller than 101.");
					return ;
				}
				temp.points = new int[temp.N];
				
				fromIndex = toIndex + 1;
				toIndex = s.indexOf(" ", fromIndex);
				temp.S = Integer.parseInt(s.substring(fromIndex, toIndex));
				if (temp.S < 0 || temp.S > temp.N) {
					System.out.println("S value should be larger than -1, also smaller than N.");
					return ;
				}
				
				fromIndex = toIndex + 1;
				toIndex = s.indexOf(" ", fromIndex);
				temp.P = Integer.parseInt(s.substring(fromIndex, toIndex));
				if (temp.P < 0 || temp.P > 10) {
					System.out.println("P value should be larger than -1, also smaller than 11.");
					return ;
				}
				
				for (int j = 0; j < temp.N; j++) {
					fromIndex = toIndex + 1;
					toIndex = s.indexOf(" ", fromIndex);
					
					if (toIndex == -1)
						temp.points[j] = Integer.parseInt(s.substring(fromIndex));
					else
						temp.points[j] = Integer.parseInt(s.substring(fromIndex, toIndex));
					
					if (temp.points[j] < 0 || temp.points[j] > 30) {
						System.out.println("points value should be larger than -1, also smaller than 31.");
						return ;
					}
				}
//				int swap;
//				for (int j = 0; j + 1 < temp.N; j++) {
//					if (temp.points[j] > temp.points[j+1]) {
//						swap = temp.points[j + 1];
//						temp.points[j + 1] = temp.points[j];
//						temp.points[j] = swap;
//					}
//				}

				fromIndex = 0;

			} catch (IOException e) {
				System.out.println("Application will be terminated.");
				e.printStackTrace();
			}
//			System.out.println("temp.N : " + String.valueOf(temp.N));
//			System.out.println("temp.S : " + String.valueOf(temp.S));
//			System.out.println("temp.P : " + String.valueOf(temp.P));
//			for (int j = 0; j < temp.N; j++) {
//				System.out.println("temp.points[" + String.valueOf(j) + "] : " + String.valueOf(temp.points[j]));
//			}
			
			info.add(temp);
		}
		System.out.println("Output");
		for (int i = 0; i < info.size(); i++) {
			System.out.print("Case #" + String.valueOf(i + 1) + ": ");
			System.out.println(String.valueOf(overPersonCheck(info.get(i))));
		}
	}
	
	private static int overPersonCheck(Info info) {
		int count = 0;
		int surprisingNum = info.S;

		for (int i = 0; i < info.N; i++) {
			if (info.P == 0) {
				count++;
				continue ;
			} else if (info.points[i] == 0) {
				continue ;
			}
			
			if (info.points[i] >= info.P * 3) {
				count++;
			} else if (info.points[i] >= info.P * 3 - 2) {
				count++;
			} else if (info.points[i] >= info.P * 3 - 4 && surprisingNum > 0) {
				count++;
				surprisingNum--;
			}
		}

		return count;
	}

}

class Info {
	int N;
	int S;
	int P;
	int[] points;
}
