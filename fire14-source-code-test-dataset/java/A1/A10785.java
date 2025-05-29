import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class CodeJam2 
{
	public static void calcMax(int numLines, String[] gLines) 
	{
		int numGoog;
		int numSurp;
		int minScore;
		
		for (int i = 0; i< numLines; i++) {
			int result = 0;
			int numSurpUsed = 0;
			String[] data = gLines[i].split(" ");
			numGoog = Integer.parseInt(data[0]);
			numSurp = Integer.parseInt(data[1]);
			minScore = Integer.parseInt(data[2]);
			for (int j = 0; j< numGoog; j++) {
				int googlerScore = Integer.parseInt(data[j+3]);
				if ((googlerScore+4) < minScore*3) continue;
				if (googlerScore <= 1) {
					if (googlerScore >= minScore) result++;
					continue;
				}
				if ((googlerScore)% 3 == 0) {
					if ((googlerScore/3) >= minScore) result++;
					else if ((googlerScore/3) +2 >= minScore && (numSurpUsed < numSurp)) {
						result++;
						numSurpUsed++;
					}
				}
				else if ((googlerScore+1)% 3 == 0) {
					googlerScore += 1;
					if ((googlerScore/3) >= minScore) result++;
					else if ((googlerScore/3) +1 >= minScore && (numSurpUsed < numSurp)) {
						result++;
						numSurpUsed++;
					}
				}
				else if ((googlerScore-1)% 3 == 0) {
					googlerScore -= 1;
					if ((googlerScore/3) +1 >= minScore) result++;
				}
			}
			System.out.println("Case #" + (i+1) + ": "  + result);
		}
	}

	public static void main(String[] args) {
		File f = new File(args[0]);
		if (!f.isFile()) {
			System.out.println("The argument must be a file");
			return;
		}
		int numLines = -1, i = 0;
		String[] gLines = null;
		String currentLine;
		try {
			LineNumberReader lineReader = new LineNumberReader(new FileReader(args[0]));
			try {
				while ((currentLine = lineReader.readLine()) != null) {
					if (numLines < 0) {
						numLines = Integer.parseInt(currentLine);
						gLines = new String[numLines];
					}
					else {
						gLines[i] = currentLine;
						i++;
						if (i == numLines) break;
					}
				}
			}
			catch(Exception e) {e.printStackTrace();}
			finally {
				lineReader.close();
			}
		}
		catch(Exception e) {e.printStackTrace();}
		CodeJam2.calcMax(numLines, gLines);
	}
}

