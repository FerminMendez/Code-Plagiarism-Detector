import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;


public class RecycledNumbers {

	/**
	 * @param args
	 * @throws Exception 
	 */
	
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader(new File(args[0]));
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter(new File("C:\\Users\\subhar\\Desktop\\DropBox\\Output.txt"));
		BufferedWriter bw = new BufferedWriter(fw);
		int testCases = Integer.parseInt(br.readLine());
		for(int i =1;i<testCases+1;i++){
			bw.write("Case #"+i+": ");
			String str = br.readLine();
			bw.write(String.valueOf(getCyclicCount(str)));
			if(i<testCases)bw.write("\r\n");

		}
		bw.flush();
		bw.close();

	}

	private static int getCyclicCount(String str) {
		int cyclicCount = 0;
		String strArr[] = str.split(" ");
		int firstNum = Integer.parseInt(strArr[0]);
		int secNum = Integer.parseInt(strArr[1]);
		int runningNum = firstNum;
		
		ArrayList<String> numList = new ArrayList<String>();
		while(runningNum<secNum+1){
				String runStr = String.valueOf(runningNum);
				int strLen = runStr.length();
				for(int i=1;i<strLen;i++){
					String newNumStr = runStr.substring(i, strLen)+runStr.substring(0, i);
					int newNum = Integer.parseInt(newNumStr);
					System.out.print(runningNum + "::"+newNum);
					if(newNum>=firstNum && newNum <=secNum && newNum!=runningNum){	
						String strFComb = runningNum<newNum?runningNum+"::"+newNum:newNum+"::"+runningNum;
						if(!numList.contains(strFComb)){
							cyclicCount++;
							numList.add(strFComb);
						}
					}
				
			}			
			runningNum++;			
		}		
		return cyclicCount;
	}
}
