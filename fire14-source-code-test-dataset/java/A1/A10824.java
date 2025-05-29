import java.io.BufferedReader;
import java.io.InputStreamReader;


public class R0_2_2012 {

	public static void main(String[] args) {
		
		try {
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			
			int T = Integer.parseInt(bf.readLine());
			
			for (int i=0; i<T; i++) {
				
				String[] strTemp = bf.readLine().split(" ");
				int N = Integer.parseInt(strTemp[0]);
				int S = Integer.parseInt(strTemp[1]);
				int p = Integer.parseInt(strTemp[2]);
				int count = 0;
				
				for (int j=0; j<N; j++) {
					
					int t = Integer.parseInt(strTemp[j+3]);
					int regular = -1;
					int surprising = -1;
					
					if (t%3 == 2) {
						regular = (t-t%3) / 3 + 1;
						if (t>1 && t<29) surprising = (t-t%3) / 3 + 2;
					} else {
						regular = (t-t%3)/3 + t%3;
						if (t>1 && t<29) surprising = (t-t%3)/3 + 1;
					}
					
					if (regular >= p) 
						count++;
					else if (surprising >= p && S>0) {
						count ++;
						S--;
					}
					
				}
				
				System.out.println("Case #" + (i+1) + ": " + count);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
