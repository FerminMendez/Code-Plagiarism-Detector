import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProblemC{
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("C-small-attempt0.in"));
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
		long a = Long.parseLong(values[0]);
		long b = Long.parseLong(values[1]);
		for(long i = a; i < b; i++)
		{
			String nText = (new Long(i)).toString();
			List<Long> list = new ArrayList<Long>();
			for (int j = 1; j<nText.length();j++)
			{	
				String mText=nText.substring(j)+nText.substring(0,j);
				long m = Long.parseLong(mText);
				if(m>i && m<=b && !list.contains(m)){
					list.add(m);
					result++;
				}
			}
		}
		return result;
	}	
}