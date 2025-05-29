import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shell {
	
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
    private static final String ERROR = "Error!";
    
    private static final String ERROR_INVALID_INT =
        "Ungueltige Integer-Zahl! (Nochmal eingeben) ";
    
    private static int numberOfCases = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
    	System.out.println("Input integer!");
		numberOfCases = readInt();
		int x = 0;
		while (x < numberOfCases) {
			String[] tokens = getTokens();
			int n = Integer.parseInt(tokens[0]);
			int s = Integer.parseInt(tokens[1]);
			int p = Integer.parseInt(tokens[2]);
			int[] googlers = new int[n];
			int index = 0;
			while (index < n) {
				googlers[index] = Integer.parseInt(tokens[index + 3]);
				index++;
			}
			int y = judge(s, p, googlers);
			x++;
			System.out.println("Case #" + x + ": " + y);
		}

	}
	
    private static String[] getTokens() {
        String line;
        try {
            line = in.readLine();
        } catch (IOException e) {
            throw new Error(e);
        }
        if (line == null) {
            System.err.println(ERROR);
            return null;
        } else {
            return line.split("\\s");
        }
    }

    private static int readInt() {
        while (true) {
            for (String token : getTokens()) {
                try {
                    return Integer.parseInt(token);
                } catch (NumberFormatException e) {
                    System.err.println(ERROR_INVALID_INT);
                }
            }
        }
    }

    private static int judge(int s, int p, int[] googlers) {
    	int judgedPoint = 0;
    	int indexOfGooglers = 0;
    	int googlersLength = googlers.length;
    	while (indexOfGooglers < googlersLength) {
    		if (withoutSurprise(s, p, googlers[indexOfGooglers])) {
    			judgedPoint++;
    		} else if (needSurprise(s, p, googlers[indexOfGooglers])) {
    			s--;
    			judgedPoint++;
    		}
    		indexOfGooglers++;
    	}
    	
    	
    	return judgedPoint;
    }
    
    private static boolean needSurprise(int s, int p, int googler) {
    	int surprisePointLeft = googler % 3;
    	int normalPoint = googler / 3;
    	if (normalPoint == 0 &&  surprisePointLeft == 0) {
    		return false;
    	}
    	int difference = p - normalPoint;
    	if (difference < 3 && surprisePointLeft == 2 && s > 0) {
    		return true;
    	} else if (difference < 2 && s > 0) {
    		return true;
    	}
    	
    	return false;
    }
    
    private static boolean withoutSurprise(int s, int p, int googler) {
    	int surprisePointLeft = googler % 3;
    	int normalPoint = googler / 3;
    	int difference = p - normalPoint;
    	if (normalPoint >= p) {
    		return true;
    	} else if (difference < 2 && (surprisePointLeft == 2 || surprisePointLeft == 1)) {
    		return true;
    	}
    	
    	return false;
    }
    
}
