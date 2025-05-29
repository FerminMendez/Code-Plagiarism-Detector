import java.io.BufferedReader;
import java.io.FileReader;


public class RecycledNumberTest {

	public static void main(String[] args) {
		int numCase = 0;
		int caseIndex = 0;
		int[] minValues = null;
		int[] maxValues = null;
		
		try {
			FileReader reader = new FileReader("C:\\Users\\CheeMeng\\Downloads\\C-small-attempt1.in");
			BufferedReader br = new BufferedReader(reader);
			String s = br.readLine();
			numCase = new Integer(s).intValue();
			minValues = new int[numCase];
			maxValues = new int[numCase];
			while((s = br.readLine()) != null) {
				String s1[] = s.split(" ");
				minValues[caseIndex] = new Integer(s1[0]).intValue();
				maxValues[caseIndex] = new Integer(s1[1]).intValue();
				caseIndex++;
			} 
			reader.close(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		numCase = 4;
//		minValues = new int[numCase];
//		maxValues = new int[numCase];
//		minValues[0] = 1;
//		maxValues[0] = 9;
//		minValues[1] = 10;
//		maxValues[1] = 40;
//		minValues[2] = 100;
//		maxValues[2] = 500;
//		minValues[3] = 1111;
//		maxValues[3] = 2222;

		for (int i = 1; i <= numCase; i++)  {
			System.out.println("Case #" + i + ": " + recycledTest(minValues[i - 1], maxValues[i - 1]));
		}
	}

	
	public static int recycledTest(int min, int max)  {
		int count = 0;
		int numDigits = (int) Math.ceil(Math.log10((float) max));
		
		if (numDigits == 2)  {
			for (int a0 = 1; a0 <= 9; a0++)  {
				for (int a1 = 0; a1 <= 9; a1++)  {
					if (a0 < a1)  {
						int actualNum = 10 * a0 + a1;
						int recycledNum = 10 * a1 + a0;
						if ((actualNum >= min) && (actualNum <= max) && (recycledNum >= min) && (recycledNum <= max) && (actualNum < recycledNum))  {
							count++;
						}
					}
				}
			}
		}
		else if (numDigits == 3)  {
			for (int a0 = 1; a0 <= 9; a0++)  {
				for (int a1 = 0; a1 <= 9; a1++)  {
					for (int a2 = 0; a2 <= 9; a2++)  {
						int actualNum = 100 * a0 + 10* a1 + a2;
						int recycledNum = 100 * a1 + 10 * a2 + a0;
						if (a1 > 0)  {
							if ((actualNum >= min) && (actualNum <= max) && (recycledNum >= min) && (recycledNum <= max) && (actualNum < recycledNum))  {
								count++;
							}
						}
						recycledNum = 100 * a2 + 10 * a0 + a1;
						if (a2 > 0)  {
							if ((actualNum >= min) && (actualNum <= max) && (recycledNum >= min) && (recycledNum <= max) && (actualNum < recycledNum))  {
								count++;
							}
						}
					}
				}
			}
		}
		
		return count;
	}	
}
