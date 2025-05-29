import java.io.*;

public class mains {
	public static void main(String[] args) {
		BufferedReader input;
		BufferedWriter output;
		
		try {
			input = new BufferedReader(new FileReader("C-small-attempt0.in"));
			output = new BufferedWriter(new FileWriter("output.out"));
			
			int caseCount = Integer.parseInt(input.readLine());
			
			String buf;
			String[] values;
			int minValue;
			int maxValue;
			int currentValue;
			int highest;
			int next;
			int result = 0;
			int numLength;
			
			for(int index = 1 ; index <= caseCount; ++index) {
				buf = input.readLine();
				values = buf.split(" ");
				
				minValue = Integer.parseInt(values[0]);
				maxValue = Integer.parseInt(values[1]);
				
				numLength = values[1].length();
				highest = (int)Math.pow(10, numLength - 1);
				result = 0;
				if(highest != 1) {
					for(int num = minValue; num <= maxValue ; ++num) {
						currentValue = num;
						for(int i = 0 ; i < numLength ; ++i) {
							next = currentValue / highest;
							currentValue %= highest;
							currentValue *= 10;
							currentValue += next;
							
							if(num < currentValue && currentValue <= maxValue)
								++result;
						}
					}
					
					output.write("Case #" + index + ": " + result);
					output.newLine();
				} else {
					output.write("Case #" + index + ": 0");
					output.newLine();
				}
			}
			
			output.close();
			input.close();
		} catch(Exception e) {
			return;
		}
	}
}
