import util.Runner;


public class DancingWithTheGooglers extends Runner{

	@Override
	public String dealWithCase(String line) {
		String[] splits = line.split(" ", -1);
		int noOfDancers = Integer.parseInt(splits[0]);
		int noOfSurprises = Integer.parseInt(splits[1]);
		int minimumScore = Integer.parseInt(splits[2]);
		int needSurpriseMinimum = minimumScore * 3 - 4;
		int noNeedForSurpriseMinimum = minimumScore * 3 - 2;
		if (minimumScore == 0) {
			needSurpriseMinimum = 0;
			noNeedForSurpriseMinimum = 0;
		} else if (minimumScore == 1) {
			needSurpriseMinimum = 1;
			noNeedForSurpriseMinimum = 1;
		}
		int needSurpriseCount = 0;
		int noNeedForSurpriseCount = 0;
		for (int i=3;i<splits.length;i++) {
			int currentTotal = Integer.parseInt(splits[i]);
			if (currentTotal >= noNeedForSurpriseMinimum) {
				noNeedForSurpriseCount++;
			} else if (currentTotal >= needSurpriseMinimum) {
				needSurpriseCount++;
			}
		}
		int result = noNeedForSurpriseCount + (noOfSurprises < needSurpriseCount ? noOfSurprises : needSurpriseCount);
		return String.valueOf(result);
	}
	
	public static void main(String[] args) throws Exception {
		DancingWithTheGooglers runner = new DancingWithTheGooglers();
		runner.run(args);
	}

}
