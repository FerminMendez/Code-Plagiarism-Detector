import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class main3 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader m = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(m.readLine());
	
		for (int i = 0; i < n; i++) {
			String cas = m.readLine();
			String [] a = cas.split(" ");
			int nofGoogler = Integer.parseInt(a[0]);
			int nofsurprising = Integer.parseInt(a[1]);
			int p = Integer.parseInt(a[2]);
			int check = (3*p) - 2;
			if (nofsurprising >0)
				check -=2;
			int count  = 0 ;
			int co  = 0 ;
			for (int j = 3; j < a.length; j++) {
				int c = Integer.parseInt(a[j]);
				if (c >= p && c >=check ){
					count++;
					if(nofsurprising >0 && c < (check+2))
						co++;
				}
			}
			if (co > nofsurprising)
				count -= (co-nofsurprising);
			System.out.print("Case #"+(i+1)+": "+count);

			System.out.print("\n");
		}

	}

}
