package fun.codeslam.dancers;

public class TestCase
{

	private Integer numberOfGooglers;

	private Integer numberOfSurprises;

	private Integer pointsNeeded;

	private Integer[] sumsOfPoints;

	public TestCase(String line)
	{
		String[] elements = line.split(" ");
		numberOfGooglers = Integer.valueOf(elements[0]);
		numberOfSurprises = Integer.valueOf(elements[1]);
		pointsNeeded = Integer.valueOf(elements[2]);
		sumsOfPoints = new Integer[numberOfGooglers];
		for (Integer key = 0; key < numberOfGooglers; key++)
		{
			sumsOfPoints[key] = Integer.valueOf(elements[key + 3]);
		}
	}

	public Integer getNumberOfGooglers()
	{
		return numberOfGooglers;
	}

	public Integer getNumberOfSurprises()
	{
		return numberOfSurprises;
	}

	public Integer getPointsNeeded()
	{
		return pointsNeeded;
	}

	public Integer getSumOfPoints(Integer dancerIndex)
	{
		return sumsOfPoints[dancerIndex];
	}

}
