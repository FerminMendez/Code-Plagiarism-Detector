
package com.google.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecycledNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String input = null;
		//String outputFileLocation = "C:\\google-code-jam\\output\\C-large-output.txt";
		String outputFileLocation = "C:\\google-code-jam\\output\\C-small-output.txt";
		//String inputFileLocation = "C:\\google-code-jam\\input\\C-large-practice.in";
	    String inputFileLocation = "C:\\google-code-jam\\input\\C-small-practice.in";
		File outputFile = new File(outputFileLocation);

        BufferedWriter outputWriter = null;
        DataInputStream in = null;
        int caseNum = 1;
        int count = 0;
        String appCount = "";
        


        try
        {
            outputWriter = new BufferedWriter(new FileWriter(outputFile));

            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream(inputFileLocation);

            // Get the object of DataInputStream
            in = new DataInputStream(fstream);

            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine = null;


            int numtestCases = 1;
            int credit = 0;
            int numItemsinStore = 0;
            String[] arrItems = null;
            int [] arrSoln = null;
            
            long startNum = 0;
    		long endNum = 0;
    		int answer = 0;
            numtestCases = new Integer(br.readLine()).intValue();
            

            // Read File Line By Line
            for (int i = 1; i <= numtestCases; i++)
            {

            	//get credit from file
                input = br.readLine();
                
                String[] a = input.split("\\s");
                answer = 0;
                startNum = Integer.parseInt(a[0]);
				endNum = Integer.parseInt(a[1]);
                
				for (long j = startNum; j < endNum; j++) {
					answer = answer + getString(String.valueOf(j), startNum, endNum);
				}

               
               // System.out.println("Case #" + i + ": " + answer);

               
                outputWriter.write("Case #" + i + ": " + answer);

                outputWriter.newLine();


            }
            
            System.out.println("Done");
            // Close the input stream
            in.close();

            // Close the output stream
            outputWriter.close();


        }
        catch (IOException e) // Catch exception if any
        {
            System.err.println("IO Error: " + e.getMessage());
        }
        catch (Exception e) // Catch exception if any
        {
            System.err.println("Error: " + e.getMessage());
        }

	}
	
	public static int getString(String inputString, long startNum, long endNum) {

		//System.out.println("Input string is " + inputString);
		int length = inputString.length();
		int varLength = length;
		int tempLength = 0;
		boolean flag = true;

		int answer = 0;

		for (int i = 0; i < inputString.length() - 1; i++) {

			if (inputString.charAt(i) != inputString.charAt(i + 1)) {
				flag = false;
			}

		}

		if (flag == true) {
			//System.out.println("found same digit number");
			return 0;
		}

		String temp1 = null;
		String temp2 = null;
		String newString = null;
		for (int i = 0; i < length; i++) {

			tempLength = length - (i + 1);
			//System.out.println("varLEnth = " + varLength + " tempLength = "
					//+ tempLength);
			if (varLength > tempLength && tempLength != 0) {

				temp1 = inputString.substring(varLength - 1, length);
				//System.out.println("1 = " + temp1);

				temp2 = inputString.substring(0, varLength - 1);
				//System.out.println("2 = " + temp2);

				varLength--;

				if (temp1.charAt(0) != '0') {

					newString = temp1 + temp2;
				} else {
					//System.out.println("found leading 0");
					newString = null;
				}

				//System.out.println("input string is " + inputString);
				//System.out.println("new string is " + newString);

				if (newString != null && Long.valueOf(newString) <= endNum
						&& Long.valueOf(newString) > Long.valueOf(inputString)) {

					answer++;

					//System.out.println("answer incremented by one " + answer);
				}
			}
		}

		return answer;
	}

}
