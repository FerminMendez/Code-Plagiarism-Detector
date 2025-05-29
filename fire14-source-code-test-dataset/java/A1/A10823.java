import IO.InputDelegate;
import IO.OutputDelegate;


public class Main {
	InputDelegate reader;
	OutputDelegate writer;
	
	public static void main(String[] args) {
		new Main().init();
	}
	
	public Main() {
		this.reader = new InputDelegate("input.in");
		this.writer = new OutputDelegate("output.out");
	}
	
	public void init() {
		String readedLine = null;
		
		int numLines = Integer.parseInt(this.reader.readLine());
		readedLine = this.reader.readLine();
		
		// Read all lines
		for (int i = 0; i < numLines; i++, readedLine = this.reader.readLine()) {
			String[] splittedLine = readedLine.split(" ", 4);
			
			int numSurprising = Integer.parseInt(splittedLine[1]);
			int controlValue  = Integer.parseInt(splittedLine[2]);
			
			String valuesStr  = splittedLine[3];
			String[] splittedValues = valuesStr.split(" ");
			
			int foundedDancer = 0;
			for (int j = 0; j < splittedValues.length; j++) {
				int value = Integer.parseInt(splittedValues[j]);
				
				if (value >= controlValue * 3 - 2) {	// Not surprising
					foundedDancer++;
				} else if (value >= controlValue && value >= controlValue * 3 - 4 && numSurprising > 0) {	// Surprising
					foundedDancer++;
					numSurprising--;
				}
			}
			
			this.writer.writeLine(String.format("Case #%d: %d", i + 1, foundedDancer));
		}
		
		this.reader.close();
		this.writer.flush();
		this.writer.close();
	}
}
