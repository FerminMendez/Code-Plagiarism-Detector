import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Shell {
	
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
    private static final String ERROR = "Error!";
    
    private static final String ERROR_INVALID_INT =
        "Ungueltige Integer-Zahl! (Nochmal eingeben) ";
    
    private static int numberOfCases = Integer.MAX_VALUE;

    public static void main(String[] args) {
		numberOfCases = readInt();
		int x = 0;
		while (x < numberOfCases) {
			String[] tokens = getTokens();
			int a = Integer.parseInt(tokens[0]);
			int b = Integer.parseInt(tokens[1]);
			int y = recycle(a, b);
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

    private static int[] intToArray(int i) {
    	String stringInt = Integer.toString(i);
    	String[] splittedString = stringInt.split("");
    	int[] resultArray = new int[splittedString.length - 1];
    	int index = 0;
    	while ((index + 1) < splittedString.length) {
    		resultArray[index] = Integer.parseInt(splittedString[index + 1]);
    		index++;
    	}
    	
    	return resultArray;
    }
    
    private static boolean validRecycledNumber(int[] a, int[] b, int m) {
    	if (m > 0 && m < a.length && a[m] >= a[0] && a.length == b.length && checkSmallerThan(a, b, m)) {
    		if (a[m] == a[0]) {
    			int indexMoved = m + 1;
    			int indexOriginal = 1;
    			int arrayLength = a.length;
    			while (indexMoved < arrayLength) {
    				if (a[indexMoved] > a[indexOriginal]) {
    					return true;
    				} else if (a[indexMoved] < a[indexOriginal]) {
    					return false;
    				}
    				indexMoved++;
    				indexOriginal++;
    			}
    			int i = 0;
    			int delta = arrayLength - m;
    			while ((i + delta) < a.length) {
    				if (a[i] > a[i + delta]) {
    					return true;
    				} else if (a[i] < a[i + delta]) {
    					return false;
    				}
    				i++;
    			}
    			return false;
    		} else {
    			return true;
    		}
    	} else {
    		return false;
    	}
    }
    
    private static boolean checkSmallerThan(int a[], int b[], int m) {
    	int changableM = m;
    	int arrayLength = a.length;
    	int actualIndex = 0;
    	while (changableM < arrayLength) {
    		if (a[changableM] < b[actualIndex]) {
    			return true;
    		} else if (a[changableM] > b[actualIndex]) {
    			return false;
    		}
    		changableM++;
    		actualIndex++;
    	}
    	int indexA = 0;
    	while (indexA < m) {
    		if (a[indexA] < b[actualIndex]) {
    			return true;
    		} else if (a[indexA] > b[actualIndex]) {
    			return false;
    		}
    		indexA++;
    		actualIndex++;
    	}
    	return true;
    }
    
    private static int recycle(int a, int b) {
    	int counter = 0;
    	int[] bArray = intToArray(b);
    	int constantM = bArray.length - 1;
    	while (a <= b) {
    		int[] aArray = intToArray(a);
    		int m = constantM;
    		ArrayList<Integer> listOfChangedNumbers = new ArrayList<>();
    		while (m > 0) {
        		if (validRecycledNumber(aArray, bArray, m)) {
        			int recycledNumber = moveRecycled(aArray, m);
        			if (!listOfChangedNumbers.contains(recycledNumber)) {
        				listOfChangedNumbers.add(recycledNumber);
        				counter++;
        			}
        		}
        		m--;
        	}
    		a++;
    	}
    	return counter;
    }
    
    private static int moveRecycled(int[] a, int m) {
    	int result = 0;
    	int changableM = m;
    	int aLength = a.length;
    	String[] resultArray = new String[aLength];
    	int index = 0;
    	while (changableM < aLength) {
    		resultArray[index] = Integer.toString(a[changableM]);
    		changableM++;
    		index++;
    	}
    	int actualIndex = 0;
    	while (index < aLength) {
    		resultArray[index] = Integer.toString(a[actualIndex]);
    		index++;
    		actualIndex++;
    	}
    	String resultString = "";
    	int i = 0;
    	while (i < resultArray.length) {
    		resultString = resultString + resultArray[i];
    		i++;
    	}
    	result = Integer.parseInt(resultString);
    	return result;
    }
}
