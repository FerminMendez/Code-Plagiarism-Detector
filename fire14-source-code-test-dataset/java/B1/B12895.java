import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

public class c_small_0 {

	static final int _threshold = 2;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		
		int num = (int) (39 / Math.pow(10, 2 - 1));
		System.out.println("num:"+ num);
		String outputFormat = "Case #%s: %s";

		String realInput = "C-small-0.in";
		String realOutput = "C-small-0.out";

		String sampleInput = "C-small-0.in";
		String sampleOutput = "C-small-0.out";
		Hashtable numberCheck = new Hashtable();
		
		FileInputStream sampleInputfstream = new FileInputStream(sampleInput);
		DataInputStream sampleInputin = new DataInputStream(sampleInputfstream);
		BufferedReader sampleInputfis = new BufferedReader(
				new InputStreamReader(sampleInputin));
		
		FileOutputStream realOutputfstream = new FileOutputStream(sampleOutput, false);
		DataOutputStream realOutputin = new DataOutputStream(realOutputfstream);
		BufferedWriter realOutputfis = new BufferedWriter(
				new OutputStreamWriter(realOutputin));

		{
		int i = 1234;
		int startNum = 1111;
		int endNum = 2222;
		String numStr = String.valueOf(i);

		//unit testing
		checkNumberRecycled(i, i, startNum, endNum, numStr.length());
		}

		String sampleInputLine, sampleOutputLine;
		int numOfLines = Integer.parseInt(sampleInputfis.readLine());

		int sampleCount = 1;
		while ((sampleInputLine = sampleInputfis.readLine()) != null) {
			allNumHt.clear();

			String[] sampleInputLineArr = sampleInputLine.split(" ");
			int startNum = Integer.parseInt(sampleInputLineArr[0]);
			int endNum = Integer.parseInt(sampleInputLineArr[1]);
			System.out.println(startNum + "..." + endNum);
			for(int i=startNum; i<=endNum; i++) {
				String numStr = String.valueOf(i);
				//System.out.println("i, startNum, endNum, numStr.length(): "+ i +" "+ startNum +" " + endNum +" "+ numStr.length());
				boolean checkNum = checkNumberRecycled(i, i, startNum, endNum, numStr.length());
				//if(checkNum)
				//	numberCheck.put(new Integer(i), "");
			}
			
			if (sampleCount > 1) {
				realOutputfis.write("\n");
			}
			String formattedOutputCaseString = String.format(
					outputFormat,
					new String[] { String.valueOf(sampleCount++),
							String.valueOf(allNumHt.size()) });
			realOutputfis.write(formattedOutputCaseString);
			System.out.println("----------------===--------------"+numberCheck.size());
		}
		realOutputfis.close();
	}

	static Hashtable allNumHt = new Hashtable();

	private static boolean checkNumberRecycled(final int num, final int _numToManipulate, final int startNum, final int endNum, final int sizeOfNum) {
		//Hashtable recycleHt = new Hashtable();

		int numToManipulate = _numToManipulate;
		for(int i=0; i<sizeOfNum; i++) {
			boolean isRecycle = true;
			int recycle = numToManipulate % 10;
			numToManipulate = (int) (numToManipulate / 10);

			StringBuffer newNumberStrBuff = new StringBuffer(); 
			newNumberStrBuff.append(recycle+""+numToManipulate);
			numToManipulate = Integer.parseInt(newNumberStrBuff.toString());
			
			String newKey1 = num + "," + numToManipulate;
			String newKey2 = numToManipulate + "," + num;

			if(num == numToManipulate) continue;
			
			if(allNumHt.containsKey(newKey1) || allNumHt.containsKey(newKey2)) {
				isRecycle = false;
			}
			
			//recycleHt.put(newKey1, "");
			//recycleHt.put(newKey2, "");
			
			if(String.valueOf(numToManipulate).length() != sizeOfNum) {
				isRecycle = false;
			}
			if( numToManipulate < startNum || numToManipulate > endNum ) {
				isRecycle = false;
			}
			
			if(isRecycle) {
				allNumHt.put(newKey1, "");
				System.out.println(newKey1+ ",NumStr:" + num + ", Size of keys"+ allNumHt.size() +", recycle:"+isRecycle);
			} else {
				//System.out.println(recycleHt+","+recycleHt.size() + ",NumStr:" + num + ", Size of keys"+ allNumHt.size() +", recycle:"+isRecycle);
			}
		}
//		if(recycleHt.size()==0) {
//			isRecycle = false;
//		}
		
//		if(isRecycle) {
//		//System.out.println("NumStr:" + num + ", "+isRecycle);
//		Enumeration keys = recycleHt.keys();
//		while(keys.hasMoreElements()) {
//			Object obj = keys.nextElement();
//			allNumHt.put(obj, "");
//		}
//		}
		//if(isRecycle)


		return true;
	}
}
