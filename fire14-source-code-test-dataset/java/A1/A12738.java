import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) throws Exception {
		PrintWriter out = new PrintWriter(new FileOutputStream(new File("output.txt")), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
		// StringTokenizer st = new StringTokenizer(in.readLine());
		// Scanner s = new Scanner(System.in);
		int t = Integer.parseInt(in.readLine());
		for(int a = 0;a < t;a++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			Map<Integer,ArrayList<Decompose>> map = new TreeMap<>();
			ArrayList<Integer> scores = new ArrayList<>();
			
			for(int m = 0;m < n;m++) {
				int g = Integer.parseInt(st.nextToken());
				scores.add(g);
				map.put(g, dec(g));
				//out.println(dec(g).toString());
			}
			
			int colSurpWinAndWin = 0;
			int colSurpWin = 0;
			int colWin = 0;
			for(int i = 0;i < n;i++) {
				if(isDecomposeThere(map.get(scores.get(i)),p,true) && isDecomposeThere(map.get(scores.get(i)),p,false)) {
					 colSurpWinAndWin++;
				}else if(isDecomposeThere(map.get(scores.get(i)),p,true)) {
					colSurpWin++;
				}else if(isDecomposeThere(map.get(scores.get(i)),p,false)) {
					colWin++;
				}
			}
			
			//out.println(colSurpWinAndWin+" "+colSurpWin+" "+colWin);
			
			if(colSurpWin >= s) {
				out.println("Case #"+(a+1)+": "+(s+colWin+colSurpWinAndWin));
			}else{
				s -= colSurpWin;
				out.println("Case #"+(a+1)+": "+(colSurpWin+colSurpWinAndWin+colWin));
			}
			
		}
		
	}
	
	public static boolean isDecomposeThere(ArrayList<Decompose> decomposes, int p, boolean surprise) {
		for(Decompose dec : decomposes) {
			if(dec.a >= p && dec.surprise == surprise) return true;
		}
		return false;
	}
	
	public static ArrayList<Decompose> dec(int n) {
		ArrayList<Decompose> list = new ArrayList<>();
		for(int i = 0;i <= 10;i++) {
			for(int j = 0;j <= i;j++) {
				for(int k = 0;k <= j;k++) {
					if(i - j <= 2 && j - k <= 2 && i - k <= 2 && i+j+k == n) {
						boolean surprise = (i-j == 2 || j-k == 2 || i-k == 2);
						list.add(new Decompose(i,j,k,surprise));
					}
				}
			}
		}
		return list;
	}

}

class Decompose {
	int a, b, c;
	boolean surprise;
	
	public Decompose(int a, int b, int c, boolean surprise) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.surprise = surprise;
	}
	
	@Override
	public String  toString() {
		return ""+a+" "+b+" "+c+" "+surprise;
	}
}