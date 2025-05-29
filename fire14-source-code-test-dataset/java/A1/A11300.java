import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class GoogleDance {
	
	public static void main(String args[]) throws Exception{
		String line = "";
		BufferedReader br =	new BufferedReader(new FileReader("/Users/ravipalacherla/Documents/workspace/CodeJam/src/input.txt"));
		int T = Integer.parseInt(br.readLine());
		int answer = 0, j =0;
		while((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line," ");
			while(st.hasMoreTokens()) {
				int N = Integer.parseInt(st.nextToken());
				int S = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				int usedS = 0;
				int result = 0;
				//LinkedList<Integer> totalPoints = new LinkedList<Integer>();
				for(int i =0;i<N;i++) {
					//totalPoints.add(Integer.parseInt(st.nextToken()));
					int totalPoint = Integer.parseInt(st.nextToken());
					if(totalPoint < p) {
						continue;
					}
					if(p <= 0) {
						result++;
						continue;
					}
					if(totalPoint >= p+(2*(p-1))) {
						result++;
					} else if ( totalPoint >= p+(2*(p-2)) && totalPoint < p+(2*(p-1)) && usedS < S) {
						usedS++;
						result++;
					}
				}
				j++;
				System.out.println("Case #"+ j +": "+result);
			}
		}
		
	}

}
