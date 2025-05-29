import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.TreeMap;

public class GoogleCodeJam {

	/**
	 * @param args
	 * @throws IOException 
	 */
	/* Speaking Tongues */
/*	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String s;
		StringBuilder sbReturn=new StringBuilder();
		sbReturn.append("Output").append("\n");
	    int iNbTestCases=0;
	    int icurrTestCase=0;
	    int icurrLineInput=0;
	    while ((s = in.readLine()) != null && s.length() != 0 && icurrTestCase<30 && iNbTestCases>=icurrTestCase) {
	      try {
	    	  if (icurrLineInput==0) {
	    		  iNbTestCases =Integer.parseInt(s);
	    	  } else {
	    		  sbReturn.append("Case #").append(++icurrTestCase).append(": ").append(translateWeirdLaguage(s)).append("\n");
	    	  }
	      } catch (Exception ex) {
	    	  System.err.println(ex.getLocalizedMessage());
	    	  return;
	      }
	      icurrLineInput++;
	      if(icurrLineInput == iNbTestCases+1) break;
		}
		System.out.println(sbReturn.toString());
	}
*/
	/* Dancing with Googlers */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String s;
		StringBuilder sbReturn=new StringBuilder();
		//sbReturn.append("Output").append("\n");
	    int iNbTestCases=0;
	    int icurrTestCase=0;
	    int icurrLineInput=0;
	    while ((s = in.readLine()) != null && s.length() != 0 && icurrTestCase<101 && iNbTestCases>=icurrTestCase) {
	      try {
	    	  if (icurrLineInput==0) {
	    		  iNbTestCases =Integer.parseInt(s);
	    	  } else {
	    		  sbReturn.append("Case #").append(++icurrTestCase).append(": ").append(generateMaxNumberOfValidTriplet(s)).append("\n");
	    	  }
	      } catch (Exception ex) {
	    	  System.err.println(ex.getLocalizedMessage());
	    	  return;
	      }
	      icurrLineInput++;
	      if(icurrLineInput == iNbTestCases+1) break;
		}
		System.out.println(sbReturn.toString());
	}	
	private static String translateWeirdLaguage(String s) {
		String sReturnValue=null;
		String[][] replacements = { {"a","y"},{"b","n"},{"c","f"},{"d","i"},{"e","c"},{"f","w"},{"g","l"},{"h","b"},{"i","k"},{"j","u"},{"k","o"},{"l","m"},{"m","x"},{"n","s"},{"o","e"},{"p","v"},{"q","z"},{"r","p"},{"s","d"},{"t","r"},{"u","j"},{"v","g"},{"w","t"},{"x","h"},{"y","a"},{"z","z"} };
		String[][] replacements2 = {{"y","a"},{"h","b"},{"e","c"},{"s","d"},{"o","e"},{"c","f"},{"v","g"},{"x","h"},{"d","i"},{"u","j"},{"i","k"},{"g","l"},{"l","m"},{"b","n"},{"k","o"},{"r","p"},{"z","q"},{"t","r"},{"n","s"},{"w","t"},{"j","u"},{"p","v"},{"f","w"},{"m","x"},{"a","y"},{"q","z"}};
		String strOutput = s;
		StringBuilder sb=new StringBuilder();
		for (char c: strOutput.toCharArray()) {
			int iAscii=(int) c;
			if (iAscii==32) {
				sb.append(" ");
			} else {
				sb.append(replacements2[iAscii-97][0]);
			}
		}	
		sReturnValue=sb.toString();
		return sReturnValue;
		
	}
	private static int generateMaxNumberOfValidTriplet(String inData) {
		int iReturnValue=0;
		String[] iData=inData.split(" ",99);
		int iNbGooglers=Integer.parseInt(iData[0]);
		int iNbSurprisingTriplets=Integer.parseInt(iData[1]);
		int iP=Integer.parseInt(iData[2]);
		int iRunningSupriTriple=iNbSurprisingTriplets;
		for (int i=3;i<iData.length;i++) {
			//allScores.put(Integer.parseInt(iData[i]), "");
	    	int iCurrentTotal=Integer.parseInt(iData[i]);
	    	if (iP>iCurrentTotal) {
	    		
	    	}else {
	    		if (iCurrentTotal - 3*iP > 0) {
	    			iReturnValue++;
	    		} else {
	    			if (3*iP>iCurrentTotal) {
	    				if (iRunningSupriTriple>0) {
	    					if (iCurrentTotal-3*iP >=-4) {
	    						iReturnValue++;
	    						if (Math.abs(iCurrentTotal-(3*iP))>2) {
	    							iRunningSupriTriple--;
	    						}
	    					}
	    				} else {
	    					if (3*iP-1==iCurrentTotal) {
	    						iReturnValue++;
	    					} else if (3*iP-2==iCurrentTotal) {
	    						iReturnValue++;
	    					}
	    				}//if (iRunningSupriTriple>0)
	    			} else {
	    				iReturnValue++;
	    			} //if (3*iP>iCurrentTotal)
	    		} //if (iCurrentTotal - 3*iP > 3)
	    	} // if (iP>iCurrentTotal) 
		}		

		return iReturnValue;
		
	}
}
