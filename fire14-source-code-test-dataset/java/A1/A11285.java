import java.io.*;

public class Qualifying_B {

	public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new FileReader(args[0]));
        int T = Integer.parseInt(input.readLine());
        
        for (int t = 1; t <= T; t++) {
        	String[] tokens = input.readLine().split(" ");
        	
        	int N = Integer.parseInt(tokens[0]);
        	int S = Integer.parseInt(tokens[1]);
        	int p = Integer.parseInt(tokens[2]);
        	int[][] Googlers = new int[N][3];
        	
        	for (int n = 0; n < N; n++) {
        		Googlers[n][0] = Integer.parseInt(tokens[3 + n]);
        		Googlers[n][1] = Googlers[n][0] / 3 + ((Googlers[n][0] % 3 != 0) ? 1 : 0);
        		Googlers[n][2] = (Googlers[n][0] < 2 || Googlers[n][0] > 28) ? -1 : (Googlers[n][0] - 2) / 3 + 2;
        	}

        	int m = 0;
        	
        	for (int n = 0; n < N; n++) {
        		if (Googlers[n][1] >= p)
        			m++;
        		else if (Googlers[n][2] >= p && S > 0) {
        			S--;
        			m++;
        		}
        	}
        	
        	System.out.println("Case #" + t + ": " + m);
        }		
	}
}
