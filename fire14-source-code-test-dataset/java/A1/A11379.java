import java.io.*;

public class mains {
	public static void main(String[] args) {
		BufferedReader input;
		BufferedWriter output;
		
		try {
			input = new BufferedReader(new FileReader("B-small-attempt2.in"));
			output = new BufferedWriter(new FileWriter("output.out"));
			
			int caseCount = Integer.parseInt(input.readLine());
			
			String buf;
			String[] values;
			int googlerCount;
			int sCount;
			int minValue;
			int score;
			int resultCount;
			for(int index = 1 ; index <= caseCount; ++index) {
				resultCount = 0;
				buf = input.readLine();
				values = buf.split(" ");
				googlerCount = Integer.parseInt(values[0]);
				sCount = Integer.parseInt(values[1]);
				minValue = Integer.parseInt(values[2]);
				
				for(int i = 0 ; i < googlerCount; ++i) {
					score = Integer.parseInt(values[3 + i]);
					switch(minValue) {
					case 0 :
						++resultCount;
						break;
					case 1 :
						if(score >= 1)
							++resultCount;
						break;
					default :
						score = minValue * 3 - score;
						if(score <= 2) {
							++resultCount;
						} else if(sCount > 0 && score <= 4) {
							++resultCount;
							--sCount;
						}
					}
				}
				
				if(sCount != 0) {
					System.out.println("Invalid sCount = " + sCount + " at " + index);
				}
				
				output.write("Case #" + index + ": " + resultCount);
				output.newLine();
			}
			
			output.close();
			input.close();
		} catch(Exception e) {
			return;
		}
	}
}
