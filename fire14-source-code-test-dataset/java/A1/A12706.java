import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.PrintWriter;

public class B {
	InputScanner s = new InputScanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		B program = new B();
		program.begin();
	}

	
	int storage[][] = new int[110][4];
	public void begin() {
		int T = s.nextInt();
		for(int t=1;t<=T;t++) {
			int N = s.nextInt();
			int S = s.nextInt();
			int P = s.nextInt();
			
			int initialCount = 0;
			//int surpriseCount = 0;
			
			int temp[] = new int[4];
			for(int n=0;n<N;n++) {
				int c = s.nextInt();
				int div = Math.round(c/3.0f);
				
				storage[n][0] = div;
				storage[n][1] = div;
				storage[n][2] = c - 2*div;
				if(storage[n][0] >= P || storage[n][2] >= P) 
					{
					//System.out.println(storage[n][0]+" "+storage[n][2]);
					storage[n][3] = 1;
					initialCount++;
					}
				else {
					if(S>0) {
						temp[0] = P;
						
						int res = c - P;
						if(res > 0) {
							int div2 = res/2;
							temp[1] = div2;
					
							if(Math.abs(temp[0]-temp[1]) <= 2) {
								temp[2] = res - div2;
								if(Math.abs(temp[0]-temp[2]) <= 2 && Math.abs(temp[1]-temp[2]) <= 2) {
									S--;
									storage[n] = temp;
									initialCount++;
								}
								}
							}
						}
					}
				}
			
			
			
			/*System.out.println(initialCount);
			for(int n=0;n<N;n++)
				System.out.println(Arrays.toString(storage[n]));*/
			out.printf("Case #%d: %d\n",t,initialCount);
		}
		out.close();
	}

	class InputScanner {
		BufferedReader br;
		StringTokenizer strtok = null;

		public InputScanner(InputStream stream) {
			br = new BufferedReader(new InputStreamReader(stream));

		}

		public InputScanner(File file) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(file));
		}

		public String next() {
			if (strtok == null || !strtok.hasMoreTokens()) {
				try {
					strtok = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return strtok.nextToken();
		}

		public int nextInt() {
			int i;
			try {
				i = Integer.parseInt(next());
			} catch (NumberFormatException e) {
				throw new RuntimeException(e);
			}
			return i;
		}

		public String nextLine() {
			if (strtok == null || !strtok.hasMoreTokens()) {
				try {
					strtok = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return strtok.nextToken("\n").trim();
		}

	}

}