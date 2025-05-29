import java.io.*;
import java.util.*;

public class DancingGooglers {
	public static void main(String args[]) {
		try {
			String strFileName = args[0];
			BufferedReader bfReader = new BufferedReader(new FileReader(strFileName));
			long nTestCases = Integer.parseInt(bfReader.readLine());
			
			for(int testCaseCounter=0;testCaseCounter<nTestCases;testCaseCounter++) {
				StringTokenizer st = new StringTokenizer(bfReader.readLine());
				int N = Integer.parseInt(st.nextToken());
				int S = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
								
				int i=0;
				int t[] = new int[N];
				while(st.hasMoreTokens()) {
					t[i++]=Integer.parseInt(st.nextToken());
				}
				
				int p1 = (p*3)-3;
				int p2 = (p*3)-4;
				int px = (p*3)-2;
				int ret=0;
				int s=0;
				
				for(i=0;i<N;i++) {
					if((t[i]>=p)&&(t[i]==p1||t[i]==p2))
						s++;
					else if((t[i]>=p)&&(t[i]>=px))
						ret++;
				}
				
				if(s<=S)
					ret+=s;
				else
					ret+=S;
				System.out.println("Case #" + (testCaseCounter+1) + ": " + ret);
			}
			
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
