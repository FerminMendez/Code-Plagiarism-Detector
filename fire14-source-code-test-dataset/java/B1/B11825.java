import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Recycled_Numbers_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String strFileName = "C-small-attempt0";
		String strInputFileName = strFileName + ".in";
		String strOutputFileName = strFileName + ".out";

		int iCaseNumber=1;
		
		try {
			////////////////////////////////////////////////////////////////
			BufferedReader in = new BufferedReader(new FileReader(strInputFileName));
			BufferedWriter out = new BufferedWriter(new FileWriter(strOutputFileName));
			String inString = "";
			String outString = "";

			String sTotalNumber = in.readLine();
			
			while ((inString = in.readLine()) != null) {
				System.out.println(inString);
				// 두 개의 숫자로 이루어져 있다.
				String[] saRange = inString.split(" ");
				int iStart = Integer.parseInt(saRange[0]);
				int iEnd = Integer.parseInt(saRange[1]);
				System.out.println(String.format("S:[%d], E:[%d]", iStart, iEnd));
				
				ArrayList<Integer> listCompare = new ArrayList<>();
				int iCount = 0;
				
				for (int iNumber = iStart; iNumber <= iEnd; iNumber++) {
					
					// 수의 자릿수 얻기
					int iGetDigit = iNumber;
					int iDigitCount = 0;
					while (iGetDigit > 0) {							
						iGetDigit /= 10;
						iDigitCount++;
					}
					
					//System.out.println(String.format("%d's Digit is %d",iNumber, iDigitCount));
					
					boolean bFound = false;
					
					// 비교
					for (int idx = 0; idx < listCompare.size(); idx++) {
						int iCompareNumber = listCompare.get(idx);
												
						for (int iDigit = 1; iDigit <= iDigitCount-1; iDigit++) {
							int iFront = (int) (iNumber/(Math.pow(10, iDigit)));
							int iBack = (int) (iNumber%(Math.pow(10, iDigit)));
							int iModify = (int) (iBack * (Math.pow(10, iDigitCount-iDigit)) + iFront);
							
//							System.out.println(String.format("Check: iNumber:[%d], iDigit:[%d], iFront:[%d], iBack:[%d], iModify:[%d]"
//																		, iNumber, iDigit, iFront, iBack, iModify));
							
							if (iCompareNumber == iModify) {
								//System.out.println(String.format("Compare:[%d], iNumber:[%d], iModify[%d], iDigit[%d]", iCompareNumber, iNumber, iModify, iDigit));
								iCount ++;
								//listCompare.remove(idx);
								bFound = true;
								//break;
							}
							
						}
						
//						if (bFound) {
//							break;
//						}						
					}
					listCompare.add(iNumber);
					
				}
				
				System.out.println(String.format("Count:[%d]",iCount));
				
				outString = String.format("Case #%d: %d\n", iCaseNumber++, iCount); 
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
