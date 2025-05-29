package info.m3o.gcj2012.recyclednumber;


public class MainRecycledNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String infilepath = "C:\\eclipse\\workspace\\gcjRecycledNumber\\data\\inputTest.txt";
		
		// String infilepath = "C:\\eclipse\\git_home\\git\\gcjRecycledNumber1\\gcjRecycledNumber\\data\\inputLarge.txt";
		String infilepath = "C:\\eclipse\\git_home\\git\\gcjRecycledNumber1\\gcjRecycledNumber\\data\\inputSmall.txt";

		
		//		String infilepath = "C:\\eclipse\\workspace\\gcjRecycledNumber\\data\\inputSmall.txt";
		//		String infilepath = "C:\\eclipse\\workspace\\gcjRecycledNumber\\data\\inputLarge.txt";

		InputFileLoader inputFileLoader = new InputFileLoader(infilepath);


		inputFileLoader.readInputFile();


		int inT = Integer.valueOf(inputFileLoader.getRawInputLines().get(0));
		// Remove the fist line, which is no logner needed.
		inputFileLoader.getRawInputLines().remove(0);


		int inA, inB;
		int caseCount = 0;
		// System.out.println("T=" + inT);

		ResultUtil resultUtil = new ResultUtil();

		for (String line : inputFileLoader.getRawInputLines()){
			String[] s = line.split("\\s");

			inA = Integer.valueOf(s[0]);
			inB = Integer.valueOf(s[1]);
			// System.out.println("A=" + inA + "B=" + inB );
			caseCount++;

			/*
			 *  Start the actual Job
			 */
			resultUtil.clearSets();
			int n, numRecycledNumber;
			RecycledNumber recycledNumber;

			
			for (n = inA; n <= inB; n++) {
				recycledNumber = new RecycledNumber(n, inA, inB);
				recycledNumber.addRecycledNumbers(resultUtil.recycledNumberSet,
						resultUtil.testedNumberSet);
				for (String str : RecycledNumber.getCycledNumber(recycledNumber
						.getNumStr())) {
					recycledNumber.addRecycledNumbers(resultUtil.recycledNumberSet,
							resultUtil.testedNumberSet, str);
					
				}

				// recycledNumber.addRecycledNumbers(resultUtil.recycledNumberSet,
				// resultUtil.testedNumberSet);
			}			numRecycledNumber = resultUtil.recycledNumberSet.size();
			

			
			
			System.out.print("Case #"+ caseCount+": ");
			System.out.println(numRecycledNumber);
			/*
			for (MyNumberStringPair mnsp: resultUtil.recycledNumberSet){
				System.out.print(mnsp.getS1() + " " + mnsp.getS2() + " " );
			}
			System.out.println("END");
			*/
		}

		/*
		System.out.println("caseCount="+caseCount);
		*/
		assert (inT == caseCount) : "CaseCount mismatch";

	}

}
