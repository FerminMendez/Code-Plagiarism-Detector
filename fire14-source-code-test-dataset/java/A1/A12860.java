package exercise;

public class Solver {
	private static int	VOTES_NB = 3;
	private static int	VARIABLES_NB = 3;
	
	public static Integer[]	solve(Integer[][] input) {
		Integer[]	result = new Integer[input.length];
		
		for (int cnt = 0; cnt < input.length; ++cnt)
			result[cnt] = solve(input[cnt]);
		
		return result;
	}

	public static int	solve(Integer[] input) {
		if (input == null || input.length < 3)
			return 0;
		
		int	googlersNb = input[0];
		int	surprisingTriplets = input[1];
		int	target = input[2];
		
		if (input.length < VARIABLES_NB + googlersNb)
			return 0;
		
		int	result = 0;
		
		Integer[]	candidates = new Integer[surprisingTriplets]; 
		for (int cnt = VARIABLES_NB; cnt < input.length; ++cnt) {
			if (input[cnt] < target * VOTES_NB - (VOTES_NB - 1)) {
				int	minIndex = 0;
				int	min = -1;
				for (int tmp = 0; tmp < candidates.length; ++tmp) {
					if (candidates[tmp] == null || input[cnt] > candidates[tmp]) {
						if (candidates[tmp] == null || min == -1 || candidates[tmp] < min) {
							min = (candidates[tmp] == null) ? 0 : candidates[tmp];
							minIndex = tmp;
						}
					}
				}
				if (min >= 0 && input[cnt] >= min)
					candidates[minIndex] = input[cnt];
			} else
				++result;
		}
		
		if (candidates.length > 0) {
			int	surprisingTarget = target + target - 2 + target - 2;
			if (surprisingTarget <= 0)
				surprisingTarget = target;
			if (candidates != null)
				for (int cnt = 0; cnt < candidates.length; ++cnt)
					if (candidates[cnt] != null && candidates[cnt] >= surprisingTarget)
						result++;
		}
		
		return result;
	}
}
