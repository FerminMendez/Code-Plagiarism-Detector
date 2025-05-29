import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class DancingWiththeGooglers {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("dancing.in"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int Case =  Integer.parseInt(bf.readLine());
		int cCase = 1;
		while(Case > 0){
			String line = bf.readLine();
			String [] parts = line.trim().split("[ ]+");
			int [][] t = new int[Integer.parseInt(parts[0])][2];
			int S = Integer.parseInt(parts[1]);
			int p = Integer.parseInt(parts[2]);
			for (int i = 3; i < parts.length; i++){
				int sum = Integer.parseInt(parts[i]);
				if(sum == 0){
					t[i-3][0] = 0;
					t[i-3][1] = 0;
				}
				else if(sum == 1){
					t[i-3][0] = 1;
					t[i-3][1] = 1;
				}
				else if(sum == 2){
					t[i-3][0] = 1;
					t[i-3][1] = 2;
				}
				else{
					int caso = 0;
					if((sum-1)%3 == 0)caso = 1;
					double h = sum/3.0;
					int x = (int) Math.ceil(h);
					t[i-3][0] = x;
					if(caso == 1 || x == 10)t[i-3][1] = x;
					else t[i-3][1] = x+1;
					}
			}
			int count = 0;
			for(int i = 0; i < Integer.parseInt(parts[0]);i++){
				if(t[i][0] >= p)count++;
				else if(t[i][1] >= p && S>0){
					S--;
					count++;
				}
			}
			System.out.println("Case #"+cCase+": "+count);
			cCase++;
			Case--;
		}
	}

}
