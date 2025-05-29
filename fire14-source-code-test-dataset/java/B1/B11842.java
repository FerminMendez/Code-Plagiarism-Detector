package info.m3o.gcj2012.recyclednumber;

public class TestMainRecycledNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int inA, inB;
		int caseCount = 0;
		// System.out.println("T=" + inT);

		ResultUtil resultUtil = new ResultUtil();

		// inA = Integer.valueOf(s[0]);
		// inB = Integer.valueOf(s[1]);
		inA = 1000000;
		// inB = 2000000;
		inB = 2000000;
		// System.out.println("A=" + inA + "B=" + inB );
		caseCount++;

		/*
		 * Start the actual Job
		 */
		resultUtil.clearSets();
		int n, numRecycledNumber;
		RecycledNumber recycledNumber;
		for (n = inA; n <= inB; n++) {
			recycledNumber = new RecycledNumber(n, inA, inB);
			recycledNumber.addRecycledNumbers(resultUtil.recycledNumberSet,
					resultUtil.testedNumberSet);
			for (String s : RecycledNumber.getCycledNumber(recycledNumber
					.getNumStr())) {
				recycledNumber.addRecycledNumbers(resultUtil.recycledNumberSet,
						resultUtil.testedNumberSet, s);
				
			}

			// recycledNumber.addRecycledNumbers(resultUtil.recycledNumberSet,
			// resultUtil.testedNumberSet);
		}
		numRecycledNumber = resultUtil.recycledNumberSet.size();

		System.out.print("Case #" + caseCount + ": ");
		System.out.println(numRecycledNumber);
//		for (MyNumberStringPair mnsp : resultUtil.recycledNumberSet) {
//			System.out.println("(" + mnsp.getS1() + ", " + mnsp.getS2() + ") ");
//		}
//		 System.out.println("END");

		// System.out.println("TestRecycleat = " +
		// RecycledNumber.testrecycleAt());

		// System.out.println("caseCount="+caseCount);
		// assert (inT == caseCount) : "CaseCount mismatch";

	}

}
