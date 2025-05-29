import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;


public class Second {

	public static void main(String[] args) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("input.txt")));
			PrintWriter writer = new PrintWriter(new FileWriter(new File("output.txt")));
			reader.readLine(); // T
			int num = 1;
			String str = "";
			while((str = reader.readLine()) != null){
				String[] temp = str.split(" ");
				int result = 0;
				int n = Integer.parseInt(temp[0]); // how many dancers
				int s = Integer.parseInt(temp[1]); // surprising scores
				int p = Integer.parseInt(temp[2]); // at least p points
				int t[] = new int[n];
				for(int i = 0; i < n; i++) {
					t[i] = Integer.parseInt(temp[i + 3]);
					int k = t[i] / 3;
					int normalMax, suprisingMax;
					if(t[i] % 3 == 0){
						normalMax = k;
						suprisingMax = k + 1;
					} else if(t[i] % 3 == 1){
						normalMax = k + 1;
						suprisingMax = k + 1;
					} else { // t[i] % 3 == 2
						normalMax = k + 1;
						suprisingMax = k + 2;
					}
					if(normalMax >= p) result++;
					else if(s > 0 && suprisingMax >= p){
						if(t[i] == 0 || t[i] == 29 || t[i] == 30) continue;
						s--;
						result++;
					}
				}
				writer.println("Case #" + num + ": " + result);
				num++;
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
