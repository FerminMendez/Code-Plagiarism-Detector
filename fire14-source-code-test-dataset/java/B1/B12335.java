import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> lstLinesOutput = new ArrayList<String>();
		int iNbAnswers;
		List<String> lstLinesInput = FileReaderHandler.openFile("/home/guillaume/Bureau/input");
		
		
		for(int n=1;n< Integer.parseInt(lstLinesInput.get(0)) + 1;n++){
			String sOutput = "Case #" + n + ": ";
			List<String> box = new ArrayList<String>();
			iNbAnswers = 0;
			String sInput = lstLinesInput.get(n);
			String[] hInput = sInput.split(" ");
			//to int array
			int[] iInput = new int[hInput.length];
			for(int i=0;i < hInput.length;i++){
				iInput[i] = Integer.parseInt(hInput[i]);
			}
			
			int iMin = iInput[0];
			int iMax = iInput[1];
			for(int i=iMin;i<iMax + 1;i++){
				String s = "" + i;
				for(int j=1; j<s.length();j++){
					String depl = s.substring(s.length() -j);
					String sRecycled = depl + s.substring(0, s.length() - j);
					int iToTest = Integer.parseInt(sRecycled);
					if(iToTest <= iMax && iToTest > i && !box.contains(i + "-" + iToTest)){
						box.add(i + "-" + iToTest);
						iNbAnswers++;
					}
				}
			}
			sOutput += iNbAnswers;
			lstLinesOutput.add(sOutput);
		}
		
		if(Integer.parseInt(lstLinesInput.get(0)) != lstLinesOutput.size()){
			System.out.println("ERROR!!!");
		}
		FileWriterHandler.writeToFile(lstLinesOutput);
	}
}