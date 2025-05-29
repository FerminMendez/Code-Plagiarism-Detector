import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Recycled {

	/**
	 * @param args
	 * @throws IOException 
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader ("data/input"));
		PrintWriter pw = new PrintWriter(new FileWriter("data/output"));
		int lines = Integer.parseInt(br.readLine());
		for(int j = 0; j < lines; j++){
			String sol = "Case #" + (j+1) + ": ";
			StringTokenizer st = new StringTokenizer(br.readLine());
			int min = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			int num = 0;
			for(int i = min; i<=max;i++){
				String numb = ""+i;
				List<String> duplicates = new ArrayList<String>();
				for(int k=0;k<numb.length();k++){
					duplicates.add(numb);
					int newNumb = Integer.parseInt(numb.substring(k) + "" + numb.subSequence(0, k));
					if(!duplicates.contains(""+newNumb) && newNumb > i && newNumb >= min && newNumb <= max){
						//System.out.println(i+"\t"+newNumb);
						duplicates.add(""+newNumb);
						
						num++;
					}
				}
			}
			pw.println(sol + ""+ num);
		}
		pw.close();

	}

}
