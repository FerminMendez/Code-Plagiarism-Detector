import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProblemB{
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("B-small-attempt0.in"));
		int count = Integer.parseInt(br.readLine());
		for (int i = 0; i<count; i++){
			String text = br.readLine();
			int result = calculate(text);
			System.out.println("Case #"+(i+1)+": "+result);
		}
		

	}

	private static int calculate(String text) {
		// TODO Auto-generated method stub
		int result = 0;
		String[] values = text.split(" ");
		int n = Integer.parseInt(values[0]);
		int t = Integer.parseInt(values[1]);
		int p = Integer.parseInt(values[2]);
		for(int i = 0; i < n; i++)
		{
			int ti = Integer.parseInt(values[i+3]);
			if ((ti/3.0)>(p-0.7)){
				result++;
			}else if (t>0 && (ti/3.0)>(p-1.4) && ti>=t ){
				t--;
				result++;
			}
		}
		return result;
	}	
}