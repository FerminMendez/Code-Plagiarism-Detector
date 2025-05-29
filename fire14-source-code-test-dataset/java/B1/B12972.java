import java.io.*;
import java.util.StringTokenizer;


public class B {
	public static void main(String[] args) throws Exception 
	{
		BufferedReader bf = new BufferedReader(new FileReader("B.in"));
		System.setOut(new PrintStream("B.out"));
		int N = Integer.parseInt(bf.readLine()), caso = 1;
		while(N-->0){
			boolean matriz[][] = new boolean[1005][1005];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
			int min = Math.min(A, B), max = Math.max(A, B);
			int cont = 0;
			for(int j = min ;j<=max;j++){
				String num = j+"";
				for(int i=num.length()-1;i>=1;--i){
					String aux = num.substring(i)+num.substring(0,i);
					int m = Integer.parseInt(aux);
					String au = m+"";
					if(m>= min && m <= max && au.length() == num.length() && !matriz[j][m] && m != j ){
						cont++;
						matriz[m][j] = matriz[j][m]=true;
					}
				}
			}
			System.out.println("Case #"+(caso++)+": "+cont);
		}
	}

}
