import java.util.ArrayList;
import java.util.List;


public class Main {
	
	public static void main(String[] args) {
		List<String> lstLinesOutput = new ArrayList<String>();
		
		List<String> lstLinesInput = FileReaderHandler.openFile("/home/guillaume/Bureau/input");
		for(int n=1;n< Integer.parseInt(lstLinesInput.get(0)) + 1;n++){
			System.out.println("Case " + n);
			String sOutput = "Case #" + n + ": ";
			String sInput = lstLinesInput.get(n);
			String[] hInput = sInput.split(" ");
			//to int array
			int[] iInput = new int[hInput.length];
			for(int i=0;i < hInput.length;i++){
				iInput[i] = Integer.parseInt(hInput[i]);
			}
			int iNbSurprising = iInput[1];
			int iToBeat = iInput[2];
			int iNbAnswers = 0;
			for(int i=0;i<iInput[0];i++){
				int iScore = iInput[i+3];
				if(iScore > 0){
					int iBase = iScore/3;
					int iReste = iScore%3;
					if(iBase >= iToBeat || iReste  > 0 && iBase + 1 >= iToBeat){
						iNbAnswers++;
					}else if(iNbSurprising > 0 && (iReste == 0 && iBase + 1 >= iToBeat || iReste == 2 && iBase + 2 >= iToBeat)){
						iNbAnswers++;
						iNbSurprising--;
					}
				} else if(iToBeat == 0){
					iNbAnswers++;
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