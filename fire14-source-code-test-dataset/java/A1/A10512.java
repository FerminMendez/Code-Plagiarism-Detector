import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

import java.io.IOException;
import java.io.InputStreamReader;

public class Dance {
	private int[][] inputFin;
	private int ArraySize;
	private boolean surpriseLeftFlag;
    private int caseCount=0;
	/**
	 * @param args
	 * @throws IOException
	 */

	public int[][] getInput() throws IOException {
		boolean iFlag = false;

		FileInputStream rawfstream = new FileInputStream(
				"C:/Documents and Settings/Family/Desktop/B-small-attempt0.in");

		DataInputStream in = new DataInputStream(rawfstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;

		// Print the content on the console

		if (!iFlag) {
			iFlag = true;
			strLine = br.readLine();
			ArraySize = Integer.parseInt(strLine);

			// print the triangular array (same as above really)

			inputFin = new int[ArraySize + 1][];
			inputFin[0] = new int[1];
			inputFin[0][0] = ArraySize;

		}
		if (iFlag) {
			int iCount1 = 1;
			int iCount2 = 0;
			while ((iCount1 <= ArraySize)) {

				String[] itemp = br.readLine().split(" ");

				inputFin[iCount1] = new int[itemp.length];
				for (iCount2 = 0; iCount2 < itemp.length; iCount2++) {

					inputFin[iCount1][iCount2] = Integer
							.parseInt(itemp[iCount2]);
					// System.out.println( inputFin [iCount1][iCount2]);

				}
				iCount1 = iCount1 + 1;
			}
		}

		this.setOutput(inputFin);
		return inputFin;

	}

	public void setOutput(int[][] in) throws IOException {
		int[] caseCountFinal=new int[ArraySize];
		for (int iCount = 1; iCount <= ArraySize; iCount++) {
			getPossibleTriplet(iCount);
			caseCountFinal[iCount-1]=caseCount;
		}
		printOutput (caseCountFinal, ArraySize);
	}

	public int[][] getPossibleTriplet(int iCount) {
		int googlers = inputFin[iCount][0];
		int supriseLeft = inputFin[iCount][1];
		int maxPoint = inputFin[iCount][2];
		int triplets[][] = new int[googlers][3];
		int iCount3 = -1;
		int incre=googlers+3;
		caseCount=0;
		for (int iCount2 = 3; iCount2 < (incre ); iCount2++) {
			iCount3 = iCount3 + 1;
			//System.out.println(iCount2+"iCount2");

			float temp = (inputFin[iCount][iCount2]);
		//	System.out.println(temp);
			float temp2 = temp / 3;
		//	System.out.println(temp2);
			//System.out.println(googlers);
			if ((((temp2 % Math.round(temp2)) == 0)) && ((temp != 0))) {

				triplets[iCount3][0] = (int) temp2;
				triplets[iCount3][1] = (int) temp2;
				triplets[iCount3][2] = (int) temp2;
				triplets = checkMax(triplets, supriseLeft, iCount3, maxPoint,
						googlers);
				googlers = googlers - 1;
				if ((surpriseLeftFlag)&&(supriseLeft!=0)) {
					supriseLeft = supriseLeft - 1;
					surpriseLeftFlag = false;
					
				}

			} else {
				temp = temp + 1;
				temp2 = temp / 3;
				// System.out.println(temp2);
				if ((temp2 % Math.round(temp2)) == 0) {
					triplets[iCount3][0] = (int) temp2;
					triplets[iCount3][1] = (int) temp2;
					triplets[iCount3][2] = (((int) (temp2)) - 1);
					triplets = checkMax(triplets, supriseLeft, iCount3,
							maxPoint, googlers);
					googlers = googlers - 1;
					if ((surpriseLeftFlag)&&(supriseLeft!=0)) {
						supriseLeft = supriseLeft - 1;
						surpriseLeftFlag = false;
					

					}

				} else {
					temp = temp - 2;
					temp2 = temp / 3;
					// System.out.println(temp2);
					if ((temp2 % Math.round(temp2)) == 0) {
						triplets[iCount3][0] = (int) temp2;
						triplets[iCount3][1] = (int) temp2;
						triplets[iCount3][2] = (((int) (temp2)) + 1);
						triplets = checkMax(triplets, supriseLeft, iCount3,
								maxPoint, googlers);
						googlers = googlers - 1;
						if ((surpriseLeftFlag) &&(supriseLeft!=0)){
							supriseLeft = supriseLeft - 1;
							surpriseLeftFlag = false;
							
						}

					} else {
						triplets = checkMax(triplets, supriseLeft, iCount3,
								maxPoint, googlers);
						googlers = googlers - 1;
						if ((surpriseLeftFlag)&&(supriseLeft!=0)) {
							supriseLeft = supriseLeft - 1;
							surpriseLeftFlag = false;
							
						}
					}
				}

			}

			
		}
		/*for (int r = 0; r < triplets.length; r++) {
			for (int c = 0; c < triplets[r].length; c++) {
				System.out.print(" " + triplets[r][c]);
			}
			System.out.println("");

		}*/
		System.out.println("supriseLeft" + supriseLeft);
		return null;

	}

	public int[][] checkMax(int[][] triplets, int supriseLeft, int iCount3,
			int maxPoint, int googlers) {

		if (((triplets[iCount3][0] >= maxPoint)
				|| (triplets[iCount3][1] >= maxPoint) || (triplets[iCount3][2] >= maxPoint))
				&& (googlers != supriseLeft)) {
			
			caseCount=caseCount+1;
			return triplets;
		} else if ((((triplets[iCount3][0]) + 1) >= maxPoint)
				&& (supriseLeft != 0) && ((triplets[iCount3][0] != 10))
				&& ((triplets[iCount3][1] != 0))) {
			triplets[iCount3][0] = triplets[iCount3][0] + 1;
			triplets[iCount3][0 + 1] = triplets[iCount3][0 + 1] - 1;
			caseCount=caseCount+1;
			surpriseLeftFlag = true;
		} else if ((googlers == supriseLeft)&&((triplets[iCount3][1] != 0))) {
			triplets[iCount3][0] = triplets[iCount3][0] + 1;
			triplets[iCount3][0 + 1] = triplets[iCount3][0 + 1] - 1;
			
			surpriseLeftFlag = true;
		}
		else if(((googlers == supriseLeft)&&(supriseLeft!=0))) {
			for(int iCount6=1;iCount6<triplets.length;iCount6++)
			{
				//System.out.println(iCount6+"iCount6");
		
				if((((triplets[iCount3-iCount6][0]) + 1)-((triplets[iCount3-iCount6][0 + 1]) - 1))<=2)
				{
					triplets[iCount3-iCount6][0] = triplets[iCount3-iCount6][0] + 1;
					triplets[iCount3-iCount6][0 + 1] = triplets[iCount3-iCount6][0 + 1] - 1;
					break;
				}
				
			}
			surpriseLeftFlag = true;
		}
		return triplets;

	}
public void printOutput(int[] caseCount, int iCount) throws IOException
{
	
	
	BufferedOutputStream buffOut = new BufferedOutputStream(new FileOutputStream("C:/Documents and Settings/Family/Desktop/A-small-attemptoutput.in"));
	PrintStream ps = new PrintStream(buffOut);

	for(int iCount2=0;iCount2<iCount;iCount2++)
	{
		ps.println("Case #"+(iCount2+1)+":" +caseCount[iCount2] );
	}
	ps.close();
	buffOut.close();
}
	public static void main(String[] args) throws IOException {
		new Dance().getInput();

	}

}
