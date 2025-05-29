package net.nixdev.gcj12.q2;

public class Solver {

	public Integer solve(CaseData data) {
		Integer result = 0;
		Integer allowedException = data.excNumber;
		
		for (Integer total: data.totals) {
			Integer minStdScore = data.bestValue * 3 - 2;
			if (minStdScore < 0) minStdScore = data.bestValue;
			if (total >= minStdScore) {
				result++;
			} else {
				if (allowedException > 0) {
					Integer minExcScore = minStdScore - 2;
					if (minExcScore < 0) minExcScore = data.bestValue;
					
					if (total >= minExcScore) {
						result++;
						allowedException--;
					}
				}
				
			}
		}
		return result;
	}
}
