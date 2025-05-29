package exercise;


public class Solver {
	private static int[][]	MATCHES;
	
	public static Integer[]	solve(Integer[][] input) {
		Integer[]	result = new Integer[input.length];
		
		for (int cnt = 0; cnt < input.length; ++cnt)
			result[cnt] = solve(input[cnt]);
		
		return result;
	}

	public static int	solve(Integer[] input) {
		if (input == null || input.length < 2)
			return 0;
		
		Integer		min = input[0];
		Integer		max = input[1];
		int			result = 0;
		
		MATCHES = new int[max][4];
		
		for (int cnt = min; cnt < max; ++cnt) {
			result += countMatches(cnt, min, max);
		}
		
		for (int i = 0; i < MATCHES.length; ++i)
			for (int j = 0; j < MATCHES[i].length; ++j)
				if (MATCHES[i][j] != 0)
					++result;
				else
					break;
		return result;
	}
	
	private static int	countMatches(int value, int min, int max) {
		String	string = String.valueOf(value);
		int		result = 0;
		
		for (int idx = string.length() - 1; idx > 0; --idx) {
			String	candidateString = string.substring(idx, string.length()) + string.substring(0, idx);
			Integer	candidate = Integer.parseInt(candidateString);
			
			if (candidate.compareTo(value) > 0
					&& candidate.compareTo(min) >= 0
					&& candidate.compareTo(max) <= 0) {
				addToMatches(value, candidate);
			}
		}
		return result;
	}
	
	private static void	addToMatches(int value, int match) {
		boolean	inserted = false;
		for (int cnt = 0; cnt < MATCHES[value].length; ++cnt) {
			if (MATCHES[value][cnt] == 0) {
				MATCHES[value][cnt] = match;
				inserted = true;
				break;
			} else if (MATCHES[value][cnt] == match)
				return;
		}
		
		if (!inserted) {
			int[]	save = MATCHES[value];
			MATCHES[value] = new int[save.length * 2];
			
			int	cnt;
			for (cnt = 0; cnt < save.length; ++cnt) {
				MATCHES[value][cnt] = save[cnt];
			}
			MATCHES[value][cnt] = match;
		}
	}
}
