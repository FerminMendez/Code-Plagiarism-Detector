import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class C_RecycledNumbers {

	//static String inputFile = "C_Sample.in";	
	static String inputFile = "C-small-attempt1.in";	
	//static String inputFile = "C-large-attempt0.in";

	public static void main(String[] args) {		
		List<String> input = null;
		List<String> output = new ArrayList<String>();

		String outputFile = inputFile.split("\\.")[0]+".out";

		try {
			input = Files.readAllLines(Paths.get("Input\\"+inputFile), Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}

		int cases = Integer.parseInt(input.get(0));		
		
		long startTime = System.currentTimeMillis();

		for(int currentCase = 1;currentCase<cases+1;currentCase++) {
			String line = input.get(currentCase);
			String outputLine = "Case #" + currentCase + ": ";

			String[] splitted = line.split(" ");
			int A=Integer.parseInt(splitted[0]);
			int B=Integer.parseInt(splitted[1]);
			int result = 0;
			
			if((""+A).length()==(""+B).length()) {
				int min = Math.min(A, B);
				int max = Math.max(A, B);

				for(int m=min;m<=max;m++) {
					for(int n=m+1;n<=max;n++) {
						String m_string = ""+m;
						
						boolean isRecycled=false;
						
						for(int nbChars=1;nbChars<m_string.length();nbChars++) {
							String m_move = m_string.substring(0, nbChars);
							String m_keep = m_string.substring(nbChars, m_string.length());
							int attempt = Integer.parseInt(m_keep+m_move);
							if(n==attempt) {
								isRecycled=true;
								break;
							}
						}
						
						if(isRecycled) {
							result++;
						}
					}			
				}
			}
			
			outputLine +=result; 

			System.out.println(outputLine);			
			output.add(outputLine);	
		}
		
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		System.out.println("Elapsed time: " + elapsedTime/1000F + "s");
		
		try {
			Files.write(Paths.get("Output\\"+outputFile), output, Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
