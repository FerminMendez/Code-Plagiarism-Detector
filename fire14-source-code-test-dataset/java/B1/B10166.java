import java.io.*;
import java.io.InputStreamReader;
import java.util.*;


public class b {
	static TreeSet<int[]> set;
	static boolean[][] matriz;
	static int cantidad;
	public static void main(String[] args) throws Throwable {
		BufferedReader bf = new BufferedReader(new FileReader("b.txt"));
		System.setOut(new PrintStream("b.out"));
		int casos = Integer.parseInt(bf.readLine());
		for (int i = 0; i < casos; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			matriz = new boolean[1001][1001];
			cantidad = 0;
			set=new TreeSet<int[]>(new Comparator<int[]>(){
				public int compare(int[] arg0, int[] arg1) {
					return 0;
				}
				
			});
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int min = Math.min(a, b); int max = Math.max(a, b);
			for (int j = min; j <= max; j++) {
				calcular(j, min, max);
			}
			System.out.println("Case #"+(i+1)+": "+cantidad);
		}
		
	}

	private static void calcular(int a , int min , int max) {
		String n = a+"";
		for (int i = 1; i < n.length(); i++) {
			String copia = n.substring(i)+n.substring(0,i);
			int c = Integer.parseInt(copia);
			String c2 = c+"";
			if(c!=a&&  c2.length()==n.length() &&  min <= c  && c <= max ){
				if( !matriz[a][c] ){
					matriz[a][c] = true;
					matriz[c][a] = true;
					cantidad++;
				}
			}
		}
	}

}
