import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class DancingWithTheGooglers {
	
	public static void main(String[] args) {
		
		try {
		
			//int T = 4;
			//int[][] testcases = new int[T][];
//			testcases[0] = new int[]{3,1,5,15,13,11};
//			testcases[1] = new int[]{3,0,8,23,22,21};
//			testcases[2] = new int[]{2,1,1,8,0};
//			testcases[3] = new int[]{6,2,8,29,20,8,18,18,21};
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("B-small-attempt0.in")));
			
			String firstLine = reader.readLine();
			int T = Integer.valueOf(firstLine);
			int[][] testcases = new int[T][];
			
			for(int i = 0; i < T; i++) {
				String[] testcase = reader.readLine().split(" ");				
				int N = Integer.valueOf(testcase[0]);
				testcases[i] = new int[3+N];
				testcases[i][0] = N;
				testcases[i][1] = Integer.valueOf(testcase[1]);
				testcases[i][2] = Integer.valueOf(testcase[2]);
				for(int j = 3; j < N+3; j++) {
					testcases[i][j] = Integer.valueOf(testcase[j]);
				}
				
			}
			
			DancingWithTheGooglers dancing = new DancingWithTheGooglers();
			
			System.out.println("Output");
			
			for(int i = 0; i < T; i++) {
				System.out.printf("Case #%d: ",i+1,testcases[i]);
				int result = dancing.maximum(testcases[i]);
				System.out.printf("%s\n", result);
			}
			
		}
		catch(Exception ex) {
			System.out.println("An error occured:\n");
			ex.printStackTrace();
		}
		
		
	}
	
	public int maximum(int[] input) {
		
		int N = input[0];
		int S = input[1];
		int p = input[2];
		
		int hits = 0;
		
		// create the set of possible triplets without considering the surprising triplet of scores
		for(int i = 0; i < N; i++) {
						
			boolean hit = false;
			int totalpoints = input[3+i];
			
			for(int x = 10; x >= p; x--) {
				
				int r1 = totalpoints - x;
				r1 = r1 - x;
				if(r1 == x || r1 == x-1) {
					hits++;
					hit = true;
					break;
				}
				
				int r2 = totalpoints - x;
				r2 = r2 - (x - 1);
				if(r2 == x || r2 == x-1) {
					hits++;
					hit = true;
					break;
				}
				
				int r3 = totalpoints - (x - 1);
				r3 = r3 - x;
				if(r3 == x || r3 == x-1) {
					hits++;
					hit = true;
					break;
				}
				
			}
			
			if(hit == false && S > 0) {
				for(int x = 10; x >= p && x >= 2; x--) {
										
					int r21 = totalpoints - x;
					r21 = r21 - (x - 2);
					if(r21 == x || r21 == x-1) {
						hits++;
						S--;
						break;
					}
					
					int r22 = totalpoints - x;
					r22 = r22 - (x - 1);
					if(r22 == x || r22 == x-2) {
						hits++;
						S--;
						break;
					}
					
					int r23 = totalpoints - x;
					r23 = r23 - (x - 2);
					if(r23 == x || r23 == x-2) {
						hits++;
						S--;
						break;
					}
					
					int r31 = totalpoints - x;
					r31 = r31 - (x - 2);
					if(r31 == x || r31 == x-1) {
						hits++;
						S--;
						break;
					}
					
					int r32 = totalpoints - x;
					r32 = r32 - (x - 1);
					if(r32 == x || r32 == x-2) {
						hits++;
						S--;
						break;
					}				
				}
			}
		}
		
		return hits;
		
	}

}
