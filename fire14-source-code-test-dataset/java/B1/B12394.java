package com.amyth.gc2012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProblemC {

	/**
	 * @param args
	 */
	private static HashMap<Integer,Integer> factorial = new HashMap<Integer, Integer>();
	private final static String INPUT_DIR_NM = "./Input/2012/";
	private final static String OUTPUT_DIR_NM = "./Output/2012/";
	private static Integer totalTestCase;
	private static ArrayList<ArrayList<Long>> dataList;
	public static void main(String[] args) {
		String fileName = args[0];
		//Read and Create necessary data structures. 
		try {
			readAndBuild(INPUT_DIR_NM + fileName);
		}
		catch (IOException e) {
			e.printStackTrace();

		}
		//TODO Implement program logic
		
		List<Integer> outputList = play();
		
		
		//write in out file
		try{
			// Create file 
			FileWriter fstream = new FileWriter(OUTPUT_DIR_NM+args[0]+".out");
			BufferedWriter out = new BufferedWriter(fstream);
			for (int caseId = 0; caseId < totalTestCase; caseId++) {
				System.out.print("Case #" + (caseId+1) + ": ");
				System.out.println(outputList.get(caseId));
				out.write("Case #" + (caseId+1) + ": ");
				out.write(outputList.get(caseId)+""); 
				if(caseId != totalTestCase)
					out.newLine();
			}
//			Close the output stream
			out.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	
	
	private static List<Integer> play() {
		List<Integer> outList = new ArrayList<Integer>(totalTestCase);
		for (int caseId = 0; caseId < totalTestCase; caseId++) {
			List<Long> testList = dataList.get(caseId);
			Long lRanger = testList.get(0);
			Long hRange = testList.get(1);
			int count = 0;
			List<Long> backupList = new ArrayList<Long>();
			for(long lRange = lRanger;lRange<=hRange;lRange++){
				String str = String.valueOf(lRange);
				int length = str.length();
				backupList=new ArrayList<Long>();
				for(int i=0;i<(length-1);i++){
					Long valCounter = (long) (Math.pow(10,(i+1)));
					int lastValue = (int) (lRange%valCounter);
//					System.out.println("lRange: "+lRange);
					Long lcounter = (long) Math.pow(10, (length-(i+1)));
					int hFirstValue = (int)  (hRange/valCounter);
					if(((lastValue*lcounter) > hRange) || 
							(lRanger > (lastValue*lcounter))
							){
						continue;
					}else{
						Long number = (long) (lastValue*(lcounter));
						number += (lRange/valCounter);
						if((number >= lRanger)&&(number > lRange) && (number <=hRange)){
							if(backupList != null && !backupList.isEmpty()){
								if(!backupList.contains(number)){
//									System.out.println("oldNumber :"+lRange+" newNumber: "+number);
									count++;
								}
							}else{
								backupList.add(number);
//								System.out.println("oldNumber :"+lRange+" newNumber: "+number);
								count++;
							}
							
						}
							
					}
				}
				
				/*Long lcounter = (long) Math.pow(10, length);
				Long rcounter = (long) 10;*/
			}
			outList.add(caseId,count);
		}
		return outList;
	}



		//Build input data structure
		private static void readAndBuild(String dataPath) throws IOException {
			File f = new File(dataPath);
			BufferedReader bf = new BufferedReader(new FileReader(f));
			String text = bf.readLine();

			if (text != null) {
//				first text will be number of test cases
				totalTestCase = Integer.valueOf(text);
				dataList = new ArrayList<ArrayList<Long>>(totalTestCase);
				ArrayList<Long> testObj = null;

				do {
					text = bf.readLine();
					if (text != null) {
						BreakIterator bi = BreakIterator.getWordInstance();
						bi.setText(text);
						testObj = new ArrayList<Long>(2);
						dataList.add(testObj);
						Long N = Long.valueOf(text.substring(0, bi.next()));
						testObj.add(N);
						Long Pd = Long.valueOf(text.substring(bi.next(), bi.next()));
						testObj.add(Pd);
					}
				}while (text != null && !text.equals(""));
			}
		}
		
		
		private static int getFactorial(int length) {
			if(factorial.containsKey(length))
				return factorial.get(length);
			return length*getFactorial(length-1);
		}

}
