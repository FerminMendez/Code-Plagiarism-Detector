package fun.codeslam.dancers;

public class Result
{

	Integer maximumNumberOfGooglers = 0;

	public Result(TestCase testCase)
	{
		Integer numberOfSurprisesLeft = testCase.getNumberOfSurprises();
		Integer pointsNeeded = testCase.getPointsNeeded();

		Integer enoughPoints = pointsNeeded * 3 - 2;
		Integer enoughPointsForSurprise = pointsNeeded * 3 - 4;

		for (Integer dancerIndex = 0; dancerIndex < testCase.getNumberOfGooglers(); dancerIndex++)
		{
			Integer sum = testCase.getSumOfPoints(dancerIndex);
			if (sum >= enoughPoints) {
				maximumNumberOfGooglers++;
			}
			else if (enoughPointsForSurprise > 0 && sum >= enoughPointsForSurprise && numberOfSurprisesLeft > 0) {
				numberOfSurprisesLeft--;
				maximumNumberOfGooglers++;
			}			
		}

	}

	public String toString()
	{
		return maximumNumberOfGooglers.toString();
	}

}
