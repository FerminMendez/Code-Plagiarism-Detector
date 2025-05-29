/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   GoogleCodeJam 2012
   Qualifier
   Problem 3 - Only for SMALL Input
   
   1.0
   by José Alberto Bonilla Vera (2012)
   Mexico
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	Package name
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	Java library imports
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

import java.lang.*;
import java.lang.reflect.*;
import java.math.*;
import java.util.*;
import java.io.*;
import java.text.*;

//import com.rits.cloning.*;
//import org.objenesis.*;

//import helper.Helper;
//import helper.AuxMath;


/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	Main Class
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

public class QualifierProblem3 {
	
	private static BufferedReader br;
	private static BufferedWriter bw;

	public static void solveProblem(String[] args) {
		/*======== Persistent Variable declarations ========*/
		String thisLine = "";
		int numCases = 0;
		String result = "";
		String[] splitLine;
		
		/*======== Problem-specific Variable declarations ========*/
		int numPairs = 0;
		int a_num = 0;
		int b_num = 0;
		int n1 = 0;
		int n2 = 0;
		int num_digits = 0;
		
		/*======== Logic ========*/
		try {
		
			/*======== Read Number of Cases ========*/
			numCases = Integer.parseInt(br.readLine());

			/*======== Process each case ========*/
			for (int i=1; i<=numCases; i++) {
			
				
				/*======== Read Each Case ========*/
				
				thisLine = br.readLine();
				splitLine = thisLine.split(" ");
				System.out.println ("___NUEVO CASO___");
				a_num = Integer.parseInt(splitLine[0]);
				b_num = Integer.parseInt(splitLine[1]);
				num_digits = (""+a_num).length();
				numPairs = 0;
				
				if (num_digits == 1 || num_digits == 4) {
					numPairs = 0;
				}				
				else {
					for (int j=a_num; j<=b_num; j++) {
						if (num_digits == 2) {
							n1 = Integer.parseInt( (""+j).substring(0,1)+(""+j).substring(1,2) );
							n2 = Integer.parseInt( (""+j).substring(1,2)+(""+j).substring(0,1) );
							//System.out.print("Comparando ("+n1+","+n2+")");
							if (a_num <= n1 && n1 < n2 && n2 <= b_num) {
								numPairs = numPairs + 1;
								//System.out.println(" (*)");
							}
						}
						else {
							n1 = Integer.parseInt( (""+j).substring(0,1)+(""+j).substring(1,2)+(""+j).substring(2,3) );
							n2 = Integer.parseInt( (""+j).substring(1,2)+(""+j).substring(2,3)+(""+j).substring(0,1) );
							//System.out.print("a) Comparando ("+n1+","+n2+")");
							if (a_num <= n1 && n1 < n2 && n2 <= b_num) {
								numPairs = numPairs + 1;
								//System.out.println(" (*)");
							}
							//System.out.println();
							n1 = Integer.parseInt( (""+j).substring(0,1)+(""+j).substring(1,2)+(""+j).substring(2,3) );
							n2 = Integer.parseInt( (""+j).substring(2,3)+(""+j).substring(0,1)+(""+j).substring(1,2) );
							//System.out.print("b) Comparando ("+n1+","+n2+")");
							if (a_num <= n1 && n1 < n2 && n2 <= b_num) {
								numPairs = numPairs + 1;
								//System.out.println(" (*)");
							}
						}
					}
				}
				
				result = ""+numPairs;
				System.out.println("Resultado: "+result);
				
				/*======== Write the result of the case to file ========*/
				bw.write("Case #" + i + ": " + result + "\r\n");
			}
		}
		catch (Exception e) {
			e.printStackTrace();			
		}
	}

	public static void main(String[] args) {
		try {
			/*======== Open Input File ========*/
			br = new BufferedReader(new FileReader(args[0]));
			/*======== Open Output File ========*/
			bw = new BufferedWriter(new FileWriter(args[1]));
			/*======== Solve Problem ========*/
			solveProblem(args);
			
			/*======== Close Output File ========*/
			bw.close();
			/*======== Open Input File ========*/
			br.close();
		}
		catch (IOException ioe) {
			System.out.println(ioe);
		}
	}	
}