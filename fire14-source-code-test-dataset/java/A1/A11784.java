import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Dancing_With_the_Googlers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String strFileName = "B-small-attempt0";
		String strInputFileName = strFileName + ".in";
		String strOutputFileName = strFileName + ".out";
		int iCaseNumber = 1;
		
		try {
			////////////////////////////////////////////////////////////////
			BufferedReader in = new BufferedReader(new FileReader(strInputFileName));
			BufferedWriter out = new BufferedWriter(new FileWriter(strOutputFileName));
			String inString = "";
			String outString = "";

			String sTotalNumber = in.readLine();
			
			while ((inString = in.readLine()) != null) {
				//System.out.println(inString);

				String[] sArray = inString.split(" ");
				int iNumCount = Integer.parseInt(sArray[0]);
				int iSurprisingNum = Integer.parseInt(sArray[1]);
				int iStandardNum = Integer.parseInt(sArray[2]);
				int iResultCount = 0;
				
				for (int idx = 3; idx < iNumCount + 3; idx++) {
					int iTarget = Integer.parseInt(sArray[idx]);
					
					// 총 합에서, 기준값을 빼고, 나머지를 구한다.
					// 그 나머지가, 차이값
					int iRemain = iTarget - iStandardNum;
					int iCompare = (iStandardNum - 1) * 2;
					int iCompareSecond = (iStandardNum - 2) * 2;
					
					if (iRemain < 0) {
						continue;
					}
					
					if (iRemain >= iCompare) {
						iResultCount++;
//						System.out.println(String.format("iTarget:[%d], iRemain:[%d], iCompare[%d], iNumCount:[%d], iSurprisingNum:[%d], iStandardNum:[%d],"
//								,iTarget,iRemain, iCompare, iNumCount, iSurprisingNum, iStandardNum));
					}
					else if (iSurprisingNum > 0 && iRemain >= iCompareSecond) {
						iResultCount++;
						iSurprisingNum--;
//						System.out.println(String.format("iTarget:[%d], iStandardNum[%d] iRemain:[%d], iCompareSecond[%d], iNumCount:[%d], iSurprisingNum:[%d], iStandardNum:[%d],"
//								,iTarget,iStandardNum,iRemain, iCompareSecond, iNumCount, iSurprisingNum, iStandardNum));
					}
				}
												
				outString = String.format("Case #%d: %d\n", iCaseNumber++, iResultCount); 
				System.out.print(outString);
				out.write(outString);
			}
			in.close();
			out.close();
			////////////////////////////////////////////////////////////////
		} catch (IOException e) {
			System.err.println("ERROR");
			System.err.println(e); // 에러가 있다면 메시지 출력
			System.exit(1);
		}	     
	}
}
