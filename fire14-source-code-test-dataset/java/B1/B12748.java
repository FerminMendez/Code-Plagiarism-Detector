import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.PrintWriter;

public class C {
	InputScanner s = new InputScanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		C program = new C();
		program.begin();
	}

	int prev;
	int current;
	
	int ansA;
	int ansB;
	
	int A;
	int B;
	
	public void begin() {
		int T = s.nextInt();
		
		for(int t=1;t<=T;t++) {
			A = s.nextInt();
			B = s.nextInt();
			prev = 0;
			for(int i=A-1;i<=B;i++) {
			current =prev+recycleCount(i);
			prev = current;
			//system.out.println(i+" CURRENT: "+current);
			if(i == A-1) ansA = current;
			}
			
			out.printf("Case #%d: %d\n",t,current-ansA);
		}
		out.close();
	}

	public int recycleCount(int x) {
		////system.out.println("-----");
		ArrayList<String> store = new ArrayList<String>();
		//system.out.print(x+" => ");
		int count = 0;
		String num = x+"";
		
		int a = 0;
		int b = 0;
		for(int i=1;i<num.length();i++) {
			String temp ="";
			for(int j=i,k=0;temp.length()<num.length();j=(j+1)%num.length(),k++) {
				////system.out.println(j);
				temp+=num.charAt(j);
				/*if(num.charAt(j)!='0') {
					b = k;
					if(a==0)
					a = k;
				}*/
				
			}
			/*//system.out.println(a+" "+b);
			temp = temp.substring(a, b+1);*/
			int val = Integer.parseInt(temp);
			
			if(val < x && (val+"").length() == num.length() && val >= A && !store.contains(val+"")) {
				count++;
				store.add(val+"");
				//system.out.print(" "+val);
				//system.out.print("*");
			}
		}
		//system.out.println();
		//system.out.println(count+"c");
		////system.out.println("-----");
		return count;
		
		
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