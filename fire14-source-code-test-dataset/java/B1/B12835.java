import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;


public class E3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner sc = null;
		
		sc = new Scanner(System.in);
		
		/*try {
			sc = new Scanner(new File("E3.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		int fases = sc.nextInt();
		
		
		for(int j=1; j<=fases; ++j){
			
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int casos = 0;
			
			for(int k=n1; k<=n2; ++k){
				String s = k + "";
				
				int l = s.length();
				
				ArrayList<Integer> arr = new ArrayList<Integer>();
				
				for(int i=1; i<l; ++i){
					String s2 = s.substring(i) + s.substring(0, i);
					
					if(s2.startsWith("0"))
						continue;
					
					int ns = Integer.parseInt(s2);
					
					if(ns >= n1 && ns <= n2 && ns != k && !arr.contains(ns)){
						
						casos++;
						arr.add(ns);
						//System.out.println(ns);
					}
				}
				
			}
			
			System.out.println("Case #" + j + ": " + casos / 2);
		}
		
		
	}

}
